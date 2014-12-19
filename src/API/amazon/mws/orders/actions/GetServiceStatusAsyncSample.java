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

import API.amazon.mws.orders.model.GetServiceStatusRequest;
import API.amazon.mws.orders.model.GetServiceStatusResponse;
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
 * Get Service Status  Samples
 *
 *
 */
public class GetServiceStatusAsyncSample {

    /**
     * Just add few required parameters, and try the service
     * Get Service Status functionality
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
         GetServiceStatusRequest requestOne = new GetServiceStatusRequest();
         // @TODO: set request parameters here

         GetServiceStatusRequest requestTwo = new GetServiceStatusRequest();
         // @TODO: set second request parameters here

         List<GetServiceStatusRequest> requests = new ArrayList<GetServiceStatusRequest>();
         requests.add(requestOne);
         requests.add(requestTwo);

         invokeGetServiceStatus(service, requests);

         executor.shutdown();

    }


                                            
    /**
     * Get Service Status request sample
     * Returns the service status of a particular MWS API section. The operation
     * takes no input.
     *   
     * @param service instance of MarketplaceWebServiceOrders service
     * @param requests list of requests to process
     */
    public static void invokeGetServiceStatus(MarketplaceWebServiceOrdersAsync service, List<GetServiceStatusRequest> requests) {
        List<Future<GetServiceStatusResponse>> responses = new ArrayList<Future<GetServiceStatusResponse>>();
        for (GetServiceStatusRequest request : requests) {
            responses.add(service.getServiceStatusAsync(request));
        }
        for (Future<GetServiceStatusResponse> future : responses) {
            while (!future.isDone()) {
                Thread.yield();
            }
            try {
                GetServiceStatusResponse response = future.get();
                // Original request corresponding to this response, if needed:
                GetServiceStatusRequest originalRequest = requests.get(responses.indexOf(future));
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
