
package API.amazon.mws.products.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element name="Products" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}ProductList" minOccurs="0"/>
 *         &lt;element ref="{http://mws.amazonservices.com/schema/Products/2011-10-01}Error" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="IdType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="status" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "products",
    "error"
})
@XmlRootElement(name = "GetMatchingProductForIdResult")
public class GetMatchingProductForIdResult {

    @XmlElement(name = "Products")
    protected ProductList products;
    @XmlElement(name = "Error")
    protected Error error;
    @XmlAttribute(name = "Id")
    protected String id;
    @XmlAttribute(name = "IdType")
    protected String idType;
    @XmlAttribute(required = true)
    protected String status;

    /**
     * Default constructor
     * 
     */
    public GetMatchingProductForIdResult() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public GetMatchingProductForIdResult(final ProductList products, final Error error, final String id, final String idType, final String status) {
        this.products = products;
        this.error = error;
        this.id = id;
        this.idType = idType;
        this.status = status;
    }

    /**
     * Gets the value of the products property.
     * 
     * @return
     *     possible object is
     *     {@link ProductList }
     *     
     */
    public ProductList getProducts() {
        return products;
    }

    /**
     * Sets the value of the products property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductList }
     *     
     */
    public void setProducts(ProductList value) {
        this.products = value;
    }

    public boolean isSetProducts() {
        return (this.products!= null);
    }

    /**
     * Gets the value of the error property.
     * 
     * @return
     *     possible object is
     *     {@link Error }
     *     
     */
    public Error getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     * 
     * @param value
     *     allowed object is
     *     {@link Error }
     *     
     */
    public void setError(Error value) {
        this.error = value;
    }

    public boolean isSetError() {
        return (this.error!= null);
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    public boolean isSetId() {
        return (this.id!= null);
    }

    /**
     * Gets the value of the idType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdType() {
        return idType;
    }

    /**
     * Sets the value of the idType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdType(String value) {
        this.idType = value;
    }

    public boolean isSetIdType() {
        return (this.idType!= null);
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    public boolean isSetStatus() {
        return (this.status!= null);
    }

    /**
     * Sets the value of the Products property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public GetMatchingProductForIdResult withProducts(ProductList value) {
        setProducts(value);
        return this;
    }

    /**
     * Sets the value of the Error property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public GetMatchingProductForIdResult withError(Error value) {
        setError(value);
        return this;
    }

    /**
     * Sets the value of the Id property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public GetMatchingProductForIdResult withId(String value) {
        setId(value);
        return this;
    }

    /**
     * Sets the value of the IdType property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public GetMatchingProductForIdResult withIdType(String value) {
        setIdType(value);
        return this;
    }

    /**
     * Sets the value of the Status property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public GetMatchingProductForIdResult withStatus(String value) {
        setStatus(value);
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
        if (isSetProducts()) {
            ProductList  products = getProducts();
            xml.append("<Products>");
            xml.append(products.toXMLFragment());
            xml.append("</Products>");
        } 
        if (isSetError()) {
            Error  error = getError();
            xml.append("<Error>");
            xml.append(error.toXMLFragment());
            xml.append("</Error>");
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
        if (isSetProducts()) {
            if (!first) json.append(", ");
            json.append("\"Products\" : {");
            ProductList  products = getProducts();


            json.append(products.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetError()) {
            if (!first) json.append(", ");
            json.append("\"Error\" : {");
            Error  error = getError();


            json.append(error.toJSONFragment());
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
