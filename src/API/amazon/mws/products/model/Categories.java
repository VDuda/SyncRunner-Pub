
package API.amazon.mws.products.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Categories complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Categories">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProductCategoryId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductCategoryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Parent" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}Categories" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Categories", propOrder = {
    "productCategoryId",
    "productCategoryName",
    "parent"
})
public class Categories {

    @XmlElement(name = "ProductCategoryId")
    protected String productCategoryId;
    @XmlElement(name = "ProductCategoryName")
    protected String productCategoryName;
    @XmlElement(name = "Parent")
    protected Categories parent;

    /**
     * Default constructor
     * 
     */
    public Categories() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public Categories(final String productCategoryId, final String productCategoryName, final Categories parent) {
        this.productCategoryId = productCategoryId;
        this.productCategoryName = productCategoryName;
        this.parent = parent;
    }

    /**
     * Gets the value of the productCategoryId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductCategoryId() {
        return productCategoryId;
    }

    /**
     * Sets the value of the productCategoryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductCategoryId(String value) {
        this.productCategoryId = value;
    }

    public boolean isSetProductCategoryId() {
        return (this.productCategoryId!= null);
    }

    /**
     * Gets the value of the productCategoryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductCategoryName() {
        return productCategoryName;
    }

    /**
     * Sets the value of the productCategoryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductCategoryName(String value) {
        this.productCategoryName = value;
    }

    public boolean isSetProductCategoryName() {
        return (this.productCategoryName!= null);
    }

    /**
     * Gets the value of the parent property.
     * 
     * @return
     *     possible object is
     *     {@link Categories }
     *     
     */
    public Categories getParent() {
        return parent;
    }

    /**
     * Sets the value of the parent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Categories }
     *     
     */
    public void setParent(Categories value) {
        this.parent = value;
    }

    public boolean isSetParent() {
        return (this.parent!= null);
    }

    /**
     * Sets the value of the ProductCategoryId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Categories withProductCategoryId(String value) {
        setProductCategoryId(value);
        return this;
    }

    /**
     * Sets the value of the ProductCategoryName property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Categories withProductCategoryName(String value) {
        setProductCategoryName(value);
        return this;
    }

    /**
     * Sets the value of the Parent property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Categories withParent(Categories value) {
        setParent(value);
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
        if (isSetProductCategoryId()) {
            xml.append("<ProductCategoryId>");
            xml.append(escapeXML(getProductCategoryId()));
            xml.append("</ProductCategoryId>");
        }
        if (isSetProductCategoryName()) {
            xml.append("<ProductCategoryName>");
            xml.append(escapeXML(getProductCategoryName()));
            xml.append("</ProductCategoryName>");
        }
        if (isSetParent()) {
            Categories  parent = getParent();
            xml.append("<Parent>");
            xml.append(parent.toXMLFragment());
            xml.append("</Parent>");
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
        if (isSetProductCategoryId()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("ProductCategoryId"));
            json.append(" : ");
            json.append(quoteJSON(getProductCategoryId()));
            first = false;
        }
        if (isSetProductCategoryName()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("ProductCategoryName"));
            json.append(" : ");
            json.append(quoteJSON(getProductCategoryName()));
            first = false;
        }
        if (isSetParent()) {
            if (!first) json.append(", ");
            json.append("\"Parent\" : {");
            Categories  parent = getParent();


            json.append(parent.toJSONFragment());
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
