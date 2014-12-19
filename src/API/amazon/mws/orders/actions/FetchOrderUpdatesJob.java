package API.amazon.mws.orders.actions;

import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.http.HttpStatus;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import controller.DBController;
import controller.amazon.model.SyncTimingsDB;
import API.amazon.mws.orders.MarketplaceWebServiceOrders;
import API.amazon.mws.orders.MarketplaceWebServiceOrdersClient;
import API.amazon.mws.orders.MarketplaceWebServiceOrdersException;
import API.amazon.mws.orders.model.ListOrderItemsByNextTokenRequest;
import API.amazon.mws.orders.model.ListOrderItemsByNextTokenResponse;
import API.amazon.mws.orders.model.ListOrderItemsByNextTokenResult;
import API.amazon.mws.orders.model.ListOrderItemsRequest;
import API.amazon.mws.orders.model.ListOrderItemsResponse;
import API.amazon.mws.orders.model.ListOrderItemsResult;
import API.amazon.mws.orders.model.ListOrdersByNextTokenRequest;
import API.amazon.mws.orders.model.ListOrdersByNextTokenResponse;
import API.amazon.mws.orders.model.ListOrdersByNextTokenResult;
import API.amazon.mws.orders.model.ListOrdersRequest;
import API.amazon.mws.orders.model.ListOrdersResponse;
import API.amazon.mws.orders.model.ListOrdersResult;
import API.amazon.mws.orders.model.MarketplaceIdList;
import API.amazon.mws.orders.model.Order;
import API.amazon.mws.orders.model.OrderItem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 * This sample illustrates continuous order updates retrieval. It contains a
 * order updates fetcher job that fetches updates every 15 minutes.
 */

public class FetchOrderUpdatesJob {

    /*
     * Add required parameters in OrdersConfig.java before trying out this
     * sample.
     */
    
    public static final Log log = LogFactory.getLog(OrderFetcherSample.class);
    private volatile boolean keepRunning = true;

    /*************************************
     * Throttling Limits in Milliseconds *
     *************************************/
    // 1 call per 1 mins
    static final long LIST_ORDERS_THROTTLE_LIMIT = 60000L;
    // 1 call per 8 secs
    static final long LIST_ORDER_ITEMS_THROTTLE_LIMIT = 8000L;

    static final int INTERVAL_IN_MINS = 2; // 15-minute update interval
    
    protected SyncTimingsDB syncTimingsDB = null;
    protected PreparedStatement pst = null;
    protected Connection conn = null;

    protected MarketplaceWebServiceOrders service;
    protected String sellerId = "A2P5W6J54UN5HV";
    protected MarketplaceIdList marketplaceIdList = new MarketplaceIdList(Arrays.asList("ATVPDKIKX0DER"));

    public FetchOrderUpdatesJob(
            MarketplaceWebServiceOrders marketplaceWebServiceOrdersClient,
            String sellerId, MarketplaceIdList marketplaceIdList, SyncTimingsDB syncTimingsDB) {
        if (marketplaceWebServiceOrdersClient == null) {
            throw new IllegalArgumentException(
                    "MarketplaceWebServiceOrders object cannot be null.");
        }
        this.service = marketplaceWebServiceOrdersClient;
        this.sellerId = sellerId;
        this.marketplaceIdList = marketplaceIdList;
        this.syncTimingsDB = syncTimingsDB;
        this.conn = syncTimingsDB.getConn();
        
    }

    /**
     * Call this method to start this job. Note that the job will run until the
     * keepRunning flag is set to false.
     */
    public void startPeriodicSynch() {

        DatatypeFactory df = null;
        try {
            df = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            log.error(e.getMessage(), e);
        }//may need to make this catch larger as to surround the while check.
        
        //Grabs Start Point from DB
        String lastUpdated = syncTimingsDB.getLastUpdated();
        
        XMLGregorianCalendar startTime = df.newXMLGregorianCalendar(lastUpdated);
                
       
        System.out.println("Start Time BEFORE ADD: "+ startTime.toString());
        // endTime = now -2. So, startTime = now - 2 - INTERVAL_IN_MINS.
        startTime.add(df.newDurationDayTime(false, 0, 0, INTERVAL_IN_MINS + 2,
                0));
        
        System.out.println("Start Time: "+ startTime.toString());
        /*
         * This loop keeps running until the stopSynch() method is called.
         * stopSynch() sets keepRunning to false.
         */
        log.info("Sync job starting.");
        while (keepRunning) {
            // Subtract 2 minutes because endTime returned from server = now - 2
            // mins.
            long timeWaited = System.currentTimeMillis()
                    - startTime.toGregorianCalendar().getTimeInMillis()
                    - 120000;
            // Postive timeWaited => we slept our alotted time + a little extra
            // Negative timeWaited => we awoke a little bit early, else logic will make us sleep.
            
            /*DEBUGGING*/
            System.out.println(System.currentTimeMillis());
            System.out.println(startTime.toGregorianCalendar().getTimeInMillis());
            System.out.print("timeWated = ");
            System.out.println(timeWaited);
            System.out.println(INTERVAL_IN_MINS * 60L * 1000L);
            System.out.println(30*INTERVAL_IN_MINS * 60L * 1000L);
            
            /*
             * If the timeWaited is greater than 30 times the interval, we exit
             * from the loop as the job is lagging far behind in getting new
             * orders.
             * 
             * The reasoning behind this is, 
             * The INTERVAL sleeps for the INTERVAL time. 
             * But if we land in a situation where the INTERVAL sleeps for too long,
             * We'd rather not have the fetch orders execute. We are for some reason, 
             * Sleeping too much.
             * It may also be a calculation error. Smaller StartTime => bigger timeWaited
             * THIS SHOULD NOT BE IN THE PRODUCTION SETTING. 
             *    If we do not update within 30 minutes; timeWaited will be bigger, thus turning off update.
             * This is pretty much optional and I think we may not have this in Production.
             */
            // Change false to true, OR just delete false&& to reactivate UPDATE only within 1 hour or NO update at all.
            // having false&& makes java ignore this case.
            if (false&&timeWaited > 30 * INTERVAL_IN_MINS * 60L * 1000L) {
                keepRunning = false;
                log
                        .info("timeWaited is greater than 30 times the interval. This a too large a time interval for which to fetch orders.");
            }
            /*
             * If the time lapsed is greater than or equal to 15 mins, we will
             * try to fetchOrderUpdates giving it a startTime.
             * 
             * The reasoning behind this is,
             * The thread must sleep for the INTERVAL and then awake.
             * By checking if timeWaited is greated than the INTERVAL,
             * We then know that 
             * 
             */
            else if (timeWaited >= INTERVAL_IN_MINS * 60L * 1000L) {
                log.info("Time to fetch new order updates.");
                //Calls Fetch Orders returning the End time
                XMLGregorianCalendar endTime = fetchOrderUpdatesSince(startTime);
                
                
                
                
                //set the new StartTime
                if (endTime != null) {
                    
                    startTime = endTime;
                    syncTimingsDB.updateLastUpdatedDB(startTime.toString());
                } else {
                    log.info("endTime returned is null. Sleeping for "
                            + INTERVAL_IN_MINS + " minutes.");
                    try {
                        System.out.println("Thread Sleep! else if");
                        Thread.sleep(INTERVAL_IN_MINS * 60L * 1000L);
                        System.out.println("Thread awake!");
                    } catch (InterruptedException e) {
                        log.error(e.getMessage(), e);
                        stopSynch();
                        break;
                    }
                }
                //In this situation we slept for too little time, Slept LESS than Intended amount.
                // to fix this we will resume sleeping for the time required. 
            } else {
                
                try {
                    long timeToSleepInMilliseconds = INTERVAL_IN_MINS * 60000L
                            - timeWaited;
                    log.info("Thread sleeping for "
                            + Math.round(timeToSleepInMilliseconds / 60000)
                            + " minutes.");
                    // Sleep in 1 minute intervals for timeToSleepInMilliseconds
                    // or until keepRunning is set to false.
                    for (long i = timeToSleepInMilliseconds; i > 0
                            && keepRunning; i = i - 60000L) {
                        if (i < 60000L) {
                            Thread.sleep(i);
                        } else {
                            Thread.sleep(60000L);
                        }
                    }
                    
                } catch (InterruptedException e) {
                    log.error(e.getMessage(), e);
                    stopSynch();
                    break;
                }
               
            }
            System.out.println("Done Iteration of checks---"); 
        }
        log.info("Sync job ending.");
    }

    /**
     * Call this method to stop execution of this job. The job will stop after
     * it has finished processing the current call (if it is in the middle of
     * processing any). For example if a listOrders call has been invoked, then
     * it will terminate the job only after the call returns with valid results.
     * If this method is called while the thread is sleeping, because a request
     * was throttled, the job will terminate after it wakes up.
     */
    public void stopSynch() {
        keepRunning = false;
    }

    /**
     * Gets all orders updated between the given startTime and the calculated
     * endTime. The endTime is calculated by the service as server's system
     * clock time minus 2 mins. The method returns this endTime.
     * 
     */
    protected XMLGregorianCalendar fetchOrderUpdatesSince(
            XMLGregorianCalendar startTime) {
        log.info("Fetching order updates since " + startTime.toString());
        //using default constructor
        ListOrdersRequest listOrdersRequest = new ListOrdersRequest();

        //set sellerID, MarketPlace, LastUpdatedAfter date
        listOrdersRequest.setSellerId(sellerId);
        listOrdersRequest.setMarketplaceId(marketplaceIdList);
        listOrdersRequest.setLastUpdatedAfter(startTime);
        XMLGregorianCalendar lastUpdatedDate = null;

        
        //forms the call request to MWS service
        try {
            //listOrders is a method that handles the Result
            ListOrdersResult listOrdersResult = listOrders(listOrdersRequest);
            if (listOrdersResult.isSetLastUpdatedBefore()) {
                //the lastUpdatedDate is the Current System time on the Server. (the server is auto -2 minutes though)
                lastUpdatedDate = listOrdersResult.getLastUpdatedBefore();
            }

            if (listOrdersResult != null && listOrdersResult.isSetNextToken()) {
                ListOrdersByNextTokenRequest listOrdersByNextTokenRequest = new ListOrdersByNextTokenRequest();
                listOrdersByNextTokenRequest.setSellerId(sellerId);
                String nextToken = listOrdersResult.getNextToken();
                ListOrdersByNextTokenResult listOrdersByNextTokenResult = null;

                while (nextToken != null && keepRunning) {
                    listOrdersByNextTokenRequest.setNextToken(nextToken);
                    listOrdersByNextTokenResult = listOrdersByNextToken(listOrdersByNextTokenRequest);
                    nextToken = listOrdersByNextTokenResult.getNextToken();
                }
                if (listOrdersByNextTokenResult.isSetLastUpdatedBefore()) {
                    lastUpdatedDate = listOrdersByNextTokenResult
                            .getLastUpdatedBefore();
                }
            }
            return lastUpdatedDate;
        } catch (MarketplaceWebServiceOrdersException ex) {
            log.error(ex.getMessage(), ex);
            System.out.println("Caught Exception: " + ex.getMessage());
            System.out.println("Response Status Code: " + ex.getStatusCode());
            System.out.println("Error Code: " + ex.getErrorCode());
            System.out.println("Error Type: " + ex.getErrorType());
            System.out.println("Request ID: " + ex.getRequestId());
            System.out.print("XML: " + ex.getXML());
            return null;
        }
    }

    /*
     * listOrders call. If a request is throttled, this method calls the
     * throttling handler and sets the retry flag to true.
     */
    protected ListOrdersResult listOrders(ListOrdersRequest request)
            throws MarketplaceWebServiceOrdersException {
        boolean retry;
        ListOrdersResponse listOrdersResponse = null;
        ListOrdersResult listOrdersResult = null;
        do {
            retry = false;
            try {
                log.info("Calling ListOrders.");
                listOrdersResponse = service.listOrders(request);
            } catch (MarketplaceWebServiceOrdersException ex) {
                if (ex.getStatusCode() == HttpStatus.SC_SERVICE_UNAVAILABLE
                        && "RequestThrottled".equals(ex.getErrorCode())) {
                    System.out.println("THE REQUEST IS THROTTLED!!!::");
                    retry = true;
                    requestThrottledExceptionHandler(LIST_ORDERS_THROTTLE_LIMIT);
                } else {
                    throw ex;
                }
            }
            //Will not execute if throttle is hit
            if (listOrdersResponse != null
                    && listOrdersResponse.isSetListOrdersResult()) {
                listOrdersResult = listOrdersResponse.getListOrdersResult();
                if (listOrdersResult.isSetOrders()
                        && listOrdersResult.getOrders().isSetOrder()) {
                    //This is what serializes the data recieved.
                    processOrderUpdates(listOrdersResult.getOrders().getOrder());
                }
            }
        } while (retry && keepRunning);
        return listOrdersResult;
    }

    /*
     * listOrdersByNextToken call. If a request is throttled, this method calls
     * the throttling handler and sets the retry flag to true.
     */
    protected ListOrdersByNextTokenResult listOrdersByNextToken(
            ListOrdersByNextTokenRequest listOrdersByNextTokenRequest)
            throws MarketplaceWebServiceOrdersException {
        boolean retry;
        ListOrdersByNextTokenResponse listOrdersByNextTokenResponse = null;
        ListOrdersByNextTokenResult listOrdersByNextTokenResult = null;
        do {
            retry = false;
            try {
                log.info("Calling ListOrdersByNextToken.");
                listOrdersByNextTokenResponse = service
                        .listOrdersByNextToken(listOrdersByNextTokenRequest);
            } catch (MarketplaceWebServiceOrdersException ex) {
                if (ex.getStatusCode() == HttpStatus.SC_SERVICE_UNAVAILABLE
                        && "RequestThrottled".equals(ex.getErrorCode())) {
                    retry = true;
                    requestThrottledExceptionHandler(LIST_ORDERS_THROTTLE_LIMIT);
                } else {
                    throw ex;
                }
            }
            if (listOrdersByNextTokenResponse != null
                    && listOrdersByNextTokenResponse
                            .isSetListOrdersByNextTokenResult()) {
                listOrdersByNextTokenResult = listOrdersByNextTokenResponse
                        .getListOrdersByNextTokenResult();
                if (listOrdersByNextTokenResult.isSetOrders()
                        && listOrdersByNextTokenResult.getOrders().isSetOrder()) {
                    processOrderUpdates(listOrdersByNextTokenResult.getOrders()
                            .getOrder());
                }
            }
        } while (retry && keepRunning);
        return listOrdersByNextTokenResult;
    }

    /**
     * This method is called to process updates on each of the orders that are
     * returned by the ListOrders and ListOrdersByNextToken calls.
     */
    protected void processOrderUpdates(List<Order> orders)
            throws MarketplaceWebServiceOrdersException {
        ListOrderItemsResult listOrderItemsResult;
        System.out.println("We have " + orders.size()+ " Orders to process!!!");
        log.info("Processing order updates.");
        for (Order order : orders) {
            System.out.println("Processing Order: "+ orders.indexOf(order));
            
            //Will always return TRUE, must change logic this method; so that it only processes orders when not in DB
            int check = shouldFetchOrderItems(order);// -2 = no fetch;-1 = ERROR; 0 = ADD item; 1 = UPDATE existing order
        
            if (check==0) {
                log.info("Order being processed: " + order.getAmazonOrderId());
                System.out.println("Order Being Processeddd: " + order.getAmazonOrderId());
                System.out.println("Order Being Statusss: " + order.getOrderStatus());
                //Find the Order items associated with this order
                listOrderItemsResult = listOrderItems(order, check);
                
                
                //Handle situation where NextToken is shown
                if (listOrderItemsResult != null
                        && listOrderItemsResult.isSetNextToken()) {
                    ListOrderItemsByNextTokenRequest listOrderItemsByNextTokenRequest = new ListOrderItemsByNextTokenRequest();
                    listOrderItemsByNextTokenRequest
                            .setSellerId(OrdersConfig.sellerId);
                    String nextToken = listOrderItemsResult.getNextToken();

                    ListOrderItemsByNextTokenResult listOrderItemsByNextTokenResult = null;

                    while (nextToken != null && keepRunning) {
                        listOrderItemsByNextTokenRequest
                                .setNextToken(nextToken);
                        listOrderItemsByNextTokenResult = listOrderItemsByNextToken(
                                listOrderItemsByNextTokenRequest, order, check);
                        nextToken = listOrderItemsByNextTokenResult
                                .getNextToken();
                    }
                }
            }else if(check > 0){//UPDATE when check is 1,2,3,4+
                log.info("Order being UPDATED: " + order.getAmazonOrderId());
                System.out.println("Order Being Processeddd: " + order.getAmazonOrderId());
                System.out.println("Order Being Statusss: " + order.getOrderStatus());
                //Find the Order items associated with this order
                listOrderItemsResult = listOrderItems(order, check);
                
                
                //Handle situation where NextToken is shown
                if (listOrderItemsResult != null
                        && listOrderItemsResult.isSetNextToken()) {
                    ListOrderItemsByNextTokenRequest listOrderItemsByNextTokenRequest = new ListOrderItemsByNextTokenRequest();
                    listOrderItemsByNextTokenRequest
                            .setSellerId(OrdersConfig.sellerId);
                    String nextToken = listOrderItemsResult.getNextToken();

                    ListOrderItemsByNextTokenResult listOrderItemsByNextTokenResult = null;

                    while (nextToken != null && keepRunning) {
                        listOrderItemsByNextTokenRequest
                                .setNextToken(nextToken);
                        listOrderItemsByNextTokenResult = listOrderItemsByNextToken(
                                listOrderItemsByNextTokenRequest, order, check);
                        nextToken = listOrderItemsByNextTokenResult
                                .getNextToken();
                    }
                }
            }
        }
    }

    /*
     * listOrderItems call. If a request is throttled, this method calls the
     * throttling handler and sets the retry flag to true.
     */
    protected ListOrderItemsResult listOrderItems(Order order, int check)
            throws MarketplaceWebServiceOrdersException {
        log.info("Calling ListOrderItems.");
        boolean retry;
        List<OrderItem> items;
        ListOrderItemsRequest listOrderItemsRequest = new ListOrderItemsRequest();
        listOrderItemsRequest.setSellerId(sellerId);
        listOrderItemsRequest.setAmazonOrderId(order.getAmazonOrderId());
        ListOrderItemsResponse listOrderItemsResponse = null;
        ListOrderItemsResult listOrderItemsResult = null;

        do {
            retry = false;
            try {
                //Sends the request from client to MWS
                listOrderItemsResponse = service
                        .listOrderItems(listOrderItemsRequest);
            } catch (MarketplaceWebServiceOrdersException ex) {
                if (ex.getStatusCode() == HttpStatus.SC_SERVICE_UNAVAILABLE
                        && "RequestThrottled".equals(ex.getErrorCode())) {
                    retry = true;
                    requestThrottledExceptionHandler(LIST_ORDER_ITEMS_THROTTLE_LIMIT);
                } else {
                    throw ex;
                }
            }
            // null = Problem with response recieved
            // such as request was throttled
            if (listOrderItemsResponse != null
                    && listOrderItemsResponse.isSetListOrderItemsResult()) {
                listOrderItemsResult = listOrderItemsResponse
                        .getListOrderItemsResult();
                if (listOrderItemsResult.isSetOrderItems()
                        && listOrderItemsResult.getOrderItems()
                                .isSetOrderItem()) {
                    items = listOrderItemsResponse.getListOrderItemsResult()
                            .getOrderItems().getOrderItem();
                    if(check==0){
                        processOrderItems(order, items);
                    }else{
                        processOrderItemUpdates(order, items);
                    }
                }
            }

        } while (retry && keepRunning);

        return listOrderItemsResult;
    }

    /**
     * Check if Order exists in DB, AND if OrderStatus or LastUpdateDate is different of that item.
     * If check TRUE => return 0; 
     * If check FALSE => return 1;
     * If Unknown condition => return -1; "ERROR"
     * @param order The Amazon order, data is serialized into Order Object
     */
    protected int shouldFetchOrderItems(Order order) {
        
        try {
            //variables we are interested in checking
            String orderStatus = order.getOrderStatus().value();
            String orderLastUpdateDate = order.getLastUpdateDate().toString();
            String orderID = order.getAmazonOrderId();
            ArrayList<String> orderID_DB = new ArrayList();
            ArrayList<String> orderLastUpdateDate_DB = new ArrayList();
            ArrayList<String> orderStatus_DB = new ArrayList();
            
            
            //load orders from DB **may need to edit this to only load non-Shipped orders **
            // ** returns may be special in this case
            String sql = "SELECT order_id,status,last_update_date FROM sync_amzn_order WHERE order_id = \""+orderID+"\"";
            System.out.println(order.getAmazonOrderId());
            pst = conn.prepareStatement(sql);
            
            System.out.println("Trying to execute");
            ResultSet rs = pst.executeQuery();
            System.out.println(rs.getRow());

                
            System.out.println("FOUND A ResultSET::--------------------------------------------------------------------------------------");
            System.out.println("CHECKING if it has something useful");
            while(rs.next()){
                orderID_DB.add(rs.getString(1));
                orderLastUpdateDate_DB.add(rs.getString(2));
                orderStatus_DB.add(rs.getString(3));
            }
            if(orderID_DB.size()>1){
                JOptionPane.showMessageDialog(null, "THERE IS A PROBLEM IN SQL TABLE, two ENTRIES!!!");
            }
            System.out.println("Recieved result::Checking it out....");            

            //IF OrderID's is empty (size = 0)           
            //THEN we must run process; entering items into DB; return 0 to carry actions.
            if(orderID_DB.isEmpty()){
                System.out.println("New Order, adding to DB");
                return 0;
            }//then found, we must check the Order in the DB; shouldn't re add new order.
            else{
                //different (orderStatus OR LastUpdateDate) => UPDATE
                if(!orderStatus_DB.get(0).equals(orderStatus)||!orderLastUpdateDate_DB.get(0).equals(orderLastUpdateDate)){
                    //Re-update everything
                    System.out.println("We have this Order in DB, a different status found, updating ALL fields");
                    return 1;
                }else{
                    return -2; // Don't fetch Order
                }
                

            }
            
            
            //default: just grab all the items and input into DB
            //JOptionPane.showMessageDialog(null, "NOT EXECUTING IF!");
            //return -1;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FetchOrderUpdatesJob.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("SOMETHIGN Went WRONG with SQL STATEMENT!!________---__-_-_"+ex);
            ex.printStackTrace();
            //we hit an error
            return -1;
        }
        
        
    }

    /*
	 * listOrderItemsByNextToken call. If a request is throttled, this method
	 * calls the throttling handler and sets the retry flag to true.
	 */
	protected ListOrderItemsByNextTokenResult listOrderItemsByNextToken(
	        ListOrderItemsByNextTokenRequest listOrderItemsByNextTokenRequest,
	        Order order, int check) throws MarketplaceWebServiceOrdersException {
	    log.info("Calling ListOrderItemsByNextToken.");
	    boolean retry;
	    List<OrderItem> items;
	    ListOrderItemsByNextTokenResponse listOrderItemsByNextTokenResponse = null;
	    ListOrderItemsByNextTokenResult listOrderItemsByNextTokenResult = null;
	
	    do {
	        retry = false;
	        try {
	            listOrderItemsByNextTokenResponse = service
	                    .listOrderItemsByNextToken(listOrderItemsByNextTokenRequest);
	        } catch (MarketplaceWebServiceOrdersException ex) {
	            if (ex.getStatusCode() == HttpStatus.SC_SERVICE_UNAVAILABLE
	                    && "RequestThrottled".equals(ex.getErrorCode())) {
	                retry = true;
	                requestThrottledExceptionHandler(LIST_ORDER_ITEMS_THROTTLE_LIMIT);
	            } else {
	                throw ex;
	            }
	        }
	        if (listOrderItemsByNextTokenResponse != null
	                && listOrderItemsByNextTokenResponse
	                        .isSetListOrderItemsByNextTokenResult()) {
	            listOrderItemsByNextTokenResult = listOrderItemsByNextTokenResponse
	                    .getListOrderItemsByNextTokenResult();
	            if (listOrderItemsByNextTokenResult.isSetOrderItems()
	                    && listOrderItemsByNextTokenResult.getOrderItems()
	                            .isSetOrderItem()) {
	                items = listOrderItemsByNextTokenResponse
	                        .getListOrderItemsByNextTokenResult()
	                        .getOrderItems().getOrderItem();
	                 if(check==0){
	                    processOrderItems(order, items);
	                }else{
	                    processOrderItemUpdates(order, items);
	                }
	            }
	        }
	    } while (retry && keepRunning);
	
	    return listOrderItemsByNextTokenResult;
	}

	/**
     * Simply prints out the data to SQLite DB.
     */
    protected void processOrderItems(Order order, List<OrderItem> orderItems) {
        log.info("****************** Order info********************");
        log.info("Adding "+order.getAmazonOrderId().toString()+ " to the Database.");
        
        //adds objects order to Database
        addOrderDB(order);
        
        log.info(order.toString() + " added to Databse");
        
        if (orderItems != null && orderItems.size() > 0) {
            
            log.info("================== Order Items info ====================");
            
            for (OrderItem item : orderItems) {
                log.info("Adding item: "+item.getOrderItemId().toString()+" into DB");
                
                //adds objects item to Database
                addOrderItemDB(order,item);
                
                log.info(item.toString() + " added to Databse");
                        
            }
        }
    }
    /**
     * The Data is already serialized, in this method we update orders with their NEW STATUS.
     * E.G order in DB is PENDING; new FetchOrder shows order is now SHIPPED
     * ALSO, update the items of these orders
     * @param order Amazon order, already serialized. 
     */
    protected void processOrderItemUpdates(Order order, List<OrderItem> orderItems){
        log.info("****************** Order info********************");
        log.info("UPDATING "+order.getAmazonOrderId()+ " in the Database.");
        
        //updates objects order in Database
        updateOrderDB(order);
        
        log.info(order.toString() + " updated in Databse");
        
        if (orderItems != null && orderItems.size() > 0) {
            
            log.info("================== Order Items info ====================");
            log.info(String.format("Found %d items to update/add.", orderItems.size()));
            for (OrderItem item : orderItems) {
                log.info("Adding item: "+item.getOrderItemId().toString()+" into DB");
                
                //updates objects item in Database
                updateOrderItemDB(order,item);
                
                log.info(item.getOrderItemId().toString() + " updated in Databse");
                        
            }
        }
    }
    
    /**
     * @param order a serialized Order object
     */
    private void addOrderDB(Order order){
        String sql = null;
        
        try{
           sql = "INSERT INTO sync_amzn_order "
                + "(order_id,"
                + "channel,"
                + "market_id,"
                + "status,"
                + "purchase_date,"
                + "last_update_date,"
                + "order_type,"
                + "fullfilled,"
                + "number_unshipped,"
                + "number_shipped,"
                + "ship_type,"
                + "ship_service,"
                + "last_ship_date,"
                + "early_ship_date,"
                + "buyer_name,"
                + "shipping_phone,"
                + "shipping_name,"
                + "shipping_street1,"
                + "shipping_street2,"
                + "shipping_street3,"
                + "shipping_city,"
                + "shipping_zip,"
                + "shipping_state,"
                + "shipping_country,"
                + "buyer_email,"
                + "buyer_payment_method,"
                + "buyer_payment_amount) "
                + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
                + " ON DUPLICATE KEY UPDATE "
                + "channel = ?,"
                + "market_id=?,"
                + "status=?,"
                + "purchase_date=?,"
                + "last_update_date=?,"
                + "order_type=?,"
                + "fullfilled=?,"
                + "number_unshipped=?,"
                + "number_shipped=?,"
                + "ship_type=?,"
                + "ship_service=?,"
                + "last_ship_date=?,"
                + "early_ship_date=?,"
                + "buyer_name=?,"
                + "shipping_phone=?,"
                + "shipping_name=?,"
                + "shipping_street1=?,"
                + "shipping_street2=?,"
                + "shipping_street3=?,"
                + "shipping_city=?,"
                + "shipping_zip=?,"
                + "shipping_state=?,"
                + "shipping_country=?,"
                + "buyer_email=?,"
                + "buyer_payment_method=?,"
                + "buyer_payment_amount=?";
           
            pst = conn.prepareStatement(sql);
            
            //THIS WILL NEED TO GET REFACTORED!!!

            if(order.isSetAmazonOrderId()){pst.setString(1, order.getAmazonOrderId());}else{pst.setString(1,null);} //order_id
            if(order.isSetSalesChannel()){pst.setString(2, order.getSalesChannel());}else{pst.setString(2,null);} // channel
            if(order.isSetMarketplaceId()){pst.setString(3, order.getMarketplaceId());}else{pst.setString(3,null);}// market_id
            if(order.isSetOrderStatus()){pst.setString(4, order.getOrderStatus().value());}else{pst.setString(4,null);}// status
            if(order.isSetPurchaseDate()){pst.setString(5, order.getPurchaseDate().toString());}else{pst.setString(5,null);}// purchase_date
            if(order.isSetLastUpdateDate()){pst.setString(6, order.getLastUpdateDate().toString());}else{pst.setString(6,null);}// last_update_date
            if(order.isSetOrderType()){pst.setString(7, order.getOrderType());}else{pst.setString(7,null);}     // order_type
            if(order.isSetFulfillmentChannel()){pst.setString(8, order.getFulfillmentChannel().value());}else{pst.setString(8,null);}// fullfilled
            if(order.isSetNumberOfItemsUnshipped()){pst.setInt(9, order.getNumberOfItemsUnshipped());}else{pst.setInt(9,0);}// number_unshipped
            if(order.isSetNumberOfItemsShipped()){pst.setInt(10, order.getNumberOfItemsShipped());}else{pst.setInt(10,0);}// number_shipped
            if(order.isSetShipmentServiceLevelCategory()){pst.setString(11, order.getShipmentServiceLevelCategory());}else{pst.setString(11,null);}// ship_type
            if(order.isSetShipServiceLevel()){pst.setString(12, order.getShipServiceLevel());}else{pst.setString(12,null);}// ship_service
            if(order.isSetLastUpdateDate()){pst.setString(13, order.getLatestShipDate().toString());}else{pst.setString(13,null);}// last_ship_date
            if(order.isSetEarliestShipDate()){pst.setString(14, order.getEarliestShipDate().toString());}else{pst.setString(14,null);}// early_ship_date
            if(order.isSetBuyerName()){pst.setString(15, order.getBuyerName());}else{pst.setString(15,null);}// buyer_name
            if(order.isSetShippingAddress()){pst.setString(16, order.getShippingAddress().getPhone());}else{pst.setString(16,null);}// shipping_phone
            if(order.isSetShippingAddress()){pst.setString(17, order.getShippingAddress().getName());}else{pst.setString(17,null);}// shipping_name
            if(order.isSetShippingAddress()){pst.setString(18, order.getShippingAddress().getAddressLine1());}else{pst.setString(18,null);}// shipping_street1
            if(order.isSetShippingAddress()){pst.setString(19, order.getShippingAddress().getAddressLine2());}else{pst.setString(19,null);}// shipping_street2
            if(order.isSetShippingAddress()){pst.setString(20, order.getShippingAddress().getAddressLine3());}else{pst.setString(20,null);}// shipping_street3
            if(order.isSetShippingAddress()){pst.setString(21, order.getShippingAddress().getCity());}else{pst.setString(21,null);}// shipping_city
            if(order.isSetShippingAddress()){pst.setString(22, order.getShippingAddress().getPostalCode());}else{pst.setString(22,null);}// shipping_zip
            if(order.isSetShippingAddress()){pst.setString(23, order.getShippingAddress().getStateOrRegion());}else{pst.setString(23,null);}// shipping_state
            if(order.isSetShippingAddress()){pst.setString(24, order.getShippingAddress().getCountryCode());}else{pst.setString(24,null);}// shipping_country 
            if(order.isSetBuyerEmail()){pst.setString(25, order.getBuyerEmail());}else{pst.setString(25,null);}// buyer_email
            if(order.isSetPaymentMethod()){pst.setString(26, order.getPaymentMethod().value());}else{pst.setString(26,null);}// buyer_payment_method
            if(order.isSetOrderTotal()){pst.setString(27, order.getOrderTotal().getAmount());}else{pst.setString(27,null);}// buyer_payment_amount
            if(order.isSetSalesChannel()){pst.setString(28, order.getSalesChannel());}else{pst.setString(28,null);}// channel
            if(order.isSetMarketplaceId()){pst.setString(29, order.getMarketplaceId());}else{pst.setString(29,null);}// market_id
            if(order.isSetOrderStatus()){pst.setString(30, order.getOrderStatus().value());}else{pst.setString(30,null);}// status
            if(order.isSetPurchaseDate()){pst.setString(31, order.getPurchaseDate().toString());}else{pst.setString(31,null);}// purchase_date
            if(order.isSetLastUpdateDate()){pst.setString(32, order.getLastUpdateDate().toString());}else{pst.setString(32,null);}// last_update_date
            if(order.isSetOrderType()){pst.setString(33, order.getOrderType());} else{pst.setString(33,null);}     // order_type
            if(order.isSetFulfillmentChannel()){pst.setString(34, order.getFulfillmentChannel().value());} else{pst.setString(34,null);}// fullfilled
            if(order.isSetNumberOfItemsUnshipped()){pst.setInt(35, order.getNumberOfItemsUnshipped());} else{pst.setInt(35,0);}// number_unshipped
            if(order.isSetNumberOfItemsShipped()){pst.setInt(36, order.getNumberOfItemsShipped());} else{pst.setInt(36,0);}// number_shipped
            if(order.isSetShipmentServiceLevelCategory()){pst.setString(37, order.getShipmentServiceLevelCategory());} else{pst.setString(37,null);}// ship_type
            if(order.isSetShipServiceLevel()){pst.setString(38, order.getShipServiceLevel());} else{pst.setString(38,null);}// ship_service
            if(order.isSetLastUpdateDate()){pst.setString(39, order.getLatestShipDate().toString());} else{pst.setString(39,null);}// last_ship_date
            if(order.isSetEarliestShipDate()){pst.setString(40, order.getEarliestShipDate().toString());} else{pst.setString(40,null);}// early_ship_date
            if(order.isSetBuyerName()){pst.setString(41, order.getBuyerName());} else{pst.setString(41,null);}// buyer_name
            if(order.isSetShippingAddress()){pst.setString(42, order.getShippingAddress().getPhone());} else{pst.setString(42,null);}// shipping_phone
            if(order.isSetShippingAddress()){pst.setString(43, order.getShippingAddress().getName());} else{pst.setString(43,null);}// shipping_name
            if(order.isSetShippingAddress()){pst.setString(44, order.getShippingAddress().getAddressLine1());} else{pst.setString(44,null);}// shipping_street1
            if(order.isSetShippingAddress()){pst.setString(45, order.getShippingAddress().getAddressLine2());} else{pst.setString(45,null);}// shipping_street2
            if(order.isSetShippingAddress()){pst.setString(46, order.getShippingAddress().getAddressLine3());} else{pst.setString(46,null);}// shipping_street3
            if(order.isSetShippingAddress()){pst.setString(47, order.getShippingAddress().getCity());} else{pst.setString(47,null);}// shipping_city
            if(order.isSetShippingAddress()){pst.setString(48, order.getShippingAddress().getPostalCode());} else{pst.setString(48,null);}// shipping_zip
            if(order.isSetShippingAddress()){pst.setString(49, order.getShippingAddress().getStateOrRegion());} else{pst.setString(49,null);}// shipping_state
            if(order.isSetShippingAddress()){pst.setString(50, order.getShippingAddress().getCountryCode());} else{pst.setString(50,null);}// shipping_country 
            if(order.isSetBuyerEmail()){pst.setString(51, order.getBuyerEmail());} else{pst.setString(51,null);}// buyer_email
            if(order.isSetPaymentMethod()){pst.setString(52, order.getPaymentMethod().value());} else{pst.setString(52,null);}// buyer_payment_method
            if(order.isSetOrderTotal()){pst.setString(53, order.getOrderTotal().getAmount());} else{pst.setString(53,null);}// buyer_payment_amount

            pst.executeUpdate();
        
        }catch(SQLException e){
            System.out.println("SQL PROBLEM: "+ e);
            Logger.getLogger(FetchOrderUpdatesJob.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * @param 
     */
    private void addOrderItemDB(Order order,OrderItem item){
        String sql;
        
        try {
            sql = "INSERT INTO sync_amzn_order_item "
                    + "(order_id,"
                    + "order_item_id,"
                    + "sku,"
                    + "asin,"
                    + "title,"
                    + "qty_ordered,"
                    + "qty_shipped,"
                    + "giftwrap_price,"
                    + "giftwrap_tax,"
                    + "ship_price,"
                    + "ship_tax,"
                    + "item_price,"
                    + "item_tax,"
                    + "promo_discount,"
                    + "ship_discount,"
                    + "item_condition)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) "
                    + "ON DUPLICATE KEY UPDATE "
                    + "sku=?,"
                    + "asin=?,"
                    + "title=?,"
                    + "qty_ordered=?,"
                    + "qty_shipped=?,"
                    + "giftwrap_price=?,"
                    + "giftwrap_tax=?,"
                    + "ship_price=?,"
                    + "ship_tax=?,"
                    + "item_price=?,"
                    + "item_tax=?,"
                    + "promo_discount=?,"
                    + "ship_discount=?,"
                    + "item_condition=?";
            pst = conn.prepareStatement(sql);


            if(order.isSetAmazonOrderId()){pst.setString(1, order.getAmazonOrderId());}else{pst.setString(1, null);}// order_id
            if(item.isSetOrderItemId()){pst.setString(2, item.getOrderItemId());}else{pst.setString(2, null);}// order_item_id
            if(item.isSetSellerSKU()){pst.setString(3, item.getSellerSKU());}else{pst.setString(3, null);}// sku
            if(item.isSetASIN()){pst.setString(4, item.getASIN());}else{pst.setString(4, null);}// asin
            if(item.isSetTitle()){pst.setString(5, item.getTitle());}else{pst.setString(5, null);}// title
            if(item.isSetQuantityOrdered()){pst.setInt(6, item.getQuantityOrdered());}else{pst.setInt(6, 0);}// qty_ordered
            if(item.isSetQuantityShipped()){pst.setInt(7, item.getQuantityShipped());}else{pst.setInt(7, 0);}// qty_shipped
            if(item.isSetGiftWrapPrice()){pst.setString(8, item.getGiftWrapPrice().getAmount());}else{pst.setString(8, null);}// giftwrap_price
            if(item.isSetGiftWrapTax()){pst.setString(9, item.getGiftWrapTax().getAmount());}else{pst.setString(9, null);}// giftwrap_tax
            if(item.isSetShippingPrice()){pst.setString(10, item.getShippingPrice().getAmount());}else{pst.setString(10, null);}// ship_price
            if(item.isSetShippingTax()){pst.setString(11, item.getShippingTax().getAmount());}else{pst.setString(11, null);}// ship_tax
            if(item.isSetItemPrice()){pst.setString(12, item.getItemPrice().getAmount());}else{pst.setString(12, null);}// item_price
            if(item.isSetItemTax()){pst.setString(13, item.getItemTax().getAmount());}else{pst.setString(13, null);}// item_tax
            if(item.isSetPromotionDiscount()){pst.setString(14, item.getPromotionDiscount().getAmount());}else{pst.setString(14, null);}// promo_discount
            if(item.isSetShippingDiscount()){pst.setString(15, item.getShippingDiscount().getAmount());}else{pst.setString(15, null);}// ship_discount
            if(item.isSetConditionId()){pst.setString(16, item.getConditionId());}else{pst.setString(16, null);}// condition
            if(item.isSetSellerSKU()){pst.setString(17, item.getSellerSKU());}else{pst.setString(17,null);}// sku
            if(item.isSetASIN()){pst.setString(18, item.getASIN());}else{pst.setString(18,null);}// asin
            if(item.isSetTitle()){pst.setString(19, item.getTitle());}else{pst.setString(19,null);}// title
            if(item.isSetQuantityOrdered()){pst.setInt(20, item.getQuantityOrdered());}else{pst.setInt(20,0);}// qty_ordered
            if(item.isSetQuantityShipped()){pst.setInt(21, item.getQuantityShipped());}else{pst.setInt(21,0);}// qty_shipped
            if(item.isSetGiftWrapPrice()){pst.setString(22, item.getGiftWrapPrice().getAmount());}else{pst.setString(22,null);}// giftwrap_price
            if(item.isSetGiftWrapTax()){pst.setString(23, item.getGiftWrapTax().getAmount());}else{pst.setString(23,null);}// giftwrap_tax
            if(item.isSetShippingPrice()){pst.setString(24, item.getShippingPrice().getAmount());}else{pst.setString(24,null);}// ship_price
            if(item.isSetShippingTax()){pst.setString(25, item.getShippingTax().getAmount());}else{pst.setString(25,null);}// ship_tax
            if(item.isSetItemPrice()){pst.setString(26, item.getItemPrice().getAmount());}else{pst.setString(26,null);}// item_price
            if(item.isSetItemTax()){pst.setString(27, item.getItemTax().getAmount());}else{pst.setString(27,null);}// item_tax
            if(item.isSetPromotionDiscount()){pst.setString(28, item.getPromotionDiscount().getAmount());}else{pst.setString(28,null);}// promo_discount
            if(item.isSetShippingDiscount()){pst.setString(29, item.getShippingDiscount().getAmount());}else{pst.setString(29,null);}// ship_discount
            if(item.isSetConditionId()){pst.setString(30, item.getConditionId());}else{pst.setString(30,null);}// condition

            pst.executeUpdate();
            

        } catch (SQLException ex) {
            System.out.println("SQL PROBLEM: "+ ex);
            Logger.getLogger(FetchOrderUpdatesJob.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    /**
     * @param order a serialized Order object
     */
    private void updateOrderDB(Order order){
        String sql = null;
        String orderID = order.getAmazonOrderId();
        
        try{
           sql = "UPDATE sync_amzn_order SET "
                + "channel = ?,"
                + "market_id = ?,"
                + "status = ?,"
                + "purchase_date = ?,"
                + "last_update_date = ?,"
                + "order_type = ?,"
                + "fullfilled = ?,"
                + "number_unshipped = ?,"
                + "number_shipped = ?,"
                + "ship_type = ?,"
                + "ship_service = ?,"
                + "last_ship_date = ?,"
                + "early_ship_date = ?,"
                + "buyer_name = ?,"
                + "shipping_phone = ?,"
                + "shipping_name = ?,"
                + "shipping_street1 = ?,"
                + "shipping_street2 = ?,"
                + "shipping_street3 = ?,"
                + "shipping_city = ?,"
                + "shipping_zip = ?,"
                + "shipping_state = ?,"
                + "shipping_country = ?,"
                + "buyer_email = ?,"
                + "buyer_payment_method = ?,"
                + "buyer_payment_amount = ? "
                + " WHERE order_id= \""+ orderID+"\"";
            pst = conn.prepareStatement(sql);
            
            //THIS WILL NEED TO GET REFACTORED!!!
            if(order.isSetSalesChannel()){pst.setString(1, order.getSalesChannel());}else{pst.setString(1,null);} // channel
            if(order.isSetMarketplaceId()){pst.setString(2, order.getMarketplaceId());}else{pst.setString(2,null);}// market_id
            if(order.isSetOrderStatus()){pst.setString(3, order.getOrderStatus().value());}else{pst.setString(3,null);}// status
            if(order.isSetPurchaseDate()){pst.setString(4, order.getPurchaseDate().toString());}else{pst.setString(4,null);}// purchase_date
            if(order.isSetLastUpdateDate()){pst.setString(5, order.getLastUpdateDate().toString());}else{pst.setString(5,null);}// last_update_date
            if(order.isSetOrderType()){pst.setString(6, order.getOrderType());}else{pst.setString(6,null);}     // order_type
            if(order.isSetFulfillmentChannel()){pst.setString(7, order.getFulfillmentChannel().value());}else{pst.setString(7,null);}// fullfilled
            if(order.isSetNumberOfItemsUnshipped()){pst.setInt(8, order.getNumberOfItemsUnshipped());}else{pst.setInt(8,0);}// number_unshipped
            if(order.isSetNumberOfItemsShipped()){pst.setInt(9, order.getNumberOfItemsShipped());}else{pst.setInt(9,0);}// number_shipped
            if(order.isSetShipmentServiceLevelCategory()){pst.setString(10, order.getShipmentServiceLevelCategory());}else{pst.setString(10,null);}// ship_type
            if(order.isSetShipServiceLevel()){pst.setString(11, order.getShipServiceLevel());}else{pst.setString(11,null);}// ship_service
            if(order.isSetLastUpdateDate()){pst.setString(12, order.getLatestShipDate().toString());}else{pst.setString(12,null);}// last_ship_date
            if(order.isSetEarliestShipDate()){pst.setString(13, order.getEarliestShipDate().toString());}else{pst.setString(13,null);}// early_ship_date
            if(order.isSetBuyerName()){pst.setString(14, order.getBuyerName());}else{pst.setString(14,null);}// buyer_name
            if(order.isSetShippingAddress()){pst.setString(15, order.getShippingAddress().getPhone());}else{pst.setString(15,null);}// shipping_phone
            if(order.isSetShippingAddress()){pst.setString(16, order.getShippingAddress().getName());}else{pst.setString(16,null);}// shipping_name
            if(order.isSetShippingAddress()){pst.setString(17, order.getShippingAddress().getAddressLine1());}else{pst.setString(17,null);}// shipping_street1
            if(order.isSetShippingAddress()){pst.setString(18, order.getShippingAddress().getAddressLine2());}else{pst.setString(18,null);}// shipping_street2
            if(order.isSetShippingAddress()){pst.setString(19, order.getShippingAddress().getAddressLine3());}else{pst.setString(19,null);}// shipping_street3
            if(order.isSetShippingAddress()){pst.setString(20, order.getShippingAddress().getCity());}else{pst.setString(20,null);}// shipping_city
            if(order.isSetShippingAddress()){pst.setString(21, order.getShippingAddress().getPostalCode());}else{pst.setString(21,null);}// shipping_zip
            if(order.isSetShippingAddress()){pst.setString(22, order.getShippingAddress().getStateOrRegion());}else{pst.setString(22,null);}// shipping_state
            if(order.isSetShippingAddress()){pst.setString(23, order.getShippingAddress().getCountryCode());}else{pst.setString(23,null);}// shipping_country 
            if(order.isSetBuyerEmail()){pst.setString(24, order.getBuyerEmail());}else{pst.setString(24,null);}// buyer_email
            if(order.isSetPaymentMethod()){pst.setString(25, order.getPaymentMethod().value());}else{pst.setString(25,null);}// buyer_payment_method
            if(order.isSetOrderTotal()){pst.setString(26, order.getOrderTotal().getAmount());}else{pst.setString(26,null);}// buyer_payment_amount

            pst.executeUpdate();
        
        }catch(SQLException e){
            System.out.println("SQL PROBLEM: "+ e);
            Logger.getLogger(FetchOrderUpdatesJob.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * @param 
     */
    private void updateOrderItemDB(Order order,OrderItem item){
        String sql;
        
        try {
            sql = "UPDATE sync_amzn_order_item SET "
                    + "sku = ?,"
                    + "asin = ?,"
                    + "title = ?,"
                    + "qty_ordered = ?,"
                    + "qty_shipped = ?,"
                    + "giftwrap_price = ?,"
                    + "giftwrap_tax = ?,"
                    + "ship_price = ?,"
                    + "ship_tax = ?,"
                    + "item_price = ?,"
                    + "item_tax = ?,"
                    + "promo_discount = ?,"
                    + "ship_discount = ?,"
                    + "item_condition = ?"
                    + " WHERE order_id= \""+ order.getAmazonOrderId()+"\""
                    		+ " and order_item_id=\""+item.getOrderItemId()+"\"";
            pst = conn.prepareStatement(sql);

            if(item.isSetSellerSKU()){pst.setString(1, item.getSellerSKU());}else{pst.setString(1, null);}// sku
            if(item.isSetASIN()){pst.setString(2, item.getASIN());}else{pst.setString(2, null);}// asin
            if(item.isSetTitle()){pst.setString(3, item.getTitle());}else{pst.setString(3, null);}// title
            if(item.isSetQuantityOrdered()){pst.setInt(4, item.getQuantityOrdered());}else{pst.setInt(4, 0);}// qty_ordered
            if(item.isSetQuantityShipped()){pst.setInt(5, item.getQuantityShipped());}else{pst.setInt(5, 0);}// qty_shipped
            if(item.isSetGiftWrapPrice()){pst.setString(6, item.getGiftWrapPrice().getAmount());}else{pst.setString(6, null);}// giftwrap_price
            if(item.isSetGiftWrapTax()){pst.setString(7, item.getGiftWrapTax().getAmount());}else{pst.setString(7, null);}// giftwrap_tax
            if(item.isSetShippingPrice()){pst.setString(8, item.getShippingPrice().getAmount());}else{pst.setString(8, null);}// ship_price
            if(item.isSetShippingTax()){pst.setString(9, item.getShippingTax().getAmount());}else{pst.setString(9, null);}// ship_tax
            if(item.isSetItemPrice()){pst.setString(10, item.getItemPrice().getAmount());}else{pst.setString(10, null);}// item_price
            if(item.isSetItemTax()){pst.setString(11, item.getItemTax().getAmount());}else{pst.setString(11, null);}// item_tax
            if(item.isSetPromotionDiscount()){pst.setString(12, item.getPromotionDiscount().getAmount());}else{pst.setString(12, null);}// promo_discount
            if(item.isSetShippingDiscount()){pst.setString(13, item.getShippingDiscount().getAmount());}else{pst.setString(13, null);}// ship_discount
            if(item.isSetConditionId()){pst.setString(14, item.getConditionId());}else{pst.setString(14, null);}// condition
            pst.executeUpdate();



        } catch (SQLException ex) {
            System.out.println("SQL PROBLEM: "+ ex);
            Logger.getLogger(FetchOrderUpdatesJob.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    /*
     * When a request is throttled, this method is called to make the thread
     * sleep for a period of time specified by the throttling limit.
     */
    private void requestThrottledExceptionHandler(
            long throttlingLimitInMilliseconds) {
        try {
            log.info("Request throttled. Sleeping for "
                    + throttlingLimitInMilliseconds / 1000 + " seconds.");
            System.out.println("Handling Throttle");

            // Sleep in 1 minute intervals for throttlingLimitInMillis or until
            // keepRunning is set to false.
            for (long i = throttlingLimitInMilliseconds; i > 0 && keepRunning; i = i - 60000L) {
                if (i < 60000L) {
                    Thread.sleep(i);
                } else {
                    Thread.sleep(60000L);
                }
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
            return;
        }
    }
}
