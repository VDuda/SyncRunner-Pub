
package API.amazon.mws.products.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OfferType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OfferType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BuyingPrice" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}PriceType"/>
 *         &lt;element name="RegularPrice" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}MoneyType"/>
 *         &lt;element name="FulfillmentChannel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ItemCondition" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ItemSubCondition" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SellerId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SellerSKU" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OfferType", propOrder = {
    "buyingPrice",
    "regularPrice",
    "fulfillmentChannel",
    "itemCondition",
    "itemSubCondition",
    "sellerId",
    "sellerSKU"
})
public class OfferType {

    @XmlElement(name = "BuyingPrice", required = true)
    protected PriceType buyingPrice;
    @XmlElement(name = "RegularPrice", required = true)
    protected MoneyType regularPrice;
    @XmlElement(name = "FulfillmentChannel", required = true)
    protected String fulfillmentChannel;
    @XmlElement(name = "ItemCondition", required = true)
    protected String itemCondition;
    @XmlElement(name = "ItemSubCondition", required = true)
    protected String itemSubCondition;
    @XmlElement(name = "SellerId", required = true)
    protected String sellerId;
    @XmlElement(name = "SellerSKU", required = true)
    protected String sellerSKU;

    /**
     * Default constructor
     * 
     */
    public OfferType() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public OfferType(final PriceType buyingPrice, final MoneyType regularPrice, final String fulfillmentChannel, final String itemCondition, final String itemSubCondition, final String sellerId, final String sellerSKU) {
        this.buyingPrice = buyingPrice;
        this.regularPrice = regularPrice;
        this.fulfillmentChannel = fulfillmentChannel;
        this.itemCondition = itemCondition;
        this.itemSubCondition = itemSubCondition;
        this.sellerId = sellerId;
        this.sellerSKU = sellerSKU;
    }

    /**
     * Gets the value of the buyingPrice property.
     * 
     * @return
     *     possible object is
     *     {@link PriceType }
     *     
     */
    public PriceType getBuyingPrice() {
        return buyingPrice;
    }

    /**
     * Sets the value of the buyingPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceType }
     *     
     */
    public void setBuyingPrice(PriceType value) {
        this.buyingPrice = value;
    }

    public boolean isSetBuyingPrice() {
        return (this.buyingPrice!= null);
    }

    /**
     * Gets the value of the regularPrice property.
     * 
     * @return
     *     possible object is
     *     {@link MoneyType }
     *     
     */
    public MoneyType getRegularPrice() {
        return regularPrice;
    }

    /**
     * Sets the value of the regularPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link MoneyType }
     *     
     */
    public void setRegularPrice(MoneyType value) {
        this.regularPrice = value;
    }

    public boolean isSetRegularPrice() {
        return (this.regularPrice!= null);
    }

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

    public boolean isSetFulfillmentChannel() {
        return (this.fulfillmentChannel!= null);
    }

    /**
     * Gets the value of the itemCondition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemCondition() {
        return itemCondition;
    }

    /**
     * Sets the value of the itemCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemCondition(String value) {
        this.itemCondition = value;
    }

    public boolean isSetItemCondition() {
        return (this.itemCondition!= null);
    }

    /**
     * Gets the value of the itemSubCondition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemSubCondition() {
        return itemSubCondition;
    }

    /**
     * Sets the value of the itemSubCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemSubCondition(String value) {
        this.itemSubCondition = value;
    }

    public boolean isSetItemSubCondition() {
        return (this.itemSubCondition!= null);
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
     * Sets the value of the BuyingPrice property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OfferType withBuyingPrice(PriceType value) {
        setBuyingPrice(value);
        return this;
    }

    /**
     * Sets the value of the RegularPrice property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OfferType withRegularPrice(MoneyType value) {
        setRegularPrice(value);
        return this;
    }

    /**
     * Sets the value of the FulfillmentChannel property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OfferType withFulfillmentChannel(String value) {
        setFulfillmentChannel(value);
        return this;
    }

    /**
     * Sets the value of the ItemCondition property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OfferType withItemCondition(String value) {
        setItemCondition(value);
        return this;
    }

    /**
     * Sets the value of the ItemSubCondition property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OfferType withItemSubCondition(String value) {
        setItemSubCondition(value);
        return this;
    }

    /**
     * Sets the value of the SellerId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OfferType withSellerId(String value) {
        setSellerId(value);
        return this;
    }

    /**
     * Sets the value of the SellerSKU property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OfferType withSellerSKU(String value) {
        setSellerSKU(value);
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
        if (isSetBuyingPrice()) {
            PriceType  buyingPrice = getBuyingPrice();
            xml.append("<BuyingPrice>");
            xml.append(buyingPrice.toXMLFragment());
            xml.append("</BuyingPrice>");
        } 
        if (isSetRegularPrice()) {
            MoneyType  regularPrice = getRegularPrice();
            xml.append("<RegularPrice>");
            xml.append(regularPrice.toXMLFragment());
            xml.append("</RegularPrice>");
        } 
        if (isSetFulfillmentChannel()) {
            xml.append("<FulfillmentChannel>");
            xml.append(escapeXML(getFulfillmentChannel()));
            xml.append("</FulfillmentChannel>");
        }
        if (isSetItemCondition()) {
            xml.append("<ItemCondition>");
            xml.append(escapeXML(getItemCondition()));
            xml.append("</ItemCondition>");
        }
        if (isSetItemSubCondition()) {
            xml.append("<ItemSubCondition>");
            xml.append(escapeXML(getItemSubCondition()));
            xml.append("</ItemSubCondition>");
        }
        if (isSetSellerId()) {
            xml.append("<SellerId>");
            xml.append(escapeXML(getSellerId()));
            xml.append("</SellerId>");
        }
        if (isSetSellerSKU()) {
            xml.append("<SellerSKU>");
            xml.append(escapeXML(getSellerSKU()));
            xml.append("</SellerSKU>");
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
        if (isSetBuyingPrice()) {
            if (!first) json.append(", ");
            json.append("\"BuyingPrice\" : {");
            PriceType  buyingPrice = getBuyingPrice();


            json.append(buyingPrice.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetRegularPrice()) {
            if (!first) json.append(", ");
            json.append("\"RegularPrice\" : {");
            MoneyType  regularPrice = getRegularPrice();


            json.append(regularPrice.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetFulfillmentChannel()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("FulfillmentChannel"));
            json.append(" : ");
            json.append(quoteJSON(getFulfillmentChannel()));
            first = false;
        }
        if (isSetItemCondition()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("ItemCondition"));
            json.append(" : ");
            json.append(quoteJSON(getItemCondition()));
            first = false;
        }
        if (isSetItemSubCondition()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("ItemSubCondition"));
            json.append(" : ");
            json.append(quoteJSON(getItemSubCondition()));
            first = false;
        }
        if (isSetSellerId()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("SellerId"));
            json.append(" : ");
            json.append(quoteJSON(getSellerId()));
            first = false;
        }
        if (isSetSellerSKU()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("SellerSKU"));
            json.append(" : ");
            json.append(quoteJSON(getSellerSKU()));
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
