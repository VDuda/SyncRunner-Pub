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



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.w3c.dom.Node;

import API.amazon.mws.products.MarketplaceWebServiceProducts;
import API.amazon.mws.products.MarketplaceWebServiceProductsClient;
import API.amazon.mws.products.MarketplaceWebServiceProductsException;
import API.amazon.mws.products.model.AttributeSetList;
import API.amazon.mws.products.model.GetMatchingProductForIdRequest;
import API.amazon.mws.products.model.GetMatchingProductForIdResponse;
import API.amazon.mws.products.model.GetMatchingProductForIdResult;
import API.amazon.mws.products.model.IdListType;
import API.amazon.mws.products.model.Product;
import API.amazon.mws.products.model.ProductList;

/**
 *
 * Get Matching Product For Id  Samples
 *
 *
 */
public class GetMatchingProductForIdSample {
    
    private Object[] data;

    /**
     * Just add few required parameters, and try the service
     * Get Matching Product For Id functionality
     *
     * @param args unused
     */
    public GetMatchingProductForIdSample(String[] args,String idType) {
        
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
         * sample for Get Matching Product For Id 
         ***********************************************************************/
         GetMatchingProductForIdRequest request = new GetMatchingProductForIdRequest();
         request.setSellerId(ProductsConfig.SELLER_ID);
         request.setMarketplaceId(ProductsConfig.MARKETPLACE_ID);
         request.setIdType(idType);
         request.setIdList(new IdListType(Arrays.asList(args)));
                 
         // @TODO: set request parameters here   - 105992

         data = invokeGetMatchingProductForId(service, request);
         
         /*System.out.println("Printing List");
         for(int i=0;i<c.length;i++){
             System.out.print(c[i]+",");
         }*/
         
         
    }
    
    public Object[] getData(){
        return data;
    }


                                    
    /**
     * Get Matching Product For Id  request sample
     * GetMatchingProduct will return the details (attributes) for the
     * given Identifier list. Identifer type can be one of [SKU|ASIN|UPC|EAN|ISBN|GTIN|JAN]
     *   
     * @param service instance of MarketplaceWebServiceProducts service
     * @param request Action to invoke
     */
    private static Object[] invokeGetMatchingProductForId(MarketplaceWebServiceProducts service, GetMatchingProductForIdRequest request) {
        
        List<String> csv = new ArrayList<String>();
        System.out.println("\n-----Checking MWS Product Service------\n");
        try {
            
            GetMatchingProductForIdResponse response = service.getMatchingProductForId(request);

/*            
            System.out.println ("GetMatchingProductForId Action Response");
            System.out.println ("=============================================================================");
            System.out.println ();
*/
            java.util.List<GetMatchingProductForIdResult> getMatchingProductForIdResultList = response.getGetMatchingProductForIdResult();
            for (GetMatchingProductForIdResult getMatchingProductForIdResult : getMatchingProductForIdResultList) {

                if (getMatchingProductForIdResult.isSetProducts()) {

                    ProductList  products = getMatchingProductForIdResult.getProducts();
                    java.util.List<Product> productList = products.getProduct();
                    for (Product product : productList) {
                        
                        if (product.isSetAttributeSets()) {
                          //System.out.println("                    Attributes");
                          //System.out.println(product.getAttributeSets().toXMLFragment());
                          //System.out.println("DONE ATTRIBUT");
                          AttributeSetList attributeSetList = product.getAttributeSets();
    
                          for (Object obj : attributeSetList.getAny()) {
                             Node attribute = (Node) obj;
                             String brand = "N/A";
                             String colorMap = "N/A";
                             String color = "N/A";
                             String gender = "N/A";
                             String style = "N/A";
                             String weight = "2";
                             String styleNum = "N/A";
                             String productGroup = "N/A";
                             String sizeShoe = "N/A";
                             String size = "N/A";
                             String width = "N/A";
                            
                             //System.out.println("V3:"+attribute.getAttributes().getLength());
                             
                             for(int i = 0; i < attribute.getChildNodes().getLength();i++){
                                 String nodeName = attribute.getChildNodes().item(i).getNodeName();
                                //System.out.println(nodeName);
                                //System.out.println("V3:"+attribute.getChildNodes().item(i).getFirstChild().getNodeValue());
                                
                                //BRAND
                                if(nodeName.equals("ns2:Brand")){
                                    brand = attribute.getChildNodes().item(i).getFirstChild().getNodeValue();
                                }
                                
                                //COLOR MAP
                                if(nodeName.equals("ns2:Color")){
                                    colorMap = attribute.getChildNodes().item(i).getFirstChild().getNodeValue();
                                    
                                    String c = colorMap.toUpperCase();
                                    if(c.contains("BLACK")){
                                        color = "Black #000000";
                                    }else if(c.contains("BLUE")){
                                        color = "Blue #000080";
                                    }else if(c.contains("BROWN")){
                                        color = "Brown #8B4513";
                                    }else if(c.contains("GRAY")){
                                        color = "Gray #808080";
                                    }else if(c.contains("GREEN")){
                                        color = "Green #008000";
                                    }else if(c.contains("BEIGE")){
                                        color = "Beige #F5F5DC";
                                    }else if(c.contains("IVORY")){
                                        color = "Ivory #FFFFF0";
                                    }else if(c.contains("WHITE")){
                                        color = "White #FFFFFF";
                                    }else if(c.contains("PINK")){
                                        color = "Pink #FF69B4";
                                    }else if(c.contains("PURPLE")){
                                        color = "Purple #800080";
                                    }else if(c.contains("RED")){
                                        color = "Red #FF0000";
                                    }else if(c.contains("ORANGE")){
                                        color = "Orange #FFA500";
                                    }else if(c.contains("YELLOW")||c.contains("GOLD")){
                                        color = "Yellow #FFFF00";
                                    }else{
                                        color = "Multi";
                                    }
                                    
                                }
                                
                                //GENDER
                                if(nodeName.equals("ns2:Department")){
                                    gender = attribute.getChildNodes().item(i).getFirstChild().getNodeValue();
                                    gender = gender.substring(0,1).toUpperCase()+gender.substring(1,gender.length()-1);
                                    
                                }
                                
                                //STYLE
                                if(nodeName.equals("ns2:Model")){
                                    style = attribute.getChildNodes().item(i).getFirstChild().getNodeValue();
                                }
                                
                                //WEIGHT
                                if(nodeName.equals("ns2:PackageDimensions")){
     
                                    for(int x = 0;x<attribute.getChildNodes().item(i).getChildNodes().getLength();x++){
                                        if(attribute.getChildNodes().item(i).getChildNodes().item(x).getNodeName().contains("ns2:Weight")){
                                            weight = attribute.getChildNodes().item(i).getChildNodes().item(x).getFirstChild().getNodeValue();
                                        }else{
                                            //System.out.println("Couldn't get weight!");
                                        }
                                    }
                                    
                                }
                                
                                //STYLE NUMB
                                if(nodeName.equals("ns2:PartNumber")){
                                    styleNum = attribute.getChildNodes().item(i).getFirstChild().getNodeValue();
                                }
                                
                                //PRODUCT GROUP
                                if(nodeName.equals("ns2:ProductGroup")){
                                    productGroup = attribute.getChildNodes().item(i).getFirstChild().getNodeValue();
                                }
                                
                                //SIZE
                                if(nodeName.equals("ns2:Size")){
                                    
                                    sizeShoe = attribute.getChildNodes().item(i).getFirstChild().getNodeValue();
                                    if(sizeShoe.contains(" ")){
                                    String[] split = sizeShoe.split(" ");
                                    size = split[0];
                                    width = split[1].toUpperCase().trim();
                                    if(width.contains("M")&&gender.equals("womens")){
                                        width = "Medium (B, M)";                                       
                                    }else if(width.contains("B")){
                                        width = "Medium (B, M)";                                       
                                    }else if(width.contains("D")){
                                        width = "Medium (D, M)";                                       
                                    }else if(width.contains("M")){
                                        width = "Medium (D, M)";                                       
                                    }else if(width.contains("E")){
                                        width = "Wide (E, W)";
                                    }else if(width.contains("W")){
                                        width = "Wide (C, D, W)";
                                    }else if(width.contains("N")){
                                        width = "Narrow (AA, N)";
                                    }
                                    
                                    }
                                }
                             }
                             
                             csv.add(brand);
                             csv.add(colorMap);
                             csv.add(color);
                             csv.add(gender);
                             csv.add(style);
                             csv.add(weight);
                             csv.add(styleNum);
                             csv.add(productGroup);
                             csv.add(sizeShoe);
                             csv.add(size);
                             csv.add(width);
                             
                             //for(int i = 0; i < csv.size();i++){
                             //    System.out.print(csv.get(i)+", ");
                             //}
                             //System.out.println();
                             //System.out.println(ProductsUtil.formatXml(attribute));
                             //System.out.println("END TESTING");
                             //System.out.println(ProductsUtil.formatXml(attribute));
                          }
                          //System.out.println();
                        }
                         
                        
                    }
                } 
                if (getMatchingProductForIdResult.isSetError()) {
                    csv.add("Error 503");
                    System.out.println("            Error");
                    System.out.println();
                    API.amazon.mws.products.model.Error  error = getMatchingProductForIdResult.getError();
                    if (error.isSetType()) {
                        System.out.println("                Type");
                        System.out.println();
                        System.out.println("                    " + error.getType());
                        System.out.println();
                    }
                    if (error.isSetCode()) {
                        System.out.println("                Code");
                        System.out.println();
                        System.out.println("                    " + error.getCode());
                        System.out.println();
                    }
                    if (error.isSetMessage()) {
                        System.out.println("                Message");
                        System.out.println();
                        System.out.println("                    " + error.getMessage());
                        System.out.println();
                    }
                } 
            }
           
            //System.out.println();
            //System.out.println(response.getResponseHeaderMetadata());
            //System.out.println();

           
        } catch (MarketplaceWebServiceProductsException ex) {
            
            System.out.println("Caught Exception: " + ex.getMessage());
            System.out.println("Response Status Code: " + ex.getStatusCode());
            System.out.println("Error Code: " + ex.getErrorCode());
            if(ex.getErrorCode().equals("RequestThrottled")){
                try {
                    Thread.sleep(500);
                    return invokeGetMatchingProductForId(service,request);
                } catch (InterruptedException ex1) {
                    Logger.getLogger(GetProductCategoriesForASINSample.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            System.out.println("Error Type: " + ex.getErrorType());
            System.out.println("Request ID: " + ex.getRequestId());
            System.out.println("XML: " + ex.getXML());
            System.out.print("ResponseHeaderMetadata: " + ex.getResponseHeaderMetadata());
            csv.add("Error 503");
            
        }
        System.out.println("\n------------Done Checking------------\n");
        if(csv.isEmpty()){
            csv.add("Error 503");
        }
        return csv.toArray();
    }
                                    
}
