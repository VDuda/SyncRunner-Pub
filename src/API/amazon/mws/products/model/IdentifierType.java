
package API.amazon.mws.products.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IdentifierType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IdentifierType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MarketplaceASIN" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}ASINIdentifier" minOccurs="0"/>
 *         &lt;element name="SKUIdentifier" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}SellerSKUIdentifier" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdentifierType", propOrder = {
    "marketplaceASIN",
    "skuIdentifier"
})
public class IdentifierType {

    @XmlElement(name = "MarketplaceASIN")
    protected ASINIdentifier marketplaceASIN;
    @XmlElement(name = "SKUIdentifier")
    protected SellerSKUIdentifier skuIdentifier;

    /**
     * Default constructor
     * 
     */
    public IdentifierType() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public IdentifierType(final ASINIdentifier marketplaceASIN, final SellerSKUIdentifier skuIdentifier) {
        this.marketplaceASIN = marketplaceASIN;
        this.skuIdentifier = skuIdentifier;
    }

    /**
     * Gets the value of the marketplaceASIN property.
     * 
     * @return
     *     possible object is
     *     {@link ASINIdentifier }
     *     
     */
    public ASINIdentifier getMarketplaceASIN() {
        return marketplaceASIN;
    }

    /**
     * Sets the value of the marketplaceASIN property.
     * 
     * @param value
     *     allowed object is
     *     {@link ASINIdentifier }
     *     
     */
    public void setMarketplaceASIN(ASINIdentifier value) {
        this.marketplaceASIN = value;
    }

    public boolean isSetMarketplaceASIN() {
        return (this.marketplaceASIN!= null);
    }

    /**
     * Gets the value of the skuIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link SellerSKUIdentifier }
     *     
     */
    public SellerSKUIdentifier getSKUIdentifier() {
        return skuIdentifier;
    }

    /**
     * Sets the value of the skuIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link SellerSKUIdentifier }
     *     
     */
    public void setSKUIdentifier(SellerSKUIdentifier value) {
        this.skuIdentifier = value;
    }

    public boolean isSetSKUIdentifier() {
        return (this.skuIdentifier!= null);
    }

    /**
     * Sets the value of the MarketplaceASIN property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public IdentifierType withMarketplaceASIN(ASINIdentifier value) {
        setMarketplaceASIN(value);
        return this;
    }

    /**
     * Sets the value of the SKUIdentifier property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public IdentifierType withSKUIdentifier(SellerSKUIdentifier value) {
        setSKUIdentifier(value);
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
        if (isSetMarketplaceASIN()) {
            ASINIdentifier  marketplaceASIN = getMarketplaceASIN();
            xml.append("<MarketplaceASIN>");
            xml.append(marketplaceASIN.toXMLFragment());
            xml.append("</MarketplaceASIN>");
        } 
        if (isSetSKUIdentifier()) {
            SellerSKUIdentifier  SKUIdentifier = getSKUIdentifier();
            xml.append("<SKUIdentifier>");
            xml.append(SKUIdentifier.toXMLFragment());
            xml.append("</SKUIdentifier>");
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
        if (isSetMarketplaceASIN()) {
            if (!first) json.append(", ");
            json.append("\"MarketplaceASIN\" : {");
            ASINIdentifier  marketplaceASIN = getMarketplaceASIN();


            json.append(marketplaceASIN.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetSKUIdentifier()) {
            if (!first) json.append(", ");
            json.append("\"SKUIdentifier\" : {");
            SellerSKUIdentifier  SKUIdentifier = getSKUIdentifier();


            json.append(SKUIdentifier.toJSONFragment());
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
