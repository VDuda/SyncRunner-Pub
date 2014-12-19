package API.amazon.mws.xml.feeds;

import java.math.BigDecimal;

import API.amazon.mws.xml.JAXB.AmazonEnvelope.Message;
import API.amazon.mws.xml.JAXB.BaseCurrencyCodeWithDefault;
import API.amazon.mws.xml.JAXB.OverrideCurrencyAmount;
import API.amazon.mws.xml.JAXB.Price;

import com.v3.utilities.Pair;

public class PricingFeed extends XMLFeed<Pair<String,Double>>{
	
	public static final String FEED_TYPE = "_POST_PRODUCT_PRICING_DATA_";
	public static final String MSG_TYPE = "Price";

	@Override
	public String getFeedType() {
		return FEED_TYPE;
	}

	@Override
	public String getEnvelopeMessageType() {
		return MSG_TYPE;
	}

	@Override
	public Message createMessage(final Pair<String,Double> dataObject, boolean isBasic) {
		Message msg = new Message();
		Price price = null;
		if(isBasic){
			price = new Price();
			price.setSKU(dataObject.getFirst());
			price.setStandardPrice(new OverrideCurrencyAmount(){{
				this.setCurrency(BaseCurrencyCodeWithDefault.USD);
				this.setValue(dataObject.getSecond());
			}});
		}else{
			
		}
		
		msg.setPrice(price);
		msg.setOperationType("Update");
		msg.setMessageID(incrementMsgCount());
		this.getEnvelope().getMessage().add(msg);
		return msg;
	}
}
