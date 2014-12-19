
package API.amazon.mws.products.model;

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
 *         &lt;element name="Status" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}ServiceStatusEnum" minOccurs="0"/>
 *         &lt;element name="Timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="MessageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Messages" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}MessageList" minOccurs="0"/>
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
    "status",
    "timestamp",
    "messageId",
    "messages"
})
@XmlRootElement(name = "GetServiceStatusResult")
public class GetServiceStatusResult {

    @XmlElement(name = "Status")
    protected ServiceStatusEnum status;
    @XmlElement(name = "Timestamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timestamp;
    @XmlElement(name = "MessageId")
    protected String messageId;
    @XmlElement(name = "Messages")
    protected MessageList messages;

    /**
     * Default constructor
     * 
     */
    public GetServiceStatusResult() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public GetServiceStatusResult(final ServiceStatusEnum status, final XMLGregorianCalendar timestamp, final String messageId, final MessageList messages) {
        this.status = status;
        this.timestamp = timestamp;
        this.messageId = messageId;
        this.messages = messages;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceStatusEnum }
     *     
     */
    public ServiceStatusEnum getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceStatusEnum }
     *     
     */
    public void setStatus(ServiceStatusEnum value) {
        this.status = value;
    }

    public boolean isSetStatus() {
        return (this.status!= null);
    }

    /**
     * Gets the value of the timestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimestamp(XMLGregorianCalendar value) {
        this.timestamp = value;
    }

    public boolean isSetTimestamp() {
        return (this.timestamp!= null);
    }

    /**
     * Gets the value of the messageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Sets the value of the messageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageId(String value) {
        this.messageId = value;
    }

    public boolean isSetMessageId() {
        return (this.messageId!= null);
    }

    /**
     * Gets the value of the messages property.
     * 
     * @return
     *     possible object is
     *     {@link MessageList }
     *     
     */
    public MessageList getMessages() {
        return messages;
    }

    /**
     * Sets the value of the messages property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageList }
     *     
     */
    public void setMessages(MessageList value) {
        this.messages = value;
    }

    public boolean isSetMessages() {
        return (this.messages!= null);
    }

    /**
     * Sets the value of the Status property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public GetServiceStatusResult withStatus(ServiceStatusEnum value) {
        setStatus(value);
        return this;
    }

    /**
     * Sets the value of the Timestamp property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public GetServiceStatusResult withTimestamp(XMLGregorianCalendar value) {
        setTimestamp(value);
        return this;
    }

    /**
     * Sets the value of the MessageId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public GetServiceStatusResult withMessageId(String value) {
        setMessageId(value);
        return this;
    }

    /**
     * Sets the value of the Messages property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public GetServiceStatusResult withMessages(MessageList value) {
        setMessages(value);
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
        if (isSetStatus()) {
            xml.append("<Status>");
            xml.append(getStatus().value());
            xml.append("</Status>");
        }
        if (isSetTimestamp()) {
            xml.append("<Timestamp>");
            xml.append(getTimestamp() + "");
            xml.append("</Timestamp>");
        }
        if (isSetMessageId()) {
            xml.append("<MessageId>");
            xml.append(escapeXML(getMessageId()));
            xml.append("</MessageId>");
        }
        if (isSetMessages()) {
            MessageList  messages = getMessages();
            xml.append("<Messages>");
            xml.append(messages.toXMLFragment());
            xml.append("</Messages>");
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
        if (isSetStatus()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("Status"));
            json.append(" : ");
            json.append(quoteJSON(getStatus().value()));
            first = false;
        }
        if (isSetTimestamp()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("Timestamp"));
            json.append(" : ");
            json.append(quoteJSON(getTimestamp() + ""));
            first = false;
        }
        if (isSetMessageId()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("MessageId"));
            json.append(" : ");
            json.append(quoteJSON(getMessageId()));
            first = false;
        }
        if (isSetMessages()) {
            if (!first) json.append(", ");
            json.append("\"Messages\" : {");
            MessageList  messages = getMessages();


            json.append(messages.toJSONFragment());
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
