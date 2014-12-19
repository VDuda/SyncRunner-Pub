package controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import API.amazon.mws.feeds.actions.FetchInventoryJob;
import API.amazon.mws.products.MarketplaceWebServiceProductsException;
import API.amazon.mws.xml.feeds.InventoryFeed;
import API.amazon.mws.xml.feeds.PricingFeed;
import API.amazon.mws.xml.feeds.ProductFeed;

import com.v3.actions.ActionFindor;
import com.v3.actions.ActionUpdator;
import com.v3.dto.SyncAmznProducts;
import com.v3.dto.SyncAmznProductsId;
import com.v3.products.actions.Item;
import com.v3.utilities.Pair;

import controller.amazon.AmazonControl;

public class ChannelProcessor {

	static final AmazonControl AMZN_CONTROL = new AmazonControl();
	static final ActionFindor findDB = new ActionFindor();
	
	private static final long WAIT_TIME = 1000 * 60 * 5; // 1000 = 1 sec, 60secs = 1 min, we want 5 mins  
	public static volatile boolean keepRunning = false;
	private static final Object lockObj = new Object();
	public static final Log log = LogFactory.getLog(ChannelProcessor.class);
	
	/*******FEEDS*****/
	static final ProductFeed productFeed = new ProductFeed();
	static int productFeedCount = 0;
	static final InventoryFeed qtyFeed = new InventoryFeed(); 
	static final PricingFeed priceFeed = new PricingFeed();
    
	
    private static void periodicSync() throws JAXBException, IOException{
        //check if reportRequestList, contains any submitted for our ReportType
        while(keepRunning){
            //Wait 5 mins before pushing
        	synchronized(lockObj){
	            try {
	            	log.info("Thread Sleeping for "+(WAIT_TIME/1000/60)+" minutes.");
	            	lockObj.wait(WAIT_TIME);
	            } catch (InterruptedException ex) {
	                Logger.getLogger(FetchInventoryJob.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
	            }
            }
            invokePushFeeds();
        }
    }
    
    /**
     * Sort of like the init/Constructor method, will init required resources.
     * @throws JAXBException
     */
    public static void startSync() throws JAXBException, IOException{
        keepRunning = true;
        productFeed.createMarshaller(new ByteArrayOutputStream());
        qtyFeed.createMarshaller(new ByteArrayOutputStream());
        priceFeed.createMarshaller(new ByteArrayOutputStream());
        log.info("Starting sync. Calling periodi cSync()...");
        periodicSync();
    }
    
    public static void stopSync(){
    	//Check if there are any feeds waiting to get pushed
    	log.info("Stopping sync.");
    	synchronized(lockObj){
	    	keepRunning = false;
	    	lockObj.notify();
    	}
        log.info("Sync is stopped, Thread will try to invokePushFeeds for last while Loop.");
    }
    
    //THIS METHOD NEEDS TO BE REWORKED, CAUSING ISSUES with 2+ qtys of same SKU and resetting feed when new are added
    private static void invokePushFeeds() throws JAXBException, IOException{
    	log.info("invokePushFeeds() called, pushing feeds to MWS.");
    	productFeed.write();
    	qtyFeed.write();
    	priceFeed.write();

    	if(productFeed.getMsgCount()>0) AMZN_CONTROL.list(productFeed);
    	if(qtyFeed.getMsgCount()>0) AMZN_CONTROL.list(qtyFeed);
    	if(priceFeed.getMsgCount()>0) AMZN_CONTROL.list(priceFeed);
    	log.info("Done pushing feeds to MWS.");
    	
    	productFeed.resetMsgCount();
    	qtyFeed.resetMsgCount();
    	priceFeed.resetMsgCount();
    	
    	log.info("Resetting feeds, streams should be emptied out.");
    	productFeed.forceByteStream().reset();
    	qtyFeed.forceByteStream().reset();
    	priceFeed.forceByteStream().reset();
    }
	
	public static void addlistItem(Item item) throws JAXBException, IOException, MarketplaceWebServiceProductsException{
/*
		Thread fetchOrderUpdatesJobThread = new Thread(new Runnable() {
            public void run() {
                listItem(item);
            }
        });
        System.out.println("Done!~~~~~~Main Thread");
        // Start the FetchOrderUpdatesJob in the second thread.
        fetchOrderUpdatesJobThread.start();
*/
			
		//AMAZON
		if(item.isOnAmazon()){ //Add to current Amazon Listing (basic XML)
//			System.out.println("Inform me");
			System.out.println(findDB.existsInDB(item));
			if(findDB.existsInDB(item)){// Check if DB has this item
//				System.out.println("First Hurdle");
				int qty = 1; // QTY to be listed - may differ based on if statements below
				double price = item.getPrice();
				SyncAmznProducts obj; // The Amazon DB object
				
				if(findDB.existsInAmznDB(item)){// check whether item exists on our AMAZON INVENTORY
					//set QTY to be listed
					obj = findDB.findSyncAmznProductOne(item); // Will only find ONE unique occurrence of this item.
					qty = obj.getQty() + 1;// Since exists, get DB known AMZN QTY
					
					//since exists, increase QTY known in DB
					obj.setQty(qty);
					if(obj.getPrice()>0) price = obj.getPrice();
						
					
					
				}else{ //item does not exist on our AMAZON INVENTORY
					//list item onto AMAZON
//					ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//					productFeed.createMarshaller(buffer);
					productFeed.createMessage(item);
//					productfeed.write();
					
//					System.out.println("-----DEBUGGG--------------------------");
//					System.out.println(new String(feed.forceByteStream().toByteArray()));
//					System.out.println("-----//DEBUGGG--------------------------");
					
//					JOptionPane.showMessageDialog(null, "Done Trun off");
					
					//receive response, decide if successful; on success insert into our AMAZON INVENTORY
//					AMZN_CONTROL.list(productfeed); //check if successful
					//set QTY to be listed
					qty = 1;
					
					//HANDLE PRICING -- AUTO to Item default price
					//list PRICE on AMAZON
//					pricingFeed = new PricingFeed();
//					ByteArrayOutputStream bufferP = new ByteArrayOutputStream();
//					pfeed.createMarshaller(bufferP);
					priceFeed.createMessage(new Pair<String,Double>(item.getItemSku(),price));
//					pfeed.write();
//					AMZN_CONTROL.list(pfeed);//pushes new price update
					
					// Create/add Amazon DB object
					obj = new SyncAmznProducts();
					SyncAmznProductsId id =new SyncAmznProductsId();
					id.setSku(item.getItemSku());
					id.setAsin(item.getAsin());
					obj.setId(id);
					obj.setQty(qty);
//					
					
					
				}
				
				//list QTY on AMAZON
//				InventoryFeed feed = new InventoryFeed();
//				ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//				feed.createMarshaller(buffer);
				qtyFeed.createMessage(new Pair<String,Integer>(item.getItemSku(),qty));
//				feed.write();
				
//				System.out.println("-----DEBUGGG--------------------------");
//				System.out.println(new String(feed.forceByteStream().toByteArray()));
//				System.out.println("-----//DEBUGGG--------------------------");
//				AMZN_CONTROL.list(feed);//pushes new qty update
				
				
				
				
//				System.out.println("-----DEBUGGG--------------------------");
//				System.out.println(new String(feed.forceByteStream().toByteArray()));
//				System.out.println("-----//DEBUGGG--------------------------");
				
				
				// --pricing can also be handled here; 
				// will not be for the time being so as to follow business rules.
				
				//HANDLE DB OPERATIONS LAST -- AS TO FORCE NON ERROR OCCURRENCE
				//list QTY to our AMAZON INVENTORY
				ActionUpdator.update(obj);
				
			}else{
				throw new UnsupportedOperationException("Not supported yet.");
			}	
		} else{ //Create new listing on Amazon (advanced XML)
			System.out.println(item.isOnAmazon());
			throw new UnsupportedOperationException("Not supported yet.");
		}
		
		productFeedCount++;
	}
	
	/**DEBUGGG
	 * @throws MarketplaceWebServiceProductsException 
	 * @throws IOException 
	 * @throws JAXBException 
	 * 
	 */
//	public static void main(String[] args) throws JAXBException, IOException, MarketplaceWebServiceProductsException{
//		try{
//		System.out.println("Starting!");
////		Item item = new Item();//Empty Constructor initial call creates Shoe + Sku objects
//		Item item = new Item(findDB.findShoeList("029002010145").get(0));
////		item.setOnAmazon(true); 
////		item.getShoe().setId(new ShoeId());
////		item.getShoe().getId().setUpc("029002010145");
//	//??	listItem(item);
//		
//		
//		PricingFeed feed = new PricingFeed();
//		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//		feed.createMarshaller(buffer);
//		feed.createMessage(new Pair<String,Double>(item.getItemSku(),29.99));
//		feed.write();
//		
//		System.out.println("-----DEBUGGG--------------------------");
//		System.out.println(new String(feed.forceByteStream().toByteArray()));
//		System.out.println("-----//DEBUGGG--------------------------");
//		
//		AMZN_CONTROL.list(feed);//pushes new qty update
//		System.out.println("We done!");
//		}catch(Exception e){
//			JOptionPane.showMessageDialog(null, e);
//		}
//	}
}
