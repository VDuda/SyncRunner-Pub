
package API.amazon.mws.products.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OffersList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OffersList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Offer" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}OfferType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OffersList", propOrder = {
    "offer"
})
public class OffersList {

    @XmlElement(name = "Offer", required = true)
    protected List<OfferType> offer;

    /**
     * Default constructor
     * 
     */
    public OffersList() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public OffersList(final List<OfferType> offer) {
        this.offer = offer;
    }

    /**
     * Gets the value of the offer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the offer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOffer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OfferType }
     * 
     * 
     */
    public List<OfferType> getOffer() {
        if (offer == null) {
            offer = new ArrayList<OfferType>();
        }
        return this.offer;
    }

    public boolean isSetOffer() {
        return ((this.offer!= null)&&(!this.offer.isEmpty()));
    }

    public void unsetOffer() {
        this.offer = null;
    }

    /**
     * Sets the value of the Offer property.
     * 
     * @param values
     * @return
     *     this instance
     */
    public OffersList withOffer(OfferType... values) {
        for (OfferType value: values) {
            getOffer().add(value);
        }
        return this;
    }

    /**
     * Sets the value of the offer property.
     * 
     * @param offer
     *     allowed object is
     *     {@link OfferType }
     *     
     */
    public void setOffer(List<OfferType> offer) {
        this.offer = offer;
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
        java.util.List<OfferType> offerList = getOffer();
        for (OfferType offer : offerList) {
            xml.append("<Offer>");
            xml.append(offer.toXMLFragment());
            xml.append("</Offer>");
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
        if (isSetOffer()) {
            if (!first) json.append(", ");
            json.append("\"Offer\" : [");
            java.util.List<OfferType> offerList = getOffer();
            int offerListIndex = 0;
            for (OfferType offer : offerList) {
                if (offerListIndex > 0) json.append(", ");
                json.append("{");
                json.append("");
                json.append(offer.toJSONFragment());
                json.append("}");
                first = false;
                ++offerListIndex;
            }
            json.append("]");
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
