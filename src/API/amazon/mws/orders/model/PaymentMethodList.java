
package API.amazon.mws.orders.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentMethodList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentMethodList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Method" type="{https://mws.amazonservices.com/Orders/2011-01-01}PaymentMethodEnum" maxOccurs="50"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentMethodList", propOrder = {
    "method"
})
public class PaymentMethodList {

    @XmlElement(name = "Method", required = true)
    protected List<PaymentMethodEnum> method;

    /**
     * Default constructor
     * 
     */
    public PaymentMethodList() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public PaymentMethodList(final List<PaymentMethodEnum> method) {
        this.method = method;
    }

    /**
     * Gets the value of the method property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the method property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMethod().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentMethodEnum }
     * 
     * 
     */
    public List<PaymentMethodEnum> getMethod() {
        if (method == null) {
            method = new ArrayList<PaymentMethodEnum>();
        }
        return this.method;
    }

    public boolean isSetMethod() {
        return ((this.method!= null)&&(!this.method.isEmpty()));
    }

    public void unsetMethod() {
        this.method = null;
    }

    /**
     * Sets the value of the Method property.
     * 
     * @param values
     * @return
     *     this instance
     */
    public PaymentMethodList withMethod(PaymentMethodEnum... values) {
        for (PaymentMethodEnum value: values) {
            getMethod().add(value);
        }
        return this;
    }

    /**
     * Sets the value of the method property.
     * 
     * @param method
     *     allowed object is
     *     {@link PaymentMethodEnum }
     *     
     */
    public void setMethod(List<PaymentMethodEnum> method) {
        this.method = method;
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
        java.util.List<PaymentMethodEnum> methodList  =  getMethod();
        for (PaymentMethodEnum method : methodList) { 
            xml.append("<Method>");
            xml.append(method.value());
            xml.append("</Method>");
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
        if (isSetMethod()) {
            if (!first) json.append(", ");
            json.append("\"Method\" : [");
            java.util.List<PaymentMethodEnum> methodList  =  getMethod();
            int methodListIndex  =  0;
            for (PaymentMethodEnum method : methodList) {
                if (methodListIndex > 0) json.append(", ");
                    json.append(method.value());
                ++methodListIndex;
            }
            json.append("]");
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
