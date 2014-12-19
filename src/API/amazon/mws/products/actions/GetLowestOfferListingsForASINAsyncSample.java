/******************************************************************************* 
 *  Copyright 2008-2012 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *  Licensed under the Apache License, Version 2.0 (the "License"); 
 *  
 *  You may not use this file except in compliance with the License. 
 *  You may obtain a copy of the License at: http://aws.amazon.com/apache2.0
 *  This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR 
 *  CONDITIONS OF ANY KIND, either express or implied. See the License for the 
 *  specific language governing permissions and limitations under the License.
 * ***************************************************************************** 
 * 
 *  Marketplace Web Service Products Java Library
 *  API Version: 2011-10-01
 * 
 */



package API.amazon.mws.products.actions;

import java.util.List;
import java.util.ArrayList;
import API.amazon.mws.products.*;
import API.amazon.mws.products.model.*;
import java.util.concurrent.Future;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 *
 * Get Lowest Offer Listings For ASIN  Samples
 *
 *
 */
public class GetLowestOfferListingsForASINAsyncSample {

    /**
     * Just add few required parameters, and try the service
     * Get Lowest Offer Listings For ASIN functionality
     *
     * @param args unused
     */
    public static void main(String... args) {
        
         ExecutorService executor = Executors.newFixedThreadPool(100);
         MarketplaceWebServiceProductsAsync service = new MarketplaceWebServiceProductsAsyncClient(
					ProductsConfig.ACCESS_KEY_ID, 
					ProductsConfig.SECRET_ACCESS_KEY, 
					ProductsConfig.APPLICATION_NAME, 
					ProductsConfig.APPLICATION_VERSION, 
					ProductsConfig.config,
					executor);

        /************************************************************************
         * Setup requests parameters and invoke parallel processing. Of course
         * in real world application, there will be much more than a couple of
         * requests to process.
         ***********************************************************************/
         GetLowestOfferListingsForASINRequest requestOne = new GetLowestOfferListingsForASINRequest();
         // @TODO: set request parameters here

         GetLowestOfferListingsForASINRequest requestTwo = new GetLowestOfferListingsForASINRequest();
         // @TODO: set second request parameters here

         List<GetLowestOfferListingsForASINRequest> requests = new ArrayList<GetLowestOfferListingsForASINRequest>();
         requests.add(requestOne);
         requests.add(requestTwo);

         invokeGetLowestOfferListingsForASIN(service, requests);

         executor.shutdown();

    }


                            
    /**
     * Get Lowest Offer Listings For ASIN request sample
     * Gets some of the lowest prices based on the product identified by the given
     * MarketplaceId and ASIN.
     *   
     * @param service instance of MarketplaceWebServiceProducts service
     * @param requests list of requests to process
     */
    public static void invokeGetLowestOfferListingsForASIN(MarketplaceWebServiceProductsAsync service, List<GetLowestOfferListingsForASINRequest> requests) {
        List<Future<GetLowestOfferListingsForASINResponse>> responses = new ArrayList<Future<GetLowestOfferListingsForASINResponse>>();
        for (GetLowestOfferListingsForASINRequest request : requests) {
            responses.add(service.getLowestOfferListingsForASINAsync(request));
        }
        for (Future<GetLowestOfferListingsForASINResponse> future : responses) {
            while (!future.isDone()) {
                Thread.yield();
            }
            try {
                GetLowestOfferListingsForASINResponse response = future.get();
                // Original request corresponding to this response, if needed:
                GetLowestOfferListingsForASINRequest originalRequest = requests.get(responses.indexOf(future));
                System.out.println("Response request id: " + response.getResponseMetadata().getRequestId());
            } catch (Exception e) {
                if (e.getCause() instanceof MarketplaceWebServiceProductsException) {
                    MarketplaceWebServiceProductsException exception = MarketplaceWebServiceProductsException.class.cast(e.getCause());
                    System.out.println("Caught Exception: " + exception.getMessage());
                    System.out.println("Response Status Code: " + exception.getStatusCode());
                    System.out.println("Error Code: " + exception.getErrorCode());
                    System.out.println("Error Type: " + exception.getErrorType());
                    System.out.println("Request ID: " + exception.getRequestId());
                    System.out.println("XML: " + exception.getXML());
                    System.out.print("ResponseHeaderMetadata: " + exception.getResponseHeaderMetadata());
                } else {
                    e.printStackTrace();
                }
            }
        }
    }
                                            
}
