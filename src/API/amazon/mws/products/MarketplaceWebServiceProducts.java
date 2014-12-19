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



package API.amazon.mws.products;

import API.amazon.mws.products.model.*;



/**
 * This is the Products API section of the Marketplace Web Service.
 * 
 * 
 */
public interface  MarketplaceWebServiceProducts {
    

            
    /**
     * Get Matching Product 
     *
     * GetMatchingProduct will return the details (attributes) for the
     * given ASIN.
     *   
     * @param request
     *          GetMatchingProduct Action
     * @return
     *          GetMatchingProduct Response from the service
     *
     * @throws MarketplaceWebServiceProductsException
     */
    public GetMatchingProductResponse getMatchingProduct(GetMatchingProductRequest request) throws MarketplaceWebServiceProductsException;


            
    /**
     * Get Lowest Offer Listings For ASIN 
     *
     * Gets some of the lowest prices based on the product identified by the given
     * MarketplaceId and ASIN.
     *   
     * @param request
     *          GetLowestOfferListingsForASIN Action
     * @return
     *          GetLowestOfferListingsForASIN Response from the service
     *
     * @throws MarketplaceWebServiceProductsException
     */
    public GetLowestOfferListingsForASINResponse getLowestOfferListingsForASIN(GetLowestOfferListingsForASINRequest request) throws MarketplaceWebServiceProductsException;


            
    /**
     * Get Service Status 
     *
     * Returns the service status of a particular MWS API section. The operation
     * takes no input.
     * All API sections within the API are required to implement this operation.
     *   
     * @param request
     *          GetServiceStatus Action
     * @return
     *          GetServiceStatus Response from the service
     *
     * @throws MarketplaceWebServiceProductsException
     */
    public GetServiceStatusResponse getServiceStatus(GetServiceStatusRequest request) throws MarketplaceWebServiceProductsException;


            
    /**
     * Get Matching Product For Id 
     *
     * GetMatchingProduct will return the details (attributes) for the
     * given Identifier list. Identifer type can be one of [SKU|ASIN|UPC|EAN|ISBN|GTIN|JAN]
     *   
     * @param request
     *          GetMatchingProductForId Action
     * @return
     *          GetMatchingProductForId Response from the service
     *
     * @throws MarketplaceWebServiceProductsException
     */
    public GetMatchingProductForIdResponse getMatchingProductForId(GetMatchingProductForIdRequest request) throws MarketplaceWebServiceProductsException;


            
    /**
     * Get My Price For SKU 
     *
     * GetMatchingProduct will return the details (attributes) for the
     * given Identifier list. Identifer type can be one of [SKU|ASIN|UPC|EAN|ISBN|GTIN|JAN]
     *   
     * @param request
     *          GetMyPriceForSKU Action
     * @return
     *          GetMyPriceForSKU Response from the service
     *
     * @throws MarketplaceWebServiceProductsException
     */
    public GetMyPriceForSKUResponse getMyPriceForSKU(GetMyPriceForSKURequest request) throws MarketplaceWebServiceProductsException;


            
    /**
     * List Matching Products 
     *
     * ListMatchingProducts can be used to
     * find products that match the given criteria.
     *   
     * @param request
     *          ListMatchingProducts Action
     * @return
     *          ListMatchingProducts Response from the service
     *
     * @throws MarketplaceWebServiceProductsException
     */
    public ListMatchingProductsResponse listMatchingProducts(ListMatchingProductsRequest request) throws MarketplaceWebServiceProductsException;


            
    /**
     * Get Competitive Pricing For SKU 
     *
     * Gets competitive pricing and related information for a product identified by
     * the SellerId and SKU.
     *   
     * @param request
     *          GetCompetitivePricingForSKU Action
     * @return
     *          GetCompetitivePricingForSKU Response from the service
     *
     * @throws MarketplaceWebServiceProductsException
     */
    public GetCompetitivePricingForSKUResponse getCompetitivePricingForSKU(GetCompetitivePricingForSKURequest request) throws MarketplaceWebServiceProductsException;


            
    /**
     * Get Competitive Pricing For ASIN 
     *
     * Gets competitive pricing and related information for a product identified by
     * the MarketplaceId and ASIN.
     *   
     * @param request
     *          GetCompetitivePricingForASIN Action
     * @return
     *          GetCompetitivePricingForASIN Response from the service
     *
     * @throws MarketplaceWebServiceProductsException
     */
    public GetCompetitivePricingForASINResponse getCompetitivePricingForASIN(GetCompetitivePricingForASINRequest request) throws MarketplaceWebServiceProductsException;


            
    /**
     * Get Product Categories For SKU 
     *
     * Gets categories information for a product identified by
     * the SellerId and SKU.
     *   
     * @param request
     *          GetProductCategoriesForSKU Action
     * @return
     *          GetProductCategoriesForSKU Response from the service
     *
     * @throws MarketplaceWebServiceProductsException
     */
    public GetProductCategoriesForSKUResponse getProductCategoriesForSKU(GetProductCategoriesForSKURequest request) throws MarketplaceWebServiceProductsException;


            
    /**
     * Get My Price For ASIN 
     *
     * Gets categories information for a product identified by
     * the SellerId and SKU.
     *   
     * @param request
     *          GetMyPriceForASIN Action
     * @return
     *          GetMyPriceForASIN Response from the service
     *
     * @throws MarketplaceWebServiceProductsException
     */
    public GetMyPriceForASINResponse getMyPriceForASIN(GetMyPriceForASINRequest request) throws MarketplaceWebServiceProductsException;


            
    /**
     * Get Lowest Offer Listings For SKU 
     *
     * Gets some of the lowest prices based on the product identified by the given
     * SellerId and SKU.
     *   
     * @param request
     *          GetLowestOfferListingsForSKU Action
     * @return
     *          GetLowestOfferListingsForSKU Response from the service
     *
     * @throws MarketplaceWebServiceProductsException
     */
    public GetLowestOfferListingsForSKUResponse getLowestOfferListingsForSKU(GetLowestOfferListingsForSKURequest request) throws MarketplaceWebServiceProductsException;


            
    /**
     * Get Product Categories For ASIN 
     *
     * Gets categories information for a product identified by
     * the MarketplaceId and ASIN.
     *   
     * @param request
     *          GetProductCategoriesForASIN Action
     * @return
     *          GetProductCategoriesForASIN Response from the service
     *
     * @throws MarketplaceWebServiceProductsException
     */
    public GetProductCategoriesForASINResponse getProductCategoriesForASIN(GetProductCategoriesForASINRequest request) throws MarketplaceWebServiceProductsException;



}