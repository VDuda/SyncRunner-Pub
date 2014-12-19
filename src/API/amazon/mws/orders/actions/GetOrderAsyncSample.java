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
 *  Marketplace Web Service Orders Java Library
 *  API Version: 2011-01-01
 * 
 */



package API.amazon.mws.orders.actions;

import API.amazon.mws.orders.model.GetOrderResponse;
import API.amazon.mws.orders.model.GetOrderRequest;
import API.amazon.mws.orders.MarketplaceWebServiceOrdersAsync;
import API.amazon.mws.orders.MarketplaceWebServiceOrdersAsyncClient;
import API.amazon.mws.orders.MarketplaceWebServiceOrdersException;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 *
 * Get Order  Samples
 *
 *
 */
public class GetOrderAsyncSample {

    /**
     * Just add few required parameters, and try the service
     * Get Order functionality
     *
     * @param args unused
     */
    public static void main(String... args) {
        
         ExecutorService executor = Executors.newFixedThreadPool(100);
         MarketplaceWebServiceOrdersAsync service = new MarketplaceWebServiceOrdersAsyncClient(
					OrdersConfig.accessKeyId, 
					OrdersConfig.secretAccessKey, 
					OrdersConfig.applicationName, 
					OrdersConfig.applicationVersion, 
					OrdersConfig.config,
					executor);

        /************************************************************************
         * Setup requests parameters and invoke parallel processing. Of course
         * in real world application, there will be much more than a couple of
         * requests to process.
         ***********************************************************************/
         GetOrderRequest requestOne = new GetOrderRequest();
         // @TODO: set request parameters here

         GetOrderRequest requestTwo = new GetOrderRequest();
         // @TODO: set second request parameters here

         List<GetOrderRequest> requests = new ArrayList<GetOrderRequest>();
         requests.add(requestOne);
         requests.add(requestTwo);

         invokeGetOrder(service, requests);

         executor.shutdown();

    }


                                
    /**
     * Get Order request sample
     * This operation takes up to 50 order ids and returns the corresponding orders.
     *   
     * @param service instance of MarketplaceWebServiceOrders service
     * @param requests list of requests to process
     */
    public static void invokeGetOrder(MarketplaceWebServiceOrdersAsync service, List<GetOrderRequest> requests) {
        List<Future<GetOrderResponse>> responses = new ArrayList<Future<GetOrderResponse>>();
        for (GetOrderRequest request : requests) {
            responses.add(service.getOrderAsync(request));
        }
        for (Future<GetOrderResponse> future : responses) {
            while (!future.isDone()) {
                Thread.yield();
            }
            try {
                GetOrderResponse response = future.get();
                // Original request corresponding to this response, if needed:
                GetOrderRequest originalRequest = requests.get(responses.indexOf(future));
                System.out.println("Response request id: " + response.getResponseMetadata().getRequestId());
            } catch (Exception e) {
                if (e.getCause() instanceof MarketplaceWebServiceOrdersException) {
                    MarketplaceWebServiceOrdersException exception = MarketplaceWebServiceOrdersException.class.cast(e.getCause());
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
