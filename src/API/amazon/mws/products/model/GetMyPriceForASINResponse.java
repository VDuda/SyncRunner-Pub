
package API.amazon.mws.products.model;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{http://mws.amazonservices.com/schema/Products/2011-10-01}GetMyPriceForASINResult" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://mws.amazonservices.com/schema/Products/2011-10-01}ResponseMetadata"/>
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
    "getMyPriceForASINResult",
    "responseMetadata"
})
@XmlRootElement(name = "GetMyPriceForASINResponse")
public class GetMyPriceForASINResponse {

    @XmlElement(name = "GetMyPriceForASINResult", required = true)
    protected List<GetMyPriceForASINResult> getMyPriceForASINResult;
    @XmlElement(name = "ResponseMetadata", required = true)
    protected ResponseMetadata responseMetadata;

    /**
     * Default constructor
     * 
     */
    public GetMyPriceForASINResponse() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public GetMyPriceForASINResponse(final List<GetMyPriceForASINResult> getMyPriceForASINResult, final ResponseMetadata responseMetadata) {
        this.getMyPriceForASINResult = getMyPriceForASINResult;
        this.responseMetadata = responseMetadata;
    }

    /**
     * Gets the value of the getMyPriceForASINResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getMyPriceForASINResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetMyPriceForASINResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetMyPriceForASINResult }
     * 
     * 
     */
    public List<GetMyPriceForASINResult> getGetMyPriceForASINResult() {
        if (getMyPriceForASINResult == null) {
            getMyPriceForASINResult = new ArrayList<GetMyPriceForASINResult>();
        }
        return this.getMyPriceForASINResult;
    }

    public boolean isSetGetMyPriceForASINResult() {
        return ((this.getMyPriceForASINResult!= null)&&(!this.getMyPriceForASINResult.isEmpty()));
    }

    public void unsetGetMyPriceForASINResult() {
        this.getMyPriceForASINResult = null;
    }

    /**
     * Gets the value of the responseMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseMetadata }
     *     
     */
    public ResponseMetadata getResponseMetadata() {
        return responseMetadata;
    }

    /**
     * Sets the value of the responseMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseMetadata }
     *     
     */
    public void setResponseMetadata(ResponseMetadata value) {
        this.responseMetadata = value;
    }

    public boolean isSetResponseMetadata() {
        return (this.responseMetadata!= null);
    }

    /**
     * Sets the value of the GetMyPriceForASINResult property.
     * 
     * @param values
     * @return
     *     this instance
     */
    public GetMyPriceForASINResponse withGetMyPriceForASINResult(GetMyPriceForASINResult... values) {
        for (GetMyPriceForASINResult value: values) {
            getGetMyPriceForASINResult().add(value);
        }
        return this;
    }

    /**
     * Sets the value of the ResponseMetadata property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public GetMyPriceForASINResponse withResponseMetadata(ResponseMetadata value) {
        setResponseMetadata(value);
        return this;
    }

    /**
     * Sets the value of the getMyPriceForASINResult property.
     * 
     * @param getMyPriceForASINResult
     *     allowed object is
     *     {@link GetMyPriceForASINResult }
     *     
     */
    public void setGetMyPriceForASINResult(List<GetMyPriceForASINResult> getMyPriceForASINResult) {
        this.getMyPriceForASINResult = getMyPriceForASINResult;
    }
    

    @javax.xml.bind.annotation.XmlTransient
    private ResponseHeaderMetadata responseHeaderMetadata;


    /**
     * Checks whether the ResponseHeaderMetadata field has been set.
     */
    public boolean isSetResponseHeaderMetadata() { 
        return this.responseHeaderMetadata != null;
    }  


    /**
     * Sets the ResponseHeaderMetadata field.
     */
    public void setResponseHeaderMetadata(ResponseHeaderMetadata responseHeaderMetadata) { 
        this.responseHeaderMetadata = responseHeaderMetadata;
    } 


    /**
     * Gets the ResponseHeaderMetadata field.
     */
    public ResponseHeaderMetadata getResponseHeaderMetadata() {  
        return responseHeaderMetadata;
    }  



    /**
     * 
     * XML string representation of this object
     * 
     * @return XML String
     */
    public String toXML() {
        StringBuffer xml = new StringBuffer();
        xml.append("<GetMyPriceForASINResponse xmlns=\"http://mws.amazonservices.com/schema/Products/2011-10-01\">");
        java.util.List<GetMyPriceForASINResult> getMyPriceForASINResultList = getGetMyPriceForASINResult();
        for (GetMyPriceForASINResult getMyPriceForASINResult : getMyPriceForASINResultList) {
            xml.append("<GetMyPriceForASINResult " + (getMyPriceForASINResult.isSetASIN() ? " ASIN=" + "\"" + escapeXML(getMyPriceForASINResult.getASIN()) + "\"" : "") + " " + (getMyPriceForASINResult.isSetStatus() ? " status=" + "\"" + escapeXML(getMyPriceForASINResult.getStatus()) + "\"" : "") + ">");
            xml.append(getMyPriceForASINResult.toXMLFragment());
            xml.append("</GetMyPriceForASINResult>");
        }
        if (isSetResponseMetadata()) {
            ResponseMetadata  responseMetadata = getResponseMetadata();
            xml.append("<ResponseMetadata>");
            xml.append(responseMetadata.toXMLFragment());
            xml.append("</ResponseMetadata>");
        } 
        xml.append("</GetMyPriceForASINResponse>");
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
     * JSON string representation of this object
     * 
     * @return JSON String
     */
    public String toJSON() {
        StringBuffer json = new StringBuffer();
        json.append("{\"GetMyPriceForASINResponse\" : {");
        json.append(quoteJSON("@xmlns"));
        json.append(" : ");
        json.append(quoteJSON("http://mws.amazonservices.com/schema/Products/2011-10-01"));
        boolean first = true;
        json.append(", ");
        if (isSetGetMyPriceForASINResult()) {
            if (!first) json.append(", ");
            json.append("\"GetMyPriceForASINResult\" : [");
            java.util.List<GetMyPriceForASINResult> getMyPriceForASINResultList = getGetMyPriceForASINResult();
            int getMyPriceForASINResultListIndex = 0;
            for (GetMyPriceForASINResult getMyPriceForASINResult : getMyPriceForASINResultList) {
                if (getMyPriceForASINResultListIndex > 0) json.append(", ");
                json.append("{");
                json.append("");
                json.append(getMyPriceForASINResult.toJSONFragment());
                json.append("}");
                first = false;
                ++getMyPriceForASINResultListIndex;
            }
            json.append("]");
        }
        if (isSetResponseMetadata()) {
            if (!first) json.append(", ");
            json.append("\"ResponseMetadata\" : {");
            ResponseMetadata  responseMetadata = getResponseMetadata();

            json.append(responseMetadata.toJSONFragment());
            json.append("}");
            first = false;
        } 
        json.append("}");
        json.append("}");
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
