
package API.amazon.mws.products.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QualifiersType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QualifiersType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ItemCondition" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ItemSubcondition" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FulfillmentChannel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ShipsDomestically" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ShippingTime" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}ShippingTimeType"/>
 *         &lt;element name="SellerPositiveFeedbackRating" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QualifiersType", propOrder = {
    "itemCondition",
    "itemSubcondition",
    "fulfillmentChannel",
    "shipsDomestically",
    "shippingTime",
    "sellerPositiveFeedbackRating"
})
public class QualifiersType {

    @XmlElement(name = "ItemCondition", required = true)
    protected String itemCondition;
    @XmlElement(name = "ItemSubcondition", required = true)
    protected String itemSubcondition;
    @XmlElement(name = "FulfillmentChannel", required = true)
    protected String fulfillmentChannel;
    @XmlElement(name = "ShipsDomestically", required = true)
    protected String shipsDomestically;
    @XmlElement(name = "ShippingTime", required = true)
    protected ShippingTimeType shippingTime;
    @XmlElement(name = "SellerPositiveFeedbackRating", required = true)
    protected String sellerPositiveFeedbackRating;

    /**
     * Default constructor
     * 
     */
    public QualifiersType() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public QualifiersType(final String itemCondition, final String itemSubcondition, final String fulfillmentChannel, final String shipsDomestically, final ShippingTimeType shippingTime, final String sellerPositiveFeedbackRating) {
        this.itemCondition = itemCondition;
        this.itemSubcondition = itemSubcondition;
        this.fulfillmentChannel = fulfillmentChannel;
        this.shipsDomestically = shipsDomestically;
        this.shippingTime = shippingTime;
        this.sellerPositiveFeedbackRating = sellerPositiveFeedbackRating;
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
     * Gets the value of the itemSubcondition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemSubcondition() {
        return itemSubcondition;
    }

    /**
     * Sets the value of the itemSubcondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemSubcondition(String value) {
        this.itemSubcondition = value;
    }

    public boolean isSetItemSubcondition() {
        return (this.itemSubcondition!= null);
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
     * Gets the value of the shipsDomestically property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipsDomestically() {
        return shipsDomestically;
    }

    /**
     * Sets the value of the shipsDomestically property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipsDomestically(String value) {
        this.shipsDomestically = value;
    }

    public boolean isSetShipsDomestically() {
        return (this.shipsDomestically!= null);
    }

    /**
     * Gets the value of the shippingTime property.
     * 
     * @return
     *     possible object is
     *     {@link ShippingTimeType }
     *     
     */
    public ShippingTimeType getShippingTime() {
        return shippingTime;
    }

    /**
     * Sets the value of the shippingTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShippingTimeType }
     *     
     */
    public void setShippingTime(ShippingTimeType value) {
        this.shippingTime = value;
    }

    public boolean isSetShippingTime() {
        return (this.shippingTime!= null);
    }

    /**
     * Gets the value of the sellerPositiveFeedbackRating property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSellerPositiveFeedbackRating() {
        return sellerPositiveFeedbackRating;
    }

    /**
     * Sets the value of the sellerPositiveFeedbackRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellerPositiveFeedbackRating(String value) {
        this.sellerPositiveFeedbackRating = value;
    }

    public boolean isSetSellerPositiveFeedbackRating() {
        return (this.sellerPositiveFeedbackRating!= null);
    }

    /**
     * Sets the value of the ItemCondition property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public QualifiersType withItemCondition(String value) {
        setItemCondition(value);
        return this;
    }

    /**
     * Sets the value of the ItemSubcondition property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public QualifiersType withItemSubcondition(String value) {
        setItemSubcondition(value);
        return this;
    }

    /**
     * Sets the value of the FulfillmentChannel property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public QualifiersType withFulfillmentChannel(String value) {
        setFulfillmentChannel(value);
        return this;
    }

    /**
     * Sets the value of the ShipsDomestically property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public QualifiersType withShipsDomestically(String value) {
        setShipsDomestically(value);
        return this;
    }

    /**
     * Sets the value of the ShippingTime property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public QualifiersType withShippingTime(ShippingTimeType value) {
        setShippingTime(value);
        return this;
    }

    /**
     * Sets the value of the SellerPositiveFeedbackRating property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public QualifiersType withSellerPositiveFeedbackRating(String value) {
        setSellerPositiveFeedbackRating(value);
        return this;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(obj instanceof QualifiersType)) {
            return false;
        }
        QualifiersType qt = (QualifiersType) obj;
        return getFulfillmentChannel().equals(qt.getFulfillmentChannel()) && getItemCondition().equals(qt.getItemCondition())
                && getItemSubcondition().equals(qt.getItemSubcondition()) && getSellerPositiveFeedbackRating().equals(qt.getSellerPositiveFeedbackRating())
                && getShippingTime().equals(qt.getShippingTime()) && getShipsDomestically().equals(qt.getShipsDomestically());

    }

    @Override
    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        if (isSetItemCondition()) {
            sb.append(getItemCondition());
        }
        if (isSetItemSubcondition()) {
            sb.append(getItemSubcondition());
        }
        if (isSetFulfillmentChannel()) {
            sb.append(getFulfillmentChannel());
        }
        if (isSetShippingTime()) {
            sb.append(getShippingTime().toString());
        }
        if (isSetSellerPositiveFeedbackRating()) {
            sb.append(getSellerPositiveFeedbackRating());
        }
        if (isSetShipsDomestically()) {
            sb.append(getShipsDomestically());
        }
        return sb.toString().hashCode();
    }

    @Override
    public String toString() {
        return toXMLFragment();
    };

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
        if (isSetItemCondition()) {
            xml.append("<ItemCondition>");
            xml.append(escapeXML(getItemCondition()));
            xml.append("</ItemCondition>");
        }
        if (isSetItemSubcondition()) {
            xml.append("<ItemSubcondition>");
            xml.append(escapeXML(getItemSubcondition()));
            xml.append("</ItemSubcondition>");
        }
        if (isSetFulfillmentChannel()) {
            xml.append("<FulfillmentChannel>");
            xml.append(escapeXML(getFulfillmentChannel()));
            xml.append("</FulfillmentChannel>");
        }
        if (isSetShipsDomestically()) {
            xml.append("<ShipsDomestically>");
            xml.append(escapeXML(getShipsDomestically()));
            xml.append("</ShipsDomestically>");
        }
        if (isSetShippingTime()) {
            ShippingTimeType  shippingTime = getShippingTime();
            xml.append("<ShippingTime>");
            xml.append(shippingTime.toXMLFragment());
            xml.append("</ShippingTime>");
        } 
        if (isSetSellerPositiveFeedbackRating()) {
            xml.append("<SellerPositiveFeedbackRating>");
            xml.append(escapeXML(getSellerPositiveFeedbackRating()));
            xml.append("</SellerPositiveFeedbackRating>");
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
        if (isSetItemCondition()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("ItemCondition"));
            json.append(" : ");
            json.append(quoteJSON(getItemCondition()));
            first = false;
        }
        if (isSetItemSubcondition()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("ItemSubcondition"));
            json.append(" : ");
            json.append(quoteJSON(getItemSubcondition()));
            first = false;
        }
        if (isSetFulfillmentChannel()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("FulfillmentChannel"));
            json.append(" : ");
            json.append(quoteJSON(getFulfillmentChannel()));
            first = false;
        }
        if (isSetShipsDomestically()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("ShipsDomestically"));
            json.append(" : ");
            json.append(quoteJSON(getShipsDomestically()));
            first = false;
        }
        if (isSetShippingTime()) {
            if (!first) json.append(", ");
            json.append("\"ShippingTime\" : {");
            ShippingTimeType  shippingTime = getShippingTime();


            json.append(shippingTime.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetSellerPositiveFeedbackRating()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("SellerPositiveFeedbackRating"));
            json.append(" : ");
            json.append(quoteJSON(getSellerPositiveFeedbackRating()));
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
