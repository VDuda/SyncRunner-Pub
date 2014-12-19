
package API.amazon.mws.orders.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SellerId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CreatedAfter" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="CreatedBefore" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="LastUpdatedAfter" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="LastUpdatedBefore" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="OrderStatus" type="{https://mws.amazonservices.com/Orders/2011-01-01}OrderStatusList" minOccurs="0"/>
 *         &lt;element name="MarketplaceId" type="{https://mws.amazonservices.com/Orders/2011-01-01}MarketplaceIdList"/>
 *         &lt;element name="FulfillmentChannel" type="{https://mws.amazonservices.com/Orders/2011-01-01}FulfillmentChannelList" minOccurs="0"/>
 *         &lt;element name="PaymentMethod" type="{https://mws.amazonservices.com/Orders/2011-01-01}PaymentMethodList" minOccurs="0"/>
 *         &lt;element name="BuyerEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SellerOrderId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MaxResultsPerPage" type="{https://mws.amazonservices.com/Orders/2011-01-01}MaxResults" minOccurs="0"/>
 *         &lt;element name="TFMShipmentStatus" type="{https://mws.amazonservices.com/Orders/2011-01-01}TFMShipmentStatusList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sellerId",
    "createdAfter",
    "createdBefore",
    "lastUpdatedAfter",
    "lastUpdatedBefore",
    "orderStatus",
    "marketplaceId",
    "fulfillmentChannel",
    "paymentMethod",
    "buyerEmail",
    "sellerOrderId",
    "maxResultsPerPage",
    "tfmShipmentStatus"
})
@XmlRootElement(name = "ListOrdersRequest")
public class ListOrdersRequest {

    @XmlElement(name = "SellerId", required = true)
    protected String sellerId;
    @XmlElement(name = "CreatedAfter")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdAfter;
    @XmlElement(name = "CreatedBefore")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdBefore;
    @XmlElement(name = "LastUpdatedAfter")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdatedAfter;
    @XmlElement(name = "LastUpdatedBefore")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdatedBefore;
    @XmlElement(name = "OrderStatus")
    protected OrderStatusList orderStatus;
    @XmlElement(name = "MarketplaceId", required = true)
    protected MarketplaceIdList marketplaceId;
    @XmlElement(name = "FulfillmentChannel")
    protected FulfillmentChannelList fulfillmentChannel;
    @XmlElement(name = "PaymentMethod")
    protected PaymentMethodList paymentMethod;
    @XmlElement(name = "BuyerEmail")
    protected String buyerEmail;
    @XmlElement(name = "SellerOrderId")
    protected String sellerOrderId;
    @XmlElement(name = "MaxResultsPerPage")
    protected Integer maxResultsPerPage;
    @XmlElement(name = "TFMShipmentStatus")
    protected TFMShipmentStatusList tfmShipmentStatus;

    /**
     * Default constructor
     * 
     */
    public ListOrdersRequest() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public ListOrdersRequest(final String sellerId, final XMLGregorianCalendar createdAfter, final XMLGregorianCalendar createdBefore, final XMLGregorianCalendar lastUpdatedAfter, final XMLGregorianCalendar lastUpdatedBefore, final OrderStatusList orderStatus, final MarketplaceIdList marketplaceId, final FulfillmentChannelList fulfillmentChannel, final PaymentMethodList paymentMethod, final String buyerEmail, final String sellerOrderId, final Integer maxResultsPerPage, final TFMShipmentStatusList tfmShipmentStatus) {
        this.sellerId = sellerId;
        this.createdAfter = createdAfter;
        this.createdBefore = createdBefore;
        this.lastUpdatedAfter = lastUpdatedAfter;
        this.lastUpdatedBefore = lastUpdatedBefore;
        this.orderStatus = orderStatus;
        this.marketplaceId = marketplaceId;
        this.fulfillmentChannel = fulfillmentChannel;
        this.paymentMethod = paymentMethod;
        this.buyerEmail = buyerEmail;
        this.sellerOrderId = sellerOrderId;
        this.maxResultsPerPage = maxResultsPerPage;
        this.tfmShipmentStatus = tfmShipmentStatus;
    }

    /**
     * Gets the value of the sellerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * Sets the value of the sellerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellerId(String value) {
        this.sellerId = value;
    }

    public boolean isSetSellerId() {
        return (this.sellerId!= null);
    }

    /**
     * Gets the value of the createdAfter property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedAfter() {
        return createdAfter;
    }

    /**
     * Sets the value of the createdAfter property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedAfter(XMLGregorianCalendar value) {
        this.createdAfter = value;
    }

    public boolean isSetCreatedAfter() {
        return (this.createdAfter!= null);
    }

    /**
     * Gets the value of the createdBefore property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedBefore() {
        return createdBefore;
    }

    /**
     * Sets the value of the createdBefore property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedBefore(XMLGregorianCalendar value) {
        this.createdBefore = value;
    }

    public boolean isSetCreatedBefore() {
        return (this.createdBefore!= null);
    }

    /**
     * Gets the value of the lastUpdatedAfter property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastUpdatedAfter() {
        return lastUpdatedAfter;
    }

    /**
     * Sets the value of the lastUpdatedAfter property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastUpdatedAfter(XMLGregorianCalendar value) {
        this.lastUpdatedAfter = value;
    }

    public boolean isSetLastUpdatedAfter() {
        return (this.lastUpdatedAfter!= null);
    }

    /**
     * Gets the value of the lastUpdatedBefore property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastUpdatedBefore() {
        return lastUpdatedBefore;
    }

    /**
     * Sets the value of the lastUpdatedBefore property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastUpdatedBefore(XMLGregorianCalendar value) {
        this.lastUpdatedBefore = value;
    }

    public boolean isSetLastUpdatedBefore() {
        return (this.lastUpdatedBefore!= null);
    }

    /**
     * Gets the value of the orderStatus property.
     * 
     * @return
     *     possible object is
     *     {@link OrderStatusList }
     *     
     */
    public OrderStatusList getOrderStatus() {
        return orderStatus;
    }

    /**
     * Sets the value of the orderStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderStatusList }
     *     
     */
    public void setOrderStatus(OrderStatusList value) {
        this.orderStatus = value;
    }

    public boolean isSetOrderStatus() {
        return (this.orderStatus!= null);
    }

    /**
     * Gets the value of the marketplaceId property.
     * 
     * @return
     *     possible object is
     *     {@link MarketplaceIdList }
     *     
     */
    public MarketplaceIdList getMarketplaceId() {
        return marketplaceId;
    }

    /**
     * Sets the value of the marketplaceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link MarketplaceIdList }
     *     
     */
    public void setMarketplaceId(MarketplaceIdList value) {
        this.marketplaceId = value;
    }

    public boolean isSetMarketplaceId() {
        return (this.marketplaceId!= null);
    }

    /**
     * Gets the value of the fulfillmentChannel property.
     * 
     * @return
     *     possible object is
     *     {@link FulfillmentChannelList }
     *     
     */
    public FulfillmentChannelList getFulfillmentChannel() {
        return fulfillmentChannel;
    }

    /**
     * Sets the value of the fulfillmentChannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link FulfillmentChannelList }
     *     
     */
    public void setFulfillmentChannel(FulfillmentChannelList value) {
        this.fulfillmentChannel = value;
    }

    public boolean isSetFulfillmentChannel() {
        return (this.fulfillmentChannel!= null);
    }

    /**
     * Gets the value of the paymentMethod property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentMethodList }
     *     
     */
    public PaymentMethodList getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the value of the paymentMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMethodList }
     *     
     */
    public void setPaymentMethod(PaymentMethodList value) {
        this.paymentMethod = value;
    }

    public boolean isSetPaymentMethod() {
        return (this.paymentMethod!= null);
    }

    /**
     * Gets the value of the buyerEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuyerEmail() {
        return buyerEmail;
    }

    /**
     * Sets the value of the buyerEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuyerEmail(String value) {
        this.buyerEmail = value;
    }

    public boolean isSetBuyerEmail() {
        return (this.buyerEmail!= null);
    }

    /**
     * Gets the value of the sellerOrderId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSellerOrderId() {
        return sellerOrderId;
    }

    /**
     * Sets the value of the sellerOrderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellerOrderId(String value) {
        this.sellerOrderId = value;
    }

    public boolean isSetSellerOrderId() {
        return (this.sellerOrderId!= null);
    }

    /**
     * Gets the value of the maxResultsPerPage property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxResultsPerPage() {
        return maxResultsPerPage;
    }

    /**
     * Sets the value of the maxResultsPerPage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxResultsPerPage(Integer value) {
        this.maxResultsPerPage = value;
    }

    public boolean isSetMaxResultsPerPage() {
        return (this.maxResultsPerPage!= null);
    }

    /**
     * Gets the value of the tfmShipmentStatus property.
     * 
     * @return
     *     possible object is
     *     {@link TFMShipmentStatusList }
     *     
     */
    public TFMShipmentStatusList getTFMShipmentStatus() {
        return tfmShipmentStatus;
    }

    /**
     * Sets the value of the tfmShipmentStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link TFMShipmentStatusList }
     *     
     */
    public void setTFMShipmentStatus(TFMShipmentStatusList value) {
        this.tfmShipmentStatus = value;
    }

    public boolean isSetTFMShipmentStatus() {
        return (this.tfmShipmentStatus!= null);
    }

    /**
     * Sets the value of the SellerId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ListOrdersRequest withSellerId(String value) {
        setSellerId(value);
        return this;
    }

    /**
     * Sets the value of the CreatedAfter property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ListOrdersRequest withCreatedAfter(XMLGregorianCalendar value) {
        setCreatedAfter(value);
        return this;
    }

    /**
     * Sets the value of the CreatedBefore property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ListOrdersRequest withCreatedBefore(XMLGregorianCalendar value) {
        setCreatedBefore(value);
        return this;
    }

    /**
     * Sets the value of the LastUpdatedAfter property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ListOrdersRequest withLastUpdatedAfter(XMLGregorianCalendar value) {
        setLastUpdatedAfter(value);
        return this;
    }

    /**
     * Sets the value of the LastUpdatedBefore property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ListOrdersRequest withLastUpdatedBefore(XMLGregorianCalendar value) {
        setLastUpdatedBefore(value);
        return this;
    }

    /**
     * Sets the value of the OrderStatus property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ListOrdersRequest withOrderStatus(OrderStatusList value) {
        setOrderStatus(value);
        return this;
    }

    /**
     * Sets the value of the MarketplaceId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ListOrdersRequest withMarketplaceId(MarketplaceIdList value) {
        setMarketplaceId(value);
        return this;
    }

    /**
     * Sets the value of the FulfillmentChannel property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ListOrdersRequest withFulfillmentChannel(FulfillmentChannelList value) {
        setFulfillmentChannel(value);
        return this;
    }

    /**
     * Sets the value of the PaymentMethod property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ListOrdersRequest withPaymentMethod(PaymentMethodList value) {
        setPaymentMethod(value);
        return this;
    }

    /**
     * Sets the value of the BuyerEmail property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ListOrdersRequest withBuyerEmail(String value) {
        setBuyerEmail(value);
        return this;
    }

    /**
     * Sets the value of the SellerOrderId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ListOrdersRequest withSellerOrderId(String value) {
        setSellerOrderId(value);
        return this;
    }

    /**
     * Sets the value of the MaxResultsPerPage property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ListOrdersRequest withMaxResultsPerPage(Integer value) {
        setMaxResultsPerPage(value);
        return this;
    }

    /**
     * Sets the value of the TFMShipmentStatus property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ListOrdersRequest withTFMShipmentStatus(TFMShipmentStatusList value) {
        setTFMShipmentStatus(value);
        return this;
    }
    



    /**
     *
     * JSON fragment representation of this object
     *
     * @return JSON fragment for this object. Name for outer
     * object expected to be set by calling method. This fragment
     * returns inner properties representation only
     *
     */
    protected String toJSONFragment() {
        StringBuffer json = new StringBuffer();
        boolean first = true;
        if (isSetSellerId()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("SellerId"));
            json.append(" : ");
            json.append(quoteJSON(getSellerId()));
            first = false;
        }
        if (isSetCreatedAfter()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("CreatedAfter"));
            json.append(" : ");
            json.append(quoteJSON(getCreatedAfter() + ""));
            first = false;
        }
        if (isSetCreatedBefore()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("CreatedBefore"));
            json.append(" : ");
            json.append(quoteJSON(getCreatedBefore() + ""));
            first = false;
        }
        if (isSetLastUpdatedAfter()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("LastUpdatedAfter"));
            json.append(" : ");
            json.append(quoteJSON(getLastUpdatedAfter() + ""));
            first = false;
        }
        if (isSetLastUpdatedBefore()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("LastUpdatedBefore"));
            json.append(" : ");
            json.append(quoteJSON(getLastUpdatedBefore() + ""));
            first = false;
        }
        if (isSetOrderStatus()) {
            if (!first) json.append(", ");
            json.append("\"OrderStatus\" : {");
            OrderStatusList  orderStatus = getOrderStatus();


            json.append(orderStatus.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetMarketplaceId()) {
            if (!first) json.append(", ");
            json.append("\"MarketplaceId\" : {");
            MarketplaceIdList  marketplaceId = getMarketplaceId();


            json.append(marketplaceId.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetFulfillmentChannel()) {
            if (!first) json.append(", ");
            json.append("\"FulfillmentChannel\" : {");
            FulfillmentChannelList  fulfillmentChannel = getFulfillmentChannel();


            json.append(fulfillmentChannel.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetPaymentMethod()) {
            if (!first) json.append(", ");
            json.append("\"PaymentMethod\" : {");
            PaymentMethodList  paymentMethod = getPaymentMethod();


            json.append(paymentMethod.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetBuyerEmail()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("BuyerEmail"));
            json.append(" : ");
            json.append(quoteJSON(getBuyerEmail()));
            first = false;
        }
        if (isSetSellerOrderId()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("SellerOrderId"));
            json.append(" : ");
            json.append(quoteJSON(getSellerOrderId()));
            first = false;
        }
        if (isSetMaxResultsPerPage()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("MaxResultsPerPage"));
            json.append(" : ");
            json.append(quoteJSON(getMaxResultsPerPage() + ""));
            first = false;
        }
        if (isSetTFMShipmentStatus()) {
            if (!first) json.append(", ");
            json.append("\"TFMShipmentStatus\" : {");
            TFMShipmentStatusList  TFMShipmentStatus = getTFMShipmentStatus();


            json.append(TFMShipmentStatus.toJSONFragment());
            json.append("}");
            first = false;
        }
        return json.toString();
    }

    /**
     *
     * Quote JSON string
     */
    private String quoteJSON(String string) {
        if (string == null)
            return "null";
        StringBuffer sb = new StringBuffer();
        sb.append("\"");
        int length = string.length();
        for (int i = 0; i < length; ++i) {
            char c = string.charAt(i);
            switch (c) {
            case '"':
                sb.append("\\\"");
                break;
            case '\\':
                sb.append("\\\\");
                break;
            case '/':
                sb.append("\\/");
                break;
            case '\b':
                sb.append("\\b");
                break;
            case '\f':
                sb.append("\\f");
                break;
            case '\n':
                sb.append("\\n");
                break;
            case '\r':
                sb.append("\\r");
                break;
            case '\t':
                sb.append("\\t");
                break;
            default:
                if (c <  ' ') {
                    sb.append("\\u" + String.format("%03x", Integer.valueOf(c)));
                } else {
                sb.append(c);
            }
        }
        }
        sb.append("\"");
        return sb.toString();
    }


}
