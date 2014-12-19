
package API.amazon.mws.orders.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrderItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrderItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ASIN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SellerSKU" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrderItemId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="QuantityOrdered" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="QuantityShipped" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ItemPrice" type="{https://mws.amazonservices.com/Orders/2011-01-01}Money" minOccurs="0"/>
 *         &lt;element name="ShippingPrice" type="{https://mws.amazonservices.com/Orders/2011-01-01}Money" minOccurs="0"/>
 *         &lt;element name="GiftWrapPrice" type="{https://mws.amazonservices.com/Orders/2011-01-01}Money" minOccurs="0"/>
 *         &lt;element name="ItemTax" type="{https://mws.amazonservices.com/Orders/2011-01-01}Money" minOccurs="0"/>
 *         &lt;element name="ShippingTax" type="{https://mws.amazonservices.com/Orders/2011-01-01}Money" minOccurs="0"/>
 *         &lt;element name="GiftWrapTax" type="{https://mws.amazonservices.com/Orders/2011-01-01}Money" minOccurs="0"/>
 *         &lt;element name="ShippingDiscount" type="{https://mws.amazonservices.com/Orders/2011-01-01}Money" minOccurs="0"/>
 *         &lt;element name="PromotionDiscount" type="{https://mws.amazonservices.com/Orders/2011-01-01}Money" minOccurs="0"/>
 *         &lt;element name="PromotionIds" type="{https://mws.amazonservices.com/Orders/2011-01-01}PromotionIdList" minOccurs="0"/>
 *         &lt;element name="CODFee" type="{https://mws.amazonservices.com/Orders/2011-01-01}Money" minOccurs="0"/>
 *         &lt;element name="CODFeeDiscount" type="{https://mws.amazonservices.com/Orders/2011-01-01}Money" minOccurs="0"/>
 *         &lt;element name="GiftMessageText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GiftWrapLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InvoiceData" type="{https://mws.amazonservices.com/Orders/2011-01-01}InvoiceData" minOccurs="0"/>
 *         &lt;element name="ConditionNote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConditionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConditionSubtypeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ScheduledDeliveryStartDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ScheduledDeliveryEndDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderItem", propOrder = {
    "asin",
    "sellerSKU",
    "orderItemId",
    "title",
    "quantityOrdered",
    "quantityShipped",
    "itemPrice",
    "shippingPrice",
    "giftWrapPrice",
    "itemTax",
    "shippingTax",
    "giftWrapTax",
    "shippingDiscount",
    "promotionDiscount",
    "promotionIds",
    "codFee",
    "codFeeDiscount",
    "giftMessageText",
    "giftWrapLevel",
    "invoiceData",
    "conditionNote",
    "conditionId",
    "conditionSubtypeId",
    "scheduledDeliveryStartDate",
    "scheduledDeliveryEndDate"
})
public class OrderItem {

    @XmlElement(name = "ASIN", required = true)
    protected String asin;
    @XmlElement(name = "SellerSKU")
    protected String sellerSKU;
    @XmlElement(name = "OrderItemId", required = true)
    protected String orderItemId;
    @XmlElement(name = "Title")
    protected String title;
    @XmlElement(name = "QuantityOrdered")
    protected int quantityOrdered;
    @XmlElement(name = "QuantityShipped")
    protected Integer quantityShipped;
    @XmlElement(name = "ItemPrice")
    protected Money itemPrice;
    @XmlElement(name = "ShippingPrice")
    protected Money shippingPrice;
    @XmlElement(name = "GiftWrapPrice")
    protected Money giftWrapPrice;
    @XmlElement(name = "ItemTax")
    protected Money itemTax;
    @XmlElement(name = "ShippingTax")
    protected Money shippingTax;
    @XmlElement(name = "GiftWrapTax")
    protected Money giftWrapTax;
    @XmlElement(name = "ShippingDiscount")
    protected Money shippingDiscount;
    @XmlElement(name = "PromotionDiscount")
    protected Money promotionDiscount;
    @XmlElement(name = "PromotionIds")
    protected PromotionIdList promotionIds;
    @XmlElement(name = "CODFee")
    protected Money codFee;
    @XmlElement(name = "CODFeeDiscount")
    protected Money codFeeDiscount;
    @XmlElement(name = "GiftMessageText")
    protected String giftMessageText;
    @XmlElement(name = "GiftWrapLevel")
    protected String giftWrapLevel;
    @XmlElement(name = "InvoiceData")
    protected InvoiceData invoiceData;
    @XmlElement(name = "ConditionNote")
    protected String conditionNote;
    @XmlElement(name = "ConditionId")
    protected String conditionId;
    @XmlElement(name = "ConditionSubtypeId")
    protected String conditionSubtypeId;
    @XmlElement(name = "ScheduledDeliveryStartDate")
    protected String scheduledDeliveryStartDate;
    @XmlElement(name = "ScheduledDeliveryEndDate")
    protected String scheduledDeliveryEndDate;

    /**
     * Default constructor
     * 
     */
    public OrderItem() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public OrderItem(final String asin, final String sellerSKU, final String orderItemId, final String title, final int quantityOrdered, final Integer quantityShipped, final Money itemPrice, final Money shippingPrice, final Money giftWrapPrice, final Money itemTax, final Money shippingTax, final Money giftWrapTax, final Money shippingDiscount, final Money promotionDiscount, final PromotionIdList promotionIds, final Money codFee, final Money codFeeDiscount, final String giftMessageText, final String giftWrapLevel, final InvoiceData invoiceData) {
        this.asin = asin;
        this.sellerSKU = sellerSKU;
        this.orderItemId = orderItemId;
        this.title = title;
        this.quantityOrdered = quantityOrdered;
        this.quantityShipped = quantityShipped;
        this.itemPrice = itemPrice;
        this.shippingPrice = shippingPrice;
        this.giftWrapPrice = giftWrapPrice;
        this.itemTax = itemTax;
        this.shippingTax = shippingTax;
        this.giftWrapTax = giftWrapTax;
        this.shippingDiscount = shippingDiscount;
        this.promotionDiscount = promotionDiscount;
        this.promotionIds = promotionIds;
        this.codFee = codFee;
        this.codFeeDiscount = codFeeDiscount;
        this.giftMessageText = giftMessageText;
        this.giftWrapLevel = giftWrapLevel;
        this.invoiceData = invoiceData;
    }

    /**
     * Gets the value of the asin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getASIN() {
        return asin;
    }

    /**
     * Sets the value of the asin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setASIN(String value) {
        this.asin = value;
    }

    public boolean isSetASIN() {
        return (this.asin!= null);
    }

    /**
     * Gets the value of the sellerSKU property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSellerSKU() {
        return sellerSKU;
    }

    /**
     * Sets the value of the sellerSKU property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellerSKU(String value) {
        this.sellerSKU = value;
    }

    public boolean isSetSellerSKU() {
        return (this.sellerSKU!= null);
    }

    /**
     * Gets the value of the orderItemId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderItemId() {
        return orderItemId;
    }

    /**
     * Sets the value of the orderItemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderItemId(String value) {
        this.orderItemId = value;
    }

    public boolean isSetOrderItemId() {
        return (this.orderItemId!= null);
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    public boolean isSetTitle() {
        return (this.title!= null);
    }

    /**
     * Gets the value of the quantityOrdered property.
     * 
     */
    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    /**
     * Sets the value of the quantityOrdered property.
     * 
     */
    public void setQuantityOrdered(int value) {
        this.quantityOrdered = value;
    }

    public boolean isSetQuantityOrdered() {
        return true;
    }

    /**
     * Gets the value of the quantityShipped property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuantityShipped() {
        return quantityShipped;
    }

    /**
     * Sets the value of the quantityShipped property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuantityShipped(Integer value) {
        this.quantityShipped = value;
    }

    public boolean isSetQuantityShipped() {
        return (this.quantityShipped!= null);
    }

    /**
     * Gets the value of the itemPrice property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getItemPrice() {
        return itemPrice;
    }

    /**
     * Sets the value of the itemPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setItemPrice(Money value) {
        this.itemPrice = value;
    }

    public boolean isSetItemPrice() {
        return (this.itemPrice!= null);
    }

    /**
     * Gets the value of the shippingPrice property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getShippingPrice() {
        return shippingPrice;
    }

    /**
     * Sets the value of the shippingPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setShippingPrice(Money value) {
        this.shippingPrice = value;
    }

    public boolean isSetShippingPrice() {
        return (this.shippingPrice!= null);
    }

    /**
     * Gets the value of the giftWrapPrice property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getGiftWrapPrice() {
        return giftWrapPrice;
    }

    /**
     * Sets the value of the giftWrapPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setGiftWrapPrice(Money value) {
        this.giftWrapPrice = value;
    }

    public boolean isSetGiftWrapPrice() {
        return (this.giftWrapPrice!= null);
    }

    /**
     * Gets the value of the itemTax property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getItemTax() {
        return itemTax;
    }

    /**
     * Sets the value of the itemTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setItemTax(Money value) {
        this.itemTax = value;
    }

    public boolean isSetItemTax() {
        return (this.itemTax!= null);
    }

    /**
     * Gets the value of the shippingTax property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getShippingTax() {
        return shippingTax;
    }

    /**
     * Sets the value of the shippingTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setShippingTax(Money value) {
        this.shippingTax = value;
    }

    public boolean isSetShippingTax() {
        return (this.shippingTax!= null);
    }

    /**
     * Gets the value of the giftWrapTax property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getGiftWrapTax() {
        return giftWrapTax;
    }

    /**
     * Sets the value of the giftWrapTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setGiftWrapTax(Money value) {
        this.giftWrapTax = value;
    }

    public boolean isSetGiftWrapTax() {
        return (this.giftWrapTax!= null);
    }

    /**
     * Gets the value of the shippingDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getShippingDiscount() {
        return shippingDiscount;
    }

    /**
     * Sets the value of the shippingDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setShippingDiscount(Money value) {
        this.shippingDiscount = value;
    }

    public boolean isSetShippingDiscount() {
        return (this.shippingDiscount!= null);
    }

    /**
     * Gets the value of the promotionDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getPromotionDiscount() {
        return promotionDiscount;
    }

    /**
     * Sets the value of the promotionDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setPromotionDiscount(Money value) {
        this.promotionDiscount = value;
    }

    public boolean isSetPromotionDiscount() {
        return (this.promotionDiscount!= null);
    }

    /**
     * Gets the value of the promotionIds property.
     * 
     * @return
     *     possible object is
     *     {@link PromotionIdList }
     *     
     */
    public PromotionIdList getPromotionIds() {
        return promotionIds;
    }

    /**
     * Sets the value of the promotionIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link PromotionIdList }
     *     
     */
    public void setPromotionIds(PromotionIdList value) {
        this.promotionIds = value;
    }

    public boolean isSetPromotionIds() {
        return (this.promotionIds!= null);
    }

    /**
     * Gets the value of the codFee property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getCODFee() {
        return codFee;
    }

    /**
     * Sets the value of the codFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setCODFee(Money value) {
        this.codFee = value;
    }

    public boolean isSetCODFee() {
        return (this.codFee!= null);
    }

    /**
     * Gets the value of the codFeeDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getCODFeeDiscount() {
        return codFeeDiscount;
    }

    /**
     * Sets the value of the codFeeDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setCODFeeDiscount(Money value) {
        this.codFeeDiscount = value;
    }

    public boolean isSetCODFeeDiscount() {
        return (this.codFeeDiscount!= null);
    }

    /**
     * Gets the value of the giftMessageText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGiftMessageText() {
        return giftMessageText;
    }

    /**
     * Sets the value of the giftMessageText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGiftMessageText(String value) {
        this.giftMessageText = value;
    }

    public boolean isSetGiftMessageText() {
        return (this.giftMessageText!= null);
    }

    /**
     * Gets the value of the giftWrapLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGiftWrapLevel() {
        return giftWrapLevel;
    }

    /**
     * Sets the value of the giftWrapLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGiftWrapLevel(String value) {
        this.giftWrapLevel = value;
    }

    public boolean isSetGiftWrapLevel() {
        return (this.giftWrapLevel!= null);
    }

    /**
     * Gets the value of the invoiceData property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceData }
     *     
     */
    public InvoiceData getInvoiceData() {
        return invoiceData;
    }

    /**
     * Sets the value of the invoiceData property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceData }
     *     
     */
    public void setInvoiceData(InvoiceData value) {
        this.invoiceData = value;
    }

    public boolean isSetInvoiceData() {
        return (this.invoiceData!= null);
    }

    /**
     * Sets the value of the ASIN property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderItem withASIN(String value) {
        setASIN(value);
        return this;
    }

    /**
     * Sets the value of the SellerSKU property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderItem withSellerSKU(String value) {
        setSellerSKU(value);
        return this;
    }

    /**
     * Sets the value of the OrderItemId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderItem withOrderItemId(String value) {
        setOrderItemId(value);
        return this;
    }

    /**
     * Sets the value of the Title property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderItem withTitle(String value) {
        setTitle(value);
        return this;
    }

    /**
     * Sets the value of the QuantityOrdered property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderItem withQuantityOrdered(int value) {
        setQuantityOrdered(value);
        return this;
    }

    /**
     * Sets the value of the QuantityShipped property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderItem withQuantityShipped(Integer value) {
        setQuantityShipped(value);
        return this;
    }

    /**
     * Sets the value of the ItemPrice property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderItem withItemPrice(Money value) {
        setItemPrice(value);
        return this;
    }

    /**
     * Sets the value of the ShippingPrice property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderItem withShippingPrice(Money value) {
        setShippingPrice(value);
        return this;
    }

    /**
     * Sets the value of the GiftWrapPrice property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderItem withGiftWrapPrice(Money value) {
        setGiftWrapPrice(value);
        return this;
    }

    /**
     * Sets the value of the ItemTax property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderItem withItemTax(Money value) {
        setItemTax(value);
        return this;
    }

    /**
     * Sets the value of the ShippingTax property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderItem withShippingTax(Money value) {
        setShippingTax(value);
        return this;
    }

    /**
     * Sets the value of the GiftWrapTax property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderItem withGiftWrapTax(Money value) {
        setGiftWrapTax(value);
        return this;
    }

    /**
     * Sets the value of the ShippingDiscount property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderItem withShippingDiscount(Money value) {
        setShippingDiscount(value);
        return this;
    }

    /**
     * Sets the value of the PromotionDiscount property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderItem withPromotionDiscount(Money value) {
        setPromotionDiscount(value);
        return this;
    }

    /**
     * Sets the value of the PromotionIds property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderItem withPromotionIds(PromotionIdList value) {
        setPromotionIds(value);
        return this;
    }

    /**
     * Sets the value of the CODFee property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderItem withCODFee(Money value) {
        setCODFee(value);
        return this;
    }

    /**
     * Sets the value of the CODFeeDiscount property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderItem withCODFeeDiscount(Money value) {
        setCODFeeDiscount(value);
        return this;
    }

    /**
     * Sets the value of the GiftMessageText property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderItem withGiftMessageText(String value) {
        setGiftMessageText(value);
        return this;
    }

    /**
     * Sets the value of the GiftWrapLevel property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderItem withGiftWrapLevel(String value) {
        setGiftWrapLevel(value);
        return this;
    }

    /**
     * Sets the value of the InvoiceData property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderItem withInvoiceData(InvoiceData value) {
        setInvoiceData(value);
        return this;
    }
    
    /**
     * Get the value of the ConditionNote property.
     * 
     * @return ConditionNote
     */
    public String getConditionNote() {
    	return conditionNote;
    }
    
    /**
     * Set the value of the ConditionNote property.
     * 
     * @param value
     */
    public void setConditionNote(String value) {
    	this.conditionNote = value;
    }
    
    /**
     * Check to see if ConditionNote is set.
     * 
     * @return true if set.
     */
    public boolean isSetConditionNote() {
    	return conditionNote!=null;
    }
    
    /**
     * Set the value of the ConditionNote property.
     * 
     * @param value
     * 
     * @return this
     */
    public OrderItem withConditionNote(String value) {
    	this.conditionNote = value;
    	return this;
    }

    /**
     * Get the value of the ConditionId property.
     * 
     * @return ConditionId
     */
    public String getConditionId() {
    	return conditionId;
    }
    
    /**
     * Set the value of the ConditionId property.
     * 
     * @param value
     */
    public void setConditionId(String value) {
    	this.conditionId = value;
    }
    
    /**
     * Check to see if ConditionId is set.
     * 
     * @return true if set.
     */
    public boolean isSetConditionId() {
    	return conditionId!=null;
    }
    
    /**
     * Set the value of the ConditionId property.
     * 
     * @param value
     * 
     * @return this
     */
    public OrderItem withConditionId(String value) {
    	this.conditionId = value;
    	return this;
    }

    /**
     * Get the value of the ConditionSubtypeId property.
     * 
     * @return ConditionSubtypeId
     */
    public String getConditionSubtypeId() {
    	return conditionSubtypeId;
    }
    
    /**
     * Set the value of the ConditionSubtypeId property.
     * 
     * @param value
     */
    public void setConditionSubtypeId(String value) {
    	this.conditionSubtypeId = value;
    }
    
    /**
     * Check to see if ConditionSubtypeId is set.
     * 
     * @return true if set.
     */
    public boolean isSetConditionSubtypeId() {
    	return conditionSubtypeId!=null;
    }
    
    /**
     * Set the value of the ConditionSubtypeId property.
     * 
     * @param value
     * 
     * @return this
     */
    public OrderItem withConditionSubtypeId(String value) {
    	this.conditionSubtypeId = value;
    	return this;
    }

    /**
     * Get the value of the ScheduledDeliveryStartDate property.
     * 
     * @return ScheduledDeliveryStartDate
     */
    public String getScheduledDeliveryStartDate() {
    	return scheduledDeliveryStartDate;
    }
    
    /**
     * Set the value of the ScheduledDeliveryStartDate property.
     * 
     * @param value
     */
    public void setScheduledDeliveryStartDate(String value) {
    	this.scheduledDeliveryStartDate = value;
    }
    
    /**
     * Check to see if ScheduledDeliveryStartDate is set.
     * 
     * @return true if set.
     */
    public boolean isSetScheduledDeliveryStartDate() {
    	return scheduledDeliveryStartDate!=null;
    }
    
    /**
     * Set the value of the ScheduledDeliveryStartDate property.
     * 
     * @param value
     * 
     * @return this
     */
    public OrderItem withScheduledDeliveryStartDate(String value) {
    	this.scheduledDeliveryStartDate = value;
    	return this;
    }

    /**
     * Get the value of the ScheduledDeliveryEndDate property.
     * 
     * @return ScheduledDeliveryEndDate
     */
    public String getScheduledDeliveryEndDate() {
    	return scheduledDeliveryEndDate;
    }
    
    /**
     * Set the value of the ScheduledDeliveryEndDate property.
     * 
     * @param value
     */
    public void setScheduledDeliveryEndDate(String value) {
    	this.scheduledDeliveryEndDate = value;
    }
    
    /**
     * Check to see if ScheduledDeliveryEndDate is set.
     * 
     * @return true if set.
     */
    public boolean isSetScheduledDeliveryEndDate() {
    	return scheduledDeliveryEndDate!=null;
    }
    
    /**
     * Set the value of the ScheduledDeliveryEndDate property.
     * 
     * @param value
     * 
     * @return this
     */
    public OrderItem withScheduledDeliveryEndDate(String value) {
    	this.scheduledDeliveryEndDate = value;
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
        if (isSetASIN()) {
            xml.append("<ASIN>");
            xml.append(escapeXML(getASIN()));
            xml.append("</ASIN>");
        }
        if (isSetSellerSKU()) {
            xml.append("<SellerSKU>");
            xml.append(escapeXML(getSellerSKU()));
            xml.append("</SellerSKU>");
        }
        if (isSetOrderItemId()) {
            xml.append("<OrderItemId>");
            xml.append(escapeXML(getOrderItemId()));
            xml.append("</OrderItemId>");
        }
        if (isSetTitle()) {
            xml.append("<Title>");
            xml.append(escapeXML(getTitle()));
            xml.append("</Title>");
        }
        if (isSetQuantityOrdered()) {
            xml.append("<QuantityOrdered>");
            xml.append(getQuantityOrdered() + "");
            xml.append("</QuantityOrdered>");
        }
        if (isSetQuantityShipped()) {
            xml.append("<QuantityShipped>");
            xml.append(getQuantityShipped() + "");
            xml.append("</QuantityShipped>");
        }
        if (isSetItemPrice()) {
            Money  itemPrice = getItemPrice();
            xml.append("<ItemPrice>");
            xml.append(itemPrice.toXMLFragment());
            xml.append("</ItemPrice>");
        } 
        if (isSetShippingPrice()) {
            Money  shippingPrice = getShippingPrice();
            xml.append("<ShippingPrice>");
            xml.append(shippingPrice.toXMLFragment());
            xml.append("</ShippingPrice>");
        } 
        if (isSetGiftWrapPrice()) {
            Money  giftWrapPrice = getGiftWrapPrice();
            xml.append("<GiftWrapPrice>");
            xml.append(giftWrapPrice.toXMLFragment());
            xml.append("</GiftWrapPrice>");
        } 
        if (isSetItemTax()) {
            Money  itemTax = getItemTax();
            xml.append("<ItemTax>");
            xml.append(itemTax.toXMLFragment());
            xml.append("</ItemTax>");
        } 
        if (isSetShippingTax()) {
            Money  shippingTax = getShippingTax();
            xml.append("<ShippingTax>");
            xml.append(shippingTax.toXMLFragment());
            xml.append("</ShippingTax>");
        } 
        if (isSetGiftWrapTax()) {
            Money  giftWrapTax = getGiftWrapTax();
            xml.append("<GiftWrapTax>");
            xml.append(giftWrapTax.toXMLFragment());
            xml.append("</GiftWrapTax>");
        } 
        if (isSetShippingDiscount()) {
            Money  shippingDiscount = getShippingDiscount();
            xml.append("<ShippingDiscount>");
            xml.append(shippingDiscount.toXMLFragment());
            xml.append("</ShippingDiscount>");
        } 
        if (isSetPromotionDiscount()) {
            Money  promotionDiscount = getPromotionDiscount();
            xml.append("<PromotionDiscount>");
            xml.append(promotionDiscount.toXMLFragment());
            xml.append("</PromotionDiscount>");
        } 
        if (isSetPromotionIds()) {
            PromotionIdList  promotionIds = getPromotionIds();
            xml.append("<PromotionIds>");
            xml.append(promotionIds.toXMLFragment());
            xml.append("</PromotionIds>");
        } 
        if (isSetCODFee()) {
            Money  CODFee = getCODFee();
            xml.append("<CODFee>");
            xml.append(CODFee.toXMLFragment());
            xml.append("</CODFee>");
        } 
        if (isSetCODFeeDiscount()) {
            Money  CODFeeDiscount = getCODFeeDiscount();
            xml.append("<CODFeeDiscount>");
            xml.append(CODFeeDiscount.toXMLFragment());
            xml.append("</CODFeeDiscount>");
        } 
        if (isSetGiftMessageText()) {
            xml.append("<GiftMessageText>");
            xml.append(escapeXML(getGiftMessageText()));
            xml.append("</GiftMessageText>");
        }
        if (isSetGiftWrapLevel()) {
            xml.append("<GiftWrapLevel>");
            xml.append(escapeXML(getGiftWrapLevel()));
            xml.append("</GiftWrapLevel>");
        }
        if (isSetInvoiceData()) {
            InvoiceData  invoiceData = getInvoiceData();
            xml.append("<InvoiceData>");
            xml.append(invoiceData.toXMLFragment());
            xml.append("</InvoiceData>");
        } 
        if (isSetConditionNote()) {
        	xml.append("<ConditionNote>");
        	xml.append(escapeXML(conditionNote));
        	xml.append("</ConditionNote>");
        }
        if (isSetConditionId()) {
        	xml.append("<ConditionId>");
        	xml.append(escapeXML(conditionId));
        	xml.append("</ConditionId>");
        }
        if (isSetConditionSubtypeId()) {
        	xml.append("<ConditionSubtypeId>");
        	xml.append(escapeXML(conditionSubtypeId));
        	xml.append("</ConditionSubtypeId>");
        }
        if (isSetScheduledDeliveryStartDate()) {
        	xml.append("<ScheduledDeliveryStartDate>");
        	xml.append(escapeXML(scheduledDeliveryStartDate));
        	xml.append("</ScheduledDeliveryStartDate>");
        }
        if (isSetScheduledDeliveryEndDate()) {
        	xml.append("<ScheduledDeliveryEndDate>");
        	xml.append(escapeXML(scheduledDeliveryEndDate));
        	xml.append("</ScheduledDeliveryEndDate>");
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
        if (isSetASIN()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("ASIN"));
            json.append(" : ");
            json.append(quoteJSON(getASIN()));
            first = false;
        }
        if (isSetSellerSKU()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("SellerSKU"));
            json.append(" : ");
            json.append(quoteJSON(getSellerSKU()));
            first = false;
        }
        if (isSetOrderItemId()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("OrderItemId"));
            json.append(" : ");
            json.append(quoteJSON(getOrderItemId()));
            first = false;
        }
        if (isSetTitle()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("Title"));
            json.append(" : ");
            json.append(quoteJSON(getTitle()));
            first = false;
        }
        if (isSetQuantityOrdered()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("QuantityOrdered"));
            json.append(" : ");
            json.append(quoteJSON(getQuantityOrdered() + ""));
            first = false;
        }
        if (isSetQuantityShipped()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("QuantityShipped"));
            json.append(" : ");
            json.append(quoteJSON(getQuantityShipped() + ""));
            first = false;
        }
        if (isSetItemPrice()) {
            if (!first) json.append(", ");
            json.append("\"ItemPrice\" : {");
            Money  itemPrice = getItemPrice();


            json.append(itemPrice.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetShippingPrice()) {
            if (!first) json.append(", ");
            json.append("\"ShippingPrice\" : {");
            Money  shippingPrice = getShippingPrice();


            json.append(shippingPrice.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetGiftWrapPrice()) {
            if (!first) json.append(", ");
            json.append("\"GiftWrapPrice\" : {");
            Money  giftWrapPrice = getGiftWrapPrice();


            json.append(giftWrapPrice.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetItemTax()) {
            if (!first) json.append(", ");
            json.append("\"ItemTax\" : {");
            Money  itemTax = getItemTax();


            json.append(itemTax.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetShippingTax()) {
            if (!first) json.append(", ");
            json.append("\"ShippingTax\" : {");
            Money  shippingTax = getShippingTax();


            json.append(shippingTax.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetGiftWrapTax()) {
            if (!first) json.append(", ");
            json.append("\"GiftWrapTax\" : {");
            Money  giftWrapTax = getGiftWrapTax();


            json.append(giftWrapTax.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetShippingDiscount()) {
            if (!first) json.append(", ");
            json.append("\"ShippingDiscount\" : {");
            Money  shippingDiscount = getShippingDiscount();


            json.append(shippingDiscount.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetPromotionDiscount()) {
            if (!first) json.append(", ");
            json.append("\"PromotionDiscount\" : {");
            Money  promotionDiscount = getPromotionDiscount();


            json.append(promotionDiscount.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetPromotionIds()) {
            if (!first) json.append(", ");
            json.append("\"PromotionIds\" : {");
            PromotionIdList  promotionIds = getPromotionIds();


            json.append(promotionIds.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetCODFee()) {
            if (!first) json.append(", ");
            json.append("\"CODFee\" : {");
            Money  CODFee = getCODFee();


            json.append(CODFee.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetCODFeeDiscount()) {
            if (!first) json.append(", ");
            json.append("\"CODFeeDiscount\" : {");
            Money  CODFeeDiscount = getCODFeeDiscount();


            json.append(CODFeeDiscount.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetGiftMessageText()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("GiftMessageText"));
            json.append(" : ");
            json.append(quoteJSON(getGiftMessageText()));
            first = false;
        }
        if (isSetGiftWrapLevel()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("GiftWrapLevel"));
            json.append(" : ");
            json.append(quoteJSON(getGiftWrapLevel()));
            first = false;
        }
        if (isSetInvoiceData()) {
            if (!first) json.append(", ");
            json.append("\"InvoiceData\" : {");
            InvoiceData  invoiceData = getInvoiceData();


            json.append(invoiceData.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetConditionNote()) {
        	if (!first) json.append(", ");
        	json.append(quoteJSON("ConditionNote"));
        	json.append(" : ");
        	json.append(quoteJSON(conditionNote));
        	first = false;
        }
        if (isSetConditionId()) {
        	if (!first) json.append(", ");
        	json.append(quoteJSON("ConditionId"));
        	json.append(" : ");
        	json.append(quoteJSON(conditionId));
        	first = false;
        }
        if (isSetConditionSubtypeId()) {
        	if (!first) json.append(", ");
        	json.append(quoteJSON("ConditionSubtypeId"));
        	json.append(" : ");
        	json.append(quoteJSON(conditionSubtypeId));
        	first = false;
        }
        if (isSetScheduledDeliveryStartDate()) {
        	if (!first) json.append(", ");
        	json.append(quoteJSON("ScheduledDeliveryStartDate"));
        	json.append(" : ");
        	json.append(quoteJSON(scheduledDeliveryStartDate));
        	first = false;
        }
        if (isSetScheduledDeliveryEndDate()) {
        	if (!first) json.append(", ");
        	json.append(quoteJSON("ScheduledDeliveryEndDate"));
        	json.append(" : ");
        	json.append(quoteJSON(scheduledDeliveryEndDate));
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
