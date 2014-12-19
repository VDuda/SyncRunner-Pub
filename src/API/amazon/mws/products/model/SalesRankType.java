
package API.amazon.mws.products.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SalesRankType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SalesRankType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProductCategoryId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Rank" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SalesRankType", propOrder = {
    "productCategoryId",
    "rank"
})
public class SalesRankType {

    @XmlElement(name = "ProductCategoryId", required = true)
    protected String productCategoryId;
    @XmlElement(name = "Rank")
    protected int rank;

    /**
     * Default constructor
     * 
     */
    public SalesRankType() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public SalesRankType(final String productCategoryId, final int rank) {
        this.productCategoryId = productCategoryId;
        this.rank = rank;
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
     * Gets the value of the rank property.
     * 
     */
    public int getRank() {
        return rank;
    }

    /**
     * Sets the value of the rank property.
     * 
     */
    public void setRank(int value) {
        this.rank = value;
    }

    public boolean isSetRank() {
        return true;
    }

    /**
     * Sets the value of the ProductCategoryId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SalesRankType withProductCategoryId(String value) {
        setProductCategoryId(value);
        return this;
    }

    /**
     * Sets the value of the Rank property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SalesRankType withRank(int value) {
        setRank(value);
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
        if (isSetRank()) {
            xml.append("<Rank>");
            xml.append(getRank() + "");
            xml.append("</Rank>");
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
        if (isSetRank()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("Rank"));
            json.append(" : ");
            json.append(quoteJSON(getRank() + ""));
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
