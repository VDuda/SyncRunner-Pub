
package API.amazon.mws.orders.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrderItemList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrderItemList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrderItem" type="{https://mws.amazonservices.com/Orders/2011-01-01}OrderItem" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderItemList", propOrder = {
    "orderItem"
})
public class OrderItemList {

    @XmlElement(name = "OrderItem", required = true)
    protected List<OrderItem> orderItem;

    /**
     * Default constructor
     * 
     */
    public OrderItemList() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public OrderItemList(final List<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }

    /**
     * Gets the value of the orderItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orderItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrderItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrderItem }
     * 
     * 
     */
    public List<OrderItem> getOrderItem() {
        if (orderItem == null) {
            orderItem = new ArrayList<OrderItem>();
        }
        return this.orderItem;
    }

    public boolean isSetOrderItem() {
        return ((this.orderItem!= null)&&(!this.orderItem.isEmpty()));
    }

    public void unsetOrderItem() {
        this.orderItem = null;
    }

    /**
     * Sets the value of the OrderItem property.
     * 
     * @param values
     * @return
     *     this instance
     */
    public OrderItemList withOrderItem(OrderItem... values) {
        for (OrderItem value: values) {
            getOrderItem().add(value);
        }
        return this;
    }

    /**
     * Sets the value of the orderItem property.
     * 
     * @param orderItem
     *     allowed object is
     *     {@link OrderItem }
     *     
     */
    public void setOrderItem(List<OrderItem> orderItem) {
        this.orderItem = orderItem;
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
        java.util.List<OrderItem> orderItemList = getOrderItem();
        for (OrderItem orderItem : orderItemList) {
            xml.append("<OrderItem>");
            xml.append(orderItem.toXMLFragment());
            xml.append("</OrderItem>");
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
        if (isSetOrderItem()) {
            if (!first) json.append(", ");
            json.append("\"OrderItem\" : [");
            java.util.List<OrderItem> orderItemList = getOrderItem();
            int orderItemListIndex = 0;
            for (OrderItem orderItem : orderItemList) {
                if (orderItemListIndex > 0) json.append(", ");
                json.append("{");
                json.append("");
                json.append(orderItem.toJSONFragment());
                json.append("}");
                first = false;
                ++orderItemListIndex;
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
