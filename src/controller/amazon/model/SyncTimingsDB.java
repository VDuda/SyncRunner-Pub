/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.amazon.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


/**
 *
 * Communicates with the DB, getting recent Sync Times
 * 
 * @author B2E_2
 */
public class SyncTimingsDB {
    
    Connection conn = null;
    PreparedStatement pst = null;
    String lastUpdated = null;
    String channel = null;
    
    /**
     * Default constructor, <b>YOU MUST</b> call setConnection() and call UpdateLastUpdatedDB()
     */
    public SyncTimingsDB(){
        super();
    }
    
    /**
     * Constructor for Checking and viewing values from the DB, calls getLastUpdatedDB automatically
     * @param conn
     * @param channel 
     */
    public SyncTimingsDB(Connection conn, String channel){
        this.conn = conn;
        this.channel = channel;
        getLastUpdatedDB(conn,channel);
    }
    
    /**
     * Sync using an already created connection, this WILL connect to the db.
     * Also, UpdateLastUpdatedDB will be called with channel and time parameters
     * @param conn Uses a previously used connection
     * @param channel pass a channel to update, available channels are
     * @param time pass the lexical string format for the date
     */
    public SyncTimingsDB(Connection conn, String channel,String time){
        this.conn = conn;
        this.channel = channel;
        updateLastUpdatedDB(channel,time);
    }
    
    /**
     * This method will return to the connection of this instance.
     * @return Connection object
     */
    public Connection getConn(){
        return conn;
    }
    
    /**
     * A public non parameter of updateLastUpdatedDB(Channel,time)
     */
    public void updateLastUpdatedDB(String time){
        String tableName = "sync_times";
        //int id = getChannelId(channel);
        int id = 1;
        try {
            pst = conn.prepareStatement("UPDATE "+ tableName + " SET last_updated = ? WHERE id_channel = ?");
            pst.setString(1, time);
            pst.setInt(2, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }      
    }
    /**
     * 
     * @param channel the channel at which we will be listing REQUIRED correct, 
     * <li>Amazon</li><li>Mage</li><li>Ebay</li>
     * @param time The time which is most recent to be added to the DB
     */
    private void updateLastUpdatedDB(String channel, String time){
        String tableName = "sync_times";
        //int id = getChannelId(channel);
        int id = 1;
        try {
            pst = conn.prepareStatement("UPDATE "+ tableName + " SET last_updated = ? WHERE id_channel = ?");
            pst.setString(1, time);
            pst.setInt(2, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }      
    }
    
    /**
     * This method will grab the correct channelID based off the inputted channel.
     * @param channel - Channel in the database
     * @return The respective channelID
     */
    private int getChannelId(String channel){
    	String tableName = "channels";
    	int rv = -1;
    	try{
    		pst = conn.prepareStatement("SELECT id_channel FROM " + tableName +" WHERE channel = ?");
    		pst.setString(1, channel);
    		ResultSet rs = pst.executeQuery();
    		rs.first();
    		rv = rs.getInt("id_channel");
    	} catch(SQLException ex){
    		System.out.println(ex);
    		ex.printStackTrace();
    	}
    	return rv;
    }
    
    
    /**
     * This method will return the lastUpdated time from the DB, which has not been altered yet.
     * @param conn MUST attach the connection to grab from DB
     * @param channel MUST attach the channel to grab from DB
     * @return lastUpdated from the DB
     */
    private String getLastUpdatedDB(Connection conn, String channel){
        try {
            pst = conn.prepareStatement("SELECT last_updated FROM sync_times WHERE id_channel = ?");
            
            String num = null;
            if(channel.equals("Amazon")){
                num = "1";
            }else if(channel.equals("Mage")){
                num = "2";
            }else if(channel.equals("Ebay")){
                num = "3";
            }
            
            pst.setString(1, num);
            ResultSet rs = pst.executeQuery();
            
            rs.first();
            lastUpdated = rs.getObject("last_updated").toString();
            setLastUpdated(lastUpdated);
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return lastUpdated;
    }
    
    /**
     * Will set the Channel to the passed value, should only pass in allotted values
     * @param channel alotted values are <li>Amazon</li> <li>Mage</li> <li>Ebay</li> 
     */
    public void setChannel(String channel){
        this.channel = channel;
    }
    
    /**
     * Method will return the class object as to allow method coupling. Similar method as setChannel()
     * @param channel
     * @return  SyncTimingsDB, the class object itself
     */
    public SyncTimingsDB withChannel(String channel){
        this.channel = channel;
        return this;
    }
    
    /**
     * This method will return the channel
     * @return channel
     */
    public String getChannel(){
        return channel;
    }
    
    /**
     * Checks if channel is variable is set
     * @return <p><b>true</b></p> - channel is set.
     * <p><b>false</b></p> - channel is not set and is null
     */
    public boolean isChannel(){
        return channel == null;
    }
    
    /**
     * Will set the lastUpdated to the passed value, this will call the Update method if isChannel is true
     * @param lastUpdated Should follow the lexical String format for the date
     */
    public void setLastUpdated(String lastUpdated){
        this.lastUpdated = lastUpdated;
        if(isChannel()){
            updateLastUpdatedDB(getChannel(),lastUpdated);
        }
    }
    
    /**
     * Method will return the class object as to allow method coupling. Similar method as setLastUpdated()
     * @param lastUpdated
     * @return  SyncTimingsDB, the class object itself
     */
    public SyncTimingsDB withLastUpdated(String lastUpdated){
        this.lastUpdated = lastUpdated;
        return this;
    }
    
    /**
     * This method will return the lastUpdated time from this class, may be NULL
     * @return lastUpdated from this class
     */
    public String getLastUpdated(){
        return lastUpdated;
    }
    
    /**
     * Checks if lastUpdated is variable is set
     * @return <p><b>true</b></p> - lastUpdated is set.
     * <p><b>false</b></p> - lastUpdated is not set and is null
     */
    public boolean isLastUpdated(){
        return lastUpdated==null;
    } 
    
    /**
     * 
     * @param conn a connection to the db 
     */
    public void setConn(Connection conn){
        this.conn = conn;
    }
  
}
