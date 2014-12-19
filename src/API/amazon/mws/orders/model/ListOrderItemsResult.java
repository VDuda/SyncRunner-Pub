
package API.amazon.mws.orders.model;

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
 *         &lt;element name="NextToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AmazonOrderId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OrderItems" type="{https://mws.amazonservices.com/Orders/2011-01-01}OrderItemList" minOccurs="0"/>
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
    "amazonOrderId",
    "orderItems"
})
@XmlRootElement(name = "ListOrderItemsResult")
public class ListOrderItemsResult {

    @XmlElement(name = "NextToken")
    protected String nextToken;
    @XmlElement(name = "AmazonOrderId", required = true)
    protected String amazonOrderId;
    @XmlElement(name = "OrderItems")
    protected OrderItemList orderItems;

    /**
     * Default constructor
     * 
     */
    public ListOrderItemsResult() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public ListOrderItemsResult(final String nextToken, final String amazonOrderId, final OrderItemList orderItems) {
        this.nextToken = nextToken;
        this.amazonOrderId = amazonOrderId;
        this.orderItems = orderItems;
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
     * Gets the value of the amazonOrderId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmazonOrderId() {
        return amazonOrderId;
    }

    /**
     * Sets the value of the amazonOrderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmazonOrderId(String value) {
        this.amazonOrderId = value;
    }

    public boolean isSetAmazonOrderId() {
        return (this.amazonOrderId!= null);
    }

    /**
     * Gets the value of the orderItems property.
     * 
     * @return
     *     possible object is
     *     {@link OrderItemList }
     *     
     */
    public OrderItemList getOrderItems() {
        return orderItems;
    }

    /**
     * Sets the value of the orderItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderItemList }
     *     
     */
    public void setOrderItems(OrderItemList value) {
        this.orderItems = value;
    }

    public boolean isSetOrderItems() {
        return (this.orderItems!= null);
    }

    /**
     * Sets the value of the NextToken property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ListOrderItemsResult withNextToken(String value) {
        setNextToken(value);
        return this;
    }

    /**
     * Sets the value of the AmazonOrderId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ListOrderItemsResult withAmazonOrderId(String value) {
        setAmazonOrderId(value);
        return this;
    }

    /**
     * Sets the value of the OrderItems property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ListOrderItemsResult withOrderItems(OrderItemList value) {
        setOrderItems(value);
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
        if (isSetAmazonOrderId()) {
            xml.append("<AmazonOrderId>");
            xml.append(escapeXML(getAmazonOrderId()));
            xml.append("</AmazonOrderId>");
        }
        if (isSetOrderItems()) {
            OrderItemList  orderItems = getOrderItems();
            xml.append("<OrderItems>");
            xml.append(orderItems.toXMLFragment());
            xml.append("</OrderItems>");
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
        if (isSetAmazonOrderId()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("AmazonOrderId"));
            json.append(" : ");
            json.append(quoteJSON(getAmazonOrderId()));
            first = false;
        }
        if (isSetOrderItems()) {
            if (!first) json.append(", ");
            json.append("\"OrderItems\" : {");
            OrderItemList  orderItems = getOrderItems();


            json.append(orderItems.toJSONFragment());
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
