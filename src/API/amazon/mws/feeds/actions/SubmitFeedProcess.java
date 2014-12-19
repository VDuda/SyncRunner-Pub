/******************************************************************************* 
 *  Copyright 2009 Amazon Services.
 *  Licensed under the Apache License, Version 2.0 (the "License"); 
 *  
 *  You may not use this file except in compliance with the License. 
 *  You may obtain a copy of the License at: http://aws.amazon.com/apache2.0
 *  This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR 
 *  CONDITIONS OF ANY KIND, either express or implied. See the License for the 
 *  specific language governing permissions and limitations under the License.
 * ***************************************************************************** 
 *
 *  Marketplace Web Service Java Library
 *  API Version: 2009-01-01
 *  Generated: Wed Feb 18 13:28:48 PST 2009 
 * 
 */

package API.amazon.mws.feeds.actions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.xml.bind.JAXBException;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import API.amazon.mws.feeds.model.ContentMD5;
import API.amazon.mws.feeds.model.FeedSubmissionInfo;
import API.amazon.mws.feeds.model.GetFeedSubmissionListRequest;
import API.amazon.mws.feeds.model.GetFeedSubmissionListResponse;
import API.amazon.mws.feeds.model.GetFeedSubmissionResultRequest;
import API.amazon.mws.feeds.model.GetFeedSubmissionResultResponse;
import API.amazon.mws.feeds.model.IdList;
import API.amazon.mws.feeds.model.ResponseMetadata;
import API.amazon.mws.feeds.model.SubmitFeedRequest;
import API.amazon.mws.feeds.model.SubmitFeedResponse;
import API.amazon.mws.feeds.model.SubmitFeedResult;
import API.amazon.mws.feeds.service.MarketplaceWebService;
import API.amazon.mws.feeds.service.MarketplaceWebServiceConfig;
import API.amazon.mws.feeds.service.MarketplaceWebServiceException;
import API.amazon.mws.xml.JAXB.AmazonEnvelope;
import API.amazon.mws.xml.JAXB.ProcessingReport;
import API.amazon.mws.xml.feeds.XMLFeed;

/**
 * 
 * Submit Feed Samples
 * 
 * 
 */
public class SubmitFeedProcess {
	
	
	public static final Log log = LogFactory.getLog(SubmitFeedProcess.class);
	private static final long THREAD_LIMIT = 45 * 1000; // 1000ms = 1sec ; 45sec = 3/4min ; 
	private static final long PERIODIC_CHECK = 30 * 1000; // 1000ms = 1sec ; 45sec = 3/4min ; 
	private MarketplaceWebService service = FeedsConfig.service;
	

    /**
     * Just add a few required parameters, and try the service Submit Feed
     * functionality
     * 
     * @param args
     *            unused
     */
    /**
     * @param args
     */
    public void initTestSubmitFeed(XMLFeed<?> feed) throws Exception {
    	
    	//replace fis with the inStream later on.
    	//FileInputStream fis = new FileInputStream(new File(SubmitFeedSample.class.getClassLoader().getResource("xmlSamples/SampleProductCreate.xml").getFile()));

    	System.out.println("Starting the MWS");
        /************************************************************************
         * Access Key ID and Secret Access Key ID, obtained from:
         * http://aws.amazon.com
         ***********************************************************************/
//        final String accessKeyId = FeedsConfig.ACCESS_KEY_ID;
//        final String secretAccessKey = FeedsConfig.SECRET_ACCESS_KEY;

//        final String appName = FeedsConfig.APPLICATION_NAME;
//        final String appVersion = FeedsConfig.APPLICATION_VERSION;

        MarketplaceWebServiceConfig config = new MarketplaceWebServiceConfig();

        /************************************************************************
         * Uncomment to set the appropriate MWS endpoint.
         ************************************************************************/
        // US
        config.setServiceURL("https://mws.amazonservices.com");
        // UK
        // config.setServiceURL("https://mws.amazonservices.co.uk");
        // Germany
        // config.setServiceURL("https://mws.amazonservices.de");
        // France
        // config.setServiceURL("https://mws.amazonservices.fr");
        // Italy
        // config.setServiceURL("https://mws.amazonservices.it");
        // Japan
        // config.setServiceURL("https://mws.amazonservices.jp");
        // China
        // config.setServiceURL("https://mws.amazonservices.com.cn");
        // Canada
        // config.setServiceURL("https://mws.amazonservices.ca");
        // India
        // config.setServiceURL("https://mws.amazonservices.in");

        /************************************************************************
         * You can also try advanced configuration options. Available options are:
         *
         *  - Signature Version
         *  - Proxy Host and Proxy Port
         *  - User Agent String to be sent to Marketplace Web Service
         *
         ***********************************************************************/

        /************************************************************************
         * Instantiate Http Client Implementation of Marketplace Web Service        
         ***********************************************************************/

//        MarketplaceWebService service = new MarketplaceWebServiceClient(
//                accessKeyId, secretAccessKey, appName, appVersion, config);
        

        /************************************************************************
         * Setup request parameters and uncomment invoke to try out sample for
         * Submit Feed
         ***********************************************************************/

        /************************************************************************
         * Marketplace and Merchant IDs are required parameters for all
         * Marketplace Web Service calls.
         ***********************************************************************/
        final String sellerId = FeedsConfig.SELLER_ID;//use sellerID not merchantID
        // marketplaces to which this feed will be submitted; look at the
        // API reference document on the MWS website to see which marketplaces are
        // included if you do not specify the list yourself
        final IdList marketplaces = new IdList(Arrays.asList(
        		FeedsConfig.MARKETPLACE_ID));

        SubmitFeedRequest request = new SubmitFeedRequest();
        request.setMerchant(sellerId);
        request.setMarketplaceIdList(marketplaces);
     //   request.setFeedType("_POST_INVENTORY_AVAILABILITY_DATA_");
        request.setFeedType(feed.getFeedType());
     //   System.out.println(new File(SubmitFeedSample.class.getClassLoader().getResource("xmlSamples/SampleProductCreate.xml").getFile()).toString());
//        ByteArrayInputStream inStream = new ByteArrayInputStream(feed.forceByteStream().toByteArray());
//        File file = new File("TestCase");
//        FileInputStream inStream = new FileInputStream(file);
        ByteArrayInputStream inStream = new ByteArrayInputStream(feed.forceByteStream().toByteArray());
        request.setFeedContent(inStream);
//        System.out.println(inStream);
        request.setContentMD5(ContentMD5.computeContentMD5(inStream));
     //   System.out.println(ContentMD5.computeContentMD5Header());
     //   System.out.println(inStream.getChannel().position());
        //System.out.println(ContentMD5.computeContentMD5Header(inStream));
        // request.setFeedContent(new FileInputStream(new File(SubmitFeedSample.class.getResource(""))));
        // MWS exclusively offers a streaming interface for uploading your
        // feeds. This is because
        // feed sizes can grow to the 1GB+ range - and as your business grows
        // you could otherwise
        // silently reach the feed size where your in-memory solution will no
        // longer work, leaving you
        // puzzled as to why a solution that worked for a long time suddenly
        // stopped working though
        // you made no changes. For the same reason, we strongly encourage you
        // to generate your feeds to
        // local disk then upload them directly from disk to MWS via Java -
        // without buffering them in Java
        // memory in their entirety.
        // Note: MarketplaceWebServiceClient will not retry a submit feed request
        // because there is no way to reset the InputStream from our client. 
        // To enable retry, recreate the InputStream and resubmit the feed
        // with the new InputStream. 
        //
        // request.setFeedContent( new FileInputStream("my-feed.xml" /*or
        // "my-flat-file.txt" if you use flat files*/);
//        System.out.println(request.getContentType());
//        System.out.println(request.getFeedType());
//        System.out.println(feed.getFeedType());
//        System.out.println(request.getContentType());
        
        //invokeSubmitFeed(service, request);
        SubmitFeedResponse response = service.submitFeed(request);//invokes the MWS submitFeed operation
        String feedSubmissionId = response.getSubmitFeedResult().getFeedSubmissionInfo().getFeedSubmissionId();
        String feedProcessingStatus = response.getSubmitFeedResult().getFeedSubmissionInfo().getFeedProcessingStatus();
        processCheckForResult(feedSubmissionId, feedProcessingStatus);
        System.out.println("all good");
        
   //     fis.close();

    }

    private void processCheckForResult(String feedSubmissionId,String feedProcessingStatus) throws InterruptedException, JAXBException, MarketplaceWebServiceException, NoSuchAlgorithmException, IOException {
    	boolean keepGoing = true;
    	while(keepGoing){//infinite loop!
	    	try{
	    		GetFeedSubmissionListRequest request = new GetFeedSubmissionListRequest();
	    		request.setMerchant(FeedsConfig.SELLER_ID);
	    		request.setFeedSubmissionIdList(new IdList(Arrays.asList(new String[] {feedSubmissionId})));
	    		GetFeedSubmissionListResponse response = service.getFeedSubmissionList(request);
	    		if(response.getGetFeedSubmissionListResult().getFeedSubmissionInfoList().isEmpty())
	    			throw new IllegalStateException("Infinite While loop avoided - CHECK WHY ISSUE CAUSED!");
	    		for(FeedSubmissionInfo obj:response.getGetFeedSubmissionListResult().getFeedSubmissionInfoList()){//Will be size of 1; but just in case loop through all
	    			if(obj.getFeedProcessingStatus().equals("_DONE_")){
	    				keepGoing = false;
	    			}
	    		}
	    		if(keepGoing)
	    			Thread.sleep(PERIODIC_CHECK);
	    	}catch(MarketplaceWebServiceException e){
	    		if (e.getStatusCode() == HttpStatus.SC_SERVICE_UNAVAILABLE
	                    && "RequestThrottled".equals(e.getErrorCode()))
	    			requestThrottledExceptionHandler(THREAD_LIMIT);
	    	}
    	}//End of Infinite loop check
    	if (processReportResults(feedSubmissionId))
    		throw new IllegalStateException("Bad upload to Amazon!\nPush May have not been Posted.");
	}
    
    

	private boolean processReportResults(String feedSubmissionId) throws MarketplaceWebServiceException, JAXBException, NoSuchAlgorithmException, IOException {
		GetFeedSubmissionResultRequest request = new GetFeedSubmissionResultRequest();
		ByteArrayInputStream inStream = null;// stream for data
		//set request params
		request.setFeedSubmissionId(feedSubmissionId);
		request.setMerchant(FeedsConfig.SELLER_ID);
		request.setFeedSubmissionResultOutputStream(new ByteArrayOutputStream());
		//Send request
		while(true){//Doesn't currently handle throttle <-- very unstable code refactor later!
			GetFeedSubmissionResultResponse response = service.getFeedSubmissionResult(request);
			
			//verify MD5s
			String md5Stated = response.getGetFeedSubmissionResultResult().getMD5Checksum();
			inStream = new ByteArrayInputStream(((ByteArrayOutputStream) request.getFeedSubmissionResultOutputStream()).toByteArray());
	        String md5Digested = ContentMD5.computeContentMD5(inStream);
	        if(md5Stated.equals(md5Digested)){
	        	break;
	        }
		}
		//This could go into a more advanced status update
		// Maybe even including a logger to log results back into database
		System.out.println("START -----------------------");
		System.out.println(new String(((ByteArrayOutputStream) request.getFeedSubmissionResultOutputStream()).toByteArray()));
		System.out.println("END -----------------------");
		ProcessingReport report = ((AmazonEnvelope) XMLFeed.getUnmarshaller().unmarshal(inStream)).getMessage().get(0).getProcessingReport();
//		System.out.println("PROCESSED: "+report.getProcessingSummary().getMessagesProcessed().intValue());
//		System.out.println("SUCCESS: "+report.getProcessingSummary().getMessagesSuccessful().intValue());
//		System.out.println("ERROR: "+report.getProcessingSummary().getMessagesWithError().intValue());

		//will return true if only Errors were detected
		return (report.getProcessingSummary().getMessagesWithError().intValue() > 0);
	}
	
	/*
     * When a request is throttled, this method is called to make the thread
     * sleep for a period of time specified by the throttling limit.
     */
    private void requestThrottledExceptionHandler(long throttlingLimit) {
        try {
            log.info("Request throttled. Sleeping for " + throttlingLimit
                    + " milliseconds.");
            Thread.sleep(throttlingLimit);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
            return;
        }
    }
    
    
	/****** DEBUGGG
	public static void main(String[] args) throws Exception{
		String OUT = null;
		XMLFeed<Item> feed = new ProductFeed();
		feed.createMarshaller(new ByteArrayOutputStream());
		OUT = new String((feed.forceByteStream().toByteArray()));
		System.out.println("This Line ----------");
//		System.out.println(ContentMD5.computeContentMD5Header());
		ActionFindor findDB = new ActionFindor();
		Item item = new Item(findDB.findShoeList("029002010145").get(0));
		feed.createMessage(item);
//		feed.createMessage(item);
		System.out.println();
//		feed.getEnvelope().getMessage().add(msg);
//		feed.getEnvelope().getMessage().add(msg2);
		feed.write();
		
		OUT = new String((feed.forceByteStream().toByteArray()));
		System.out.print(OUT);
		System.out.println("DONE Line ---------------");
		System.out.println(ContentMD5.computeContentMD5(new ByteArrayInputStream(feed.forceByteStream().toByteArray())));

//		File file = new File("TestCase");
//		feed.setOutStream(new FileOutputStream(file));
//		feed.write();
//		System.out.println("MD5-byteFis: "+ ContentMD5.computeContentMD5(new FileInputStream(file)));
		
		
		
		
		JOptionPane.showMessageDialog(null,"T");
		System.out.println("Done");
		initTestSubmitFeed(feed);
	}
	*******/
    
    
	/** DEBUGGING PURPOSES
     * Submit Feed request sample Uploads a file for processing together with
     * the necessary metadata to process the file, such as which type of feed it
     * is. PurgeAndReplace if true means that your existing e.g. inventory is
     * wiped out and replace with the contents of this feed - use with caution
     * (the default is false).
     * 
     * @param service
     *            instance of MarketplaceWebService service
     * @param request
     *            Action to invoke
     */
    public static void invokeSubmitFeed(MarketplaceWebService service,
            SubmitFeedRequest request) {
        try {

            SubmitFeedResponse response = service.submitFeed(request);

            System.out.println("SubmitFeed Action Response");
            System.out
            .println("=============================================================================");
            System.out.println();

            System.out.print("    SubmitFeedResponse");
            System.out.println();
            if (response.isSetSubmitFeedResult()) {
                System.out.print("        SubmitFeedResult");
                System.out.println();
                SubmitFeedResult submitFeedResult = response
                .getSubmitFeedResult();
                if (submitFeedResult.isSetFeedSubmissionInfo()) {
                    System.out.print("            FeedSubmissionInfo");
                    System.out.println();
                    FeedSubmissionInfo feedSubmissionInfo = submitFeedResult
                    .getFeedSubmissionInfo();
                    if (feedSubmissionInfo.isSetFeedSubmissionId()) {
                        System.out.print("                FeedSubmissionId");
                        System.out.println();
                        System.out.print("                    "
                                + feedSubmissionInfo.getFeedSubmissionId());
                        System.out.println();
                    }
                    if (feedSubmissionInfo.isSetFeedType()) {
                        System.out.print("                FeedType");
                        System.out.println();
                        System.out.print("                    "
                                + feedSubmissionInfo.getFeedType());
                        System.out.println();
                    }
                    if (feedSubmissionInfo.isSetSubmittedDate()) {
                        System.out.print("                SubmittedDate");
                        System.out.println();
                        System.out.print("                    "
                                + feedSubmissionInfo.getSubmittedDate());
                        System.out.println();
                    }
                    if (feedSubmissionInfo.isSetFeedProcessingStatus()) {
                        System.out
                        .print("                FeedProcessingStatus");
                        System.out.println();
                        System.out.print("                    "
                                + feedSubmissionInfo.getFeedProcessingStatus());
                        System.out.println();
                    }
                    if (feedSubmissionInfo.isSetStartedProcessingDate()) {
                        System.out
                        .print("                StartedProcessingDate");
                        System.out.println();
                        System.out
                        .print("                    "
                                + feedSubmissionInfo
                                .getStartedProcessingDate());
                        System.out.println();
                    }
                    if (feedSubmissionInfo.isSetCompletedProcessingDate()) {
                        System.out
                        .print("                CompletedProcessingDate");
                        System.out.println();
                        System.out.print("                    "
                                + feedSubmissionInfo
                                .getCompletedProcessingDate());
                        System.out.println();
                    }
                }
            }
            if (response.isSetResponseMetadata()) {
                System.out.print("        ResponseMetadata");
                System.out.println();
                ResponseMetadata responseMetadata = response
                .getResponseMetadata();
                if (responseMetadata.isSetRequestId()) {
                    System.out.print("            RequestId");
                    System.out.println();
                    System.out.print("                "
                            + responseMetadata.getRequestId());
                    System.out.println();
                }
            }
            System.out.println(response.getResponseHeaderMetadata());
            System.out.println();
            System.out.println();

        } catch (MarketplaceWebServiceException ex) {

            System.out.println("Caught Exception: " + ex.getMessage());
            System.out.println("Response Status Code: " + ex.getStatusCode());
            System.out.println("Error Code: " + ex.getErrorCode());
            System.out.println("Error Type: " + ex.getErrorType());
            System.out.println("Request ID: " + ex.getRequestId());
            System.out.print("XML: " + ex.getXML());
            System.out.println("ResponseHeaderMetadata: " + ex.getResponseHeaderMetadata());
        }
    }

}
