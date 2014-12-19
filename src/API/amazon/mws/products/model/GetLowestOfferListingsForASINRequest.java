
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
 *         &lt;element name="ASINList" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}ASINListType"/>
 *         &lt;element name="ItemCondition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExcludeMe" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
    "asinList",
    "itemCondition",
    "excludeMe"
})
@XmlRootElement(name = "GetLowestOfferListingsForASINRequest")
public class GetLowestOfferListingsForASINRequest {

    @XmlElement(name = "SellerId", required = true)
    protected String sellerId;
    @XmlElement(name = "MarketplaceId", required = true)
    protected String marketplaceId;
    @XmlElement(name = "ASINList", required = true)
    protected ASINListType asinList;
    @XmlElement(name = "ItemCondition")
    protected String itemCondition;
    @XmlElement(name = "ExcludeMe")
    protected Boolean excludeMe;

    /**
     * Default constructor
     * 
     */
    public GetLowestOfferListingsForASINRequest() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public GetLowestOfferListingsForASINRequest(final String sellerId, final String marketplaceId, final ASINListType asinList, final String itemCondition, final Boolean excludeMe) {
        this.sellerId = sellerId;
        this.marketplaceId = marketplaceId;
        this.asinList = asinList;
        this.itemCondition = itemCondition;
        this.excludeMe = excludeMe;
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
     * Gets the value of the asinList property.
     * 
     * @return
     *     possible object is
     *     {@link ASINListType }
     *     
     */
    public ASINListType getASINList() {
        return asinList;
    }

    /**
     * Sets the value of the asinList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ASINListType }
     *     
     */
    public void setASINList(ASINListType value) {
        this.asinList = value;
    }

    public boolean isSetASINList() {
        return (this.asinList!= null);
    }

    /**
     * Gets the value of the itemCondition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemCondition() {
        return itemCondition;
    }

    /**
     * Sets the value of the itemCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemCondition(String value) {
        this.itemCondition = value;
    }

    public boolean isSetItemCondition() {
        return (this.itemCondition!= null);
    }

    /**
     * Gets the value of the excludeMe property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExcludeMe() {
        return excludeMe;
    }

    /**
     * Sets the value of the excludeMe property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExcludeMe(Boolean value) {
        this.excludeMe = value;
    }

    public boolean isSetExcludeMe() {
        return (this.excludeMe!= null);
    }

    /**
     * Sets the value of the SellerId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public GetLowestOfferListingsForASINRequest withSellerId(String value) {
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
    public GetLowestOfferListingsForASINRequest withMarketplaceId(String value) {
        setMarketplaceId(value);
        return this;
    }

    /**
     * Sets the value of the ASINList property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public GetLowestOfferListingsForASINRequest withASINList(ASINListType value) {
        setASINList(value);
        return this;
    }

    /**
     * Sets the value of the ItemCondition property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public GetLowestOfferListingsForASINRequest withItemCondition(String value) {
        setItemCondition(value);
        return this;
    }

    /**
     * Sets the value of the ExcludeMe property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public GetLowestOfferListingsForASINRequest withExcludeMe(Boolean value) {
        setExcludeMe(value);
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
        if (isSetASINList()) {
            if (!first) json.append(", ");
            json.append("\"ASINList\" : {");
            ASINListType  ASINList = getASINList();


            json.append(ASINList.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetItemCondition()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("ItemCondition"));
            json.append(" : ");
            json.append(quoteJSON(getItemCondition()));
            first = false;
        }
        if (isSetExcludeMe()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("ExcludeMe"));
            json.append(" : ");
            json.append(quoteJSON(isExcludeMe() + ""));
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
