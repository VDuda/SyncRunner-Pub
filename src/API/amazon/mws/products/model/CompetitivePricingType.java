
package API.amazon.mws.products.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CompetitivePricingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CompetitivePricingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CompetitivePrices" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}CompetitivePriceList"/>
 *         &lt;element name="NumberOfOfferListings" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}NumberOfOfferListingsList"/>
 *         &lt;element name="TradeInValue" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}MoneyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompetitivePricingType", propOrder = {
    "competitivePrices",
    "numberOfOfferListings",
    "tradeInValue"
})
public class CompetitivePricingType {

    @XmlElement(name = "CompetitivePrices", required = true)
    protected CompetitivePriceList competitivePrices;
    @XmlElement(name = "NumberOfOfferListings", required = true)
    protected NumberOfOfferListingsList numberOfOfferListings;
    @XmlElement(name = "TradeInValue")
    protected MoneyType tradeInValue;

    /**
     * Default constructor
     * 
     */
    public CompetitivePricingType() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public CompetitivePricingType(final CompetitivePriceList competitivePrices, final NumberOfOfferListingsList numberOfOfferListings, final MoneyType tradeInValue) {
        this.competitivePrices = competitivePrices;
        this.numberOfOfferListings = numberOfOfferListings;
        this.tradeInValue = tradeInValue;
    }

    /**
     * Gets the value of the competitivePrices property.
     * 
     * @return
     *     possible object is
     *     {@link CompetitivePriceList }
     *     
     */
    public CompetitivePriceList getCompetitivePrices() {
        return competitivePrices;
    }

    /**
     * Sets the value of the competitivePrices property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompetitivePriceList }
     *     
     */
    public void setCompetitivePrices(CompetitivePriceList value) {
        this.competitivePrices = value;
    }

    public boolean isSetCompetitivePrices() {
        return (this.competitivePrices!= null);
    }

    /**
     * Gets the value of the numberOfOfferListings property.
     * 
     * @return
     *     possible object is
     *     {@link NumberOfOfferListingsList }
     *     
     */
    public NumberOfOfferListingsList getNumberOfOfferListings() {
        return numberOfOfferListings;
    }

    /**
     * Sets the value of the numberOfOfferListings property.
     * 
     * @param value
     *     allowed object is
     *     {@link NumberOfOfferListingsList }
     *     
     */
    public void setNumberOfOfferListings(NumberOfOfferListingsList value) {
        this.numberOfOfferListings = value;
    }

    public boolean isSetNumberOfOfferListings() {
        return (this.numberOfOfferListings!= null);
    }

    /**
     * Gets the value of the tradeInValue property.
     * 
     * @return
     *     possible object is
     *     {@link MoneyType }
     *     
     */
    public MoneyType getTradeInValue() {
        return tradeInValue;
    }

    /**
     * Sets the value of the tradeInValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link MoneyType }
     *     
     */
    public void setTradeInValue(MoneyType value) {
        this.tradeInValue = value;
    }

    public boolean isSetTradeInValue() {
        return (this.tradeInValue!= null);
    }

    /**
     * Sets the value of the CompetitivePrices property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public CompetitivePricingType withCompetitivePrices(CompetitivePriceList value) {
        setCompetitivePrices(value);
        return this;
    }

    /**
     * Sets the value of the NumberOfOfferListings property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public CompetitivePricingType withNumberOfOfferListings(NumberOfOfferListingsList value) {
        setNumberOfOfferListings(value);
        return this;
    }

    /**
     * Sets the value of the TradeInValue property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public CompetitivePricingType withTradeInValue(MoneyType value) {
        setTradeInValue(value);
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
        if (isSetCompetitivePrices()) {
            CompetitivePriceList  competitivePrices = getCompetitivePrices();
            xml.append("<CompetitivePrices>");
            xml.append(competitivePrices.toXMLFragment());
            xml.append("</CompetitivePrices>");
        } 
        if (isSetNumberOfOfferListings()) {
            NumberOfOfferListingsList  numberOfOfferListings = getNumberOfOfferListings();
            xml.append("<NumberOfOfferListings>");
            xml.append(numberOfOfferListings.toXMLFragment());
            xml.append("</NumberOfOfferListings>");
        } 
        if (isSetTradeInValue()) {
            MoneyType  tradeInValue = getTradeInValue();
            xml.append("<TradeInValue>");
            xml.append(tradeInValue.toXMLFragment());
            xml.append("</TradeInValue>");
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
        if (isSetCompetitivePrices()) {
            if (!first) json.append(", ");
            json.append("\"CompetitivePrices\" : {");
            CompetitivePriceList  competitivePrices = getCompetitivePrices();


            json.append(competitivePrices.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetNumberOfOfferListings()) {
            if (!first) json.append(", ");
            json.append("\"NumberOfOfferListings\" : {");
            NumberOfOfferListingsList  numberOfOfferListings = getNumberOfOfferListings();


            json.append(numberOfOfferListings.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetTradeInValue()) {
            if (!first) json.append(", ");
            json.append("\"TradeInValue\" : {");
            MoneyType  tradeInValue = getTradeInValue();


            json.append(tradeInValue.toJSONFragment());
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
