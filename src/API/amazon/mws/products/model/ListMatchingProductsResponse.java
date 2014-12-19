
package API.amazon.mws.products.model;

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
 *         &lt;element ref="{http://mws.amazonservices.com/schema/Products/2011-10-01}ListMatchingProductsResult"/>
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
    "listMatchingProductsResult",
    "responseMetadata"
})
@XmlRootElement(name = "ListMatchingProductsResponse")
public class ListMatchingProductsResponse {

    @XmlElement(name = "ListMatchingProductsResult", required = true)
    protected ListMatchingProductsResult listMatchingProductsResult;
    @XmlElement(name = "ResponseMetadata", required = true)
    protected ResponseMetadata responseMetadata;

    /**
     * Default constructor
     * 
     */
    public ListMatchingProductsResponse() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public ListMatchingProductsResponse(final ListMatchingProductsResult listMatchingProductsResult, final ResponseMetadata responseMetadata) {
        this.listMatchingProductsResult = listMatchingProductsResult;
        this.responseMetadata = responseMetadata;
    }

    /**
     * Gets the value of the listMatchingProductsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ListMatchingProductsResult }
     *     
     */
    public ListMatchingProductsResult getListMatchingProductsResult() {
        return listMatchingProductsResult;
    }

    /**
     * Sets the value of the listMatchingProductsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListMatchingProductsResult }
     *     
     */
    public void setListMatchingProductsResult(ListMatchingProductsResult value) {
        this.listMatchingProductsResult = value;
    }

    public boolean isSetListMatchingProductsResult() {
        return (this.listMatchingProductsResult!= null);
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
     * Sets the value of the ListMatchingProductsResult property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ListMatchingProductsResponse withListMatchingProductsResult(ListMatchingProductsResult value) {
        setListMatchingProductsResult(value);
        return this;
    }

    /**
     * Sets the value of the ResponseMetadata property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ListMatchingProductsResponse withResponseMetadata(ResponseMetadata value) {
        setResponseMetadata(value);
        return this;
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
        xml.append("<ListMatchingProductsResponse xmlns=\"http://mws.amazonservices.com/schema/Products/2011-10-01\">");
        if (isSetListMatchingProductsResult()) {
            ListMatchingProductsResult  listMatchingProductsResult = getListMatchingProductsResult();
            xml.append("<ListMatchingProductsResult>");
            xml.append(listMatchingProductsResult.toXMLFragment());
            xml.append("</ListMatchingProductsResult>");
        } 
        if (isSetResponseMetadata()) {
            ResponseMetadata  responseMetadata = getResponseMetadata();
            xml.append("<ResponseMetadata>");
            xml.append(responseMetadata.toXMLFragment());
            xml.append("</ResponseMetadata>");
        } 
        xml.append("</ListMatchingProductsResponse>");
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
        json.append("{\"ListMatchingProductsResponse\" : {");
        json.append(quoteJSON("@xmlns"));
        json.append(" : ");
        json.append(quoteJSON("http://mws.amazonservices.com/schema/Products/2011-10-01"));
        boolean first = true;
        json.append(", ");
        if (isSetListMatchingProductsResult()) {
            if (!first) json.append(", ");
            json.append("\"ListMatchingProductsResult\" : {");
            ListMatchingProductsResult  listMatchingProductsResult = getListMatchingProductsResult();

            json.append(listMatchingProductsResult.toJSONFragment());
            json.append("}");
            first = false;
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
