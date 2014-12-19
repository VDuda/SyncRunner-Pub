package API.amazon.mws.xml.feeds;

import API.amazon.mws.xml.JAXB.AmazonEnvelope.Message;
import API.amazon.mws.xml.JAXB.Inventory;

import com.v3.utilities.*;

public class InventoryFeed extends XMLFeed<Pair<String,Integer>>{

	public static final String FEED_TYPE = "_POST_INVENTORY_AVAILABILITY_DATA_";
	public static final String MSG_TYPE = "Inventory";

	@Override
	public String getFeedType() {
		return FEED_TYPE;
	}

	@Override
	public String getEnvelopeMessageType() {
		return MSG_TYPE;
	}

	@Override
	public Message createMessage(Pair<String,Integer> dataObject, boolean isBasic) {
		Message msg = new Message();
		Inventory inventory = null;
		
		if(isBasic){
			inventory = new Inventory();
//			inventory.setAvailable(true);//default do not use w/setQTY() - US MERCHANT CHECK DOCUMENTATION FOR XML 
			inventory.setSKU(dataObject.getFirst());
			inventory.setQuantity(dataObject.getSecond());
			inventory.setFulfillmentLatency(1);//default 
		}else{
			throw new UnsupportedOperationException("Creating an Advanced Message");
		}
		
		msg.setInventory(inventory);
		msg.setOperationType("Update");
		msg.setMessageID(incrementMsgCount());
		this.getEnvelope().getMessage().add(msg);
		return msg;
	}

}
