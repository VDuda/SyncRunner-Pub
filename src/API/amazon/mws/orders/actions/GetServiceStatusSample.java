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

import API.amazon.mws.orders.model.Message;
import API.amazon.mws.orders.model.GetServiceStatusRequest;
import API.amazon.mws.orders.model.GetServiceStatusResult;
import API.amazon.mws.orders.model.GetServiceStatusResponse;
import API.amazon.mws.orders.model.ResponseMetadata;
import API.amazon.mws.orders.model.MessageList;
import API.amazon.mws.orders.MarketplaceWebServiceOrders;
import API.amazon.mws.orders.MarketplaceWebServiceOrdersClient;
import API.amazon.mws.orders.MarketplaceWebServiceOrdersException;
import java.util.List;
import java.util.ArrayList;
import API.amazon.mws.orders.mock.MarketplaceWebServiceOrdersMock;

/**
 *
 * Get Service Status  Samples
 *
 *
 */
public class GetServiceStatusSample {

    /**
     * Just add few required parameters, and try the service
     * Get Service Status functionality
     *
     * @param args unused
     */
    public static void main(String... args) {
        
        MarketplaceWebServiceOrders service = new MarketplaceWebServiceOrdersClient(
					OrdersConfig.accessKeyId, 
					OrdersConfig.secretAccessKey, 
					OrdersConfig.applicationName, 
					OrdersConfig.applicationVersion, 
					OrdersConfig.config);
 
        /************************************************************************
         * Uncomment to try out Mock Service that simulates Marketplace Web Service Orders 
         * responses without calling Marketplace Web Service Orders  service.
         *
         * Responses are loaded from local XML files. You can tweak XML files to
         * experiment with various outputs during development
         *
         * XML files available under com/amazonservices/mws/orders/mock tree
         *
         ***********************************************************************/
        // MarketplaceWebServiceOrders service = new MarketplaceWebServiceOrdersMock();

        /************************************************************************
         * Setup request parameters and uncomment invoke to try out 
         * sample for Get Service Status 
         ***********************************************************************/
         GetServiceStatusRequest request = new GetServiceStatusRequest();
         request.setSellerId(OrdersConfig.sellerId);
        
         // @TODO: set request parameters here

         invokeGetServiceStatus(service, request);

    }


                                            
    /**
     * Get Service Status  request sample
     * Returns the service status of a particular MWS API section. The operation
     * takes no input.
     *   
     * @param service instance of MarketplaceWebServiceOrders service
     * @param request Action to invoke
     */
    public static void invokeGetServiceStatus(MarketplaceWebServiceOrders service, GetServiceStatusRequest request) {
        try {
            
            GetServiceStatusResponse response = service.getServiceStatus(request);

            
            System.out.println ("GetServiceStatus Action Response");
            System.out.println ("=============================================================================");
            System.out.println ();

            System.out.println("    GetServiceStatusResponse");
            System.out.println();
            if (response.isSetGetServiceStatusResult()) {
                System.out.println("        GetServiceStatusResult");
                System.out.println();
                GetServiceStatusResult  getServiceStatusResult = response.getGetServiceStatusResult();
                if (getServiceStatusResult.isSetStatus()) {
                    System.out.println("            Status");
                    System.out.println();
                    System.out.println("                " + getServiceStatusResult.getStatus().value());
                    System.out.println();
                }
                if (getServiceStatusResult.isSetTimestamp()) {
                    System.out.println("            Timestamp");
                    System.out.println();
                    System.out.println("                " + getServiceStatusResult.getTimestamp());
                    System.out.println();
                }
                if (getServiceStatusResult.isSetMessageId()) {
                    System.out.println("            MessageId");
                    System.out.println();
                    System.out.println("                " + getServiceStatusResult.getMessageId());
                    System.out.println();
                }
                if (getServiceStatusResult.isSetMessages()) {
                    System.out.println("            Messages");
                    System.out.println();
                    MessageList  messages = getServiceStatusResult.getMessages();
                    java.util.List<Message> messageList = messages.getMessage();
                    for (Message message : messageList) {
                        System.out.println("                Message");
                        System.out.println();
                        if (message.isSetLocale()) {
                            System.out.println("                    Locale");
                            System.out.println();
                            System.out.println("                        " + message.getLocale());
                            System.out.println();
                        }
                        if (message.isSetText()) {
                            System.out.println("                    Text");
                            System.out.println();
                            System.out.println("                        " + message.getText());
                            System.out.println();
                        }
                    }
                } 
            } 
            if (response.isSetResponseMetadata()) {
                System.out.println("        ResponseMetadata");
                System.out.println();
                ResponseMetadata  responseMetadata = response.getResponseMetadata();
                if (responseMetadata.isSetRequestId()) {
                    System.out.println("            RequestId");
                    System.out.println();
                    System.out.println("                " + responseMetadata.getRequestId());
                    System.out.println();
                }
            } 
            System.out.println();
            System.out.println(response.getResponseHeaderMetadata());
            System.out.println();

           
        } catch (MarketplaceWebServiceOrdersException ex) {
            
            System.out.println("Caught Exception: " + ex.getMessage());
            System.out.println("Response Status Code: " + ex.getStatusCode());
            System.out.println("Error Code: " + ex.getErrorCode());
            System.out.println("Error Type: " + ex.getErrorType());
            System.out.println("Request ID: " + ex.getRequestId());
            System.out.println("XML: " + ex.getXML());
            System.out.print("ResponseHeaderMetadata: " + ex.getResponseHeaderMetadata());
        }
    }
    
}
