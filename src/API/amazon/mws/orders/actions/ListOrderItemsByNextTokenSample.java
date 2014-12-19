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

import API.amazon.mws.orders.model.PromotionIdList;
import API.amazon.mws.orders.model.ListOrderItemsByNextTokenRequest;
import API.amazon.mws.orders.model.ListOrderItemsByNextTokenResponse;
import API.amazon.mws.orders.model.Money;
import API.amazon.mws.orders.model.InvoiceData;
import API.amazon.mws.orders.model.ResponseMetadata;
import API.amazon.mws.orders.model.OrderItemList;
import API.amazon.mws.orders.model.ListOrderItemsByNextTokenResult;
import API.amazon.mws.orders.model.OrderItem;
import API.amazon.mws.orders.MarketplaceWebServiceOrders;
import API.amazon.mws.orders.MarketplaceWebServiceOrdersClient;
import API.amazon.mws.orders.MarketplaceWebServiceOrdersException;
import java.util.List;
import java.util.ArrayList;
import API.amazon.mws.orders.mock.MarketplaceWebServiceOrdersMock;

/**
 *
 * List Order Items By Next Token  Samples
 *
 *
 */
public class ListOrderItemsByNextTokenSample {

    /**
     * Just add few required parameters, and try the service
     * List Order Items By Next Token functionality
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
         * sample for List Order Items By Next Token 
         ***********************************************************************/
         ListOrderItemsByNextTokenRequest request = new ListOrderItemsByNextTokenRequest();
         request.setSellerId(OrdersConfig.sellerId);
        
         // @TODO: set request parameters here

         invokeListOrderItemsByNextToken(service, request);

    }


                            
    /**
     * List Order Items By Next Token  request sample
     * If ListOrderItems cannot return all the order items in one go, it will
     * provide a nextToken. That nextToken can be used with this operation to
     * retrive the next batch of items for that order.
     *   
     * @param service instance of MarketplaceWebServiceOrders service
     * @param request Action to invoke
     */
    public static void invokeListOrderItemsByNextToken(MarketplaceWebServiceOrders service, ListOrderItemsByNextTokenRequest request) {
        try {
            
            ListOrderItemsByNextTokenResponse response = service.listOrderItemsByNextToken(request);

            
            System.out.println ("ListOrderItemsByNextToken Action Response");
            System.out.println ("=============================================================================");
            System.out.println ();

            System.out.println("    ListOrderItemsByNextTokenResponse");
            System.out.println();
            if (response.isSetListOrderItemsByNextTokenResult()) {
                System.out.println("        ListOrderItemsByNextTokenResult");
                System.out.println();
                ListOrderItemsByNextTokenResult  listOrderItemsByNextTokenResult = response.getListOrderItemsByNextTokenResult();
                if (listOrderItemsByNextTokenResult.isSetNextToken()) {
                    System.out.println("            NextToken");
                    System.out.println();
                    System.out.println("                " + listOrderItemsByNextTokenResult.getNextToken());
                    System.out.println();
                }
                if (listOrderItemsByNextTokenResult.isSetAmazonOrderId()) {
                    System.out.println("            AmazonOrderId");
                    System.out.println();
                    System.out.println("                " + listOrderItemsByNextTokenResult.getAmazonOrderId());
                    System.out.println();
                }
                if (listOrderItemsByNextTokenResult.isSetOrderItems()) {
                    System.out.println("            OrderItems");
                    System.out.println();
                    OrderItemList  orderItems = listOrderItemsByNextTokenResult.getOrderItems();
                    java.util.List<OrderItem> orderItemList = orderItems.getOrderItem();
                    for (OrderItem orderItem : orderItemList) {
                        System.out.println("                OrderItem");
                        System.out.println();
                        if (orderItem.isSetASIN()) {
                            System.out.println("                    ASIN");
                            System.out.println();
                            System.out.println("                        " + orderItem.getASIN());
                            System.out.println();
                        }
                        if (orderItem.isSetSellerSKU()) {
                            System.out.println("                    SellerSKU");
                            System.out.println();
                            System.out.println("                        " + orderItem.getSellerSKU());
                            System.out.println();
                        }
                        if (orderItem.isSetOrderItemId()) {
                            System.out.println("                    OrderItemId");
                            System.out.println();
                            System.out.println("                        " + orderItem.getOrderItemId());
                            System.out.println();
                        }
                        if (orderItem.isSetTitle()) {
                            System.out.println("                    Title");
                            System.out.println();
                            System.out.println("                        " + orderItem.getTitle());
                            System.out.println();
                        }
                        if (orderItem.isSetQuantityOrdered()) {
                            System.out.println("                    QuantityOrdered");
                            System.out.println();
                            System.out.println("                        " + orderItem.getQuantityOrdered());
                            System.out.println();
                        }
                        if (orderItem.isSetQuantityShipped()) {
                            System.out.println("                    QuantityShipped");
                            System.out.println();
                            System.out.println("                        " + orderItem.getQuantityShipped());
                            System.out.println();
                        }
                        if (orderItem.isSetItemPrice()) {
                            System.out.println("                    ItemPrice");
                            System.out.println();
                            Money  itemPrice = orderItem.getItemPrice();
                            if (itemPrice.isSetCurrencyCode()) {
                                System.out.println("                        CurrencyCode");
                                System.out.println();
                                System.out.println("                            " + itemPrice.getCurrencyCode());
                                System.out.println();
                            }
                            if (itemPrice.isSetAmount()) {
                                System.out.println("                        Amount");
                                System.out.println();
                                System.out.println("                            " + itemPrice.getAmount());
                                System.out.println();
                            }
                        } 
                        if (orderItem.isSetShippingPrice()) {
                            System.out.println("                    ShippingPrice");
                            System.out.println();
                            Money  shippingPrice = orderItem.getShippingPrice();
                            if (shippingPrice.isSetCurrencyCode()) {
                                System.out.println("                        CurrencyCode");
                                System.out.println();
                                System.out.println("                            " + shippingPrice.getCurrencyCode());
                                System.out.println();
                            }
                            if (shippingPrice.isSetAmount()) {
                                System.out.println("                        Amount");
                                System.out.println();
                                System.out.println("                            " + shippingPrice.getAmount());
                                System.out.println();
                            }
                        } 
                        if (orderItem.isSetGiftWrapPrice()) {
                            System.out.println("                    GiftWrapPrice");
                            System.out.println();
                            Money  giftWrapPrice = orderItem.getGiftWrapPrice();
                            if (giftWrapPrice.isSetCurrencyCode()) {
                                System.out.println("                        CurrencyCode");
                                System.out.println();
                                System.out.println("                            " + giftWrapPrice.getCurrencyCode());
                                System.out.println();
                            }
                            if (giftWrapPrice.isSetAmount()) {
                                System.out.println("                        Amount");
                                System.out.println();
                                System.out.println("                            " + giftWrapPrice.getAmount());
                                System.out.println();
                            }
                        } 
                        if (orderItem.isSetItemTax()) {
                            System.out.println("                    ItemTax");
                            System.out.println();
                            Money  itemTax = orderItem.getItemTax();
                            if (itemTax.isSetCurrencyCode()) {
                                System.out.println("                        CurrencyCode");
                                System.out.println();
                                System.out.println("                            " + itemTax.getCurrencyCode());
                                System.out.println();
                            }
                            if (itemTax.isSetAmount()) {
                                System.out.println("                        Amount");
                                System.out.println();
                                System.out.println("                            " + itemTax.getAmount());
                                System.out.println();
                            }
                        } 
                        if (orderItem.isSetShippingTax()) {
                            System.out.println("                    ShippingTax");
                            System.out.println();
                            Money  shippingTax = orderItem.getShippingTax();
                            if (shippingTax.isSetCurrencyCode()) {
                                System.out.println("                        CurrencyCode");
                                System.out.println();
                                System.out.println("                            " + shippingTax.getCurrencyCode());
                                System.out.println();
                            }
                            if (shippingTax.isSetAmount()) {
                                System.out.println("                        Amount");
                                System.out.println();
                                System.out.println("                            " + shippingTax.getAmount());
                                System.out.println();
                            }
                        } 
                        if (orderItem.isSetGiftWrapTax()) {
                            System.out.println("                    GiftWrapTax");
                            System.out.println();
                            Money  giftWrapTax = orderItem.getGiftWrapTax();
                            if (giftWrapTax.isSetCurrencyCode()) {
                                System.out.println("                        CurrencyCode");
                                System.out.println();
                                System.out.println("                            " + giftWrapTax.getCurrencyCode());
                                System.out.println();
                            }
                            if (giftWrapTax.isSetAmount()) {
                                System.out.println("                        Amount");
                                System.out.println();
                                System.out.println("                            " + giftWrapTax.getAmount());
                                System.out.println();
                            }
                        } 
                        if (orderItem.isSetShippingDiscount()) {
                            System.out.println("                    ShippingDiscount");
                            System.out.println();
                            Money  shippingDiscount = orderItem.getShippingDiscount();
                            if (shippingDiscount.isSetCurrencyCode()) {
                                System.out.println("                        CurrencyCode");
                                System.out.println();
                                System.out.println("                            " + shippingDiscount.getCurrencyCode());
                                System.out.println();
                            }
                            if (shippingDiscount.isSetAmount()) {
                                System.out.println("                        Amount");
                                System.out.println();
                                System.out.println("                            " + shippingDiscount.getAmount());
                                System.out.println();
                            }
                        } 
                        if (orderItem.isSetPromotionDiscount()) {
                            System.out.println("                    PromotionDiscount");
                            System.out.println();
                            Money  promotionDiscount = orderItem.getPromotionDiscount();
                            if (promotionDiscount.isSetCurrencyCode()) {
                                System.out.println("                        CurrencyCode");
                                System.out.println();
                                System.out.println("                            " + promotionDiscount.getCurrencyCode());
                                System.out.println();
                            }
                            if (promotionDiscount.isSetAmount()) {
                                System.out.println("                        Amount");
                                System.out.println();
                                System.out.println("                            " + promotionDiscount.getAmount());
                                System.out.println();
                            }
                        } 
                        if (orderItem.isSetPromotionIds()) {
                            System.out.println("                    PromotionIds");
                            System.out.println();
                            PromotionIdList  promotionIds = orderItem.getPromotionIds();
                            java.util.List<String> promotionIdList  =  promotionIds.getPromotionId();
                            for (String promotionId : promotionIdList) { 
                                System.out.println("                        PromotionId");
                                    System.out.println();
                                System.out.println("                            " + promotionId);
                            }	
                        } 
                        if (orderItem.isSetCODFee()) {
                            System.out.println("                    CODFee");
                            System.out.println();
                            Money  CODFee = orderItem.getCODFee();
                            if (CODFee.isSetCurrencyCode()) {
                                System.out.println("                        CurrencyCode");
                                System.out.println();
                                System.out.println("                            " + CODFee.getCurrencyCode());
                                System.out.println();
                            }
                            if (CODFee.isSetAmount()) {
                                System.out.println("                        Amount");
                                System.out.println();
                                System.out.println("                            " + CODFee.getAmount());
                                System.out.println();
                            }
                        } 
                        if (orderItem.isSetCODFeeDiscount()) {
                            System.out.println("                    CODFeeDiscount");
                            System.out.println();
                            Money  CODFeeDiscount = orderItem.getCODFeeDiscount();
                            if (CODFeeDiscount.isSetCurrencyCode()) {
                                System.out.println("                        CurrencyCode");
                                System.out.println();
                                System.out.println("                            " + CODFeeDiscount.getCurrencyCode());
                                System.out.println();
                            }
                            if (CODFeeDiscount.isSetAmount()) {
                                System.out.println("                        Amount");
                                System.out.println();
                                System.out.println("                            " + CODFeeDiscount.getAmount());
                                System.out.println();
                            }
                        } 
                        if (orderItem.isSetGiftMessageText()) {
                            System.out.println("                    GiftMessageText");
                            System.out.println();
                            System.out.println("                        " + orderItem.getGiftMessageText());
                            System.out.println();
                        }
                        if (orderItem.isSetGiftWrapLevel()) {
                            System.out.println("                    GiftWrapLevel");
                            System.out.println();
                            System.out.println("                        " + orderItem.getGiftWrapLevel());
                            System.out.println();
                        }
                        if (orderItem.isSetInvoiceData()) {
                            System.out.println("                    InvoiceData");
                            System.out.println();
                            InvoiceData  invoiceData = orderItem.getInvoiceData();
                            if (invoiceData.isSetInvoiceRequirement()) {
                                System.out.println("                        InvoiceRequirement");
                                System.out.println();
                                System.out.println("                            " + invoiceData.getInvoiceRequirement());
                                System.out.println();
                            }
                            if (invoiceData.isSetBuyerSelectedInvoiceCategory()) {
                                System.out.println("                        BuyerSelectedInvoiceCategory");
                                System.out.println();
                                System.out.println("                            " + invoiceData.getBuyerSelectedInvoiceCategory());
                                System.out.println();
                            }
                            if (invoiceData.isSetInvoiceTitle()) {
                                System.out.println("                        InvoiceTitle");
                                System.out.println();
                                System.out.println("                            " + invoiceData.getInvoiceTitle());
                                System.out.println();
                            }
                            if (invoiceData.isSetInvoiceInformation()) {
                                System.out.println("                        InvoiceInformation");
                                System.out.println();
                                System.out.println("                            " + invoiceData.getInvoiceInformation());
                                System.out.println();
                            }
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
