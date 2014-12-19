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
import API.amazon.mws.orders.model.GetServiceStatusRequest;
import API.amazon.mws.orders.model.ListOrdersResponse;
import API.amazon.mws.orders.model.OrderStatusEnum;
import API.amazon.mws.orders.model.MarketplaceIdList;
import API.amazon.mws.orders.model.PaymentMethodList;
import API.amazon.mws.orders.model.FulfillmentChannelEnum;
import API.amazon.mws.orders.model.ListOrderItemsResponse;
import API.amazon.mws.orders.model.ListOrdersByNextTokenResponse;
import API.amazon.mws.orders.model.ErrorResponse;
import API.amazon.mws.orders.model.OrderIdList;
import API.amazon.mws.orders.model.FulfillmentChannelList;
import API.amazon.mws.orders.model.PaymentMethodEnum;
import API.amazon.mws.orders.model.ListOrderItemsRequest;
import API.amazon.mws.orders.model.OrderStatusList;
import API.amazon.mws.orders.model.ListOrderItemsByNextTokenRequest;
import API.amazon.mws.orders.model.ListOrderItemsByNextTokenResponse;
import API.amazon.mws.orders.model.TFMShipmentStatusList;
import API.amazon.mws.orders.model.GetServiceStatusResponse;
import API.amazon.mws.orders.model.GetOrderResponse;
import API.amazon.mws.orders.model.ListOrdersByNextTokenRequest;
import API.amazon.mws.orders.model.ResponseHeaderMetadata;
import API.amazon.mws.orders.model.GetOrderRequest;

import java.lang.reflect.Method;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SignatureException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.protocol.HTTP;
import org.apache.http.NameValuePair;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.HttpHost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.client.HttpClient;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.client.protocol.ClientContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;





/**
 * This contains the Order Retrieval API section of the Marketplace Web Service.
 * 
 *
 *
 * MarketplaceWebServiceOrdersClient is implementation of MarketplaceWebServiceOrders based on the
 * Apache <a href="http://jakarta.apache.org/commons/httpclient/">HttpClient</a>.
 *
 */
public  class MarketplaceWebServiceOrdersClient implements MarketplaceWebServiceOrders {

    private final Log log = LogFactory.getLog(MarketplaceWebServiceOrdersClient.class);

    private String awsAccessKeyId = null;
    private String awsSecretAccessKey = null;
    private MarketplaceWebServiceOrdersConfig config = null;
    private HttpClient httpClient = null;
    private List<Header> defaultHeaders = new ArrayList<Header>();
    private CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
    private HttpContext httpContext= null;
    private static JAXBContext  jaxbContext;
    private static ThreadLocal<Unmarshaller> unmarshaller;
    private static Pattern ERROR_PATTERN_ONE = Pattern.compile(".*\\<RequestId>(.*)\\</RequestId>.*\\<Error>" +
            "\\<Code>(.*)\\</Code>\\<Message>(.*)\\</Message>\\</Error>.*(\\<Error>)?.*",
            Pattern.MULTILINE | Pattern.DOTALL);
    private static Pattern ERROR_PATTERN_TWO = Pattern.compile(".*\\<Error>\\<Code>(.*)\\</Code>\\<Message>(.*)" +
            "\\</Message>\\</Error>.*(\\<Error>)?.*\\<RequestID>(.*)\\</RequestID>.*",
            Pattern.MULTILINE | Pattern.DOTALL);
    private static String DEFAULT_ENCODING = "UTF-8";
    /** Initialize JAXBContext and  Unmarshaller **/
    
    private static final String clientVersion = "2013-06-10";
    
    static {
        try {
            jaxbContext = JAXBContext.newInstance("API.amazon.mws.orders.model", MarketplaceWebServiceOrders.class.getClassLoader());
        } catch (JAXBException ex) {
            throw new ExceptionInInitializerError(ex);
        }
        unmarshaller = new ThreadLocal<Unmarshaller>() {
            @Override
            protected synchronized Unmarshaller initialValue() {
                try {
                    return jaxbContext.createUnmarshaller();
                } catch(JAXBException e) {
                    throw new ExceptionInInitializerError(e);
                }
            }
        };
    }


    /**
     * Constructs MarketplaceWebServiceOrdersClient with AWS Access Key ID, AWS Secret Key
     * and MarketplaceWebServiceOrdersConfig. Use MarketplaceWebServiceOrdersConfig to pass additional
     * configuration that affects how service is being called.
     *
     * @param awsAccessKeyId
     *          AWS Access Key ID
     * @param awsSecretAccessKey
     *          AWS Secret Access Key
     * @param applicationName
     *            Application Name
     * @param applicationVersion
     *            Application Version
     * @param config
     *          Additional configuration options
     */
    public  MarketplaceWebServiceOrdersClient(
            String awsAccessKeyId, 
            String awsSecretAccessKey,
            String applicationName, 
            String applicationVersion,             
            MarketplaceWebServiceOrdersConfig config) {
        this.awsAccessKeyId = awsAccessKeyId;
        this.awsSecretAccessKey = awsSecretAccessKey;
        this.config = config;
        this.httpClient = configureHttpClient(applicationName, applicationVersion);
    }

    // Public API ------------------------------------------------------------//


        
    /**
     * List Orders By Next Token 
     *
     * If ListOrders returns a nextToken, thus indicating that there are more orders
     * than returned that matched the given filter criteria, ListOrdersByNextToken
     * can be used to retrieve those other orders using that nextToken.
     * 
     * @param request
     *          ListOrdersByNextTokenRequest request
     * @return
     *          ListOrdersByNextToken Response from the service
     *
     * @throws MarketplaceWebServiceOrdersException
     */
    public ListOrdersByNextTokenResponse listOrdersByNextToken(ListOrdersByNextTokenRequest request) throws MarketplaceWebServiceOrdersException {
        return invoke(ListOrdersByNextTokenResponse.class, convertListOrdersByNextToken(request));
    }

        
    /**
     * List Order Items By Next Token 
     *
     * If ListOrderItems cannot return all the order items in one go, it will
     * provide a nextToken. That nextToken can be used with this operation to
     * retrive the next batch of items for that order.
     * 
     * @param request
     *          ListOrderItemsByNextTokenRequest request
     * @return
     *          ListOrderItemsByNextToken Response from the service
     *
     * @throws MarketplaceWebServiceOrdersException
     */
    public ListOrderItemsByNextTokenResponse listOrderItemsByNextToken(ListOrderItemsByNextTokenRequest request) throws MarketplaceWebServiceOrdersException {
        return invoke(ListOrderItemsByNextTokenResponse.class, convertListOrderItemsByNextToken(request));
    }

        
    /**
     * Get Order 
     *
     * This operation takes up to 50 order ids and returns the corresponding orders.
     * 
     * @param request
     *          GetOrderRequest request
     * @return
     *          GetOrder Response from the service
     *
     * @throws MarketplaceWebServiceOrdersException
     */
    public GetOrderResponse getOrder(GetOrderRequest request) throws MarketplaceWebServiceOrdersException {
        return invoke(GetOrderResponse.class, convertGetOrder(request));
    }

        
    /**
     * List Order Items 
     *
     * This operation can be used to list the items of the order indicated by the
     * given order id (only a single Amazon order id is allowed).
     * 
     * @param request
     *          ListOrderItemsRequest request
     * @return
     *          ListOrderItems Response from the service
     *
     * @throws MarketplaceWebServiceOrdersException
     */
    public ListOrderItemsResponse listOrderItems(ListOrderItemsRequest request) throws MarketplaceWebServiceOrdersException {
        return invoke(ListOrderItemsResponse.class, convertListOrderItems(request));
    }

        
    /**
     * List Orders 
     *
     * ListOrders can be used to find orders that meet the specified criteria.
     * 
     * @param request
     *          ListOrdersRequest request
     * @return
     *          ListOrders Response from the service
     *
     * @throws MarketplaceWebServiceOrdersException
     */
    public ListOrdersResponse listOrders(ListOrdersRequest request) throws MarketplaceWebServiceOrdersException {
        return invoke(ListOrdersResponse.class, convertListOrders(request));
    }

        
    /**
     * Get Service Status 
     *
     * Returns the service status of a particular MWS API section. The operation
     * takes no input.
     * 
     * @param request
     *          GetServiceStatusRequest request
     * @return
     *          GetServiceStatus Response from the service
     *
     * @throws MarketplaceWebServiceOrdersException
     */
    public GetServiceStatusResponse getServiceStatus(GetServiceStatusRequest request) throws MarketplaceWebServiceOrdersException {
        return invoke(GetServiceStatusResponse.class, convertGetServiceStatus(request));
    }



    // Private API ------------------------------------------------------------//
    
    /**
     * Configure HttpClient with set of defaults as well as configuration from
     * MarketplaceWebServiceProductsConfig instance
     * 
     */
    private HttpClient configureHttpClient(
    		String applicationName,
    		String applicationVersion) {
        
        // respect a user-provided User-Agent header as-is, but if none is provided
        // then generate one satisfying the MWS User-Agent requirements
        if(config.getUserAgent()==null) {
        	config.setUserAgent(
        			quoteAppName(applicationName), 
        			quoteAppVersion(applicationVersion), 
        			quoteAttributeValue("Java/"+System.getProperty("java.version")+
        			"/"+System.getProperty("java.class.version")+
        			"/"+System.getProperty("java.vendor")), 
        			
        			quoteAttributeName("Platform"), 
        			quoteAttributeValue(""+System.getProperty("os.name")+
        			"/"+System.getProperty("os.arch")+
        			"/"+System.getProperty("os.version")),
        			
        			quoteAttributeName("MWSClientVersion"), 
        			quoteAttributeValue(clientVersion));
        }
 
        defaultHeaders.add(new BasicHeader("X-Amazon-User-Agent", config.getUserAgent()));
        
        
        /* Set http client parameters */
    	BasicHttpParams httpParams = new BasicHttpParams();
    	
        httpParams.setParameter(CoreProtocolPNames.USER_AGENT, config.getUserAgent());
        

        /* Set connection parameters */
        HttpConnectionParams.setConnectionTimeout(httpParams, 50000);
        HttpConnectionParams.setSoTimeout(httpParams, 50000);
        HttpConnectionParams.setStaleCheckingEnabled(httpParams, true);
        HttpConnectionParams.setTcpNoDelay(httpParams, true);    
        

        /* Set connection manager */
        PoolingClientConnectionManager connectionManager = new PoolingClientConnectionManager();
        connectionManager.setMaxTotal(config.getMaxConnections());
        connectionManager.setDefaultMaxPerRoute(config.getMaxConnections());

        /* Set http client */
        httpClient = new DefaultHttpClient(connectionManager, httpParams);
        httpContext = new BasicHttpContext();

        
        /* Set proxy if configured */
        if (config.isSetProxyHost() && config.isSetProxyPort()) {
            log.info("Configuring Proxy. Proxy Host: " + config.getProxyHost() +
                    "Proxy Port: " + config.getProxyPort() );
            final HttpHost hostConfiguration = new HttpHost(config.getProxyHost(), config.getProxyPort(), (usesHttps(config.getServiceURL()) ? "https" : "http") );
            httpContext = new BasicHttpContext();
            httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, hostConfiguration); 

            if (config.isSetProxyUsername() && config.isSetProxyPassword()) {
                credentialsProvider.setCredentials (new AuthScope(
                                          config.getProxyHost(),
                                          config.getProxyPort()),
                                          new UsernamePasswordCredentials(
                                              config.getProxyUsername(),
                                              config.getProxyPassword()));
                httpContext.setAttribute(ClientContext.CREDS_PROVIDER, credentialsProvider);

            }

        }

        return httpClient;
    }
	
    /**
     * Remove all leading whitespace, trailing whitespace, repeated whitespace
     * and replace any interior whitespace with a single space
     */
    private static String clean(String s) {
        return s.replaceAll("\\s", " ").replaceAll(" {2,}", " ").trim();
    }

    public static String quoteAppName(String s) {
        return clean(s).replace("\\", "\\\\").replace("/", "\\/");
    }

    public static String quoteAppVersion(String s) {
        return clean(s).replace("\\", "\\\\").replace("(", "\\(");
    }

    public static String quoteAttributeName(String s) {
        return clean(s).replace("\\", "\\\\").replace("=", "\\=");
    }

    public static String quoteAttributeValue(String s) {
        return clean(s).replace("\\", "\\\\").replace(";", "\\;").replace(")", "\\)");
    }

    /**
     * Invokes request using parameters from parameters map.
     * Returns response of the T type passed to this method
     */
    private <T> T invoke(Class<T> clazz, Map<String, String> parameters)
            throws MarketplaceWebServiceOrdersException {

        String actionName = parameters.get("Action");
        T response = null;
        String responseBodyString = null;
        ResponseHeaderMetadata responseHeaderMetadata = null;
        HttpPost method = new HttpPost(config.getServiceURL());
        int status = -1;

        log.debug("Invoking" + actionName + " request. Current parameters: " + parameters);

        try {

            Method responseHeaderMetadataSetter = clazz.getMethod("setResponseHeaderMetadata", ResponseHeaderMetadata.class);

            /* Set content type and encoding */
            log.debug("Setting content-type to application/x-www-form-urlencoded; charset=" + DEFAULT_ENCODING.toLowerCase());
            method.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=" + DEFAULT_ENCODING.toLowerCase());
            /* Set X-Amazon-User-Agent to header */
            method.addHeader("X-Amazon-User-Agent", config.getUserAgent());

            /* Add required request parameters and set request body */
            log.debug("Adding required parameters...");
            addRequiredParametersToRequest(method, parameters);
            log.debug("Done adding additional required parameters. Parameters now: " + parameters);

            boolean shouldRetry = true;
            int retries = 0;
            do {
                log.debug("Sending Request to host:  " + config.getServiceURL());

                try {

                    /* Submit request */
                	HttpResponse postResponse;
                    postResponse = httpClient.execute(method, httpContext);
                    status = postResponse.getStatusLine().getStatusCode();

                    responseHeaderMetadata = getResponseHeaderMetadata(postResponse);

                    /* Consume response stream */
                    responseBodyString = getResponsBodyAsString(postResponse.getEntity().getContent());

                    /* Successful response. Attempting to unmarshal into the <Action>Response type */
                    if (status == HttpStatus.SC_OK) {
                        shouldRetry = false;
                        log.debug("Received Response. Status: " + status + ". " +
                                "Response Body: " + responseBodyString);
                        log.debug("Attempting to unmarshal into the " + actionName + "Response type...");
                        response = clazz.cast(getUnmarshaller().unmarshal(new StreamSource(new StringReader(responseBodyString))));

                        responseHeaderMetadataSetter.invoke(response, responseHeaderMetadata);

                        log.debug("Unmarshalled response into " + actionName + "Response type.");

                    } else { /* Unsucessful response. Attempting to unmarshall into ErrorResponse  type */

                        log.debug("Received Response. Status: " + status + ". " +
                                "Response Body: " + responseBodyString);

                        if ((status == HttpStatus.SC_INTERNAL_SERVER_ERROR && pauseIfRetryNeeded(++retries))) {
                            shouldRetry = true;
                        } else {
                            log.debug("Attempting to unmarshal into the ErrorResponse type...");
                            ErrorResponse errorResponse = (ErrorResponse) getUnmarshaller().unmarshal(new StreamSource(new StringReader(responseBodyString)));

                            log.debug("Unmarshalled response into the ErrorResponse type.");

                            API.amazon.mws.orders.model.Error error = errorResponse.getError().get(0);
                            if (status == HttpStatus.SC_SERVICE_UNAVAILABLE && !(error.getCode().equals("RequestThrottled")) && pauseIfRetryNeeded(++retries)) {
                                shouldRetry = true;
                            } else {
                                shouldRetry = false;
                                throw new MarketplaceWebServiceOrdersException(error.getMessage(), status, error.getCode(), error.getType(),
                                errorResponse.getRequestId(), errorResponse.toXML(), responseHeaderMetadata);
                            }                            
                        }
                    }
                } catch (JAXBException je) {
                    /* Response cannot be unmarshalled neither as <Action>Response or ErrorResponse types.
                    Checking for other possible errors. */

                    log.debug ("Caught JAXBException", je);
                    log.debug("Response cannot be unmarshalled neither as " + actionName + "Response or ErrorResponse types." +
                            "Checking for other possible errors.");

                    MarketplaceWebServiceOrdersException awse = processErrors(responseBodyString, status, responseHeaderMetadata);

                    throw awse;

                } catch (IOException ioe) {
                    log.debug("Caught IOException exception", ioe);
                    throw new MarketplaceWebServiceOrdersException("Internal Error", ioe);
                } catch (Exception e) {
                    log.debug("Caught Exception", e);
                    throw new MarketplaceWebServiceOrdersException(e);
                } finally {
                    method.releaseConnection();
                }
            } while (shouldRetry);

        } catch (MarketplaceWebServiceOrdersException se) {
            log.debug("Caught MarketplaceWebServiceOrdersException", se);
            throw se;

        } catch (Throwable t) {
            log.debug("Caught Exception", t);
            throw new MarketplaceWebServiceOrdersException(t);
        }
        return response;
    }

    /**
     * Extract response metadata from the response headers.
     */
    private ResponseHeaderMetadata getResponseHeaderMetadata(HttpResponse method) {
        Header requestId = method.getFirstHeader("x-mws-request-id"); 
        Header responseContext = method.getFirstHeader("x-mws-response-context");
        Header timestamp = method.getFirstHeader("x-mws-timestamp");

      List<String> responseContextList = null;
      if (responseContext != null) {
        String value = responseContext.getValue();
        responseContextList = Arrays.asList(value.split(","));
      }

      return new ResponseHeaderMetadata(
        requestId != null ? requestId.getValue() : null,
        responseContextList,
        timestamp != null ? timestamp.getValue() : null);
    }

    /**
     * Read stream into string
     * @param input stream to read
     */
    private String getResponsBodyAsString(InputStream input) throws IOException {
        String responsBodyString = null;
        try {
            Reader reader = new InputStreamReader(input, DEFAULT_ENCODING);
            StringBuilder b = new StringBuilder();
            char[] c = new char[1024];
            int len;
            while (0 < (len = reader.read(c))) {
                b.append(c, 0, len);
            }
            responsBodyString = b.toString();
        } finally {
            input.close();
        }
        return responsBodyString;
    }

    /**
     * Exponential sleep on failed request. Sleeps and returns true if retry needed
     * @param retries current retry
     * @throws java.lang.InterruptedException
     */
    private boolean pauseIfRetryNeeded(int retries)
          throws InterruptedException {
        if (retries <= config.getMaxErrorRetry()) {
            long delay = (long) (Math.pow(4, retries) * 100L);
            log.debug("Retriable error detected, will retry in " + delay + "ms, attempt number: " + retries);
            Thread.sleep(delay);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Add authentication related and version parameter and set request body
     * with all of the parameters
     * @throws UnsupportedEncodingException 
     */
    private void addRequiredParametersToRequest(HttpPost method, Map<String, String> parameters)
            throws SignatureException, UnsupportedEncodingException {
        parameters.put("Version", config.getServiceVersion());
        parameters.put("SignatureVersion", config.getSignatureVersion());
        parameters.put("Timestamp", getFormattedTimestamp());
        parameters.put("AWSAccessKeyId",  this.awsAccessKeyId);
        parameters.put("Signature", signParameters(parameters, this.awsSecretAccessKey));
        List <NameValuePair> parameterList = new ArrayList <NameValuePair>();
        for (Entry<String, String> entry : parameters.entrySet()) {
            String key = entry.getKey()==null ? "" : entry.getKey();
            String value = entry.getValue()==null ? "" : entry.getValue();
            parameterList.add(new BasicNameValuePair(key, value));
        }
        method.setEntity(new UrlEncodedFormEntity(parameterList, HTTP.UTF_8));

    }

    private MarketplaceWebServiceOrdersException processErrors(String responseString, int status, ResponseHeaderMetadata responseHeaderMetadata)  {
        MarketplaceWebServiceOrdersException ex = null;
        Matcher matcher = null;
        if (responseString != null && responseString.startsWith("<")) {
            matcher = ERROR_PATTERN_ONE.matcher(responseString);
            if (matcher.matches()) {
                ex = new MarketplaceWebServiceOrdersException(matcher.group(3), status,
                        matcher.group(2), "Unknown", matcher.group(1), responseString, responseHeaderMetadata);
            } else {
                matcher = ERROR_PATTERN_TWO.matcher(responseString);
                if (matcher.matches()) {
                    ex = new MarketplaceWebServiceOrdersException(matcher.group(2), status,
                            matcher.group(1), "Unknown", matcher.group(4), responseString, responseHeaderMetadata);
            } else {
                ex =  new MarketplaceWebServiceOrdersException("Internal Error", status);
                log.debug("Service Error. Response Status: " + status);
            }
            }
        } else {
            ex =  new MarketplaceWebServiceOrdersException("Internal Error", status);
            log.debug("Service Error. Response Status: " + status);
        }
        return ex;
    }

    /**
     * Formats date as ISO 8601 timestamp
     */
    private String getFormattedTimestamp() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        return df.format(new Date());
    }

    /**
     * Computes RFC 2104-compliant HMAC signature for request parameters
     * Implements AWS Signature, as per following spec:
     *
     * If Signature Version is 0, it signs concatenated Action and Timestamp
     *
     * If Signature Version is 1, it performs the following:
     *
     * Sorts all  parameters (including SignatureVersion and excluding Signature,
     * the value of which is being created), ignoring case.
     *
     * Iterate over the sorted list and append the parameter name (in original case)
     * and then its value. It will not URL-encode the parameter values before
     * constructing this string. There are no separators.
     *
     * If Signature Version is 2, string to sign is based on following:
     *
     *    1. The HTTP Request Method followed by an ASCII newline (%0A)
     *    2. The HTTP Host header in the form of lowercase host, followed by an ASCII newline.
     *    3. The URL encoded HTTP absolute path component of the URI
     *       (up to but not including the query string parameters);
     *       if this is empty use a forward '/'. This parameter is followed by an ASCII newline.
     *    4. The concatenation of all query string components (names and values)
     *       as UTF-8 characters which are URL encoded as per RFC 3986
     *       (hex characters MUST be uppercase), sorted using lexicographic byte ordering.
     *       Parameter names are separated from their values by the '=' character
     *       (ASCII character 61), even if the value is empty.
     *       Pairs of parameter and values are separated by the '&' character (ASCII code 38).
     *
     */
    private String signParameters(Map<String, String> parameters, String key)
            throws  SignatureException {

        String signatureVersion = parameters.get("SignatureVersion");
        String algorithm = "HmacSHA1";
        String stringToSign = null;
        if ("0".equals(signatureVersion)) {
            stringToSign = calculateStringToSignV0(parameters);
        } else if ("1".equals(signatureVersion)) {
            stringToSign = calculateStringToSignV1(parameters);
        } else if ("2".equals(signatureVersion)) {
            algorithm = config.getSignatureMethod();
            parameters.put("SignatureMethod", algorithm);
            stringToSign = calculateStringToSignV2(parameters);
        } else {
            throw new SignatureException("Invalid Signature Version specified");
        }
        log.debug("Calculated string to sign: " + stringToSign);
        return sign(stringToSign, key, algorithm);
    }

    /**
     * Calculate String to Sign for SignatureVersion 0
     * @param parameters request parameters
     * @return String to Sign
     * @throws java.security.SignatureException
     */
    private String calculateStringToSignV0(Map<String, String> parameters) {
        StringBuilder data = new StringBuilder();
            data.append(parameters.get("Action")).append(parameters.get("Timestamp"));
        return data.toString();
    }

    /**
     * Calculate String to Sign for SignatureVersion 1
     * @param parameters request parameters
     * @return String to Sign
     * @throws java.security.SignatureException
     */
    private String calculateStringToSignV1(Map<String, String> parameters) {
        StringBuilder data = new StringBuilder();
            Map<String, String> sorted =  new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
            sorted.putAll(parameters);
            Iterator pairs = sorted.entrySet().iterator();
            while (pairs.hasNext()) {
                Map.Entry pair = (Map.Entry)pairs.next();
                data.append(pair.getKey());
                data.append(pair.getValue());
            }
        return data.toString();
    }

    /**
     * Calculate String to Sign for SignatureVersion 2
     * @param parameters request parameters
     * @return String to Sign
     * @throws java.security.SignatureException
     */
    private String calculateStringToSignV2(Map<String, String> parameters)
            throws SignatureException {
        StringBuilder data = new StringBuilder();
        data.append("POST");
        data.append("\n");
        URI endpoint = null;
        try {
            endpoint = new URI(config.getServiceURL().toLowerCase());
        } catch (URISyntaxException ex) {
            log.debug("URI Syntax Exception", ex);
            throw new SignatureException("URI Syntax Exception thrown " +
                    "while constructing string to sign", ex);
        }
        data.append(endpoint.getHost());
        if (!usesAStandardPort(config.getServiceURL())) {
            data.append(":");
            data.append(endpoint.getPort());
        }
        data.append("\n");
        String uri = "/Orders/2011-01-01";
        data.append(urlEncode(uri, true));
        data.append("\n");
        Map<String, String> sorted = new TreeMap<String, String>();
        sorted.putAll(parameters);
        Iterator<Map.Entry<String, String>> pairs = sorted.entrySet().iterator();
        while (pairs.hasNext()) {
            Map.Entry<String, String> pair = pairs.next();
            String key = pair.getKey();
            data.append(urlEncode(key, false));
            data.append("=");
            String value = pair.getValue();
            data.append(urlEncode(value, false));
            if (pairs.hasNext()) {
                data.append("&");
            }
        }
        return data.toString();
    }

    private static boolean usesAStandardPort(String url) {
        boolean usesHttps = usesHttps(url);
        int portNumber = extractPortNumber(url, usesHttps);
        return usesHttps && portNumber == 443
            || !usesHttps && portNumber == 80;
    }
    
    private static boolean usesHttps(String url){
        URL urlToCheck;
        try {
            urlToCheck = new URL(url);
        } catch (MalformedURLException e) {
            return false;
        }
        if (urlToCheck.getProtocol().equals("https")){
            return true;
        }else
        {
            return false;
        }
    }

    private static int extractPortNumber(String url, boolean usesHttps) {
        URL urlToCheck;
        try {
            urlToCheck = new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException("not a URL", e);
        }
        
        int portNumber = urlToCheck.getPort();
        if (portNumber == -1){
            // no port was specified
            if (usesHttps){
                // it uses https, so we should return the standard https port number
                return 443;
            }else
            {
                // it uses http, so we should return the standard http port number
                return 80;
            }
        }else
        {
            return portNumber;
        }
    }

    private String urlEncode(String value, boolean path) {
        String encoded = null;
        try {
            encoded = URLEncoder.encode(value, DEFAULT_ENCODING)
                                        .replace("+", "%20")
                                        .replace("*", "%2A")
                                        .replace("%7E","~");
            if (path) {
                encoded = encoded.replace("%2F", "/");
            }
        } catch (UnsupportedEncodingException ex) {
            log.debug("Unsupported Encoding Exception", ex);
            throw new RuntimeException(ex);
        }
        return encoded;
    }

    /**
     * Computes RFC 2104-compliant HMAC signature.
     *
     */
    private String sign(String data, String key, String algorithm) throws SignatureException {
        byte [] signature;
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.getBytes(), algorithm));
            signature = Base64.encodeBase64(mac.doFinal(data.getBytes(DEFAULT_ENCODING)));
        } catch (Exception e) {
            throw new SignatureException("Failed to generate signature: " + e.getMessage(), e);
        }

        return new String(signature);
    }

    /**
     * Get unmarshaller for current thread
     */
    private Unmarshaller getUnmarshaller() {
        return unmarshaller.get();
    }
    
    
    
                    
   /**
     * Convert ListOrdersByNextTokenRequest to name value pairs
     */
    private Map<String, String> convertListOrdersByNextToken(ListOrdersByNextTokenRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "ListOrdersByNextToken");
        if (request.isSetSellerId()) {
            params.put("SellerId", request.getSellerId());
        }
        if (request.isSetNextToken()) {
            params.put("NextToken", request.getNextToken());
        }

        return params;
    }
        
        
    
    
                    
   /**
     * Convert ListOrderItemsByNextTokenRequest to name value pairs
     */
    private Map<String, String> convertListOrderItemsByNextToken(ListOrderItemsByNextTokenRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "ListOrderItemsByNextToken");
        if (request.isSetSellerId()) {
            params.put("SellerId", request.getSellerId());
        }
        if (request.isSetNextToken()) {
            params.put("NextToken", request.getNextToken());
        }

        return params;
    }
        
        
    
    
                    
   /**
     * Convert GetOrderRequest to name value pairs
     */
    private Map<String, String> convertGetOrder(GetOrderRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "GetOrder");
        if (request.isSetSellerId()) {
            params.put("SellerId", request.getSellerId());
        }
        if (request.isSetAmazonOrderId()) {
            OrderIdList  amazonOrderId = request.getAmazonOrderId();
            java.util.List<String> idList  =  amazonOrderId.getId();
            int idListIndex = 1;
            for  (String id : idList) { 
                params.put("AmazonOrderId" + "." + "Id" + "."  + idListIndex, id);
                idListIndex++;
            }	
        } 

        return params;
    }
        
        
    
    
                    
   /**
     * Convert ListOrderItemsRequest to name value pairs
     */
    private Map<String, String> convertListOrderItems(ListOrderItemsRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "ListOrderItems");
        if (request.isSetSellerId()) {
            params.put("SellerId", request.getSellerId());
        }
        if (request.isSetAmazonOrderId()) {
            params.put("AmazonOrderId", request.getAmazonOrderId());
        }

        return params;
    }
        
        
    
    
                    
   /**
     * Convert ListOrdersRequest to name value pairs
     */
    private Map<String, String> convertListOrders(ListOrdersRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "ListOrders");
        if (request.isSetSellerId()) {
            params.put("SellerId", request.getSellerId());
        }
        if (request.isSetCreatedAfter()) {
            params.put("CreatedAfter", request.getCreatedAfter() + "");
        }
        if (request.isSetCreatedBefore()) {
            params.put("CreatedBefore", request.getCreatedBefore() + "");
        }
        if (request.isSetLastUpdatedAfter()) {
            params.put("LastUpdatedAfter", request.getLastUpdatedAfter() + "");
        }
        if (request.isSetLastUpdatedBefore()) {
            params.put("LastUpdatedBefore", request.getLastUpdatedBefore() + "");
        }
        if (request.isSetOrderStatus()) {
            OrderStatusList  orderStatus = request.getOrderStatus();
            java.util.List<OrderStatusEnum> statusList  =  orderStatus.getStatus();
            int statusListIndex = 1;
            for  (OrderStatusEnum status : statusList) { 
                params.put("OrderStatus" + "." + "Status" + "."  + statusListIndex, status.value());
                statusListIndex++;
            }	
        } 
        if (request.isSetMarketplaceId()) {
            MarketplaceIdList  marketplaceId = request.getMarketplaceId();
            java.util.List<String> idList  =  marketplaceId.getId();
            int idListIndex = 1;
            for  (String id : idList) { 
                params.put("MarketplaceId" + "." + "Id" + "."  + idListIndex, id);
                idListIndex++;
            }	
        } 
        if (request.isSetFulfillmentChannel()) {
            FulfillmentChannelList  fulfillmentChannel = request.getFulfillmentChannel();
            java.util.List<FulfillmentChannelEnum> channelList  =  fulfillmentChannel.getChannel();
            int channelListIndex = 1;
            for  (FulfillmentChannelEnum channel : channelList) { 
                params.put("FulfillmentChannel" + "." + "Channel" + "."  + channelListIndex, channel.value());
                channelListIndex++;
            }	
        } 
        if (request.isSetPaymentMethod()) {
            PaymentMethodList  paymentMethod = request.getPaymentMethod();
            java.util.List<PaymentMethodEnum> methodList  =  paymentMethod.getMethod();
            int methodListIndex = 1;
            for  (PaymentMethodEnum method : methodList) { 
                params.put("PaymentMethod" + "." + "Method" + "."  + methodListIndex, method.value());
                methodListIndex++;
            }	
        } 
        if (request.isSetBuyerEmail()) {
            params.put("BuyerEmail", request.getBuyerEmail());
        }
        if (request.isSetSellerOrderId()) {
            params.put("SellerOrderId", request.getSellerOrderId());
        }
        if (request.isSetMaxResultsPerPage()) {
            params.put("MaxResultsPerPage", request.getMaxResultsPerPage() + "");
        }
        if (request.isSetTFMShipmentStatus()) {
            TFMShipmentStatusList  TFMShipmentStatus = request.getTFMShipmentStatus();
            java.util.List<String> status1List  =  TFMShipmentStatus.getStatus();
            int status1ListIndex = 1;
            for  (String status1 : status1List) { 
                params.put("TFMShipmentStatus" + "." + "Status" + "."  + status1ListIndex, status1);
                status1ListIndex++;
            }	
        } 

        return params;
    }
        
        
    
    
                    
   /**
     * Convert GetServiceStatusRequest to name value pairs
     */
    private Map<String, String> convertGetServiceStatus(GetServiceStatusRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "GetServiceStatus");
        if (request.isSetSellerId()) {
            params.put("SellerId", request.getSellerId());
        }

        return params;
    }
        
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    



}
