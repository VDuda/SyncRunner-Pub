package controller;

import controller.amazon.AmazonControl;
import controller.mage.MageControl;

public class SyncRunner {
	
	public static void main(String[] args){
		
		AmazonControl amzn = new AmazonControl();
		MageControl mage = new MageControl();
		//***Grab Orders first
		amzn.getOrders(DBController.getConn());
		//Should we tell threads to wait? or Can we just handle MultiThread getOrders? 
		// -- Also think about having this Class dictate the time to fetch
//		mage.getOrders(DBController.getConn());
		
		//***Grab Inventory Updates
		
		//***Compute Inventory-Order differences
		
		//***Push changes to respective channels
	}
}
