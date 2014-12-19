
package API.amazon.mws.products.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="Self" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}Categories" maxOccurs="unbounded"/>
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
    "self"
})
@XmlRootElement(name = "GetProductCategoriesForASINResult")
public class GetProductCategoriesForASINResult {

    @XmlElement(name = "Self", required = true)
    protected List<Categories> self;

    /**
     * Default constructor
     * 
     */
    public GetProductCategoriesForASINResult() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public GetProductCategoriesForASINResult(final List<Categories> self) {
        this.self = self;
    }

    /**
     * Gets the value of the self property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the self property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSelf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Categories }
     * 
     * 
     */
    public List<Categories> getSelf() {
        if (self == null) {
            self = new ArrayList<Categories>();
        }
        return this.self;
    }

    public boolean isSetSelf() {
        return ((this.self!= null)&&(!this.self.isEmpty()));
    }

    public void unsetSelf() {
        this.self = null;
    }

    /**
     * Sets the value of the Self property.
     * 
     * @param values
     * @return
     *     this instance
     */
    public GetProductCategoriesForASINResult withSelf(Categories... values) {
        for (Categories value: values) {
            getSelf().add(value);
        }
        return this;
    }

    /**
     * Sets the value of the self property.
     * 
     * @param self
     *     allowed object is
     *     {@link Categories }
     *     
     */
    public void setSelf(List<Categories> self) {
        this.self = self;
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
        java.util.List<Categories> selfList = getSelf();
        for (Categories self : selfList) {
            xml.append("<Self>");
            xml.append(self.toXMLFragment());
            xml.append("</Self>");
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
        if (isSetSelf()) {
            if (!first) json.append(", ");
            json.append("\"Self\" : [");
            java.util.List<Categories> selfList = getSelf();
            int selfListIndex = 0;
            for (Categories self : selfList) {
                if (selfListIndex > 0) json.append(", ");
                json.append("{");
                json.append("");
                json.append(self.toJSONFragment());
                json.append("}");
                first = false;
                ++selfListIndex;
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
