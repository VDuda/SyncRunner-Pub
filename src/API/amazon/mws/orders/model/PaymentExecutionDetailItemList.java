
package API.amazon.mws.orders.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentExecutionDetailItemList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentExecutionDetailItemList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PaymentExecutionDetailItem" type="{https://mws.amazonservices.com/Orders/2011-01-01}PaymentExecutionDetailItem" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentExecutionDetailItemList", propOrder = {
    "paymentExecutionDetailItem"
})
public class PaymentExecutionDetailItemList {

    @XmlElement(name = "PaymentExecutionDetailItem", required = true)
    protected List<PaymentExecutionDetailItem> paymentExecutionDetailItem;

    /**
     * Default constructor
     * 
     */
    public PaymentExecutionDetailItemList() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public PaymentExecutionDetailItemList(final List<PaymentExecutionDetailItem> paymentExecutionDetailItem) {
        this.paymentExecutionDetailItem = paymentExecutionDetailItem;
    }

    /**
     * Gets the value of the paymentExecutionDetailItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentExecutionDetailItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentExecutionDetailItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentExecutionDetailItem }
     * 
     * 
     */
    public List<PaymentExecutionDetailItem> getPaymentExecutionDetailItem() {
        if (paymentExecutionDetailItem == null) {
            paymentExecutionDetailItem = new ArrayList<PaymentExecutionDetailItem>();
        }
        return this.paymentExecutionDetailItem;
    }

    public boolean isSetPaymentExecutionDetailItem() {
        return ((this.paymentExecutionDetailItem!= null)&&(!this.paymentExecutionDetailItem.isEmpty()));
    }

    public void unsetPaymentExecutionDetailItem() {
        this.paymentExecutionDetailItem = null;
    }

    /**
     * Sets the value of the PaymentExecutionDetailItem property.
     * 
     * @param values
     * @return
     *     this instance
     */
    public PaymentExecutionDetailItemList withPaymentExecutionDetailItem(PaymentExecutionDetailItem... values) {
        for (PaymentExecutionDetailItem value: values) {
            getPaymentExecutionDetailItem().add(value);
        }
        return this;
    }

    /**
     * Sets the value of the paymentExecutionDetailItem property.
     * 
     * @param paymentExecutionDetailItem
     *     allowed object is
     *     {@link PaymentExecutionDetailItem }
     *     
     */
    public void setPaymentExecutionDetailItem(List<PaymentExecutionDetailItem> paymentExecutionDetailItem) {
        this.paymentExecutionDetailItem = paymentExecutionDetailItem;
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
        java.util.List<PaymentExecutionDetailItem> paymentExecutionDetailItemList = getPaymentExecutionDetailItem();
        for (PaymentExecutionDetailItem paymentExecutionDetailItem : paymentExecutionDetailItemList) {
            xml.append("<PaymentExecutionDetailItem>");
            xml.append(paymentExecutionDetailItem.toXMLFragment());
            xml.append("</PaymentExecutionDetailItem>");
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
        if (isSetPaymentExecutionDetailItem()) {
            if (!first) json.append(", ");
            json.append("\"PaymentExecutionDetailItem\" : [");
            java.util.List<PaymentExecutionDetailItem> paymentExecutionDetailItemList = getPaymentExecutionDetailItem();
            int paymentExecutionDetailItemListIndex = 0;
            for (PaymentExecutionDetailItem paymentExecutionDetailItem : paymentExecutionDetailItemList) {
                if (paymentExecutionDetailItemListIndex > 0) json.append(", ");
                json.append("{");
                json.append("");
                json.append(paymentExecutionDetailItem.toJSONFragment());
                json.append("}");
                first = false;
                ++paymentExecutionDetailItemListIndex;
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
