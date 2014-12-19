
package API.amazon.mws.products.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PriceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PriceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LandedPrice" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}MoneyType" minOccurs="0"/>
 *         &lt;element name="ListingPrice" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}MoneyType"/>
 *         &lt;element name="Shipping" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}MoneyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PriceType", propOrder = {
    "landedPrice",
    "listingPrice",
    "shipping"
})
public class PriceType {

    @XmlElement(name = "LandedPrice")
    protected MoneyType landedPrice;
    @XmlElement(name = "ListingPrice", required = true)
    protected MoneyType listingPrice;
    @XmlElement(name = "Shipping")
    protected MoneyType shipping;

    /**
     * Default constructor
     * 
     */
    public PriceType() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public PriceType(final MoneyType landedPrice, final MoneyType listingPrice, final MoneyType shipping) {
        this.landedPrice = landedPrice;
        this.listingPrice = listingPrice;
        this.shipping = shipping;
    }

    /**
     * Gets the value of the landedPrice property.
     * 
     * @return
     *     possible object is
     *     {@link MoneyType }
     *     
     */
    public MoneyType getLandedPrice() {
        return landedPrice;
    }

    /**
     * Sets the value of the landedPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link MoneyType }
     *     
     */
    public void setLandedPrice(MoneyType value) {
        this.landedPrice = value;
    }

    public boolean isSetLandedPrice() {
        return (this.landedPrice!= null);
    }

    /**
     * Gets the value of the listingPrice property.
     * 
     * @return
     *     possible object is
     *     {@link MoneyType }
     *     
     */
    public MoneyType getListingPrice() {
        return listingPrice;
    }

    /**
     * Sets the value of the listingPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link MoneyType }
     *     
     */
    public void setListingPrice(MoneyType value) {
        this.listingPrice = value;
    }

    public boolean isSetListingPrice() {
        return (this.listingPrice!= null);
    }

    /**
     * Gets the value of the shipping property.
     * 
     * @return
     *     possible object is
     *     {@link MoneyType }
     *     
     */
    public MoneyType getShipping() {
        return shipping;
    }

    /**
     * Sets the value of the shipping property.
     * 
     * @param value
     *     allowed object is
     *     {@link MoneyType }
     *     
     */
    public void setShipping(MoneyType value) {
        this.shipping = value;
    }

    public boolean isSetShipping() {
        return (this.shipping!= null);
    }

    /**
     * Sets the value of the LandedPrice property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public PriceType withLandedPrice(MoneyType value) {
        setLandedPrice(value);
        return this;
    }

    /**
     * Sets the value of the ListingPrice property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public PriceType withListingPrice(MoneyType value) {
        setListingPrice(value);
        return this;
    }

    /**
     * Sets the value of the Shipping property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public PriceType withShipping(MoneyType value) {
        setShipping(value);
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
        if (isSetLandedPrice()) {
            MoneyType  landedPrice = getLandedPrice();
            xml.append("<LandedPrice>");
            xml.append(landedPrice.toXMLFragment());
            xml.append("</LandedPrice>");
        } 
        if (isSetListingPrice()) {
            MoneyType  listingPrice = getListingPrice();
            xml.append("<ListingPrice>");
            xml.append(listingPrice.toXMLFragment());
            xml.append("</ListingPrice>");
        } 
        if (isSetShipping()) {
            MoneyType  shipping = getShipping();
            xml.append("<Shipping>");
            xml.append(shipping.toXMLFragment());
            xml.append("</Shipping>");
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
        if (isSetLandedPrice()) {
            if (!first) json.append(", ");
            json.append("\"LandedPrice\" : {");
            MoneyType  landedPrice = getLandedPrice();


            json.append(landedPrice.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetListingPrice()) {
            if (!first) json.append(", ");
            json.append("\"ListingPrice\" : {");
            MoneyType  listingPrice = getListingPrice();


            json.append(listingPrice.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetShipping()) {
            if (!first) json.append(", ");
            json.append("\"Shipping\" : {");
            MoneyType  shipping = getShipping();


            json.append(shipping.toJSONFragment());
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
