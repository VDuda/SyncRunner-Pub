//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.05.03 at 03:15:27 PM EDT 
//


package API.amazon.mws.xml.JAXB;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
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
 *         &lt;element name="AmazonOrderID">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="\w{3}-\d{7}-\d{7}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MerchantOrderID" type="{}String"/>
 *         &lt;element name="OrderDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="BillingData">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BuyerEmailAddress" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *                         &lt;pattern value="[^@]+@[^@\.]+(\.[^@\.]+)+"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="BuyerName" type="{}String"/>
 *                   &lt;element name="BuyerPhoneNumber" type="{}String" minOccurs="0"/>
 *                   &lt;element ref="{}Address" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="FulfillmentData">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="FulfillmentChannel">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="AFN"/>
 *                         &lt;enumeration value="MFN"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element ref="{}FulfillmentServiceLevel"/>
 *                   &lt;element ref="{}Address"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SalesChannel" type="{}HundredString"/>
 *         &lt;element name="OrderStatus">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="ASSIGNED"/>
 *               &lt;enumeration value="COMPLETED"/>
 *               &lt;enumeration value="CANCELLED"/>
 *               &lt;enumeration value="HOLD"/>
 *               &lt;enumeration value="ADJUSTED"/>
 *               &lt;enumeration value="PLANNING"/>
 *               &lt;enumeration value="PROCESSING"/>
 *               &lt;enumeration value="UNFULFILLABLE"/>
 *               &lt;enumeration value="INVALID"/>
 *               &lt;enumeration value="COMPLETE_PARTIAL"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Item" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{}AmazonOrderItemCode" minOccurs="0"/>
 *                   &lt;element name="MerchantOrderItemID" type="{}HundredString" minOccurs="0"/>
 *                   &lt;element ref="{}SKU"/>
 *                   &lt;element name="Title" type="{}LongString"/>
 *                   &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *                   &lt;element name="ItemPrice" type="{}BuyerPrice" minOccurs="0"/>
 *                   &lt;element name="GiftWrapLevel" type="{}StringNotNull" minOccurs="0"/>
 *                   &lt;element name="GiftMessageText" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="500"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Promotion" type="{}PromotionDataType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "amazonOrderID",
    "merchantOrderID",
    "orderDate",
    "billingData",
    "fulfillmentData",
    "salesChannel",
    "orderStatus",
    "item"
})
@XmlRootElement(name = "MultiChannelOrderReport")
public class MultiChannelOrderReport {

    @XmlElement(name = "AmazonOrderID", required = true)
    protected String amazonOrderID;
    @XmlElement(name = "MerchantOrderID", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String merchantOrderID;
    @XmlElement(name = "OrderDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar orderDate;
    @XmlElement(name = "BillingData", required = true)
    protected MultiChannelOrderReport.BillingData billingData;
    @XmlElement(name = "FulfillmentData", required = true)
    protected MultiChannelOrderReport.FulfillmentData fulfillmentData;
    @XmlElement(name = "SalesChannel", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String salesChannel;
    @XmlElement(name = "OrderStatus", required = true)
    protected String orderStatus;
    @XmlElement(name = "Item", required = true)
    protected List<MultiChannelOrderReport.Item> item;

    /**
     * Gets the value of the amazonOrderID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmazonOrderID() {
        return amazonOrderID;
    }

    /**
     * Sets the value of the amazonOrderID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmazonOrderID(String value) {
        this.amazonOrderID = value;
    }

    /**
     * Gets the value of the merchantOrderID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantOrderID() {
        return merchantOrderID;
    }

    /**
     * Sets the value of the merchantOrderID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantOrderID(String value) {
        this.merchantOrderID = value;
    }

    /**
     * Gets the value of the orderDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOrderDate() {
        return orderDate;
    }

    /**
     * Sets the value of the orderDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOrderDate(XMLGregorianCalendar value) {
        this.orderDate = value;
    }

    /**
     * Gets the value of the billingData property.
     * 
     * @return
     *     possible object is
     *     {@link MultiChannelOrderReport.BillingData }
     *     
     */
    public MultiChannelOrderReport.BillingData getBillingData() {
        return billingData;
    }

    /**
     * Sets the value of the billingData property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiChannelOrderReport.BillingData }
     *     
     */
    public void setBillingData(MultiChannelOrderReport.BillingData value) {
        this.billingData = value;
    }

    /**
     * Gets the value of the fulfillmentData property.
     * 
     * @return
     *     possible object is
     *     {@link MultiChannelOrderReport.FulfillmentData }
     *     
     */
    public MultiChannelOrderReport.FulfillmentData getFulfillmentData() {
        return fulfillmentData;
    }

    /**
     * Sets the value of the fulfillmentData property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiChannelOrderReport.FulfillmentData }
     *     
     */
    public void setFulfillmentData(MultiChannelOrderReport.FulfillmentData value) {
        this.fulfillmentData = value;
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

    /**
     * Gets the value of the orderStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * Sets the value of the orderStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderStatus(String value) {
        this.orderStatus = value;
    }

    /**
     * Gets the value of the item property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MultiChannelOrderReport.Item }
     * 
     * 
     */
    public List<MultiChannelOrderReport.Item> getItem() {
        if (item == null) {
            item = new ArrayList<MultiChannelOrderReport.Item>();
        }
        return this.item;
    }


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
     *         &lt;element name="BuyerEmailAddress" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
     *               &lt;pattern value="[^@]+@[^@\.]+(\.[^@\.]+)+"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="BuyerName" type="{}String"/>
     *         &lt;element name="BuyerPhoneNumber" type="{}String" minOccurs="0"/>
     *         &lt;element ref="{}Address" minOccurs="0"/>
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
        "buyerEmailAddress",
        "buyerName",
        "buyerPhoneNumber",
        "address"
    })
    public static class BillingData {

        @XmlElement(name = "BuyerEmailAddress")
        @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
        protected String buyerEmailAddress;
        @XmlElement(name = "BuyerName", required = true)
        @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
        protected String buyerName;
        @XmlElement(name = "BuyerPhoneNumber")
        @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
        protected String buyerPhoneNumber;
        @XmlElement(name = "Address")
        protected AddressType address;

        /**
         * Gets the value of the buyerEmailAddress property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBuyerEmailAddress() {
            return buyerEmailAddress;
        }

        /**
         * Sets the value of the buyerEmailAddress property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBuyerEmailAddress(String value) {
            this.buyerEmailAddress = value;
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

        /**
         * Gets the value of the buyerPhoneNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBuyerPhoneNumber() {
            return buyerPhoneNumber;
        }

        /**
         * Sets the value of the buyerPhoneNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBuyerPhoneNumber(String value) {
            this.buyerPhoneNumber = value;
        }

        /**
         * Gets the value of the address property.
         * 
         * @return
         *     possible object is
         *     {@link AddressType }
         *     
         */
        public AddressType getAddress() {
            return address;
        }

        /**
         * Sets the value of the address property.
         * 
         * @param value
         *     allowed object is
         *     {@link AddressType }
         *     
         */
        public void setAddress(AddressType value) {
            this.address = value;
        }

    }


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
     *         &lt;element name="FulfillmentChannel">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="AFN"/>
     *               &lt;enumeration value="MFN"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element ref="{}FulfillmentServiceLevel"/>
     *         &lt;element ref="{}Address"/>
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
        "fulfillmentChannel",
        "fulfillmentServiceLevel",
        "address"
    })
    public static class FulfillmentData {

        @XmlElement(name = "FulfillmentChannel", required = true)
        protected String fulfillmentChannel;
        @XmlElement(name = "FulfillmentServiceLevel", required = true)
        protected String fulfillmentServiceLevel;
        @XmlElement(name = "Address", required = true)
        protected AddressType address;

        /**
         * Gets the value of the fulfillmentChannel property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFulfillmentChannel() {
            return fulfillmentChannel;
        }

        /**
         * Sets the value of the fulfillmentChannel property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFulfillmentChannel(String value) {
            this.fulfillmentChannel = value;
        }

        /**
         * Gets the value of the fulfillmentServiceLevel property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFulfillmentServiceLevel() {
            return fulfillmentServiceLevel;
        }

        /**
         * Sets the value of the fulfillmentServiceLevel property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFulfillmentServiceLevel(String value) {
            this.fulfillmentServiceLevel = value;
        }

        /**
         * Gets the value of the address property.
         * 
         * @return
         *     possible object is
         *     {@link AddressType }
         *     
         */
        public AddressType getAddress() {
            return address;
        }

        /**
         * Sets the value of the address property.
         * 
         * @param value
         *     allowed object is
         *     {@link AddressType }
         *     
         */
        public void setAddress(AddressType value) {
            this.address = value;
        }

    }


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
     *         &lt;element ref="{}AmazonOrderItemCode" minOccurs="0"/>
     *         &lt;element name="MerchantOrderItemID" type="{}HundredString" minOccurs="0"/>
     *         &lt;element ref="{}SKU"/>
     *         &lt;element name="Title" type="{}LongString"/>
     *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
     *         &lt;element name="ItemPrice" type="{}BuyerPrice" minOccurs="0"/>
     *         &lt;element name="GiftWrapLevel" type="{}StringNotNull" minOccurs="0"/>
     *         &lt;element name="GiftMessageText" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="500"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Promotion" type="{}PromotionDataType" maxOccurs="unbounded" minOccurs="0"/>
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
        "amazonOrderItemCode",
        "merchantOrderItemID",
        "sku",
        "title",
        "quantity",
        "itemPrice",
        "giftWrapLevel",
        "giftMessageText",
        "promotion"
    })
    public static class Item {

        @XmlElement(name = "AmazonOrderItemCode")
        protected String amazonOrderItemCode;
        @XmlElement(name = "MerchantOrderItemID")
        @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
        protected String merchantOrderItemID;
        @XmlElement(name = "SKU", required = true)
        @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
        protected String sku;
        @XmlElement(name = "Title", required = true)
        @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
        protected String title;
        @XmlElement(name = "Quantity", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger quantity;
        @XmlElement(name = "ItemPrice")
        protected BuyerPrice itemPrice;
        @XmlElement(name = "GiftWrapLevel")
        @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
        protected String giftWrapLevel;
        @XmlElement(name = "GiftMessageText")
        protected String giftMessageText;
        @XmlElement(name = "Promotion")
        protected List<PromotionDataType> promotion;

        /**
         * Gets the value of the amazonOrderItemCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAmazonOrderItemCode() {
            return amazonOrderItemCode;
        }

        /**
         * Sets the value of the amazonOrderItemCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAmazonOrderItemCode(String value) {
            this.amazonOrderItemCode = value;
        }

        /**
         * Gets the value of the merchantOrderItemID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMerchantOrderItemID() {
            return merchantOrderItemID;
        }

        /**
         * Sets the value of the merchantOrderItemID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMerchantOrderItemID(String value) {
            this.merchantOrderItemID = value;
        }

        /**
         * Gets the value of the sku property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSKU() {
            return sku;
        }

        /**
         * Sets the value of the sku property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSKU(String value) {
            this.sku = value;
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

        /**
         * Gets the value of the quantity property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getQuantity() {
            return quantity;
        }

        /**
         * Sets the value of the quantity property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setQuantity(BigInteger value) {
            this.quantity = value;
        }

        /**
         * Gets the value of the itemPrice property.
         * 
         * @return
         *     possible object is
         *     {@link BuyerPrice }
         *     
         */
        public BuyerPrice getItemPrice() {
            return itemPrice;
        }

        /**
         * Sets the value of the itemPrice property.
         * 
         * @param value
         *     allowed object is
         *     {@link BuyerPrice }
         *     
         */
        public void setItemPrice(BuyerPrice value) {
            this.itemPrice = value;
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

        /**
         * Gets the value of the promotion property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the promotion property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPromotion().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PromotionDataType }
         * 
         * 
         */
        public List<PromotionDataType> getPromotion() {
            if (promotion == null) {
                promotion = new ArrayList<PromotionDataType>();
            }
            return this.promotion;
        }

    }

}
