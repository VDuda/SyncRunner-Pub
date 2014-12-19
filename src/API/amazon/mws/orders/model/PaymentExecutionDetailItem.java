
package API.amazon.mws.orders.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentExecutionDetailItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentExecutionDetailItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Payment" type="{https://mws.amazonservices.com/Orders/2011-01-01}Money"/>
 *         &lt;element name="PaymentMethod" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentExecutionDetailItem", propOrder = {
    "payment",
    "paymentMethod"
})
public class PaymentExecutionDetailItem {

    @XmlElement(name = "Payment", required = true)
    protected Money payment;
    @XmlElement(name = "PaymentMethod", required = true)
    protected String paymentMethod;

    /**
     * Default constructor
     * 
     */
    public PaymentExecutionDetailItem() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public PaymentExecutionDetailItem(final Money payment, final String paymentMethod) {
        this.payment = payment;
        this.paymentMethod = paymentMethod;
    }

    /**
     * Gets the value of the payment property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getPayment() {
        return payment;
    }

    /**
     * Sets the value of the payment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setPayment(Money value) {
        this.payment = value;
    }

    public boolean isSetPayment() {
        return (this.payment!= null);
    }

    /**
     * Gets the value of the paymentMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the value of the paymentMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentMethod(String value) {
        this.paymentMethod = value;
    }

    public boolean isSetPaymentMethod() {
        return (this.paymentMethod!= null);
    }

    /**
     * Sets the value of the Payment property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public PaymentExecutionDetailItem withPayment(Money value) {
        setPayment(value);
        return this;
    }

    /**
     * Sets the value of the PaymentMethod property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public PaymentExecutionDetailItem withPaymentMethod(String value) {
        setPaymentMethod(value);
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
        if (isSetPayment()) {
            Money  payment = getPayment();
            xml.append("<Payment>");
            xml.append(payment.toXMLFragment());
            xml.append("</Payment>");
        } 
        if (isSetPaymentMethod()) {
            xml.append("<PaymentMethod>");
            xml.append(escapeXML(getPaymentMethod()));
            xml.append("</PaymentMethod>");
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
        if (isSetPayment()) {
            if (!first) json.append(", ");
            json.append("\"Payment\" : {");
            Money  payment = getPayment();


            json.append(payment.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetPaymentMethod()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("PaymentMethod"));
            json.append(" : ");
            json.append(quoteJSON(getPaymentMethod()));
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
