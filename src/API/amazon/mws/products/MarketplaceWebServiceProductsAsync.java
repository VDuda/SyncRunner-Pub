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
import java.util.concurrent.Future;



/**
 * This is the Products API section of the Marketplace Web Service.
 * 
 *
 */

public interface MarketplaceWebServiceProductsAsync extends MarketplaceWebServiceProducts {


            
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
     */
    public Future<GetMatchingProductResponse> getMatchingProductAsync(final GetMatchingProductRequest request);


            
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
     */
    public Future<GetLowestOfferListingsForASINResponse> getLowestOfferListingsForASINAsync(final GetLowestOfferListingsForASINRequest request);


            
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
     */
    public Future<GetServiceStatusResponse> getServiceStatusAsync(final GetServiceStatusRequest request);


            
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
     */
    public Future<GetMatchingProductForIdResponse> getMatchingProductForIdAsync(final GetMatchingProductForIdRequest request);


            
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
     */
    public Future<GetMyPriceForSKUResponse> getMyPriceForSKUAsync(final GetMyPriceForSKURequest request);


            
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
     */
    public Future<ListMatchingProductsResponse> listMatchingProductsAsync(final ListMatchingProductsRequest request);


            
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
     */
    public Future<GetCompetitivePricingForSKUResponse> getCompetitivePricingForSKUAsync(final GetCompetitivePricingForSKURequest request);


            
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
     */
    public Future<GetCompetitivePricingForASINResponse> getCompetitivePricingForASINAsync(final GetCompetitivePricingForASINRequest request);


            
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
     */
    public Future<GetProductCategoriesForSKUResponse> getProductCategoriesForSKUAsync(final GetProductCategoriesForSKURequest request);


            
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
     */
    public Future<GetMyPriceForASINResponse> getMyPriceForASINAsync(final GetMyPriceForASINRequest request);


            
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
     */
    public Future<GetLowestOfferListingsForSKUResponse> getLowestOfferListingsForSKUAsync(final GetLowestOfferListingsForSKURequest request);


            
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
     */
    public Future<GetProductCategoriesForASINResponse> getProductCategoriesForASINAsync(final GetProductCategoriesForASINRequest request);



}
