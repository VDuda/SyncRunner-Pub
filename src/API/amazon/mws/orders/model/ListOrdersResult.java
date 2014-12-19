
package API.amazon.mws.orders.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="NextToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreatedBefore" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="LastUpdatedBefore" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Orders" type="{https://mws.amazonservices.com/Orders/2011-01-01}OrderList" minOccurs="0"/>
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
    "nextToken",
    "createdBefore",
    "lastUpdatedBefore",
    "orders"
})
@XmlRootElement(name = "ListOrdersResult")
public class ListOrdersResult {

    @XmlElement(name = "NextToken")
    protected String nextToken;
    @XmlElement(name = "CreatedBefore")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdBefore;
    @XmlElement(name = "LastUpdatedBefore")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdatedBefore;
    @XmlElement(name = "Orders")
    protected OrderList orders;

    /**
     * Default constructor
     * 
     */
    public ListOrdersResult() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public ListOrdersResult(final String nextToken, final XMLGregorianCalendar createdBefore, final XMLGregorianCalendar lastUpdatedBefore, final OrderList orders) {
        this.nextToken = nextToken;
        this.createdBefore = createdBefore;
        this.lastUpdatedBefore = lastUpdatedBefore;
        this.orders = orders;
    }

    /**
     * Gets the value of the nextToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNextToken() {
        return nextToken;
    }

    /**
     * Sets the value of the nextToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNextToken(String value) {
        this.nextToken = value;
    }

    public boolean isSetNextToken() {
        return (this.nextToken!= null);
    }

    /**
     * Gets the value of the createdBefore property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedBefore() {
        return createdBefore;
    }

    /**
     * Sets the value of the createdBefore property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedBefore(XMLGregorianCalendar value) {
        this.createdBefore = value;
    }

    public boolean isSetCreatedBefore() {
        return (this.createdBefore!= null);
    }

    /**
     * Gets the value of the lastUpdatedBefore property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastUpdatedBefore() {
        return lastUpdatedBefore;
    }

    /**
     * Sets the value of the lastUpdatedBefore property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastUpdatedBefore(XMLGregorianCalendar value) {
        this.lastUpdatedBefore = value;
    }

    public boolean isSetLastUpdatedBefore() {
        return (this.lastUpdatedBefore!= null);
    }

    /**
     * Gets the value of the orders property.
     * 
     * @return
     *     possible object is
     *     {@link OrderList }
     *     
     */
    public OrderList getOrders() {
        return orders;
    }

    /**
     * Sets the value of the orders property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderList }
     *     
     */
    public void setOrders(OrderList value) {
        this.orders = value;
    }

    public boolean isSetOrders() {
        return (this.orders!= null);
    }

    /**
     * Sets the value of the NextToken property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ListOrdersResult withNextToken(String value) {
        setNextToken(value);
        return this;
    }

    /**
     * Sets the value of the CreatedBefore property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ListOrdersResult withCreatedBefore(XMLGregorianCalendar value) {
        setCreatedBefore(value);
        return this;
    }

    /**
     * Sets the value of the LastUpdatedBefore property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ListOrdersResult withLastUpdatedBefore(XMLGregorianCalendar value) {
        setLastUpdatedBefore(value);
        return this;
    }

    /**
     * Sets the value of the Orders property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ListOrdersResult withOrders(OrderList value) {
        setOrders(value);
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
        if (isSetNextToken()) {
            xml.append("<NextToken>");
            xml.append(escapeXML(getNextToken()));
            xml.append("</NextToken>");
        }
        if (isSetCreatedBefore()) {
            xml.append("<CreatedBefore>");
            xml.append(getCreatedBefore() + "");
            xml.append("</CreatedBefore>");
        }
        if (isSetLastUpdatedBefore()) {
            xml.append("<LastUpdatedBefore>");
            xml.append(getLastUpdatedBefore() + "");
            xml.append("</LastUpdatedBefore>");
        }
        if (isSetOrders()) {
            OrderList  orders = getOrders();
            xml.append("<Orders>");
            xml.append(orders.toXMLFragment());
            xml.append("</Orders>");
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
        if (isSetNextToken()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("NextToken"));
            json.append(" : ");
            json.append(quoteJSON(getNextToken()));
            first = false;
        }
        if (isSetCreatedBefore()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("CreatedBefore"));
            json.append(" : ");
            json.append(quoteJSON(getCreatedBefore() + ""));
            first = false;
        }
        if (isSetLastUpdatedBefore()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("LastUpdatedBefore"));
            json.append(" : ");
            json.append(quoteJSON(getLastUpdatedBefore() + ""));
            first = false;
        }
        if (isSetOrders()) {
            if (!first) json.append(", ");
            json.append("\"Orders\" : {");
            OrderList  orders = getOrders();


            json.append(orders.toJSONFragment());
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
