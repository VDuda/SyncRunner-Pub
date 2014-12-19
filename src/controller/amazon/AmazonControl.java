/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.amazon;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import API.amazon.mws.feeds.actions.SubmitFeedProcess;
import API.amazon.mws.products.MarketplaceWebServiceProductsException;
import API.amazon.mws.products.actions.ProductsConfig;
import API.amazon.mws.products.model.GetMatchingProductForIdRequest;
import API.amazon.mws.products.model.GetMatchingProductForIdResponse;
import API.amazon.mws.products.model.IdListType;
import API.amazon.mws.xml.feeds.XMLFeed;
import controller.ChannelController;
import controller.DBController;


/**
 *
 * @author B2E_2
 */
public class AmazonControl extends ChannelController<XMLFeed<?>>{
	
//	private static boolean isLocked = false;
//	
//	private static boolean checkLock(){
//		if(isLocked){
//			
//		}else{
//			
//		}
//		return isLocked;
//	}

	/**
	 * This call takes 35-120 minutes to complete. 
	 * Should be done only to reCheck qty on Amazon and what is Stored for Amazon in DB.
	 * @param conn - A {@link Connection} will be needed to push to the database.
	 */
    public synchronized void getInventory(Connection conn) {
        //Grabs all inventory items currently Active on Amazon
        // Handles all SQL insertion
    	//DEBUG print- use DBController.conn
    	//DBController.writeColumns(DBController.issueCmd("SELECT * from sync_amzn_products"));
    	SyncAMZGrabInventory.conn = conn;
    	SyncAMZGrabInventory.initGrab();
    	JOptionPane.showMessageDialog(null, "Fetching Inventory!");
    }

    public synchronized void createInventory(File data) {
        //Use MWS to grab intial CSV Items
        //Use AWS to grab images
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @desc Check Target Data's SKU with the SKU in DB inventory, check QTYs
     * @param data
     * @return 
     */
    public synchronized File compareToDB(File data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public synchronized void getOrders(Connection conn) {
        //All the SQL insertion is handled in SyncAMZGrabOrders()
        new SyncAMZGrabOrders(conn);

    }

    public synchronized File bulkList(File data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	public void list(XMLFeed<?> data) {
		try {
			SubmitFeedProcess subProc = new SubmitFeedProcess();
			subProc.initTestSubmitFeed(data);
		} catch (Exception e) {
			throw new IllegalStateException(e.getMessage());
		}
	}

	public synchronized String findProduct(final String itemSku) throws MarketplaceWebServiceProductsException {
		//Building a request
		GetMatchingProductForIdRequest request = new GetMatchingProductForIdRequest();
		request.setIdType("SellerSKU");
		request.setIdList(new IdListType(new ArrayList<String>(){{add(itemSku);}}));
		request.setMarketplaceId(ProductsConfig.MARKETPLACE_ID);
		request.setSellerId(ProductsConfig.SELLER_ID);
		//Send out to receive a response
		GetMatchingProductForIdResponse response = ProductsConfig.service.getMatchingProductForId(request); 
//		System.out.println(response.toXML());
		if (response.getGetMatchingProductForIdResult().isEmpty())// simple check for a weird possible situation
			throw new IllegalStateException("There is not result!");
		if (!response.getGetMatchingProductForIdResult().get(0).getStatus().equals("Success"))// simple check for a weird possible situation
			throw new IllegalStateException("Error recieved; we shouldn't process this!\n"+response.getGetMatchingProductForIdResult().get(0).getError());
		if (response.getGetMatchingProductForIdResult().get(0).getProducts().getProduct().size() > 1)// simple check for a weird possible situation
			throw new IllegalStateException("Found more than two items with the same SKU!\nGive this to Vlad!");
		
		//Only interested in the first returned item
		//	Find its asin and return it
		return response.getGetMatchingProductForIdResult().get(0).getProducts().getProduct().get(0).getIdentifiers().getMarketplaceASIN().getASIN();
	}
    
}
