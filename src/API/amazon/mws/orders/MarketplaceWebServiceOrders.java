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



package API.amazon.mws.orders;

import API.amazon.mws.orders.model.ListOrdersRequest;
import API.amazon.mws.orders.model.ListOrderItemsRequest;
import API.amazon.mws.orders.model.ListOrdersResponse;
import API.amazon.mws.orders.model.GetServiceStatusRequest;
import API.amazon.mws.orders.model.ListOrderItemsByNextTokenRequest;
import API.amazon.mws.orders.model.ListOrderItemsByNextTokenResponse;
import API.amazon.mws.orders.model.GetServiceStatusResponse;
import API.amazon.mws.orders.model.ListOrdersByNextTokenRequest;
import API.amazon.mws.orders.model.GetOrderResponse;
import API.amazon.mws.orders.model.GetOrderRequest;
import API.amazon.mws.orders.model.ListOrderItemsResponse;
import API.amazon.mws.orders.model.ListOrdersByNextTokenResponse;



/**
 * This contains the Order Retrieval API section of the Marketplace Web Service.
 * 
 * 
 */
public interface  MarketplaceWebServiceOrders {
    

            
    /**
     * List Orders By Next Token 
     *
     * If ListOrders returns a nextToken, thus indicating that there are more orders
     * than returned that matched the given filter criteria, ListOrdersByNextToken
     * can be used to retrieve those other orders using that nextToken.
     *   
     * @param request
     *          ListOrdersByNextToken Action
     * @return
     *          ListOrdersByNextToken Response from the service
     *
     * @throws MarketplaceWebServiceOrdersException
     */
    public ListOrdersByNextTokenResponse listOrdersByNextToken(ListOrdersByNextTokenRequest request) throws MarketplaceWebServiceOrdersException;


            
    /**
     * List Order Items By Next Token 
     *
     * If ListOrderItems cannot return all the order items in one go, it will
     * provide a nextToken. That nextToken can be used with this operation to
     * retrive the next batch of items for that order.
     *   
     * @param request
     *          ListOrderItemsByNextToken Action
     * @return
     *          ListOrderItemsByNextToken Response from the service
     *
     * @throws MarketplaceWebServiceOrdersException
     */
    public ListOrderItemsByNextTokenResponse listOrderItemsByNextToken(ListOrderItemsByNextTokenRequest request) throws MarketplaceWebServiceOrdersException;


            
    /**
     * Get Order 
     *
     * This operation takes up to 50 order ids and returns the corresponding orders.
     *   
     * @param request
     *          GetOrder Action
     * @return
     *          GetOrder Response from the service
     *
     * @throws MarketplaceWebServiceOrdersException
     */
    public GetOrderResponse getOrder(GetOrderRequest request) throws MarketplaceWebServiceOrdersException;


            
    /**
     * List Order Items 
     *
     * This operation can be used to list the items of the order indicated by the
     * given order id (only a single Amazon order id is allowed).
     *   
     * @param request
     *          ListOrderItems Action
     * @return
     *          ListOrderItems Response from the service
     *
     * @throws MarketplaceWebServiceOrdersException
     */
    public ListOrderItemsResponse listOrderItems(ListOrderItemsRequest request) throws MarketplaceWebServiceOrdersException;


            
    /**
     * List Orders 
     *
     * ListOrders can be used to find orders that meet the specified criteria.
     *   
     * @param request
     *          ListOrders Action
     * @return
     *          ListOrders Response from the service
     *
     * @throws MarketplaceWebServiceOrdersException
     */
    public ListOrdersResponse listOrders(ListOrdersRequest request) throws MarketplaceWebServiceOrdersException;


            
    /**
     * Get Service Status 
     *
     * Returns the service status of a particular MWS API section. The operation
     * takes no input.
     *   
     * @param request
     *          GetServiceStatus Action
     * @return
     *          GetServiceStatus Response from the service
     *
     * @throws MarketplaceWebServiceOrdersException
     */
    public GetServiceStatusResponse getServiceStatus(GetServiceStatusRequest request) throws MarketplaceWebServiceOrdersException;



}