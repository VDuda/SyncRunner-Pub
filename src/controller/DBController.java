/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * APPLICATION SHOULD ONLY HAVE 1 CONNECTION OPEN MAX. That connection being the current user. 
 * @author B2E_2
 */
public class DBController {
    
    private static Connection conn = connectDB();
    private static PreparedStatement pst = null;
    private static ResultSet rs = null;
    
    /**
     * @description Create a connection to the local sqlite JBDC
     */
/*    public DBController(){//will add user authentication later on. 
        //intitilize db connection
        connectDB();

    }
*/ 
    
/** TEST    *
    public static void main(String[] args){
    	connectDB();
    	writeColumns(issueCmd("SELECT * FROM PRODUCT"));
    	System.out.println("Done");
    }
**/    
    public static Connection connectDB(){

/**MYSQL*/
        String dbUrl = "jdbc:mysql://B2E_2-PC:3306/";
        String dbName = "v3_inventory";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "SyncRunner";
        String passwd = "somepass";//Not a good way to store passwords!
        Connection connection = null;
        
        //ADD THIS BELOW WHERE CONN IS
        //conn = DriverManager.getConnection(dbUrl+dbName,userName,passwd);
        String url = dbUrl +dbName;
/**/      
/**SQLITE    	
        String dbUrl = "jdbc:sqlite:C:\\Users\\B2E_2\\workspace\\V3-inventory\\Inventory.sqlite";
        String dbName = "v3_business";
        String driver = "org.sqlite.JDBC";
        String userName = "root";
        String passwd = "";
        
        //ADD THIS BELOW WHERE CONN IS
        //conn = DriverManager.getConnection(dbUrl,userName,passwd);
        String url = dbUrl;
**/        
        try{
            
            Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(url,userName,passwd);
            
        }catch(Exception e){
        	e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Problem with Connecting to Database, check DBController");
        }
        
        return connection;
    }
    
    /** 
     * @return The active Connection to the DB 
     */
    public static Connection getConn(){
        if(conn==null){
//            JOptionPane.showMessageDialog(null,"Conn is NULL! Connect to DB first!");
        	conn = connectDB();
        }
        return conn;
    }
    
     /**
     * @description Close Local Resources
     */
    public static void close() {
        try {
            if (rs != null) {
              rs.close();
            }

            if (pst != null) {
              pst.close();
            }

            if (conn != null) {
              conn.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    /**
     * Debug use, prints out Columns
     * <p><b>VERY IMPORTANT!</b> you must issue command to Database again.
     * This method WILL release the ResultSet back to the DB.</p>
     */
    public static void writeColumns(ResultSet rs){
        System.out.println("=============DEBUG - Columns=============");
        try {
            for(int i = 1; i<=rs.getMetaData().getColumnCount();i++){
                System.out.println("COL "+i+" :: "+rs.getMetaData().getColumnName(i));
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    /**
     * Debug use, prints out ResultSet 
     * <p><b>VERY IMPORTANT!</b> you must issue command to Database again.
     * This method WILL release the ResultSet back to the DB.</p>
     */
   
    public static void writeResultSet(ResultSet rs){
        System.out.println("=============DEBUG - ResultSet=============");
        int c = 0;
        try {
            //row
            while(rs.next()){
                //col
                c++;
                System.out.print("ROW "+c+" :: | ");
                for(int i = 1;i<=rs.getMetaData().getColumnCount();i++){
                    System.out.print(rs.getObject(i)+" | ");
                }
                System.out.println();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public static ResultSet issueCmd(String sql){
        
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
