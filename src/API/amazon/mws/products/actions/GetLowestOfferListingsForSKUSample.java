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

/**
 *
 * Get Lowest Offer Listings For SKU  Samples
 *
 *
 */
public class GetLowestOfferListingsForSKUSample {

    /**
     * Just add few required parameters, and try the service
     * Get Lowest Offer Listings For SKU functionality
     *
     * @param args unused
     */
    public static void main(String... args) {
        
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
         * sample for Get Lowest Offer Listings For SKU 
         ***********************************************************************/
         GetLowestOfferListingsForSKURequest request = new GetLowestOfferListingsForSKURequest();
         request.setSellerId(ProductsConfig.SELLER_ID);
        
         // @TODO: set request parameters here

         invokeGetLowestOfferListingsForSKU(service, request);

    }


                                                                
    /**
     * Get Lowest Offer Listings For SKU  request sample
     * Gets some of the lowest prices based on the product identified by the given
     * SellerId and SKU.
     *   
     * @param service instance of MarketplaceWebServiceProducts service
     * @param request Action to invoke
     */
    public static void invokeGetLowestOfferListingsForSKU(MarketplaceWebServiceProducts service, GetLowestOfferListingsForSKURequest request) {
        try {
            
            GetLowestOfferListingsForSKUResponse response = service.getLowestOfferListingsForSKU(request);

            
            System.out.println ("GetLowestOfferListingsForSKU Action Response");
            System.out.println ("=============================================================================");
            System.out.println ();

            System.out.println("    GetLowestOfferListingsForSKUResponse");
            System.out.println();
            java.util.List<GetLowestOfferListingsForSKUResult> getLowestOfferListingsForSKUResultList = response.getGetLowestOfferListingsForSKUResult();
            for (GetLowestOfferListingsForSKUResult getLowestOfferListingsForSKUResult : getLowestOfferListingsForSKUResultList) {
                System.out.println("        GetLowestOfferListingsForSKUResult");
                System.out.println();
            if (getLowestOfferListingsForSKUResult.isSetSellerSKU()) {
                System.out.println("        SellerSKU");
                System.out.println();
                System.out.println("            " + getLowestOfferListingsForSKUResult.getSellerSKU());
                System.out.println();
            } 
            if (getLowestOfferListingsForSKUResult.isSetStatus()) {
                System.out.println("        status");
                System.out.println();
                System.out.println("            " + getLowestOfferListingsForSKUResult.getStatus());
                System.out.println();
            } 
                if (getLowestOfferListingsForSKUResult.isSetAllOfferListingsConsidered()) {
                    System.out.println("            AllOfferListingsConsidered");
                    System.out.println();
                    System.out.println("                " + getLowestOfferListingsForSKUResult.isAllOfferListingsConsidered());
                    System.out.println();
                }
                if (getLowestOfferListingsForSKUResult.isSetProduct()) {
                    System.out.println("            Product");
                    System.out.println();
                    Product  product = getLowestOfferListingsForSKUResult.getProduct();
                    if (product.isSetIdentifiers()) {
                        System.out.println("                Identifiers");
                        System.out.println();
                        IdentifierType  identifiers = product.getIdentifiers();
                        if (identifiers.isSetMarketplaceASIN()) {
                            System.out.println("                    MarketplaceASIN");
                            System.out.println();
                            ASINIdentifier  marketplaceASIN = identifiers.getMarketplaceASIN();
                            if (marketplaceASIN.isSetMarketplaceId()) {
                                System.out.println("                        MarketplaceId");
                                System.out.println();
                                System.out.println("                            " + marketplaceASIN.getMarketplaceId());
                                System.out.println();
                            }
                            if (marketplaceASIN.isSetASIN()) {
                                System.out.println("                        ASIN");
                                System.out.println();
                                System.out.println("                            " + marketplaceASIN.getASIN());
                                System.out.println();
                            }
                        } 
                        if (identifiers.isSetSKUIdentifier()) {
                            System.out.println("                    SKUIdentifier");
                            System.out.println();
                            SellerSKUIdentifier  SKUIdentifier = identifiers.getSKUIdentifier();
                            if (SKUIdentifier.isSetMarketplaceId()) {
                                System.out.println("                        MarketplaceId");
                                System.out.println();
                                System.out.println("                            " + SKUIdentifier.getMarketplaceId());
                                System.out.println();
                            }
                            if (SKUIdentifier.isSetSellerId()) {
                                System.out.println("                        SellerId");
                                System.out.println();
                                System.out.println("                            " + SKUIdentifier.getSellerId());
                                System.out.println();
                            }
                            if (SKUIdentifier.isSetSellerSKU()) {
                                System.out.println("                        SellerSKU");
                                System.out.println();
                                System.out.println("                            " + SKUIdentifier.getSellerSKU());
                                System.out.println();
                            }
                        } 
                    } 
                    if (product.isSetCompetitivePricing()) {
                        System.out.println("                CompetitivePricing");
                        System.out.println();
                        CompetitivePricingType  competitivePricing = product.getCompetitivePricing();
                        if (competitivePricing.isSetCompetitivePrices()) {
                            System.out.println("                    CompetitivePrices");
                            System.out.println();
                            CompetitivePriceList  competitivePrices = competitivePricing.getCompetitivePrices();
                            java.util.List<CompetitivePriceType> competitivePriceList = competitivePrices.getCompetitivePrice();
                            for (CompetitivePriceType competitivePrice : competitivePriceList) {
                                System.out.println("                        CompetitivePrice");
                                System.out.println();
                            if (competitivePrice.isSetCondition()) {
                                System.out.println("                        condition");
                                System.out.println();
                                System.out.println("                            " + competitivePrice.getCondition());
                                System.out.println();
                            } 
                            if (competitivePrice.isSetSubcondition()) {
                                System.out.println("                        subcondition");
                                System.out.println();
                                System.out.println("                            " + competitivePrice.getSubcondition());
                                System.out.println();
                            } 
                            if (competitivePrice.isSetBelongsToRequester()) {
                                System.out.println("                        belongsToRequester");
                                System.out.println();
                                System.out.println("                            " + competitivePrice.isBelongsToRequester());
                                System.out.println();
                            } 
                                if (competitivePrice.isSetCompetitivePriceId()) {
                                    System.out.println("                            CompetitivePriceId");
                                    System.out.println();
                                    System.out.println("                                " + competitivePrice.getCompetitivePriceId());
                                    System.out.println();
                                }
                                if (competitivePrice.isSetPrice()) {
                                    System.out.println("                            Price");
                                    System.out.println();
                                    PriceType  price = competitivePrice.getPrice();
                                    if (price.isSetLandedPrice()) {
                                        System.out.println("                                LandedPrice");
                                        System.out.println();
                                        MoneyType  landedPrice = price.getLandedPrice();
                                        if (landedPrice.isSetCurrencyCode()) {
                                            System.out.println("                                    CurrencyCode");
                                            System.out.println();
                                            System.out.println("                                        " + landedPrice.getCurrencyCode());
                                            System.out.println();
                                        }
                                        if (landedPrice.isSetAmount()) {
                                            System.out.println("                                    Amount");
                                            System.out.println();
                                            System.out.println("                                        " + landedPrice.getAmount());
                                            System.out.println();
                                        }
                                    } 
                                    if (price.isSetListingPrice()) {
                                        System.out.println("                                ListingPrice");
                                        System.out.println();
                                        MoneyType  listingPrice = price.getListingPrice();
                                        if (listingPrice.isSetCurrencyCode()) {
                                            System.out.println("                                    CurrencyCode");
                                            System.out.println();
                                            System.out.println("                                        " + listingPrice.getCurrencyCode());
                                            System.out.println();
                                        }
                                        if (listingPrice.isSetAmount()) {
                                            System.out.println("                                    Amount");
                                            System.out.println();
                                            System.out.println("                                        " + listingPrice.getAmount());
                                            System.out.println();
                                        }
                                    } 
                                    if (price.isSetShipping()) {
                                        System.out.println("                                Shipping");
                                        System.out.println();
                                        MoneyType  shipping = price.getShipping();
                                        if (shipping.isSetCurrencyCode()) {
                                            System.out.println("                                    CurrencyCode");
                                            System.out.println();
                                            System.out.println("                                        " + shipping.getCurrencyCode());
                                            System.out.println();
                                        }
                                        if (shipping.isSetAmount()) {
                                            System.out.println("                                    Amount");
                                            System.out.println();
                                            System.out.println("                                        " + shipping.getAmount());
                                            System.out.println();
                                        }
                                    } 
                                } 
                            }
                        } 
                        if (competitivePricing.isSetNumberOfOfferListings()) {
                            System.out.println("                    NumberOfOfferListings");
                            System.out.println();
                            NumberOfOfferListingsList  numberOfOfferListings = competitivePricing.getNumberOfOfferListings();
                            java.util.List<OfferListingCountType> offerListingCountList = numberOfOfferListings.getOfferListingCount();
                            for (OfferListingCountType offerListingCount : offerListingCountList) {
                                System.out.println("                        OfferListingCount");
                                System.out.println();
                            if (offerListingCount.isSetCondition()) {
                                System.out.println("                        condition");
                                System.out.println();
                                System.out.println("                            " + offerListingCount.getCondition());
                                System.out.println();
                            } 
                            if (offerListingCount.isSetValue()) {
                                System.out.println("                        Value");
                                System.out.println();
                                System.out.println("                            " + offerListingCount.getValue());
                            } 
                            }
                        } 
                        if (competitivePricing.isSetTradeInValue()) {
                            System.out.println("                    TradeInValue");
                            System.out.println();
                            MoneyType  tradeInValue = competitivePricing.getTradeInValue();
                            if (tradeInValue.isSetCurrencyCode()) {
                                System.out.println("                        CurrencyCode");
                                System.out.println();
                                System.out.println("                            " + tradeInValue.getCurrencyCode());
                                System.out.println();
                            }
                            if (tradeInValue.isSetAmount()) {
                                System.out.println("                        Amount");
                                System.out.println();
                                System.out.println("                            " + tradeInValue.getAmount());
                                System.out.println();
                            }
                        } 
                    } 
                    if (product.isSetSalesRankings()) {
                        System.out.println("                SalesRankings");
                        System.out.println();
                        SalesRankList  salesRankings = product.getSalesRankings();
                        java.util.List<SalesRankType> salesRankList = salesRankings.getSalesRank();
                        for (SalesRankType salesRank : salesRankList) {
                            System.out.println("                    SalesRank");
                            System.out.println();
                            if (salesRank.isSetProductCategoryId()) {
                                System.out.println("                        ProductCategoryId");
                                System.out.println();
                                System.out.println("                            " + salesRank.getProductCategoryId());
                                System.out.println();
                            }
                            if (salesRank.isSetRank()) {
                                System.out.println("                        Rank");
                                System.out.println();
                                System.out.println("                            " + salesRank.getRank());
                                System.out.println();
                            }
                        }
                    } 
                    if (product.isSetLowestOfferListings()) {
                        System.out.println("                LowestOfferListings");
                        System.out.println();
                        LowestOfferListingList  lowestOfferListings = product.getLowestOfferListings();
                        java.util.List<LowestOfferListingType> lowestOfferListingList = lowestOfferListings.getLowestOfferListing();
                        for (LowestOfferListingType lowestOfferListing : lowestOfferListingList) {
                            System.out.println("                    LowestOfferListing");
                            System.out.println();
                            if (lowestOfferListing.isSetQualifiers()) {
                                System.out.println("                        Qualifiers");
                                System.out.println();
                                QualifiersType  qualifiers = lowestOfferListing.getQualifiers();
                                if (qualifiers.isSetItemCondition()) {
                                    System.out.println("                            ItemCondition");
                                    System.out.println();
                                    System.out.println("                                " + qualifiers.getItemCondition());
                                    System.out.println();
                                }
                                if (qualifiers.isSetItemSubcondition()) {
                                    System.out.println("                            ItemSubcondition");
                                    System.out.println();
                                    System.out.println("                                " + qualifiers.getItemSubcondition());
                                    System.out.println();
                                }
                                if (qualifiers.isSetFulfillmentChannel()) {
                                    System.out.println("                            FulfillmentChannel");
                                    System.out.println();
                                    System.out.println("                                " + qualifiers.getFulfillmentChannel());
                                    System.out.println();
                                }
                                if (qualifiers.isSetShipsDomestically()) {
                                    System.out.println("                            ShipsDomestically");
                                    System.out.println();
                                    System.out.println("                                " + qualifiers.getShipsDomestically());
                                    System.out.println();
                                }
                                if (qualifiers.isSetShippingTime()) {
                                    System.out.println("                            ShippingTime");
                                    System.out.println();
                                    ShippingTimeType  shippingTime = qualifiers.getShippingTime();
                                    if (shippingTime.isSetMax()) {
                                        System.out.println("                                Max");
                                        System.out.println();
                                        System.out.println("                                    " + shippingTime.getMax());
                                        System.out.println();
                                    }
                                } 
                                if (qualifiers.isSetSellerPositiveFeedbackRating()) {
                                    System.out.println("                            SellerPositiveFeedbackRating");
                                    System.out.println();
                                    System.out.println("                                " + qualifiers.getSellerPositiveFeedbackRating());
                                    System.out.println();
                                }
                            } 
                            if (lowestOfferListing.isSetNumberOfOfferListingsConsidered()) {
                                System.out.println("                        NumberOfOfferListingsConsidered");
                                System.out.println();
                                System.out.println("                            " + lowestOfferListing.getNumberOfOfferListingsConsidered());
                                System.out.println();
                            }
                            if (lowestOfferListing.isSetSellerFeedbackCount()) {
                                System.out.println("                        SellerFeedbackCount");
                                System.out.println();
                                System.out.println("                            " + lowestOfferListing.getSellerFeedbackCount());
                                System.out.println();
                            }
                            if (lowestOfferListing.isSetPrice()) {
                                System.out.println("                        Price");
                                System.out.println();
                                PriceType  price1 = lowestOfferListing.getPrice();
                                if (price1.isSetLandedPrice()) {
                                    System.out.println("                            LandedPrice");
                                    System.out.println();
                                    MoneyType  landedPrice1 = price1.getLandedPrice();
                                    if (landedPrice1.isSetCurrencyCode()) {
                                        System.out.println("                                CurrencyCode");
                                        System.out.println();
                                        System.out.println("                                    " + landedPrice1.getCurrencyCode());
                                        System.out.println();
                                    }
                                    if (landedPrice1.isSetAmount()) {
                                        System.out.println("                                Amount");
                                        System.out.println();
                                        System.out.println("                                    " + landedPrice1.getAmount());
                                        System.out.println();
                                    }
                                } 
                                if (price1.isSetListingPrice()) {
                                    System.out.println("                            ListingPrice");
                                    System.out.println();
                                    MoneyType  listingPrice1 = price1.getListingPrice();
                                    if (listingPrice1.isSetCurrencyCode()) {
                                        System.out.println("                                CurrencyCode");
                                        System.out.println();
                                        System.out.println("                                    " + listingPrice1.getCurrencyCode());
                                        System.out.println();
                                    }
                                    if (listingPrice1.isSetAmount()) {
                                        System.out.println("                                Amount");
                                        System.out.println();
                                        System.out.println("                                    " + listingPrice1.getAmount());
                                        System.out.println();
                                    }
                                } 
                                if (price1.isSetShipping()) {
                                    System.out.println("                            Shipping");
                                    System.out.println();
                                    MoneyType  shipping1 = price1.getShipping();
                                    if (shipping1.isSetCurrencyCode()) {
                                        System.out.println("                                CurrencyCode");
                                        System.out.println();
                                        System.out.println("                                    " + shipping1.getCurrencyCode());
                                        System.out.println();
                                    }
                                    if (shipping1.isSetAmount()) {
                                        System.out.println("                                Amount");
                                        System.out.println();
                                        System.out.println("                                    " + shipping1.getAmount());
                                        System.out.println();
                                    }
                                } 
                            } 
                            if (lowestOfferListing.isSetMultipleOffersAtLowestPrice()) {
                                System.out.println("                        MultipleOffersAtLowestPrice");
                                System.out.println();
                                System.out.println("                            " + lowestOfferListing.getMultipleOffersAtLowestPrice());
                                System.out.println();
                            }
                        }
                    } 
                    if (product.isSetOffers()) {
                        System.out.println("                Offers");
                        System.out.println();
                        OffersList  offers = product.getOffers();
                        java.util.List<OfferType> offerList = offers.getOffer();
                        for (OfferType offer : offerList) {
                            System.out.println("                    Offer");
                            System.out.println();
                            if (offer.isSetBuyingPrice()) {
                                System.out.println("                        BuyingPrice");
                                System.out.println();
                                PriceType  buyingPrice = offer.getBuyingPrice();
                                if (buyingPrice.isSetLandedPrice()) {
                                    System.out.println("                            LandedPrice");
                                    System.out.println();
                                    MoneyType  landedPrice2 = buyingPrice.getLandedPrice();
                                    if (landedPrice2.isSetCurrencyCode()) {
                                        System.out.println("                                CurrencyCode");
                                        System.out.println();
                                        System.out.println("                                    " + landedPrice2.getCurrencyCode());
                                        System.out.println();
                                    }
                                    if (landedPrice2.isSetAmount()) {
                                        System.out.println("                                Amount");
                                        System.out.println();
                                        System.out.println("                                    " + landedPrice2.getAmount());
                                        System.out.println();
                                    }
                                } 
                                if (buyingPrice.isSetListingPrice()) {
                                    System.out.println("                            ListingPrice");
                                    System.out.println();
                                    MoneyType  listingPrice2 = buyingPrice.getListingPrice();
                                    if (listingPrice2.isSetCurrencyCode()) {
                                        System.out.println("                                CurrencyCode");
                                        System.out.println();
                                        System.out.println("                                    " + listingPrice2.getCurrencyCode());
                                        System.out.println();
                                    }
                                    if (listingPrice2.isSetAmount()) {
                                        System.out.println("                                Amount");
                                        System.out.println();
                                        System.out.println("                                    " + listingPrice2.getAmount());
                                        System.out.println();
                                    }
                                } 
                                if (buyingPrice.isSetShipping()) {
                                    System.out.println("                            Shipping");
                                    System.out.println();
                                    MoneyType  shipping2 = buyingPrice.getShipping();
                                    if (shipping2.isSetCurrencyCode()) {
                                        System.out.println("                                CurrencyCode");
                                        System.out.println();
                                        System.out.println("                                    " + shipping2.getCurrencyCode());
                                        System.out.println();
                                    }
                                    if (shipping2.isSetAmount()) {
                                        System.out.println("                                Amount");
                                        System.out.println();
                                        System.out.println("                                    " + shipping2.getAmount());
                                        System.out.println();
                                    }
                                } 
                            } 
                            if (offer.isSetRegularPrice()) {
                                System.out.println("                        RegularPrice");
                                System.out.println();
                                MoneyType  regularPrice = offer.getRegularPrice();
                                if (regularPrice.isSetCurrencyCode()) {
                                    System.out.println("                            CurrencyCode");
                                    System.out.println();
                                    System.out.println("                                " + regularPrice.getCurrencyCode());
                                    System.out.println();
                                }
                                if (regularPrice.isSetAmount()) {
                                    System.out.println("                            Amount");
                                    System.out.println();
                                    System.out.println("                                " + regularPrice.getAmount());
                                    System.out.println();
                                }
                            } 
                            if (offer.isSetFulfillmentChannel()) {
                                System.out.println("                        FulfillmentChannel");
                                System.out.println();
                                System.out.println("                            " + offer.getFulfillmentChannel());
                                System.out.println();
                            }
                            if (offer.isSetItemCondition()) {
                                System.out.println("                        ItemCondition");
                                System.out.println();
                                System.out.println("                            " + offer.getItemCondition());
                                System.out.println();
                            }
                            if (offer.isSetItemSubCondition()) {
                                System.out.println("                        ItemSubCondition");
                                System.out.println();
                                System.out.println("                            " + offer.getItemSubCondition());
                                System.out.println();
                            }
                            if (offer.isSetSellerId()) {
                                System.out.println("                        SellerId");
                                System.out.println();
                                System.out.println("                            " + offer.getSellerId());
                                System.out.println();
                            }
                            if (offer.isSetSellerSKU()) {
                                System.out.println("                        SellerSKU");
                                System.out.println();
                                System.out.println("                            " + offer.getSellerSKU());
                                System.out.println();
                            }
                        }
                    } 
                } 
                if (getLowestOfferListingsForSKUResult.isSetError()) {
                    System.out.println("            Error");
                    System.out.println();
                    API.amazon.mws.products.model.Error  error = getLowestOfferListingsForSKUResult.getError();
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

           
        } catch (MarketplaceWebServiceProductsException ex) {
            
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
