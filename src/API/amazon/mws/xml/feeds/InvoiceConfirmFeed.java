package API.amazon.mws.xml.feeds;

import API.amazon.mws.xml.JAXB.AmazonEnvelope.Message;

public class InvoiceConfirmFeed extends XMLFeed{

	public static final String FEED_TYPE = "_POST_INVOICE_CONFIRMATION_DATA_";

	@Override
	public String getFeedType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEnvelopeMessageType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message createMessage(Object dataObject, boolean isBasic) {
		// TODO Auto-generated method stub
		return null;
	}
}
