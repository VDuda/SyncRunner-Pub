/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.amazon;

import API.amazon.mws.orders.MarketplaceWebServiceOrders;
import API.amazon.mws.orders.MarketplaceWebServiceOrdersClient;
import API.amazon.mws.orders.actions.FetchOrderUpdatesJob;
import static API.amazon.mws.orders.actions.FetchOrderUpdatesJob.log;
import API.amazon.mws.orders.actions.OrdersConfig;

import java.sql.Connection;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.DBController;
import controller.amazon.model.SyncTimingsDB;

/**
 *
 * @author B2E_2
 */
public class SyncAMZGrabOrders {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String sql = null;
    
    
    /**
     * CONSTRUCTOR of GrabOrders
     * @throws InterruptedException 
     */
    public SyncAMZGrabOrders(Connection conn){
        System.out.println("hello");
        DatatypeFactory df = null;
        
        try {
            df = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(SyncAMZGrabOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        XMLGregorianCalendar startTime = df
                .newXMLGregorianCalendar(new GregorianCalendar());
        System.out.println(startTime);
        
        this.conn = conn;
        
        
        SyncTimingsDB syncTimingsDB = new SyncTimingsDB(conn,"Amazon");
        
        System.out.println(syncTimingsDB.getLastUpdated());
    
        System.out.println("\n\nNON LOG: test print");
        //This creates the connection to the MWS service
        //HAS NOT SENT ANY REQUESTS THOUGH, so MWS does not see us
        MarketplaceWebServiceOrders client = new MarketplaceWebServiceOrdersClient(
                OrdersConfig.accessKeyId,
                OrdersConfig.secretAccessKey,
                OrdersConfig.applicationName,
                OrdersConfig.applicationVersion,
                OrdersConfig.config);
        final FetchOrderUpdatesJob orderFetcher = new FetchOrderUpdatesJob(
                client, OrdersConfig.sellerId,
                OrdersConfig.marketplaceIdList,syncTimingsDB);
        

        Thread fetchOrderUpdatesJobThread = new Thread(new Runnable() {
            public void run() {
                orderFetcher.startPeriodicSynch();
            }
        });
        System.out.println("Done!~~~~~~Main Thread");
        // Start the FetchOrderUpdatesJob in the second thread.
        fetchOrderUpdatesJobThread.start();
        // at this point we have two threads
        // the main thread from the Main class  AND
        // the orderFetcher thread which executes startPeriodicSynch after THREAD.start() is called

        /*
         * The following code puts this thread to sleep for an hour and then the
         * stopSynch() method is called which stops the job in the second
         * thread.
         */

        /*
         * TODO: Make sure to change this if you want it to run indefinitely or
         * for some other length of time .
         *
        try {
            log.info("Main thread sleeping.");
            System.out.println("Dunno what this doing");
            Thread.sleep(3600000L); // = 1 hour
            //Thread.sleep(600000L);// = 10 min
            log.info("Main thread awake.");
            System.out.println("We are done executing things! Ending Main Thread");
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
            return;
        }
        */ 
        log.info("Main thread setting keepRunning to false.");
        //orderFetcher.stopSynch(); // Stops the FetchOrderUpdatesJob thread.

        // Join the two threads and wait for the fetchOrderUpdatesJobThread to
        // finish.
        /*
        try {
            fetchOrderUpdatesJobThread.join(); //wait forever for the sync to end.
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
            return;
        }*/
    }
    
    
    
    
}
