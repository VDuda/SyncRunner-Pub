
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
 *         &lt;element ref="{http://mws.amazonservices.com/schema/Products/2011-10-01}GetLowestOfferListingsForASINResult" maxOccurs="unbounded"/>
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
    "getLowestOfferListingsForASINResult",
    "responseMetadata"
})
@XmlRootElement(name = "GetLowestOfferListingsForASINResponse")
public class GetLowestOfferListingsForASINResponse {

    @XmlElement(name = "GetLowestOfferListingsForASINResult", required = true)
    protected List<GetLowestOfferListingsForASINResult> getLowestOfferListingsForASINResult;
    @XmlElement(name = "ResponseMetadata", required = true)
    protected ResponseMetadata responseMetadata;

    /**
     * Default constructor
     * 
     */
    public GetLowestOfferListingsForASINResponse() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public GetLowestOfferListingsForASINResponse(final List<GetLowestOfferListingsForASINResult> getLowestOfferListingsForASINResult, final ResponseMetadata responseMetadata) {
        this.getLowestOfferListingsForASINResult = getLowestOfferListingsForASINResult;
        this.responseMetadata = responseMetadata;
    }

    /**
     * Gets the value of the getLowestOfferListingsForASINResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getLowestOfferListingsForASINResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetLowestOfferListingsForASINResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetLowestOfferListingsForASINResult }
     * 
     * 
     */
    public List<GetLowestOfferListingsForASINResult> getGetLowestOfferListingsForASINResult() {
        if (getLowestOfferListingsForASINResult == null) {
            getLowestOfferListingsForASINResult = new ArrayList<GetLowestOfferListingsForASINResult>();
        }
        return this.getLowestOfferListingsForASINResult;
    }

    public boolean isSetGetLowestOfferListingsForASINResult() {
        return ((this.getLowestOfferListingsForASINResult!= null)&&(!this.getLowestOfferListingsForASINResult.isEmpty()));
    }

    public void unsetGetLowestOfferListingsForASINResult() {
        this.getLowestOfferListingsForASINResult = null;
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
     * Sets the value of the GetLowestOfferListingsForASINResult property.
     * 
     * @param values
     * @return
     *     this instance
     */
    public GetLowestOfferListingsForASINResponse withGetLowestOfferListingsForASINResult(GetLowestOfferListingsForASINResult... values) {
        for (GetLowestOfferListingsForASINResult value: values) {
            getGetLowestOfferListingsForASINResult().add(value);
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
    public GetLowestOfferListingsForASINResponse withResponseMetadata(ResponseMetadata value) {
        setResponseMetadata(value);
        return this;
    }

    /**
     * Sets the value of the getLowestOfferListingsForASINResult property.
     * 
     * @param getLowestOfferListingsForASINResult
     *     allowed object is
     *     {@link GetLowestOfferListingsForASINResult }
     *     
     */
    public void setGetLowestOfferListingsForASINResult(List<GetLowestOfferListingsForASINResult> getLowestOfferListingsForASINResult) {
        this.getLowestOfferListingsForASINResult = getLowestOfferListingsForASINResult;
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
        xml.append("<GetLowestOfferListingsForASINResponse xmlns=\"http://mws.amazonservices.com/schema/Products/2011-10-01\">");
        java.util.List<GetLowestOfferListingsForASINResult> getLowestOfferListingsForASINResultList = getGetLowestOfferListingsForASINResult();
        for (GetLowestOfferListingsForASINResult getLowestOfferListingsForASINResult : getLowestOfferListingsForASINResultList) {
            xml.append("<GetLowestOfferListingsForASINResult " + (getLowestOfferListingsForASINResult.isSetASIN() ? " ASIN=" + "\"" + escapeXML(getLowestOfferListingsForASINResult.getASIN()) + "\"" : "") + " " + (getLowestOfferListingsForASINResult.isSetStatus() ? " status=" + "\"" + escapeXML(getLowestOfferListingsForASINResult.getStatus()) + "\"" : "") + ">");
            xml.append(getLowestOfferListingsForASINResult.toXMLFragment());
            xml.append("</GetLowestOfferListingsForASINResult>");
        }
        if (isSetResponseMetadata()) {
            ResponseMetadata  responseMetadata = getResponseMetadata();
            xml.append("<ResponseMetadata>");
            xml.append(responseMetadata.toXMLFragment());
            xml.append("</ResponseMetadata>");
        } 
        xml.append("</GetLowestOfferListingsForASINResponse>");
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
        json.append("{\"GetLowestOfferListingsForASINResponse\" : {");
        json.append(quoteJSON("@xmlns"));
        json.append(" : ");
        json.append(quoteJSON("http://mws.amazonservices.com/schema/Products/2011-10-01"));
        boolean first = true;
        json.append(", ");
        if (isSetGetLowestOfferListingsForASINResult()) {
            if (!first) json.append(", ");
            json.append("\"GetLowestOfferListingsForASINResult\" : [");
            java.util.List<GetLowestOfferListingsForASINResult> getLowestOfferListingsForASINResultList = getGetLowestOfferListingsForASINResult();
            int getLowestOfferListingsForASINResultListIndex = 0;
            for (GetLowestOfferListingsForASINResult getLowestOfferListingsForASINResult : getLowestOfferListingsForASINResultList) {
                if (getLowestOfferListingsForASINResultListIndex > 0) json.append(", ");
                json.append("{");
                json.append("");
                json.append(getLowestOfferListingsForASINResult.toJSONFragment());
                json.append("}");
                first = false;
                ++getLowestOfferListingsForASINResultListIndex;
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
