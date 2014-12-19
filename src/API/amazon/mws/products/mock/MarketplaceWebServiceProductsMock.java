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



package API.amazon.mws.products.mock;

import API.amazon.mws.products.model.*;
import API.amazon.mws.products.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.InputSource;

/**
 *
 * MarketplaceWebServiceProductsMock is the implementation of MarketplaceWebServiceProducts based
 * on the pre-populated set of XML files that serve local data. It simulates
 * responses from Marketplace Web Service Products service.
 *
 * Use this to test your application without making a call to Marketplace Web Service Products 
 *
 * Note, current Mock Service implementation does not valiadate requests
 *
 */
public  class MarketplaceWebServiceProductsMock implements MarketplaceWebServiceProducts {

    private final Log log = LogFactory.getLog(MarketplaceWebServiceProductsMock.class);
    private static JAXBContext  jaxbContext;
    private static ThreadLocal<Unmarshaller> unmarshaller;


    /** Initialize JAXBContext and  Unmarshaller **/
    static {
        try {
            jaxbContext = JAXBContext.newInstance("API.amazon.mws.products.model", MarketplaceWebServiceProducts.class.getClassLoader());
        } catch (JAXBException ex) {
            throw new ExceptionInInitializerError(ex);
        }
        unmarshaller = new ThreadLocal<Unmarshaller>() {
            protected synchronized Unmarshaller initialValue() {
                try {
                    return jaxbContext.createUnmarshaller();
                } catch(JAXBException e) {
                    throw new ExceptionInInitializerError(e);
                }
            }
        };
    }

    // Public API ------------------------------------------------------------//

        
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
    public GetMatchingProductResponse getMatchingProduct(GetMatchingProductRequest request)
        throws MarketplaceWebServiceProductsException {
        GetMatchingProductResponse response;
        try {
            response = (GetMatchingProductResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("GetMatchingProductResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new MarketplaceWebServiceProductsException("Unable to process mock response", jbe);
        }
        return response;
    }

        
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
    public GetLowestOfferListingsForASINResponse getLowestOfferListingsForASIN(GetLowestOfferListingsForASINRequest request)
        throws MarketplaceWebServiceProductsException {
        GetLowestOfferListingsForASINResponse response;
        try {
            response = (GetLowestOfferListingsForASINResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("GetLowestOfferListingsForASINResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new MarketplaceWebServiceProductsException("Unable to process mock response", jbe);
        }
        return response;
    }

        
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
    public GetServiceStatusResponse getServiceStatus(GetServiceStatusRequest request)
        throws MarketplaceWebServiceProductsException {
        GetServiceStatusResponse response;
        try {
            response = (GetServiceStatusResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("GetServiceStatusResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new MarketplaceWebServiceProductsException("Unable to process mock response", jbe);
        }
        return response;
    }

        
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
    public GetMatchingProductForIdResponse getMatchingProductForId(GetMatchingProductForIdRequest request)
        throws MarketplaceWebServiceProductsException {
        GetMatchingProductForIdResponse response;
        try {
            response = (GetMatchingProductForIdResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("GetMatchingProductForIdResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new MarketplaceWebServiceProductsException("Unable to process mock response", jbe);
        }
        return response;
    }

        
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
    public GetMyPriceForSKUResponse getMyPriceForSKU(GetMyPriceForSKURequest request)
        throws MarketplaceWebServiceProductsException {
        GetMyPriceForSKUResponse response;
        try {
            response = (GetMyPriceForSKUResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("GetMyPriceForSKUResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new MarketplaceWebServiceProductsException("Unable to process mock response", jbe);
        }
        return response;
    }

        
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
    public ListMatchingProductsResponse listMatchingProducts(ListMatchingProductsRequest request)
        throws MarketplaceWebServiceProductsException {
        ListMatchingProductsResponse response;
        try {
            response = (ListMatchingProductsResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("ListMatchingProductsResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new MarketplaceWebServiceProductsException("Unable to process mock response", jbe);
        }
        return response;
    }

        
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
    public GetCompetitivePricingForSKUResponse getCompetitivePricingForSKU(GetCompetitivePricingForSKURequest request)
        throws MarketplaceWebServiceProductsException {
        GetCompetitivePricingForSKUResponse response;
        try {
            response = (GetCompetitivePricingForSKUResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("GetCompetitivePricingForSKUResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new MarketplaceWebServiceProductsException("Unable to process mock response", jbe);
        }
        return response;
    }

        
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
    public GetCompetitivePricingForASINResponse getCompetitivePricingForASIN(GetCompetitivePricingForASINRequest request)
        throws MarketplaceWebServiceProductsException {
        GetCompetitivePricingForASINResponse response;
        try {
            response = (GetCompetitivePricingForASINResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("GetCompetitivePricingForASINResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new MarketplaceWebServiceProductsException("Unable to process mock response", jbe);
        }
        return response;
    }

        
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
    public GetProductCategoriesForSKUResponse getProductCategoriesForSKU(GetProductCategoriesForSKURequest request)
        throws MarketplaceWebServiceProductsException {
        GetProductCategoriesForSKUResponse response;
        try {
            response = (GetProductCategoriesForSKUResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("GetProductCategoriesForSKUResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new MarketplaceWebServiceProductsException("Unable to process mock response", jbe);
        }
        return response;
    }

        
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
    public GetMyPriceForASINResponse getMyPriceForASIN(GetMyPriceForASINRequest request)
        throws MarketplaceWebServiceProductsException {
        GetMyPriceForASINResponse response;
        try {
            response = (GetMyPriceForASINResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("GetMyPriceForASINResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new MarketplaceWebServiceProductsException("Unable to process mock response", jbe);
        }
        return response;
    }

        
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
    public GetLowestOfferListingsForSKUResponse getLowestOfferListingsForSKU(GetLowestOfferListingsForSKURequest request)
        throws MarketplaceWebServiceProductsException {
        GetLowestOfferListingsForSKUResponse response;
        try {
            response = (GetLowestOfferListingsForSKUResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("GetLowestOfferListingsForSKUResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new MarketplaceWebServiceProductsException("Unable to process mock response", jbe);
        }
        return response;
    }

        
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
    public GetProductCategoriesForASINResponse getProductCategoriesForASIN(GetProductCategoriesForASINRequest request)
        throws MarketplaceWebServiceProductsException {
        GetProductCategoriesForASINResponse response;
        try {
            response = (GetProductCategoriesForASINResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("GetProductCategoriesForASINResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new MarketplaceWebServiceProductsException("Unable to process mock response", jbe);
        }
        return response;
    }


    /**
     * Get unmarshaller for current thread
     */
    private Unmarshaller getUnmarshaller() {
        return unmarshaller.get();
    }
}