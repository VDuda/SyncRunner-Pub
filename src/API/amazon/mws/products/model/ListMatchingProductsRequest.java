
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
 *         &lt;element name="SellerId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MarketplaceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Query" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="QueryContextId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "sellerId",
    "marketplaceId",
    "query",
    "queryContextId"
})
@XmlRootElement(name = "ListMatchingProductsRequest")
public class ListMatchingProductsRequest {

    @XmlElement(name = "SellerId", required = true)
    protected String sellerId;
    @XmlElement(name = "MarketplaceId", required = true)
    protected String marketplaceId;
    @XmlElement(name = "Query", required = true)
    protected String query;
    @XmlElement(name = "QueryContextId")
    protected String queryContextId;

    /**
     * Default constructor
     * 
     */
    public ListMatchingProductsRequest() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public ListMatchingProductsRequest(final String sellerId, final String marketplaceId, final String query, final String queryContextId) {
        this.sellerId = sellerId;
        this.marketplaceId = marketplaceId;
        this.query = query;
        this.queryContextId = queryContextId;
    }

    /**
     * Gets the value of the sellerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * Sets the value of the sellerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellerId(String value) {
        this.sellerId = value;
    }

    public boolean isSetSellerId() {
        return (this.sellerId!= null);
    }

    /**
     * Gets the value of the marketplaceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarketplaceId() {
        return marketplaceId;
    }

    /**
     * Sets the value of the marketplaceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarketplaceId(String value) {
        this.marketplaceId = value;
    }

    public boolean isSetMarketplaceId() {
        return (this.marketplaceId!= null);
    }

    /**
     * Gets the value of the query property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuery() {
        return query;
    }

    /**
     * Sets the value of the query property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuery(String value) {
        this.query = value;
    }

    public boolean isSetQuery() {
        return (this.query!= null);
    }

    /**
     * Gets the value of the queryContextId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryContextId() {
        return queryContextId;
    }

    /**
     * Sets the value of the queryContextId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryContextId(String value) {
        this.queryContextId = value;
    }

    public boolean isSetQueryContextId() {
        return (this.queryContextId!= null);
    }

    /**
     * Sets the value of the SellerId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ListMatchingProductsRequest withSellerId(String value) {
        setSellerId(value);
        return this;
    }

    /**
     * Sets the value of the MarketplaceId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ListMatchingProductsRequest withMarketplaceId(String value) {
        setMarketplaceId(value);
        return this;
    }

    /**
     * Sets the value of the Query property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ListMatchingProductsRequest withQuery(String value) {
        setQuery(value);
        return this;
    }

    /**
     * Sets the value of the QueryContextId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ListMatchingProductsRequest withQueryContextId(String value) {
        setQueryContextId(value);
        return this;
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
        if (isSetSellerId()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("SellerId"));
            json.append(" : ");
            json.append(quoteJSON(getSellerId()));
            first = false;
        }
        if (isSetMarketplaceId()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("MarketplaceId"));
            json.append(" : ");
            json.append(quoteJSON(getMarketplaceId()));
            first = false;
        }
        if (isSetQuery()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("Query"));
            json.append(" : ");
            json.append(quoteJSON(getQuery()));
            first = false;
        }
        if (isSetQueryContextId()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("QueryContextId"));
            json.append(" : ");
            json.append(quoteJSON(getQueryContextId()));
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
