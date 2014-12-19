
package API.amazon.mws.orders.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Order complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Order">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AmazonOrderId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SellerOrderId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PurchaseDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="LastUpdateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="OrderStatus" type="{https://mws.amazonservices.com/Orders/2011-01-01}OrderStatusEnum"/>
 *         &lt;element name="FulfillmentChannel" type="{https://mws.amazonservices.com/Orders/2011-01-01}FulfillmentChannelEnum" minOccurs="0"/>
 *         &lt;element name="SalesChannel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrderChannel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShipServiceLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShippingAddress" type="{https://mws.amazonservices.com/Orders/2011-01-01}Address" minOccurs="0"/>
 *         &lt;element name="OrderTotal" type="{https://mws.amazonservices.com/Orders/2011-01-01}Money" minOccurs="0"/>
 *         &lt;element name="NumberOfItemsShipped" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="NumberOfItemsUnshipped" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="PaymentExecutionDetail" type="{https://mws.amazonservices.com/Orders/2011-01-01}PaymentExecutionDetailItemList" minOccurs="0"/>
 *         &lt;element name="PaymentMethod" type="{https://mws.amazonservices.com/Orders/2011-01-01}PaymentMethodEnum" minOccurs="0"/>
 *         &lt;element name="MarketplaceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BuyerEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BuyerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShipmentServiceLevelCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShippedByAmazonTFM" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="TFMShipmentStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CbaDisplayableShippingLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrderType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EarliestShipDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="LatestShipDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Order", propOrder = {
    "amazonOrderId",
    "sellerOrderId",
    "purchaseDate",
    "lastUpdateDate",
    "orderStatus",
    "fulfillmentChannel",
    "salesChannel",
    "orderChannel",
    "shipServiceLevel",
    "shippingAddress",
    "orderTotal",
    "numberOfItemsShipped",
    "numberOfItemsUnshipped",
    "paymentExecutionDetail",
    "paymentMethod",
    "marketplaceId",
    "buyerEmail",
    "buyerName",
    "shipmentServiceLevelCategory",
    "shippedByAmazonTFM",
    "tfmShipmentStatus",
    "cbaDisplayableShippingLabel",
    "orderType",
    "earliestShipDate",
    "latestShipDate"
})
public class Order {

    @XmlElement(name = "AmazonOrderId", required = true)
    protected String amazonOrderId;
    @XmlElement(name = "SellerOrderId")
    protected String sellerOrderId;
    @XmlElement(name = "PurchaseDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar purchaseDate;
    @XmlElement(name = "LastUpdateDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdateDate;
    @XmlElement(name = "OrderStatus", required = true)
    protected OrderStatusEnum orderStatus;
    @XmlElement(name = "FulfillmentChannel")
    protected FulfillmentChannelEnum fulfillmentChannel;
    @XmlElement(name = "SalesChannel")
    protected String salesChannel;
    @XmlElement(name = "OrderChannel")
    protected String orderChannel;
    @XmlElement(name = "ShipServiceLevel")
    protected String shipServiceLevel;
    @XmlElement(name = "ShippingAddress")
    protected Address shippingAddress;
    @XmlElement(name = "OrderTotal")
    protected Money orderTotal;
    @XmlElement(name = "NumberOfItemsShipped")
    protected Integer numberOfItemsShipped;
    @XmlElement(name = "NumberOfItemsUnshipped")
    protected Integer numberOfItemsUnshipped;
    @XmlElement(name = "PaymentExecutionDetail")
    protected PaymentExecutionDetailItemList paymentExecutionDetail;
    @XmlElement(name = "PaymentMethod")
    protected PaymentMethodEnum paymentMethod;
    @XmlElement(name = "MarketplaceId")
    protected String marketplaceId;
    @XmlElement(name = "BuyerEmail")
    protected String buyerEmail;
    @XmlElement(name = "BuyerName")
    protected String buyerName;
    @XmlElement(name = "ShipmentServiceLevelCategory")
    protected String shipmentServiceLevelCategory;
    @XmlElement(name = "ShippedByAmazonTFM")
    protected Boolean shippedByAmazonTFM;
    @XmlElement(name = "TFMShipmentStatus")
    protected String tfmShipmentStatus;
    @XmlElement(name = "CbaDisplayableShippingLabel")
    protected String cbaDisplayableShippingLabel;    
    @XmlElement(name = "OrderType")
    protected String orderType;
    @XmlElement(name = "EarliestShipDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar earliestShipDate;
    @XmlElement(name = "LatestShipDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar latestShipDate;
    

    /**
     * Default constructor
     * 
     */
    public Order() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public Order(final String amazonOrderId, final String sellerOrderId, final XMLGregorianCalendar purchaseDate, final XMLGregorianCalendar lastUpdateDate, final OrderStatusEnum orderStatus, final FulfillmentChannelEnum fulfillmentChannel, final String salesChannel, final String orderChannel, final String shipServiceLevel, final Address shippingAddress, final Money orderTotal, final Integer numberOfItemsShipped, final Integer numberOfItemsUnshipped, final PaymentExecutionDetailItemList paymentExecutionDetail, final PaymentMethodEnum paymentMethod, final String marketplaceId, final String buyerEmail, final String buyerName, final String shipmentServiceLevelCategory, final Boolean shippedByAmazonTFM, final String tfmShipmentStatus) {
        this.amazonOrderId = amazonOrderId;
        this.sellerOrderId = sellerOrderId;
        this.purchaseDate = purchaseDate;
        this.lastUpdateDate = lastUpdateDate;
        this.orderStatus = orderStatus;
        this.fulfillmentChannel = fulfillmentChannel;
        this.salesChannel = salesChannel;
        this.orderChannel = orderChannel;
        this.shipServiceLevel = shipServiceLevel;
        this.shippingAddress = shippingAddress;
        this.orderTotal = orderTotal;
        this.numberOfItemsShipped = numberOfItemsShipped;
        this.numberOfItemsUnshipped = numberOfItemsUnshipped;
        this.paymentExecutionDetail = paymentExecutionDetail;
        this.paymentMethod = paymentMethod;
        this.marketplaceId = marketplaceId;
        this.buyerEmail = buyerEmail;
        this.buyerName = buyerName;
        this.shipmentServiceLevelCategory = shipmentServiceLevelCategory;
        this.shippedByAmazonTFM = shippedByAmazonTFM;
        this.tfmShipmentStatus = tfmShipmentStatus;
    }

    /**
     * Gets the value of the amazonOrderId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmazonOrderId() {
        return amazonOrderId;
    }

    /**
     * Sets the value of the amazonOrderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmazonOrderId(String value) {
        this.amazonOrderId = value;
    }

    public boolean isSetAmazonOrderId() {
        return (this.amazonOrderId!= null);
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
     * Gets the value of the purchaseDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * Sets the value of the purchaseDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPurchaseDate(XMLGregorianCalendar value) {
        this.purchaseDate = value;
    }

    public boolean isSetPurchaseDate() {
        return (this.purchaseDate!= null);
    }

    /**
     * Gets the value of the lastUpdateDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * Sets the value of the lastUpdateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastUpdateDate(XMLGregorianCalendar value) {
        this.lastUpdateDate = value;
    }

    public boolean isSetLastUpdateDate() {
        return (this.lastUpdateDate!= null);
    }

    /**
     * Gets the value of the orderStatus property.
     * 
     * @return
     *     possible object is
     *     {@link OrderStatusEnum }
     *     
     */
    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    /**
     * Sets the value of the orderStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderStatusEnum }
     *     
     */
    public void setOrderStatus(OrderStatusEnum value) {
        this.orderStatus = value;
    }

    public boolean isSetOrderStatus() {
        return (this.orderStatus!= null);
    }

    /**
     * Gets the value of the fulfillmentChannel property.
     * 
     * @return
     *     possible object is
     *     {@link FulfillmentChannelEnum }
     *     
     */
    public FulfillmentChannelEnum getFulfillmentChannel() {
        return fulfillmentChannel;
    }

    /**
     * Sets the value of the fulfillmentChannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link FulfillmentChannelEnum }
     *     
     */
    public void setFulfillmentChannel(FulfillmentChannelEnum value) {
        this.fulfillmentChannel = value;
    }

    public boolean isSetFulfillmentChannel() {
        return (this.fulfillmentChannel!= null);
    }

    /**
     * Gets the value of the salesChannel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSalesChannel() {
        return salesChannel;
    }

    /**
     * Sets the value of the salesChannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalesChannel(String value) {
        this.salesChannel = value;
    }

    public boolean isSetSalesChannel() {
        return (this.salesChannel!= null);
    }

    /**
     * Gets the value of the orderChannel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderChannel() {
        return orderChannel;
    }

    /**
     * Sets the value of the orderChannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderChannel(String value) {
        this.orderChannel = value;
    }

    public boolean isSetOrderChannel() {
        return (this.orderChannel!= null);
    }

    /**
     * Gets the value of the shipServiceLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipServiceLevel() {
        return shipServiceLevel;
    }

    /**
     * Sets the value of the shipServiceLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipServiceLevel(String value) {
        this.shipServiceLevel = value;
    }

    public boolean isSetShipServiceLevel() {
        return (this.shipServiceLevel!= null);
    }

    /**
     * Gets the value of the shippingAddress property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Sets the value of the shippingAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setShippingAddress(Address value) {
        this.shippingAddress = value;
    }

    public boolean isSetShippingAddress() {
        return (this.shippingAddress!= null);
    }

    /**
     * Gets the value of the orderTotal property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getOrderTotal() {
        return orderTotal;
    }

    /**
     * Sets the value of the orderTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setOrderTotal(Money value) {
        this.orderTotal = value;
    }

    public boolean isSetOrderTotal() {
        return (this.orderTotal!= null);
    }

    /**
     * Gets the value of the numberOfItemsShipped property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberOfItemsShipped() {
        return numberOfItemsShipped;
    }

    /**
     * Sets the value of the numberOfItemsShipped property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberOfItemsShipped(Integer value) {
        this.numberOfItemsShipped = value;
    }

    public boolean isSetNumberOfItemsShipped() {
        return (this.numberOfItemsShipped!= null);
    }

    /**
     * Gets the value of the numberOfItemsUnshipped property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberOfItemsUnshipped() {
        return numberOfItemsUnshipped;
    }

    /**
     * Sets the value of the numberOfItemsUnshipped property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberOfItemsUnshipped(Integer value) {
        this.numberOfItemsUnshipped = value;
    }

    public boolean isSetNumberOfItemsUnshipped() {
        return (this.numberOfItemsUnshipped!= null);
    }

    /**
     * Gets the value of the paymentExecutionDetail property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentExecutionDetailItemList }
     *     
     */
    public PaymentExecutionDetailItemList getPaymentExecutionDetail() {
        return paymentExecutionDetail;
    }

    /**
     * Sets the value of the paymentExecutionDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentExecutionDetailItemList }
     *     
     */
    public void setPaymentExecutionDetail(PaymentExecutionDetailItemList value) {
        this.paymentExecutionDetail = value;
    }

    public boolean isSetPaymentExecutionDetail() {
        return (this.paymentExecutionDetail!= null);
    }

    /**
     * Gets the value of the paymentMethod property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentMethodEnum }
     *     
     */
    public PaymentMethodEnum getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the value of the paymentMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMethodEnum }
     *     
     */
    public void setPaymentMethod(PaymentMethodEnum value) {
        this.paymentMethod = value;
    }

    public boolean isSetPaymentMethod() {
        return (this.paymentMethod!= null);
    }

    /**
     * Gets the value of the marketplaceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarketplaceId() {
        return marketplaceId;
    }

    /**
     * Sets the value of the marketplaceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarketplaceId(String value) {
        this.marketplaceId = value;
    }

    public boolean isSetMarketplaceId() {
        return (this.marketplaceId!= null);
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
     * Gets the value of the buyerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuyerName() {
        return buyerName;
    }

    /**
     * Sets the value of the buyerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuyerName(String value) {
        this.buyerName = value;
    }

    public boolean isSetBuyerName() {
        return (this.buyerName!= null);
    }

    /**
     * Gets the value of the shipmentServiceLevelCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipmentServiceLevelCategory() {
        return shipmentServiceLevelCategory;
    }

    /**
     * Sets the value of the shipmentServiceLevelCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipmentServiceLevelCategory(String value) {
        this.shipmentServiceLevelCategory = value;
    }

    public boolean isSetShipmentServiceLevelCategory() {
        return (this.shipmentServiceLevelCategory!= null);
    }

    /**
     * Gets the value of the shippedByAmazonTFM property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShippedByAmazonTFM() {
        return shippedByAmazonTFM;
    }

    /**
     * Sets the value of the shippedByAmazonTFM property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShippedByAmazonTFM(Boolean value) {
        this.shippedByAmazonTFM = value;
    }

    public boolean isSetShippedByAmazonTFM() {
        return (this.shippedByAmazonTFM!= null);
    }

    /**
     * Gets the value of the tfmShipmentStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTFMShipmentStatus() {
        return tfmShipmentStatus;
    }

    /**
     * Sets the value of the tfmShipmentStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTFMShipmentStatus(String value) {
        this.tfmShipmentStatus = value;
    }

    public boolean isSetTFMShipmentStatus() {
        return (this.tfmShipmentStatus!= null);
    }

    /**
     * Sets the value of the AmazonOrderId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Order withAmazonOrderId(String value) {
        setAmazonOrderId(value);
        return this;
    }

    /**
     * Sets the value of the SellerOrderId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Order withSellerOrderId(String value) {
        setSellerOrderId(value);
        return this;
    }

    /**
     * Sets the value of the PurchaseDate property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Order withPurchaseDate(XMLGregorianCalendar value) {
        setPurchaseDate(value);
        return this;
    }

    /**
     * Sets the value of the LastUpdateDate property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Order withLastUpdateDate(XMLGregorianCalendar value) {
        setLastUpdateDate(value);
        return this;
    }

    /**
     * Sets the value of the OrderStatus property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Order withOrderStatus(OrderStatusEnum value) {
        setOrderStatus(value);
        return this;
    }

    /**
     * Sets the value of the FulfillmentChannel property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Order withFulfillmentChannel(FulfillmentChannelEnum value) {
        setFulfillmentChannel(value);
        return this;
    }

    /**
     * Sets the value of the SalesChannel property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Order withSalesChannel(String value) {
        setSalesChannel(value);
        return this;
    }

    /**
     * Sets the value of the OrderChannel property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Order withOrderChannel(String value) {
        setOrderChannel(value);
        return this;
    }

    /**
     * Sets the value of the ShipServiceLevel property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Order withShipServiceLevel(String value) {
        setShipServiceLevel(value);
        return this;
    }

    /**
     * Sets the value of the ShippingAddress property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Order withShippingAddress(Address value) {
        setShippingAddress(value);
        return this;
    }

    /**
     * Sets the value of the OrderTotal property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Order withOrderTotal(Money value) {
        setOrderTotal(value);
        return this;
    }

    /**
     * Sets the value of the NumberOfItemsShipped property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Order withNumberOfItemsShipped(Integer value) {
        setNumberOfItemsShipped(value);
        return this;
    }

    /**
     * Sets the value of the NumberOfItemsUnshipped property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Order withNumberOfItemsUnshipped(Integer value) {
        setNumberOfItemsUnshipped(value);
        return this;
    }

    /**
     * Sets the value of the PaymentExecutionDetail property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Order withPaymentExecutionDetail(PaymentExecutionDetailItemList value) {
        setPaymentExecutionDetail(value);
        return this;
    }

    /**
     * Sets the value of the PaymentMethod property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Order withPaymentMethod(PaymentMethodEnum value) {
        setPaymentMethod(value);
        return this;
    }

    /**
     * Sets the value of the MarketplaceId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Order withMarketplaceId(String value) {
        setMarketplaceId(value);
        return this;
    }

    /**
     * Sets the value of the BuyerEmail property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Order withBuyerEmail(String value) {
        setBuyerEmail(value);
        return this;
    }

    /**
     * Sets the value of the BuyerName property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Order withBuyerName(String value) {
        setBuyerName(value);
        return this;
    }

    /**
     * Sets the value of the ShipmentServiceLevelCategory property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Order withShipmentServiceLevelCategory(String value) {
        setShipmentServiceLevelCategory(value);
        return this;
    }

    /**
     * Sets the value of the ShippedByAmazonTFM property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Order withShippedByAmazonTFM(Boolean value) {
        setShippedByAmazonTFM(value);
        return this;
    }

    /**
     * Sets the value of the TFMShipmentStatus property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Order withTFMShipmentStatus(String value) {
        setTFMShipmentStatus(value);
        return this;
    }
    
    /**
     * Get the value of the CbaDisplayableShippingLabel property.
     * 
     * @return CbaDisplayableShippingLabel.
     */
    public String getCbaDisplayableShippingLabel() {
    	return cbaDisplayableShippingLabel;
    }
    
    /**
     * Set the value of the CbaDisplayableShippingLabel property.
     * 
     * @param value
     */
    public void setCbaDisplayableShippingLabel(String value) {
    	this.cbaDisplayableShippingLabel = value;
    }
    
    /**
     * Check to see if CbaDisplayableShippingLabel is set.
     * 
     * @return true if set.
     */
    public boolean isSetCbaDisplayableShippingLabel() {
    	return cbaDisplayableShippingLabel!=null;
    }
    
    /**
     * Set the value of the CbaDisplayableShippingLabel property.
     * 
     * @param value
     * 
     * @return this
     */
    public Order withCbaDisplayableShippingLabel(String value) {
    	this.cbaDisplayableShippingLabel = value;
    	return this;
    }
    
    /**
     * Get the value of the OrderType property.
     * 
     * @return OrderType
     */
    public String getOrderType() {
    	return orderType;
    }
    
    /**
     * Set the value of the OrderType property.
     * 
     * @param value
     */
    public void setOrderType(String value) {
    	this.orderType = value;
    }
    
    /**
     * Check to see if OrderType is set.
     * 
     * @return true if set.
     */
    public boolean isSetOrderType() {
    	return orderType!=null;
    }
    
    /**
     * Set the value of the OrderType property.
     * 
     * @param value
     * 
     * @return this
     */
    public Order withOrderType(String value) {
    	this.orderType = value;
    	return this;
    }
    
    /**
     * Get the value of the EarliestShipDate property.
     * 
     * @return EarliestShipDate
     */
    public XMLGregorianCalendar getEarliestShipDate() {
    	return earliestShipDate;
    }
    
    /**
     * Set the value of the EarliestShipDate property.
     * 
     * @param value
     */
    public void setEarliestShipDate(XMLGregorianCalendar value) {
    	this.earliestShipDate = value;
    }
    
    /**
     * Check to see if EarliestShipDate is set.
     * 
     * @return true if set.
     */
    public boolean isSetEarliestShipDate() {
    	return earliestShipDate!=null;
    }
    
    /**
     * Set the value of the EarliestShipDate property.
     * 
     * @param value
     * 
     * @return this
     */
    public Order withEarliestShipDate(XMLGregorianCalendar value) {
    	this.earliestShipDate = value;
    	return this;
    }
    
    /**
     * Get the value of the LatestShipDate property.
     * 
     * @return LatestShipDate
     */
    public XMLGregorianCalendar getLatestShipDate() {
    	return latestShipDate;
    }
    
    /**
     * Set the value of the LatestShipDate property.
     * 
     * @param value
     */
    public void setLatestShipDate(XMLGregorianCalendar value) {
    	this.latestShipDate = value;
    }
    
    /**
     * Check to see if LatestShipDate is set.
     * 
     * @return true if set.
     */
    public boolean isSetLatestShipDate() {
    	return latestShipDate!=null;
    }
    
    /**
     * Set the value of the LatestShipDate property.
     * 
     * @param value
     * 
     * @return this
     */
    public Order withLatestShipDate(XMLGregorianCalendar value) {
    	this.latestShipDate = value;
    	return this;
    }
   
    /**
     * 
     * XML fragment representation of this object
     * 
     * @return XML fragment for this object. Name for outer
     * tag expected to be set by calling method. This fragment
     * returns inner properties representation only
     */
    public String toXMLFragment() {
        StringBuffer xml = new StringBuffer();
        if (isSetAmazonOrderId()) {
            xml.append("<AmazonOrderId>");
            xml.append(escapeXML(getAmazonOrderId()));
            xml.append("</AmazonOrderId>");
        }
        if (isSetSellerOrderId()) {
            xml.append("<SellerOrderId>");
            xml.append(escapeXML(getSellerOrderId()));
            xml.append("</SellerOrderId>");
        }
        if (isSetPurchaseDate()) {
            xml.append("<PurchaseDate>");
            xml.append(getPurchaseDate() + "");
            xml.append("</PurchaseDate>");
        }
        if (isSetLastUpdateDate()) {
            xml.append("<LastUpdateDate>");
            xml.append(getLastUpdateDate() + "");
            xml.append("</LastUpdateDate>");
        }
        if (isSetOrderStatus()) {
            xml.append("<OrderStatus>");
            xml.append(getOrderStatus().value());
            xml.append("</OrderStatus>");
        }
        if (isSetFulfillmentChannel()) {
            xml.append("<FulfillmentChannel>");
            xml.append(getFulfillmentChannel().value());
            xml.append("</FulfillmentChannel>");
        }
        if (isSetSalesChannel()) {
            xml.append("<SalesChannel>");
            xml.append(escapeXML(getSalesChannel()));
            xml.append("</SalesChannel>");
        }
        if (isSetOrderChannel()) {
            xml.append("<OrderChannel>");
            xml.append(escapeXML(getOrderChannel()));
            xml.append("</OrderChannel>");
        }
        if (isSetShipServiceLevel()) {
            xml.append("<ShipServiceLevel>");
            xml.append(escapeXML(getShipServiceLevel()));
            xml.append("</ShipServiceLevel>");
        }
        if (isSetShippingAddress()) {
            Address  shippingAddress = getShippingAddress();
            xml.append("<ShippingAddress>");
            xml.append(shippingAddress.toXMLFragment());
            xml.append("</ShippingAddress>");
        } 
        if (isSetOrderTotal()) {
            Money  orderTotal = getOrderTotal();
            xml.append("<OrderTotal>");
            xml.append(orderTotal.toXMLFragment());
            xml.append("</OrderTotal>");
        } 
        if (isSetNumberOfItemsShipped()) {
            xml.append("<NumberOfItemsShipped>");
            xml.append(getNumberOfItemsShipped() + "");
            xml.append("</NumberOfItemsShipped>");
        }
        if (isSetNumberOfItemsUnshipped()) {
            xml.append("<NumberOfItemsUnshipped>");
            xml.append(getNumberOfItemsUnshipped() + "");
            xml.append("</NumberOfItemsUnshipped>");
        }
        if (isSetPaymentExecutionDetail()) {
            PaymentExecutionDetailItemList  paymentExecutionDetail = getPaymentExecutionDetail();
            xml.append("<PaymentExecutionDetail>");
            xml.append(paymentExecutionDetail.toXMLFragment());
            xml.append("</PaymentExecutionDetail>");
        } 
        if (isSetPaymentMethod()) {
            xml.append("<PaymentMethod>");
            xml.append(getPaymentMethod().value());
            xml.append("</PaymentMethod>");
        }
        if (isSetMarketplaceId()) {
            xml.append("<MarketplaceId>");
            xml.append(escapeXML(getMarketplaceId()));
            xml.append("</MarketplaceId>");
        }
        if (isSetBuyerEmail()) {
            xml.append("<BuyerEmail>");
            xml.append(escapeXML(getBuyerEmail()));
            xml.append("</BuyerEmail>");
        }
        if (isSetBuyerName()) {
            xml.append("<BuyerName>");
            xml.append(escapeXML(getBuyerName()));
            xml.append("</BuyerName>");
        }
        if (isSetShipmentServiceLevelCategory()) {
            xml.append("<ShipmentServiceLevelCategory>");
            xml.append(escapeXML(getShipmentServiceLevelCategory()));
            xml.append("</ShipmentServiceLevelCategory>");
        }
        if (isSetShippedByAmazonTFM()) {
            xml.append("<ShippedByAmazonTFM>");
            xml.append(isShippedByAmazonTFM() + "");
            xml.append("</ShippedByAmazonTFM>");
        }
        if (isSetTFMShipmentStatus()) {
            xml.append("<TFMShipmentStatus>");
            xml.append(escapeXML(getTFMShipmentStatus()));
            xml.append("</TFMShipmentStatus>");
        }
        if (isSetCbaDisplayableShippingLabel()) {
        	xml.append("<CbaDisplayableShippingLabel>");
        	xml.append(escapeXML(cbaDisplayableShippingLabel));
        	xml.append("</CbaDisplayableShippingLabel>");
        }
        if (isSetOrderType()) {
        	xml.append("<OrderType>");
        	xml.append(escapeXML(orderType));
        	xml.append("</OrderType>");
        }
        if (isSetEarliestShipDate()) {
        	xml.append("<EarliestShipDate>");
        	xml.append(escapeXML(earliestShipDate+""));
        	xml.append("</EarliestShipDate>");
        }
        if (isSetLatestShipDate()) {
        	xml.append("<LatestShipDate>");
        	xml.append(escapeXML(latestShipDate+""));
        	xml.append("</LatestShipDate>");
        }
        return xml.toString();
    }

    /**
     * 
     * Escape XML special characters
     */
    private String escapeXML(String string) {
        if (string == null)
            return "null";
        StringBuffer sb = new StringBuffer();
        int length = string.length();
        for (int i = 0; i < length; ++i) {
            char c = string.charAt(i);
            switch (c) {
            case '&':
                sb.append("&amp;");
                break;
            case '<':
                sb.append("&lt;");
                break;
            case '>':
                sb.append("&gt;");
                break;
            case '\'':
                sb.append("&#039;");
                break;
            case '"':
                sb.append("&quot;");
                break;
            default:
                sb.append(c);
            }
        }
        return sb.toString();
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
        if (isSetAmazonOrderId()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("AmazonOrderId"));
            json.append(" : ");
            json.append(quoteJSON(getAmazonOrderId()));
            first = false;
        }
        if (isSetSellerOrderId()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("SellerOrderId"));
            json.append(" : ");
            json.append(quoteJSON(getSellerOrderId()));
            first = false;
        }
        if (isSetPurchaseDate()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("PurchaseDate"));
            json.append(" : ");
            json.append(quoteJSON(getPurchaseDate() + ""));
            first = false;
        }
        if (isSetLastUpdateDate()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("LastUpdateDate"));
            json.append(" : ");
            json.append(quoteJSON(getLastUpdateDate() + ""));
            first = false;
        }
        if (isSetOrderStatus()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("OrderStatus"));
            json.append(" : ");
            json.append(quoteJSON(getOrderStatus().value()));
            first = false;
        }
        if (isSetFulfillmentChannel()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("FulfillmentChannel"));
            json.append(" : ");
            json.append(quoteJSON(getFulfillmentChannel().value()));
            first = false;
        }
        if (isSetSalesChannel()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("SalesChannel"));
            json.append(" : ");
            json.append(quoteJSON(getSalesChannel()));
            first = false;
        }
        if (isSetOrderChannel()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("OrderChannel"));
            json.append(" : ");
            json.append(quoteJSON(getOrderChannel()));
            first = false;
        }
        if (isSetShipServiceLevel()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("ShipServiceLevel"));
            json.append(" : ");
            json.append(quoteJSON(getShipServiceLevel()));
            first = false;
        }
        if (isSetShippingAddress()) {
            if (!first) json.append(", ");
            json.append("\"ShippingAddress\" : {");
            Address  shippingAddress = getShippingAddress();


            json.append(shippingAddress.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetOrderTotal()) {
            if (!first) json.append(", ");
            json.append("\"OrderTotal\" : {");
            Money  orderTotal = getOrderTotal();


            json.append(orderTotal.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetNumberOfItemsShipped()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("NumberOfItemsShipped"));
            json.append(" : ");
            json.append(quoteJSON(getNumberOfItemsShipped() + ""));
            first = false;
        }
        if (isSetNumberOfItemsUnshipped()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("NumberOfItemsUnshipped"));
            json.append(" : ");
            json.append(quoteJSON(getNumberOfItemsUnshipped() + ""));
            first = false;
        }
        if (isSetPaymentExecutionDetail()) {
            if (!first) json.append(", ");
            json.append("\"PaymentExecutionDetail\" : {");
            PaymentExecutionDetailItemList  paymentExecutionDetail = getPaymentExecutionDetail();


            json.append(paymentExecutionDetail.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetPaymentMethod()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("PaymentMethod"));
            json.append(" : ");
            json.append(quoteJSON(getPaymentMethod().value()));
            first = false;
        }
        if (isSetMarketplaceId()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("MarketplaceId"));
            json.append(" : ");
            json.append(quoteJSON(getMarketplaceId()));
            first = false;
        }
        if (isSetBuyerEmail()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("BuyerEmail"));
            json.append(" : ");
            json.append(quoteJSON(getBuyerEmail()));
            first = false;
        }
        if (isSetBuyerName()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("BuyerName"));
            json.append(" : ");
            json.append(quoteJSON(getBuyerName()));
            first = false;
        }
        if (isSetShipmentServiceLevelCategory()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("ShipmentServiceLevelCategory"));
            json.append(" : ");
            json.append(quoteJSON(getShipmentServiceLevelCategory()));
            first = false;
        }
        if (isSetShippedByAmazonTFM()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("ShippedByAmazonTFM"));
            json.append(" : ");
            json.append(quoteJSON(isShippedByAmazonTFM() + ""));
            first = false;
        }
        if (isSetTFMShipmentStatus()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("TFMShipmentStatus"));
            json.append(" : ");
            json.append(quoteJSON(getTFMShipmentStatus()));
            first = false;
        }
        if (isSetCbaDisplayableShippingLabel()) {
            if (!first) json.append(", ");
        	json.append(quoteJSON("CbaDisplayableShippingLabel"));
        	json.append(" : ");
        	json.append(quoteJSON(cbaDisplayableShippingLabel));
        	first = false;
        }
        if (isSetOrderType()) {
            if (!first) json.append(", ");
        	json.append(quoteJSON("OrderType"));
        	json.append(" : ");
        	json.append(quoteJSON(orderType));
        	first = false;
        }
        if (isSetEarliestShipDate()) {
            if (!first) json.append(", ");
        	json.append(quoteJSON("EarliestShipDate"));
        	json.append(" : ");
        	json.append(quoteJSON(earliestShipDate+""));
        	first = false;
        }
        if (isSetLatestShipDate()) {
            if (!first) json.append(", ");
        	json.append(quoteJSON("LatestShipDate"));
        	json.append(" : ");
        	json.append(quoteJSON(latestShipDate+""));
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
