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
import API.amazon.mws.products.mock.MarketplaceWebServiceProductsMock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Get Product Categories For ASIN  Samples
 *
 *
 */
public class GetProductCategoriesForASINSample {

    
    private Object[] data;
    
    /**
     * Just add few required parameters, and try the service
     * Get Product Categories For ASIN functionality
     *
     * @param args unused
     */
    public GetProductCategoriesForASINSample(String args) {
        
        MarketplaceWebServiceProducts service = new MarketplaceWebServiceProductsClient(
					ProductsConfig.ACCESS_KEY_ID, 
					ProductsConfig.SECRET_ACCESS_KEY, 
					ProductsConfig.APPLICATION_NAME, 
					ProductsConfig.APPLICATION_VERSION, 
					ProductsConfig.config);
 
        /************************************************************************
         * Uncomment to try out Mock Service that simulates Marketplace Web Service Products 
         * responses without calling Marketplace Web Service Products  service.
         *
         * Responses are loaded from local XML files. You can tweak XML files to
         * experiment with various outputs during development
         *
         * XML files available under com/amazonservices/mws/products/mock tree
         *
         ***********************************************************************/
        // MarketplaceWebServiceProducts service = new MarketplaceWebServiceProductsMock();

        /************************************************************************
         * Setup request parameters and uncomment invoke to try out 
         * sample for Get Product Categories For ASIN 
         ***********************************************************************/
         GetProductCategoriesForASINRequest request = new GetProductCategoriesForASINRequest();
         request.setSellerId(ProductsConfig.SELLER_ID);
         request.setASIN(args);
         request.setMarketplaceId("ATVPDKIKX0DER");
         // @TODO: set request parameters here

         data = invokeGetProductCategoriesForASIN(service, request);

    }

    public Object[] getData(){
        return data;
    }

                                                                    
    /**
     * Get Product Categories For ASIN  request sample
     * Gets categories information for a product identified by
     * the MarketplaceId and ASIN.
     *   
     * @param service instance of MarketplaceWebServiceProducts service
     * @param request Action to invoke
     */
    public static Object[] invokeGetProductCategoriesForASIN(MarketplaceWebServiceProducts service, GetProductCategoriesForASINRequest request) {
        
        ArrayList s = new ArrayList();
        
        try {
            
            GetProductCategoriesForASINResponse response = service.getProductCategoriesForASIN(request);
            //System.out.println ("GetProductCategoriesForASIN Action Response");
            //System.out.println ("=============================================================================");
            //System.out.println ();

            //System.out.println("    GetProductCategoriesForASINResponse");
            //System.out.println();
            if (response.isSetGetProductCategoriesForASINResult()) {
                //System.out.println("        GetProductCategoriesForASINResult");
                //System.out.println();
                GetProductCategoriesForASINResult  getProductCategoriesForASINResult = response.getGetProductCategoriesForASINResult();
                java.util.List<Categories> selfList = getProductCategoriesForASINResult.getSelf();
                for (Categories self : selfList) {
                    
                    
                    String gender = self.getParent().getProductCategoryName();
                    s.add(gender);// GENDER
                    
                    if (self.isSetProductCategoryName()) {
                        String cat = self.getProductCategoryName();
                        s.add(cat);
                        
                        String catValue;
                        if(gender.toUpperCase().startsWith("M")){
                            catValue = "27";
                            
                            cat = cat.toUpperCase();
                            if(cat.contains("BOOT")){
                                catValue = catValue+ ";30";
                            }
                            if(cat.contains("LOAFER")){
                                catValue = catValue+ ";31;202";
                            }
                            if(cat.contains("Oxford")){
                                catValue = catValue+ ";29";
                            }
                            if(cat.contains("SANDAL")){
                                catValue = catValue+ ";43";
                            }
                            if(cat.contains("SLIPPER")){
                                catValue = catValue+ ";28";
                            }
                            if(cat.contains("SNEAKER")){
                                catValue = catValue+ ";51";
                            }
                        }else{
                            catValue = "26";
                            
                            cat = cat.toUpperCase();
                            if(cat.contains("BOOT")){
                                catValue = catValue+ ";38";
                            }
                            if(cat.contains("OXFORD")){
                                catValue = catValue + ";207";
                            }
                            if(cat.contains("PLATFORM")){
                                catValue = catValue + ";82";
                            }
                            if(cat.contains("CLOG")){
                                catValue = catValue + ";208";
                            }
                            if(cat.contains("FLAT")){
                                catValue = catValue + ";113";
                            }
                            if(cat.contains("FLOPS")){
                                catValue = catValue + ";200";
                            }
                            if(cat.contains("LOAFER")){
                                catValue = catValue + ";62";
                            }
                            if(cat.contains("PUMP")){
                                catValue = catValue + ";207";
                            }
                            if(cat.contains("SANDAL")){
                                catValue = catValue + ";41";
                            }
                            if(cat.contains("SLIPPER")){
                                catValue = catValue + ";42";
                            }
                            if(cat.contains("SNEAKERS")){
                                catValue = catValue + ";47";
                            }
                            if(cat.contains("HIKING")){
                                catValue = catValue + ";41";
                            }
                            if(cat.contains("RUNNING")){
                                catValue = catValue + ";41";
                            }
                        }
                        
                        s.add(catValue);
                        
                        
                    }
                }
            } /*
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
            */ 
           
        } catch (MarketplaceWebServiceProductsException ex) {
            
            System.out.println("Caught Exception: " + ex.getMessage());
            System.out.println("Response Status Code: " + ex.getStatusCode());
            System.out.println("Error Code: " + ex.getErrorCode());
            if(ex.getErrorCode().equals("RequestThrottled")){
                try {
                    Thread.sleep(500);
                    return invokeGetProductCategoriesForASIN(service,request);
                } catch (InterruptedException ex1) {
                    Logger.getLogger(GetProductCategoriesForASINSample.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            System.out.println("Error Type: " + ex.getErrorType());
            System.out.println("Request ID: " + ex.getRequestId());
            System.out.println("XML: " + ex.getXML());
            System.out.print("ResponseHeaderMetadata: " + ex.getResponseHeaderMetadata());
            s.add("Error 503");
        }
        if(s.isEmpty()){
            s.add("Error 503");
        }
        return s.toArray();
    }
    
}
