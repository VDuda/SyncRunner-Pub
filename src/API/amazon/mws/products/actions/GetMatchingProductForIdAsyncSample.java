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
 * Get Matching Product For Id  Samples
 *
 *
 */
public class GetMatchingProductForIdAsyncSample {

    /**
     * Just add few required parameters, and try the service
     * Get Matching Product For Id functionality
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
         GetMatchingProductForIdRequest requestOne = new GetMatchingProductForIdRequest();
         // @TODO: set request parameters here

         GetMatchingProductForIdRequest requestTwo = new GetMatchingProductForIdRequest();
         // @TODO: set second request parameters here

         List<GetMatchingProductForIdRequest> requests = new ArrayList<GetMatchingProductForIdRequest>();
         requests.add(requestOne);
         requests.add(requestTwo);

         invokeGetMatchingProductForId(service, requests);

         executor.shutdown();

    }


                                    
    /**
     * Get Matching Product For Id request sample
     * GetMatchingProduct will return the details (attributes) for the
     * given Identifier list. Identifer type can be one of [SKU|ASIN|UPC|EAN|ISBN|GTIN|JAN]
     *   
     * @param service instance of MarketplaceWebServiceProducts service
     * @param requests list of requests to process
     */
    public static void invokeGetMatchingProductForId(MarketplaceWebServiceProductsAsync service, List<GetMatchingProductForIdRequest> requests) {
        List<Future<GetMatchingProductForIdResponse>> responses = new ArrayList<Future<GetMatchingProductForIdResponse>>();
        for (GetMatchingProductForIdRequest request : requests) {
            responses.add(service.getMatchingProductForIdAsync(request));
        }
        for (Future<GetMatchingProductForIdResponse> future : responses) {
            while (!future.isDone()) {
                Thread.yield();
            }
            try {
                GetMatchingProductForIdResponse response = future.get();
                // Original request corresponding to this response, if needed:
                GetMatchingProductForIdRequest originalRequest = requests.get(responses.indexOf(future));
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
