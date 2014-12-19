
package API.amazon.mws.products.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SellerSKUListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SellerSKUListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SellerSKU" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SellerSKUListType", propOrder = {
    "sellerSKU"
})
public class SellerSKUListType {

    @XmlElement(name = "SellerSKU", required = true)
    protected List<String> sellerSKU;

    /**
     * Default constructor
     * 
     */
    public SellerSKUListType() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public SellerSKUListType(final List<String> sellerSKU) {
        this.sellerSKU = sellerSKU;
    }

    /**
     * Gets the value of the sellerSKU property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sellerSKU property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSellerSKU().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSellerSKU() {
        if (sellerSKU == null) {
            sellerSKU = new ArrayList<String>();
        }
        return this.sellerSKU;
    }

    public boolean isSetSellerSKU() {
        return ((this.sellerSKU!= null)&&(!this.sellerSKU.isEmpty()));
    }

    public void unsetSellerSKU() {
        this.sellerSKU = null;
    }

    /**
     * Sets the value of the SellerSKU property.
     * 
     * @param values
     * @return
     *     this instance
     */
    public SellerSKUListType withSellerSKU(String... values) {
        for (String value: values) {
            getSellerSKU().add(value);
        }
        return this;
    }

    /**
     * Sets the value of the sellerSKU property.
     * 
     * @param sellerSKU
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellerSKU(List<String> sellerSKU) {
        this.sellerSKU = sellerSKU;
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
        java.util.List<String> sellerSKUList  =  getSellerSKU();
        for (String sellerSKU : sellerSKUList) { 
            xml.append("<SellerSKU>");
            xml.append(escapeXML(sellerSKU));
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
        if (isSetSellerSKU()) {
            if (!first) json.append(", ");
            json.append("\"SellerSKU\" : [");
            java.util.List<String> sellerSKUList  =  getSellerSKU();
            int sellerSKUListIndex  =  0;
            for (String sellerSKU : sellerSKUList) {
                if (sellerSKUListIndex > 0) json.append(", ");
                    json.append(quoteJSON(sellerSKU));
                ++sellerSKUListIndex;
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
