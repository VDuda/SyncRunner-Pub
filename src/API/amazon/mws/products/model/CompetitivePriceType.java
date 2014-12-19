
package API.amazon.mws.products.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CompetitivePriceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CompetitivePriceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CompetitivePriceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Price" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}PriceType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="condition" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="subcondition" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="belongsToRequester" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompetitivePriceType", propOrder = {
    "competitivePriceId",
    "price"
})
public class CompetitivePriceType {

    @XmlElement(name = "CompetitivePriceId", required = true)
    protected String competitivePriceId;
    @XmlElement(name = "Price", required = true)
    protected PriceType price;
    @XmlAttribute
    protected String condition;
    @XmlAttribute
    protected String subcondition;
    @XmlAttribute
    protected Boolean belongsToRequester;

    /**
     * Default constructor
     * 
     */
    public CompetitivePriceType() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public CompetitivePriceType(final String competitivePriceId, final PriceType price, final String condition, final String subcondition, final Boolean belongsToRequester) {
        this.competitivePriceId = competitivePriceId;
        this.price = price;
        this.condition = condition;
        this.subcondition = subcondition;
        this.belongsToRequester = belongsToRequester;
    }

    /**
     * Gets the value of the competitivePriceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompetitivePriceId() {
        return competitivePriceId;
    }

    /**
     * Sets the value of the competitivePriceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompetitivePriceId(String value) {
        this.competitivePriceId = value;
    }

    public boolean isSetCompetitivePriceId() {
        return (this.competitivePriceId!= null);
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link PriceType }
     *     
     */
    public PriceType getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceType }
     *     
     */
    public void setPrice(PriceType value) {
        this.price = value;
    }

    public boolean isSetPrice() {
        return (this.price!= null);
    }

    /**
     * Gets the value of the condition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCondition() {
        return condition;
    }

    /**
     * Sets the value of the condition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCondition(String value) {
        this.condition = value;
    }

    public boolean isSetCondition() {
        return (this.condition!= null);
    }

    /**
     * Gets the value of the subcondition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubcondition() {
        return subcondition;
    }

    /**
     * Sets the value of the subcondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubcondition(String value) {
        this.subcondition = value;
    }

    public boolean isSetSubcondition() {
        return (this.subcondition!= null);
    }

    /**
     * Gets the value of the belongsToRequester property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isBelongsToRequester() {
        return belongsToRequester;
    }

    /**
     * Sets the value of the belongsToRequester property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBelongsToRequester(boolean value) {
        this.belongsToRequester = value;
    }

    public boolean isSetBelongsToRequester() {
        return (this.belongsToRequester!= null);
    }

    public void unsetBelongsToRequester() {
        this.belongsToRequester = null;
    }

    /**
     * Sets the value of the CompetitivePriceId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public CompetitivePriceType withCompetitivePriceId(String value) {
        setCompetitivePriceId(value);
        return this;
    }

    /**
     * Sets the value of the Price property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public CompetitivePriceType withPrice(PriceType value) {
        setPrice(value);
        return this;
    }

    /**
     * Sets the value of the Condition property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public CompetitivePriceType withCondition(String value) {
        setCondition(value);
        return this;
    }

    /**
     * Sets the value of the Subcondition property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public CompetitivePriceType withSubcondition(String value) {
        setSubcondition(value);
        return this;
    }

    /**
     * Sets the value of the BelongsToRequester property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public CompetitivePriceType withBelongsToRequester(boolean value) {
        setBelongsToRequester(value);
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
        if (isSetCompetitivePriceId()) {
            xml.append("<CompetitivePriceId>");
            xml.append(escapeXML(getCompetitivePriceId()));
            xml.append("</CompetitivePriceId>");
        }
        if (isSetPrice()) {
            PriceType  price = getPrice();
            xml.append("<Price>");
            xml.append(price.toXMLFragment());
            xml.append("</Price>");
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
        if (isSetCompetitivePriceId()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("CompetitivePriceId"));
            json.append(" : ");
            json.append(quoteJSON(getCompetitivePriceId()));
            first = false;
        }
        if (isSetPrice()) {
            if (!first) json.append(", ");
            json.append("\"Price\" : {");
            PriceType  price = getPrice();


            json.append(price.toJSONFragment());
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
