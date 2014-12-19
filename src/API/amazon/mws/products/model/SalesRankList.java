
package API.amazon.mws.products.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SalesRankList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SalesRankList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SalesRank" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}SalesRankType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SalesRankList", propOrder = {
    "salesRank"
})
public class SalesRankList {

    @XmlElement(name = "SalesRank", required = true)
    protected List<SalesRankType> salesRank;

    /**
     * Default constructor
     * 
     */
    public SalesRankList() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public SalesRankList(final List<SalesRankType> salesRank) {
        this.salesRank = salesRank;
    }

    /**
     * Gets the value of the salesRank property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the salesRank property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSalesRank().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SalesRankType }
     * 
     * 
     */
    public List<SalesRankType> getSalesRank() {
        if (salesRank == null) {
            salesRank = new ArrayList<SalesRankType>();
        }
        return this.salesRank;
    }

    public boolean isSetSalesRank() {
        return ((this.salesRank!= null)&&(!this.salesRank.isEmpty()));
    }

    public void unsetSalesRank() {
        this.salesRank = null;
    }

    /**
     * Sets the value of the SalesRank property.
     * 
     * @param values
     * @return
     *     this instance
     */
    public SalesRankList withSalesRank(SalesRankType... values) {
        for (SalesRankType value: values) {
            getSalesRank().add(value);
        }
        return this;
    }

    /**
     * Sets the value of the salesRank property.
     * 
     * @param salesRank
     *     allowed object is
     *     {@link SalesRankType }
     *     
     */
    public void setSalesRank(List<SalesRankType> salesRank) {
        this.salesRank = salesRank;
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
        java.util.List<SalesRankType> salesRankList = getSalesRank();
        for (SalesRankType salesRank : salesRankList) {
            xml.append("<SalesRank>");
            xml.append(salesRank.toXMLFragment());
            xml.append("</SalesRank>");
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
        if (isSetSalesRank()) {
            if (!first) json.append(", ");
            json.append("\"SalesRank\" : [");
            java.util.List<SalesRankType> salesRankList = getSalesRank();
            int salesRankListIndex = 0;
            for (SalesRankType salesRank : salesRankList) {
                if (salesRankListIndex > 0) json.append(", ");
                json.append("{");
                json.append("");
                json.append(salesRank.toJSONFragment());
                json.append("}");
                first = false;
                ++salesRankListIndex;
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
