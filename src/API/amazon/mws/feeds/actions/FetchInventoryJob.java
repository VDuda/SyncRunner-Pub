
package API.amazon.mws.feeds.actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import API.amazon.mws.feeds.model.GetReportRequest;
import API.amazon.mws.feeds.model.GetReportRequestListRequest;
import API.amazon.mws.feeds.model.GetReportRequestListResponse;
import API.amazon.mws.feeds.model.GetReportRequestListResult;
import API.amazon.mws.feeds.model.GetReportResponse;
import API.amazon.mws.feeds.model.GetReportResult;
import API.amazon.mws.feeds.model.IdList;
import API.amazon.mws.feeds.model.ReportRequestInfo;
import API.amazon.mws.feeds.model.RequestReportRequest;
import API.amazon.mws.feeds.model.RequestReportResponse;
import API.amazon.mws.feeds.service.MarketplaceWebService;
import API.amazon.mws.feeds.service.MarketplaceWebServiceClient;
import API.amazon.mws.feeds.service.MarketplaceWebServiceException;
import controller.DBController;


/**
 * THIS IS NOT AN EFFIECIENT METHOD OF GRABBING PRODUCTS! 
 * WE WRITE AND DELETE TO THE DATABASE TOO MUCH!
 * @author B2E_2
 */
public class FetchInventoryJob {
    
    //Class specific variables
    private static final String DONE = "_DONE_";
    private static final String SUBMITTED = "_SUBMITTED_";
    private static final String PROGRESS = "_IN_PROGRESS_";
    private static final String CANCELED = "_CANCELLED_";
    
    private static final long WAIT_TIME = 1000 * 60 * 10; // 1000 = 1 sec, 60secs = 1 min, we want 10 mins  
    
    private static Connection conn;
    
    //Logger
    public static final Log log = LogFactory.getLog(FetchInventoryJob.class);
    
    // Service variables
    private static final String merchantId = FeedsConfig.SELLER_ID; 
    private static final String marketplaces = FeedsConfig.MARKETPLACE_ID;//this can be an array
    private static final String reportType = "_GET_FLAT_FILE_OPEN_LISTINGS_DATA_";
    
    //may need to move this, don't really want more than 1 connection at a time. 
    private static final MarketplaceWebService service = new MarketplaceWebServiceClient(
            FeedsConfig.ACCESS_KEY_ID, FeedsConfig.SECRET_ACCESS_KEY, FeedsConfig.APPLICATION_NAME, 
            FeedsConfig.APPLICATION_VERSION, FeedsConfig.config);
    
    boolean keepRunning = false;
    boolean requestReportSet = false;
    String reportRequestID = "";
    String reportID = "";
    //we request a reportType, in our case we want the open Lite EVERY 2 hours
    // Store  ReportRequestId in memory. 
    //Every 10 mins request getReportList from MWS for ReportType "_GET_MERCHANT_LISTINGS_DATA_LITE_"
    //  checking whether we have a completed report with stored ReportRequestId. 
    // once report is found we process it, and submit a new request for another OpenLite
    
    public FetchInventoryJob(Connection conn){
        this.conn = conn;
    }
    
    public void periodicSync(){
        //check if reportRequestList, contains any submitted for our ReportType
        startSync();
        invokeRequestReport(reportType);
        while(keepRunning){
            //Wait 10 mins before checking for Report again
            try {
                Thread.sleep(WAIT_TIME);
            } catch (InterruptedException ex) {
                Logger.getLogger(FetchInventoryJob.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
            
            //break loop once report is done
            if(isReportDone()){
                stopSync();
            }
        }
        //process the report
        invokeGetReport(reportID);
        
        
    }
    
    public void startSync(){
        this.keepRunning = true;
        log.info("Starting sync. Calling periodicSync()...");
        //periodicSync();
    }
    
    public void stopSync(){
        this.keepRunning = false;
        log.info("Stopping sync.");
    }
    
    public void invokeRequestReport(String reportType){
        
        //building the request
        RequestReportRequest request = new RequestReportRequest()
		        .withMerchant(merchantId)
		        .withMarketplace(marketplaces)
		        .withReportType(reportType)
		        .withReportOptions("ShowSalesChannel=true");
        
        //send out the request.
        RequestReportResponse response = null;
        try {
            response = service.requestReport(request);
         
        } catch (MarketplaceWebServiceException ex) {
            Logger.getLogger(FetchInventoryJob.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "CHECK FETCHINVENTORYJOB, Couldn't make request");
        }
        
        //process the response
        processRequestReportResponse(response);
        
    }
    
    //process the response, e.g store variables
    public void processRequestReportResponse(RequestReportResponse response){
        if(response!=null){ // response succeeded, time to store things!
            requestReportSet = true;
            ReportRequestInfo result = response.getRequestReportResult().getReportRequestInfo();
            reportRequestID = result.getReportRequestId();
            //log requestId and date
            log.info("StartDate: "+result.getStartDate()+ " :::: ReportRequestID: "+reportRequestID);
            //RequestID is now stored, we need to keep checking
        }else{ //response failed!
            requestReportSet = false;
        }
    }
    
    /**
     * Sends a reportRequestList request to Service, checking for reportStatus 
     * @return 
     */
    public Boolean isReportDone(){       
        String status = invokeGetReportRequestList();
        
        if(status.equals(DONE)){
            log.info("The requestedReport is Finished!");
            return true;
        }else{
            return false;
        }
        
    }
    
    /**
     * private method, a helper for isReportDone(); sets reportID when status is DONE
     * @return status
     */
    private String invokeGetReportRequestList(){
        String status = "";
        System.out.println("Will attach ReportRequestID: "+ reportRequestID);
        //builing the request call
        GetReportRequestListRequest request = new GetReportRequestListRequest();
        
        // this is a cool statement, should look into it more
        request.withMerchant(merchantId).withReportRequestIdList(new IdList(new ArrayList<String>(){{add(reportRequestID);}}));
        
        
        //send request onto service
        GetReportRequestListResponse response = null;
        
        try {            
            response = service.getReportRequestList(request);
        } catch (MarketplaceWebServiceException ex) {
            Logger.getLogger(FetchInventoryJob.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //process
        if(response!=null){
            GetReportRequestListResult result = response.getGetReportRequestListResult();
            List<ReportRequestInfo> requestList = result.getReportRequestInfoList();
            //error handling
            if(requestList.size()>1){
                log.error("Problem in invokeGetReportRequestList, found 2 similar requestID");
                JOptionPane.showOptionDialog(null, "Problem in requestList! more than 1 similar reportID!", "ERROR",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null, new String[]{"OK","CANCEL"}, "OK");

            }
            status = requestList.get(0).getReportProcessingStatus();
            //set the reportID
            if(status.equals(DONE)){
                reportID = requestList.get(0).getGeneratedReportId();
                log.info("Recieved a reportID: "+ reportID+ " from the requestList.");
            }else{ //just adds a bit of safe redudancy, incase we ever access this variable
                reportID = "";
            }
        }
        
        return status;
    }
    
    public void invokeGetReport(String reportId){
        //we want to form the files following the batch-ID, which is the reportRequestID
        // we want to do this because We want to match the file name with what we see on Amazon inventory reports
        File file = new File("Inventory-Reports/"+reportRequestID+".tsv");
        //build the GetReport request
        GetReportRequest request = new GetReportRequest();
        request.withMerchant(merchantId).withMarketplace(marketplaces).withReportId(reportId);
       
        
        //send the request to the service
        GetReportResponse response = null;
        try {
        	FileOutputStream report = new FileOutputStream(file);
            request.setReportOutputStream(report);
//            log.info("Creating a new OutPutStream: "+ (new String(reportId.toCharArray())) 
//                    + " --- File: "+ file);
            response= service.getReport(request);
            log.info("Found a report! - Report: "+reportId);
        } catch (MarketplaceWebServiceException ex) {
            Logger.getLogger(FetchInventoryJob.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FetchInventoryJob.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //process the response
        if(response!=null){
            try {
                processGetReport(response.getGetReportResult(), file);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FetchInventoryJob.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FetchInventoryJob.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FetchInventoryJob.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            log.info("Can't process report, no response recieved.");
        }
    }
/****
    public static void main(String[] args) throws Exception{
    	File file = new File("Inventory-Reports/10114180342.tsv");
        Connection conn = DBController.getConn();
        PreparedStatement pst = null;
        long start = System.currentTimeMillis();
/***BETA HERE*    
        //Insert Report into Temp AmazonDB
        pst = conn.prepareStatement("TRUNCATE v3_inventory.sync_amzn_products_temp");//clears previous items
        pst.execute();
	        /*Possible deletion method as well
	        RENAME TABLE v3_inventory.sync_amzn_products_temp TO v3_inventory.t1;
	        CREATE TABLE v3_inventory.sync_amzn_products_temp LIKE v3_inventory.t1;
	        DROP TABLE v3_inventory.t1;
	        *
        System.out.println("Deleted Data Done time: "+ (System.currentTimeMillis()-start));
        pst = conn.prepareStatement("LOAD DATA LOCAL INFILE ? " + 
			"INTO TABLE v3_inventory.sync_amzn_products_temp " + 
			"FIELDS TERMINATED BY '\\t' " +
			"ENCLOSED BY '\"' " +
			"LINES TERMINATED BY '\\n' " +
			"IGNORE 1 ROWS");
        pst.setString(1, file.getAbsolutePath());//can use canonicalPath instead - will reference fileSys obj
        pst.execute();
        System.out.println("Added new Data Done time: "+ (System.currentTimeMillis()-start));
        //Get AmazonDB items
        ActionFindor findDB = new ActionFindor();
        List<SyncAmznProducts> amazonDB = findDB.findAllSyncAmznProducts();
        
        for(SyncAmznProducts amznItem : amazonDB){//check each item in DB
        	
        	//Determine if exists in report
            pst = conn.prepareStatement("SELECT EXISTS (SELECT NULL FROM v3_inventory.sync_amzn_products_temp"
            		+ " where sku = ? and asin = ?)");
            pst.setString(1, amznItem.getId().getSku());
            pst.setString(2, amznItem.getId().getAsin());
            ResultSet rs = pst.executeQuery();
            
            if(rs.first()&&rs.getBoolean(1)){//Check if found exists
            	//UPDATE EXISTING PRICE & QTY
            	//pst = conn.prepareStatement("UPDATE")
            	//System.out.println("Exists");
            	continue;
            }else{//Doesn't exist in report
            	//DELETE
            	System.out.println("DNE - Deleting");
            }
        	
        }
        System.out.println("Done time: "+ (System.currentTimeMillis()-start));
    }
*/    
    
    private void processGetReport(GetReportResult result,File file) throws FileNotFoundException, IOException, SQLException{
        System.out.println("This is where we process the file");
        BufferedReader report = new BufferedReader(new InputStreamReader( new FileInputStream(file)));
        Connection conn = DBController.getConn();
        PreparedStatement pst = null;
        String str;          
        
/*
        log.info("Deleting all entries from table: sync_amzn_products");
        pst = conn.prepareStatement("DELETE FROM sync_amzn_products");
        pst.execute();
*/      
        log.info("Deleting all items in table: sync_amzn_products");
        pst = conn.prepareStatement("TRUNCATE v3_inventory.sync_amzn_products");//clears previous items
        pst.execute();
        
        log.info("Adding new entries to table: sync_amzn_products");
        report.readLine();//Skips the first row with title
        while((str=report.readLine())!=null){
            String[] items = str.split("\t");
            String sku = items[0];
            String asin = items[1];
            String price = items[2];
            String qty = items[3];
            
            //Determine if already exists in table
            pst = conn.prepareStatement("SELECT EXISTS (SELECT NULL FROM v3_inventory.sync_amzn_products"
            		+ " where sku = ? and asin = ?)");
            pst.setString(1, sku);
            pst.setString(2, asin);
            ResultSet rs = pst.executeQuery();
            
            if(rs.first()&&rs.getBoolean(1)){//Check if found exists
            	//UPDATE EXISTING PRICE & QTY
            	//pst = conn.prepareStatement("UPDATE")
            	continue;
            }
           
            // >>> Otherwise
            //INSERT
            pst = conn.prepareStatement("INSERT INTO sync_amzn_products (sku,qty,price,asin) " +
            		"VALUES(?,?,?,?)");
            pst.setObject(1, sku);
            pst.setObject(2, qty);
            pst.setObject(3, price);
            pst.setObject(4, asin);
/*            "SELECT " +
            "\""+sku+"\","+
            "\""+qty+"\","+ 
            "\""+price+"\","+ 
            "\""+asin+"\","+
            "COUNT(*) as is_in_db FROM local_inventory_stock WHERE sku LIKE \"%"+sku+"%\"");
*/
            log.info("Adding SKU: "+ sku);
            pst.execute();
            
        }
        report.close();
    }
}
