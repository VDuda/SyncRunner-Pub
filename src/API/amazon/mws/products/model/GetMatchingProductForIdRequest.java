
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
 *         &lt;element name="IdType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IdList" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}IdListType"/>
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
    "idType",
    "idList"
})
@XmlRootElement(name = "GetMatchingProductForIdRequest")
public class GetMatchingProductForIdRequest {

    @XmlElement(name = "SellerId", required = true)
    protected String sellerId;
    @XmlElement(name = "MarketplaceId", required = true)
    protected String marketplaceId;
    @XmlElement(name = "IdType", required = true)
    protected String idType;
    @XmlElement(name = "IdList", required = true)
    protected IdListType idList;

    /**
     * Default constructor
     * 
     */
    public GetMatchingProductForIdRequest() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public GetMatchingProductForIdRequest(final String sellerId, final String marketplaceId, final String idType, final IdListType idList) {
        this.sellerId = sellerId;
        this.marketplaceId = marketplaceId;
        this.idType = idType;
        this.idList = idList;
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
     * Gets the value of the idType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdType() {
        return idType;
    }

    /**
     * Sets the value of the idType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdType(String value) {
        this.idType = value;
    }

    public boolean isSetIdType() {
        return (this.idType!= null);
    }

    /**
     * Gets the value of the idList property.
     * 
     * @return
     *     possible object is
     *     {@link IdListType }
     *     
     */
    public IdListType getIdList() {
        return idList;
    }

    /**
     * Sets the value of the idList property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdListType }
     *     
     */
    public void setIdList(IdListType value) {
        this.idList = value;
    }

    public boolean isSetIdList() {
        return (this.idList!= null);
    }

    /**
     * Sets the value of the SellerId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public GetMatchingProductForIdRequest withSellerId(String value) {
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
    public GetMatchingProductForIdRequest withMarketplaceId(String value) {
        setMarketplaceId(value);
        return this;
    }

    /**
     * Sets the value of the IdType property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public GetMatchingProductForIdRequest withIdType(String value) {
        setIdType(value);
        return this;
    }

    /**
     * Sets the value of the IdList property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public GetMatchingProductForIdRequest withIdList(IdListType value) {
        setIdList(value);
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
        if (isSetIdType()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("IdType"));
            json.append(" : ");
            json.append(quoteJSON(getIdType()));
            first = false;
        }
        if (isSetIdList()) {
            if (!first) json.append(", ");
            json.append("\"IdList\" : {");
            IdListType  idList = getIdList();


            json.append(idList.toJSONFragment());
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
