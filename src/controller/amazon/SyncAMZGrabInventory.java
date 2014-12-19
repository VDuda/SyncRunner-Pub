/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.amazon;

import API.amazon.mws.feeds.actions.FetchInventoryJob;

import java.sql.Connection;

import controller.DBController;

/**
 *
 * @author B2E_2
 */
public class SyncAMZGrabInventory {
    
    static Connection conn = null;
    
    public SyncAMZGrabInventory(Connection conn){
    	SyncAMZGrabInventory.conn = conn;
    }
    
    public static void initGrab(){
        System.out.println("Hello World! - from GrabInventory");

        final FetchInventoryJob fetchInventoryJob = new FetchInventoryJob(conn);

        Thread fetchInventoryJobThread = new Thread(new Runnable() {
            public void run() {
            	//_GET_FLAT_FILE_OPEN_LISTINGS_DATA_
            	fetchInventoryJob.periodicSync();
//            	System.out.println(fetchInventoryJob.invokeGetReportRequestList());
            	//fetchInventoryJob.invokeGetReport("16867400383");
            }
        });
        fetchInventoryJobThread.start(); // starts the thread to intiate sync.
        System.out.println("Done!~~~~~~Main Thread");
        
        
/*        ///
        final FetchOrderUpdatesJob orderFetcher = new FetchOrderUpdatesJob(
                client, OrdersConfig.sellerId,
                OrdersConfig.marketplaceIdList,syncTimingsDB);
        
        
        Thread fetchOrderUpdatesJobThread = new Thread(new Runnable() {
            public void run() {
                orderFetcher.startPeriodicSynch();
            }
        });
        */
        
        int c = 1;
        int t = (int) (c + c * Math.PI * Math.atan(c));
        
        System.out.println(t);
        
    }
    
    public static void main(String[] args){
    	DBController.writeColumns(DBController.issueCmd("SELECT * from sync_amzn_products"));
    	new SyncAMZGrabInventory(DBController.getConn());
    }
}
