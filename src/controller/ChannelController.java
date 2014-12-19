package controller;


import java.io.File;
import java.sql.Connection;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author B2E_2
 */
public abstract class ChannelController<T> implements ChannelListing<T>{
    
    /**
     * @description Grab recent orders from respective Channel
     *      upload these orders into a SQLite table
     */
    public abstract void getOrders(Connection conn); 
    
    /**
     * @parameters Array of SKUs
     * @description Grab items from Selected Channel 
     * @return Should return a CSV file, as to easily transmit into DB
     */
    public abstract void getInventory(Connection conn);/*{
        System.out.println("Not implemented in Controller, getInventory()");
        
        return null;
    }*/
    
    /**
     * @parameters Item description to create item, should be an external File, XML or CSV
     * @description Create & format a file based off items from Amazon MWS + Advert, for that respective channel
     * 
     */
    public abstract void createInventory(File data);/*{ //this may be deleted, seems confusing and unnecessary 
        System.out.println("Not Implemented in Controller, createInventory()\n Data Entered: "+ data);
    }*/
    
    /**
     * @parameters The output file from getInventory() should be the parameter
     * @description Process should look through DB to see if any matching SKUs are found, 
     *  if so delete from new output File.
     * 
     * @return  Returned should be a CSV File with the items NOT in the DB but on the specific channel.
     *  Therefore these products will need to be added to the DB.  
     */
    public abstract File compareToDB(File data);/*{
        System.out.println("Not implemented in Controller, compareToDB()\n Data Entered: "+ data);
        return null;
    }*/
    
    /**
     * 
     * @description List a file to respective channel. Item attributes should come from DB.
     *              Must format items to fit respective channel's specification.
     * @param data
     * @return The file which gets pushed to Channel
     */
    public abstract File bulkList(File data);
    
    /**
     * @description List & format an individual item
     */
	public abstract void list(T data);

}
