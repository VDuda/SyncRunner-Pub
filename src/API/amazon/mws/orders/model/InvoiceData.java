
package API.amazon.mws.orders.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InvoiceData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InvoiceData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InvoiceRequirement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BuyerSelectedInvoiceCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InvoiceTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InvoiceInformation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvoiceData", propOrder = {
    "invoiceRequirement",
    "buyerSelectedInvoiceCategory",
    "invoiceTitle",
    "invoiceInformation"
})
public class InvoiceData {

    @XmlElement(name = "InvoiceRequirement")
    protected String invoiceRequirement;
    @XmlElement(name = "BuyerSelectedInvoiceCategory")
    protected String buyerSelectedInvoiceCategory;
    @XmlElement(name = "InvoiceTitle")
    protected String invoiceTitle;
    @XmlElement(name = "InvoiceInformation")
    protected String invoiceInformation;

    /**
     * Default constructor
     * 
     */
    public InvoiceData() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public InvoiceData(final String invoiceRequirement, final String buyerSelectedInvoiceCategory, final String invoiceTitle, final String invoiceInformation) {
        this.invoiceRequirement = invoiceRequirement;
        this.buyerSelectedInvoiceCategory = buyerSelectedInvoiceCategory;
        this.invoiceTitle = invoiceTitle;
        this.invoiceInformation = invoiceInformation;
    }

    /**
     * Gets the value of the invoiceRequirement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceRequirement() {
        return invoiceRequirement;
    }

    /**
     * Sets the value of the invoiceRequirement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceRequirement(String value) {
        this.invoiceRequirement = value;
    }

    public boolean isSetInvoiceRequirement() {
        return (this.invoiceRequirement!= null);
    }

    /**
     * Gets the value of the buyerSelectedInvoiceCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuyerSelectedInvoiceCategory() {
        return buyerSelectedInvoiceCategory;
    }

    /**
     * Sets the value of the buyerSelectedInvoiceCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuyerSelectedInvoiceCategory(String value) {
        this.buyerSelectedInvoiceCategory = value;
    }

    public boolean isSetBuyerSelectedInvoiceCategory() {
        return (this.buyerSelectedInvoiceCategory!= null);
    }

    /**
     * Gets the value of the invoiceTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    /**
     * Sets the value of the invoiceTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceTitle(String value) {
        this.invoiceTitle = value;
    }

    public boolean isSetInvoiceTitle() {
        return (this.invoiceTitle!= null);
    }

    /**
     * Gets the value of the invoiceInformation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceInformation() {
        return invoiceInformation;
    }

    /**
     * Sets the value of the invoiceInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceInformation(String value) {
        this.invoiceInformation = value;
    }

    public boolean isSetInvoiceInformation() {
        return (this.invoiceInformation!= null);
    }

    /**
     * Sets the value of the InvoiceRequirement property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public InvoiceData withInvoiceRequirement(String value) {
        setInvoiceRequirement(value);
        return this;
    }

    /**
     * Sets the value of the BuyerSelectedInvoiceCategory property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public InvoiceData withBuyerSelectedInvoiceCategory(String value) {
        setBuyerSelectedInvoiceCategory(value);
        return this;
    }

    /**
     * Sets the value of the InvoiceTitle property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public InvoiceData withInvoiceTitle(String value) {
        setInvoiceTitle(value);
        return this;
    }

    /**
     * Sets the value of the InvoiceInformation property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public InvoiceData withInvoiceInformation(String value) {
        setInvoiceInformation(value);
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
        if (isSetInvoiceRequirement()) {
            xml.append("<InvoiceRequirement>");
            xml.append(escapeXML(getInvoiceRequirement()));
            xml.append("</InvoiceRequirement>");
        }
        if (isSetBuyerSelectedInvoiceCategory()) {
            xml.append("<BuyerSelectedInvoiceCategory>");
            xml.append(escapeXML(getBuyerSelectedInvoiceCategory()));
            xml.append("</BuyerSelectedInvoiceCategory>");
        }
        if (isSetInvoiceTitle()) {
            xml.append("<InvoiceTitle>");
            xml.append(escapeXML(getInvoiceTitle()));
            xml.append("</InvoiceTitle>");
        }
        if (isSetInvoiceInformation()) {
            xml.append("<InvoiceInformation>");
            xml.append(escapeXML(getInvoiceInformation()));
            xml.append("</InvoiceInformation>");
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
        if (isSetInvoiceRequirement()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("InvoiceRequirement"));
            json.append(" : ");
            json.append(quoteJSON(getInvoiceRequirement()));
            first = false;
        }
        if (isSetBuyerSelectedInvoiceCategory()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("BuyerSelectedInvoiceCategory"));
            json.append(" : ");
            json.append(quoteJSON(getBuyerSelectedInvoiceCategory()));
            first = false;
        }
        if (isSetInvoiceTitle()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("InvoiceTitle"));
            json.append(" : ");
            json.append(quoteJSON(getInvoiceTitle()));
            first = false;
        }
        if (isSetInvoiceInformation()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("InvoiceInformation"));
            json.append(" : ");
            json.append(quoteJSON(getInvoiceInformation()));
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
