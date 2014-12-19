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
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;


/**
 * This is the Products API section of the Marketplace Web Service.
 * 
 *
 */
public class MarketplaceWebServiceProductsAsyncClient extends MarketplaceWebServiceProductsClient implements MarketplaceWebServiceProductsAsync {

    private ExecutorService executor;

    /**
     * Client to make asynchronous calls to the service. Please note, you should
     * configure executor with same number of concurrent threads as number of
     * http connections specified in MarketplaceWebServiceProductsConfig. Default number of
     * max http connections is 100.
     *
     * @param awsAccessKeyId AWS Access Key Id
     * @param awsSecretAccessKey AWS Secret Key
     * @param applicationName  Application Name
     * @param applicationVersion Application Version
     * @param config service configuration. Pass new MarketplaceWebServiceProductsConfig() if you
     * plan to use defaults
     *
     * @param executor Executor service to manage asynchronous calls.
     *
     */
    public MarketplaceWebServiceProductsAsyncClient(String awsAccessKeyId, String awsSecretAccessKey,
            String applicationName, String applicationVersion,             
            MarketplaceWebServiceProductsConfig config, ExecutorService executor) {
        super(awsAccessKeyId, awsSecretAccessKey, applicationName, applicationVersion, config);
        this.executor = executor;
    }

            

    /**
     * Non-blocking Get Matching Product 
     * <p/>
     * Returns <code>future</code> pointer to GetMatchingProductResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return GetMatchingProductResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, MarketplaceWebServiceProductsException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;GetMatchingProductResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;GetMatchingProductResponse&gt;&gt;();
     *  for (GetMatchingProductRequest request : requests) {
     *      responses.add(client.getMatchingProductAsync(request));
     *  }
     *  for (Future&lt;GetMatchingProductResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          GetMatchingProductResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof MarketplaceWebServiceProductsException) {
     *              MarketplaceWebServiceProductsException exception = MarketplaceWebServiceProductsException.class.cast(e);
     *          // handle MarketplaceWebServiceProductsException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          GetMatchingProductRequest request
     * @return Future&lt;GetMatchingProductResponse&gt; future pointer to GetMatchingProductResponse
     * 
     */
    public Future<GetMatchingProductResponse> getMatchingProductAsync(final GetMatchingProductRequest request) {
        Future<GetMatchingProductResponse> response = executor.submit(new Callable<GetMatchingProductResponse>() {

            public GetMatchingProductResponse call() throws MarketplaceWebServiceProductsException {
                return getMatchingProduct(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Get Lowest Offer Listings For ASIN 
     * <p/>
     * Returns <code>future</code> pointer to GetLowestOfferListingsForASINResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return GetLowestOfferListingsForASINResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, MarketplaceWebServiceProductsException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;GetLowestOfferListingsForASINResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;GetLowestOfferListingsForASINResponse&gt;&gt;();
     *  for (GetLowestOfferListingsForASINRequest request : requests) {
     *      responses.add(client.getLowestOfferListingsForASINAsync(request));
     *  }
     *  for (Future&lt;GetLowestOfferListingsForASINResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          GetLowestOfferListingsForASINResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof MarketplaceWebServiceProductsException) {
     *              MarketplaceWebServiceProductsException exception = MarketplaceWebServiceProductsException.class.cast(e);
     *          // handle MarketplaceWebServiceProductsException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          GetLowestOfferListingsForASINRequest request
     * @return Future&lt;GetLowestOfferListingsForASINResponse&gt; future pointer to GetLowestOfferListingsForASINResponse
     * 
     */
    public Future<GetLowestOfferListingsForASINResponse> getLowestOfferListingsForASINAsync(final GetLowestOfferListingsForASINRequest request) {
        Future<GetLowestOfferListingsForASINResponse> response = executor.submit(new Callable<GetLowestOfferListingsForASINResponse>() {

            public GetLowestOfferListingsForASINResponse call() throws MarketplaceWebServiceProductsException {
                return getLowestOfferListingsForASIN(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Get Service Status 
     * <p/>
     * Returns <code>future</code> pointer to GetServiceStatusResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return GetServiceStatusResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, MarketplaceWebServiceProductsException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;GetServiceStatusResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;GetServiceStatusResponse&gt;&gt;();
     *  for (GetServiceStatusRequest request : requests) {
     *      responses.add(client.getServiceStatusAsync(request));
     *  }
     *  for (Future&lt;GetServiceStatusResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          GetServiceStatusResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof MarketplaceWebServiceProductsException) {
     *              MarketplaceWebServiceProductsException exception = MarketplaceWebServiceProductsException.class.cast(e);
     *          // handle MarketplaceWebServiceProductsException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          GetServiceStatusRequest request
     * @return Future&lt;GetServiceStatusResponse&gt; future pointer to GetServiceStatusResponse
     * 
     */
    public Future<GetServiceStatusResponse> getServiceStatusAsync(final GetServiceStatusRequest request) {
        Future<GetServiceStatusResponse> response = executor.submit(new Callable<GetServiceStatusResponse>() {

            public GetServiceStatusResponse call() throws MarketplaceWebServiceProductsException {
                return getServiceStatus(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Get Matching Product For Id 
     * <p/>
     * Returns <code>future</code> pointer to GetMatchingProductForIdResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return GetMatchingProductForIdResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, MarketplaceWebServiceProductsException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;GetMatchingProductForIdResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;GetMatchingProductForIdResponse&gt;&gt;();
     *  for (GetMatchingProductForIdRequest request : requests) {
     *      responses.add(client.getMatchingProductForIdAsync(request));
     *  }
     *  for (Future&lt;GetMatchingProductForIdResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          GetMatchingProductForIdResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof MarketplaceWebServiceProductsException) {
     *              MarketplaceWebServiceProductsException exception = MarketplaceWebServiceProductsException.class.cast(e);
     *          // handle MarketplaceWebServiceProductsException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          GetMatchingProductForIdRequest request
     * @return Future&lt;GetMatchingProductForIdResponse&gt; future pointer to GetMatchingProductForIdResponse
     * 
     */
    public Future<GetMatchingProductForIdResponse> getMatchingProductForIdAsync(final GetMatchingProductForIdRequest request) {
        Future<GetMatchingProductForIdResponse> response = executor.submit(new Callable<GetMatchingProductForIdResponse>() {

            public GetMatchingProductForIdResponse call() throws MarketplaceWebServiceProductsException {
                return getMatchingProductForId(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Get My Price For SKU 
     * <p/>
     * Returns <code>future</code> pointer to GetMyPriceForSKUResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return GetMyPriceForSKUResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, MarketplaceWebServiceProductsException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;GetMyPriceForSKUResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;GetMyPriceForSKUResponse&gt;&gt;();
     *  for (GetMyPriceForSKURequest request : requests) {
     *      responses.add(client.getMyPriceForSKUAsync(request));
     *  }
     *  for (Future&lt;GetMyPriceForSKUResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          GetMyPriceForSKUResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof MarketplaceWebServiceProductsException) {
     *              MarketplaceWebServiceProductsException exception = MarketplaceWebServiceProductsException.class.cast(e);
     *          // handle MarketplaceWebServiceProductsException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          GetMyPriceForSKURequest request
     * @return Future&lt;GetMyPriceForSKUResponse&gt; future pointer to GetMyPriceForSKUResponse
     * 
     */
    public Future<GetMyPriceForSKUResponse> getMyPriceForSKUAsync(final GetMyPriceForSKURequest request) {
        Future<GetMyPriceForSKUResponse> response = executor.submit(new Callable<GetMyPriceForSKUResponse>() {

            public GetMyPriceForSKUResponse call() throws MarketplaceWebServiceProductsException {
                return getMyPriceForSKU(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking List Matching Products 
     * <p/>
     * Returns <code>future</code> pointer to ListMatchingProductsResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return ListMatchingProductsResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, MarketplaceWebServiceProductsException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;ListMatchingProductsResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;ListMatchingProductsResponse&gt;&gt;();
     *  for (ListMatchingProductsRequest request : requests) {
     *      responses.add(client.listMatchingProductsAsync(request));
     *  }
     *  for (Future&lt;ListMatchingProductsResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          ListMatchingProductsResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof MarketplaceWebServiceProductsException) {
     *              MarketplaceWebServiceProductsException exception = MarketplaceWebServiceProductsException.class.cast(e);
     *          // handle MarketplaceWebServiceProductsException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          ListMatchingProductsRequest request
     * @return Future&lt;ListMatchingProductsResponse&gt; future pointer to ListMatchingProductsResponse
     * 
     */
    public Future<ListMatchingProductsResponse> listMatchingProductsAsync(final ListMatchingProductsRequest request) {
        Future<ListMatchingProductsResponse> response = executor.submit(new Callable<ListMatchingProductsResponse>() {

            public ListMatchingProductsResponse call() throws MarketplaceWebServiceProductsException {
                return listMatchingProducts(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Get Competitive Pricing For SKU 
     * <p/>
     * Returns <code>future</code> pointer to GetCompetitivePricingForSKUResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return GetCompetitivePricingForSKUResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, MarketplaceWebServiceProductsException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;GetCompetitivePricingForSKUResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;GetCompetitivePricingForSKUResponse&gt;&gt;();
     *  for (GetCompetitivePricingForSKURequest request : requests) {
     *      responses.add(client.getCompetitivePricingForSKUAsync(request));
     *  }
     *  for (Future&lt;GetCompetitivePricingForSKUResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          GetCompetitivePricingForSKUResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof MarketplaceWebServiceProductsException) {
     *              MarketplaceWebServiceProductsException exception = MarketplaceWebServiceProductsException.class.cast(e);
     *          // handle MarketplaceWebServiceProductsException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          GetCompetitivePricingForSKURequest request
     * @return Future&lt;GetCompetitivePricingForSKUResponse&gt; future pointer to GetCompetitivePricingForSKUResponse
     * 
     */
    public Future<GetCompetitivePricingForSKUResponse> getCompetitivePricingForSKUAsync(final GetCompetitivePricingForSKURequest request) {
        Future<GetCompetitivePricingForSKUResponse> response = executor.submit(new Callable<GetCompetitivePricingForSKUResponse>() {

            public GetCompetitivePricingForSKUResponse call() throws MarketplaceWebServiceProductsException {
                return getCompetitivePricingForSKU(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Get Competitive Pricing For ASIN 
     * <p/>
     * Returns <code>future</code> pointer to GetCompetitivePricingForASINResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return GetCompetitivePricingForASINResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, MarketplaceWebServiceProductsException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;GetCompetitivePricingForASINResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;GetCompetitivePricingForASINResponse&gt;&gt;();
     *  for (GetCompetitivePricingForASINRequest request : requests) {
     *      responses.add(client.getCompetitivePricingForASINAsync(request));
     *  }
     *  for (Future&lt;GetCompetitivePricingForASINResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          GetCompetitivePricingForASINResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof MarketplaceWebServiceProductsException) {
     *              MarketplaceWebServiceProductsException exception = MarketplaceWebServiceProductsException.class.cast(e);
     *          // handle MarketplaceWebServiceProductsException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          GetCompetitivePricingForASINRequest request
     * @return Future&lt;GetCompetitivePricingForASINResponse&gt; future pointer to GetCompetitivePricingForASINResponse
     * 
     */
    public Future<GetCompetitivePricingForASINResponse> getCompetitivePricingForASINAsync(final GetCompetitivePricingForASINRequest request) {
        Future<GetCompetitivePricingForASINResponse> response = executor.submit(new Callable<GetCompetitivePricingForASINResponse>() {

            public GetCompetitivePricingForASINResponse call() throws MarketplaceWebServiceProductsException {
                return getCompetitivePricingForASIN(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Get Product Categories For SKU 
     * <p/>
     * Returns <code>future</code> pointer to GetProductCategoriesForSKUResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return GetProductCategoriesForSKUResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, MarketplaceWebServiceProductsException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;GetProductCategoriesForSKUResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;GetProductCategoriesForSKUResponse&gt;&gt;();
     *  for (GetProductCategoriesForSKURequest request : requests) {
     *      responses.add(client.getProductCategoriesForSKUAsync(request));
     *  }
     *  for (Future&lt;GetProductCategoriesForSKUResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          GetProductCategoriesForSKUResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof MarketplaceWebServiceProductsException) {
     *              MarketplaceWebServiceProductsException exception = MarketplaceWebServiceProductsException.class.cast(e);
     *          // handle MarketplaceWebServiceProductsException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          GetProductCategoriesForSKURequest request
     * @return Future&lt;GetProductCategoriesForSKUResponse&gt; future pointer to GetProductCategoriesForSKUResponse
     * 
     */
    public Future<GetProductCategoriesForSKUResponse> getProductCategoriesForSKUAsync(final GetProductCategoriesForSKURequest request) {
        Future<GetProductCategoriesForSKUResponse> response = executor.submit(new Callable<GetProductCategoriesForSKUResponse>() {

            public GetProductCategoriesForSKUResponse call() throws MarketplaceWebServiceProductsException {
                return getProductCategoriesForSKU(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Get My Price For ASIN 
     * <p/>
     * Returns <code>future</code> pointer to GetMyPriceForASINResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return GetMyPriceForASINResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, MarketplaceWebServiceProductsException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;GetMyPriceForASINResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;GetMyPriceForASINResponse&gt;&gt;();
     *  for (GetMyPriceForASINRequest request : requests) {
     *      responses.add(client.getMyPriceForASINAsync(request));
     *  }
     *  for (Future&lt;GetMyPriceForASINResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          GetMyPriceForASINResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof MarketplaceWebServiceProductsException) {
     *              MarketplaceWebServiceProductsException exception = MarketplaceWebServiceProductsException.class.cast(e);
     *          // handle MarketplaceWebServiceProductsException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          GetMyPriceForASINRequest request
     * @return Future&lt;GetMyPriceForASINResponse&gt; future pointer to GetMyPriceForASINResponse
     * 
     */
    public Future<GetMyPriceForASINResponse> getMyPriceForASINAsync(final GetMyPriceForASINRequest request) {
        Future<GetMyPriceForASINResponse> response = executor.submit(new Callable<GetMyPriceForASINResponse>() {

            public GetMyPriceForASINResponse call() throws MarketplaceWebServiceProductsException {
                return getMyPriceForASIN(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Get Lowest Offer Listings For SKU 
     * <p/>
     * Returns <code>future</code> pointer to GetLowestOfferListingsForSKUResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return GetLowestOfferListingsForSKUResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, MarketplaceWebServiceProductsException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;GetLowestOfferListingsForSKUResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;GetLowestOfferListingsForSKUResponse&gt;&gt;();
     *  for (GetLowestOfferListingsForSKURequest request : requests) {
     *      responses.add(client.getLowestOfferListingsForSKUAsync(request));
     *  }
     *  for (Future&lt;GetLowestOfferListingsForSKUResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          GetLowestOfferListingsForSKUResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof MarketplaceWebServiceProductsException) {
     *              MarketplaceWebServiceProductsException exception = MarketplaceWebServiceProductsException.class.cast(e);
     *          // handle MarketplaceWebServiceProductsException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          GetLowestOfferListingsForSKURequest request
     * @return Future&lt;GetLowestOfferListingsForSKUResponse&gt; future pointer to GetLowestOfferListingsForSKUResponse
     * 
     */
    public Future<GetLowestOfferListingsForSKUResponse> getLowestOfferListingsForSKUAsync(final GetLowestOfferListingsForSKURequest request) {
        Future<GetLowestOfferListingsForSKUResponse> response = executor.submit(new Callable<GetLowestOfferListingsForSKUResponse>() {

            public GetLowestOfferListingsForSKUResponse call() throws MarketplaceWebServiceProductsException {
                return getLowestOfferListingsForSKU(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Get Product Categories For ASIN 
     * <p/>
     * Returns <code>future</code> pointer to GetProductCategoriesForASINResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return GetProductCategoriesForASINResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, MarketplaceWebServiceProductsException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;GetProductCategoriesForASINResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;GetProductCategoriesForASINResponse&gt;&gt;();
     *  for (GetProductCategoriesForASINRequest request : requests) {
     *      responses.add(client.getProductCategoriesForASINAsync(request));
     *  }
     *  for (Future&lt;GetProductCategoriesForASINResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          GetProductCategoriesForASINResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof MarketplaceWebServiceProductsException) {
     *              MarketplaceWebServiceProductsException exception = MarketplaceWebServiceProductsException.class.cast(e);
     *          // handle MarketplaceWebServiceProductsException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          GetProductCategoriesForASINRequest request
     * @return Future&lt;GetProductCategoriesForASINResponse&gt; future pointer to GetProductCategoriesForASINResponse
     * 
     */
    public Future<GetProductCategoriesForASINResponse> getProductCategoriesForASINAsync(final GetProductCategoriesForASINRequest request) {
        Future<GetProductCategoriesForASINResponse> response = executor.submit(new Callable<GetProductCategoriesForASINResponse>() {

            public GetProductCategoriesForASINResponse call() throws MarketplaceWebServiceProductsException {
                return getProductCategoriesForASIN(request);
            }
        });
        return response;
    }


}
