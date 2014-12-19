
package API.amazon.mws.orders.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PromotionIdList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PromotionIdList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PromotionId" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PromotionIdList", propOrder = {
    "promotionId"
})
public class PromotionIdList {

    @XmlElement(name = "PromotionId", required = true)
    protected List<String> promotionId;

    /**
     * Default constructor
     * 
     */
    public PromotionIdList() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public PromotionIdList(final List<String> promotionId) {
        this.promotionId = promotionId;
    }

    /**
     * Gets the value of the promotionId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the promotionId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPromotionId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPromotionId() {
        if (promotionId == null) {
            promotionId = new ArrayList<String>();
        }
        return this.promotionId;
    }

    public boolean isSetPromotionId() {
        return ((this.promotionId!= null)&&(!this.promotionId.isEmpty()));
    }

    public void unsetPromotionId() {
        this.promotionId = null;
    }

    /**
     * Sets the value of the PromotionId property.
     * 
     * @param values
     * @return
     *     this instance
     */
    public PromotionIdList withPromotionId(String... values) {
        for (String value: values) {
            getPromotionId().add(value);
        }
        return this;
    }

    /**
     * Sets the value of the promotionId property.
     * 
     * @param promotionId
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromotionId(List<String> promotionId) {
        this.promotionId = promotionId;
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
        java.util.List<String> promotionIdList  =  getPromotionId();
        for (String promotionId : promotionIdList) { 
            xml.append("<PromotionId>");
            xml.append(escapeXML(promotionId));
            xml.append("</PromotionId>");
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
        if (isSetPromotionId()) {
            if (!first) json.append(", ");
            json.append("\"PromotionId\" : [");
            java.util.List<String> promotionIdList  =  getPromotionId();
            int promotionIdListIndex  =  0;
            for (String promotionId : promotionIdList) {
                if (promotionIdListIndex > 0) json.append(", ");
                    json.append(quoteJSON(promotionId));
                ++promotionIdListIndex;
            }
            json.append("]");
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
