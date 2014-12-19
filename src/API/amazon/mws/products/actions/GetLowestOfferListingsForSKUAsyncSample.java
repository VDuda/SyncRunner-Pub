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
 * Get Lowest Offer Listings For SKU  Samples
 *
 *
 */
public class GetLowestOfferListingsForSKUAsyncSample {

    /**
     * Just add few required parameters, and try the service
     * Get Lowest Offer Listings For SKU functionality
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
         GetLowestOfferListingsForSKURequest requestOne = new GetLowestOfferListingsForSKURequest();
         // @TODO: set request parameters here

         GetLowestOfferListingsForSKURequest requestTwo = new GetLowestOfferListingsForSKURequest();
         // @TODO: set second request parameters here

         List<GetLowestOfferListingsForSKURequest> requests = new ArrayList<GetLowestOfferListingsForSKURequest>();
         requests.add(requestOne);
         requests.add(requestTwo);

         invokeGetLowestOfferListingsForSKU(service, requests);

         executor.shutdown();

    }


                                                                
    /**
     * Get Lowest Offer Listings For SKU request sample
     * Gets some of the lowest prices based on the product identified by the given
     * SellerId and SKU.
     *   
     * @param service instance of MarketplaceWebServiceProducts service
     * @param requests list of requests to process
     */
    public static void invokeGetLowestOfferListingsForSKU(MarketplaceWebServiceProductsAsync service, List<GetLowestOfferListingsForSKURequest> requests) {
        List<Future<GetLowestOfferListingsForSKUResponse>> responses = new ArrayList<Future<GetLowestOfferListingsForSKUResponse>>();
        for (GetLowestOfferListingsForSKURequest request : requests) {
            responses.add(service.getLowestOfferListingsForSKUAsync(request));
        }
        for (Future<GetLowestOfferListingsForSKUResponse> future : responses) {
            while (!future.isDone()) {
                Thread.yield();
            }
            try {
                GetLowestOfferListingsForSKUResponse response = future.get();
                // Original request corresponding to this response, if needed:
                GetLowestOfferListingsForSKURequest originalRequest = requests.get(responses.indexOf(future));
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
