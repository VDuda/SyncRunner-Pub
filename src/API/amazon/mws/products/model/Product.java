
package API.amazon.mws.products.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Product complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Product">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Identifiers" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}IdentifierType"/>
 *         &lt;element name="AttributeSets" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}AttributeSetList" minOccurs="0"/>
 *         &lt;element name="Relationships" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}RelationshipList" minOccurs="0"/>
 *         &lt;element name="CompetitivePricing" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}CompetitivePricingType" minOccurs="0"/>
 *         &lt;element name="SalesRankings" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}SalesRankList" minOccurs="0"/>
 *         &lt;element name="LowestOfferListings" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}LowestOfferListingList" minOccurs="0"/>
 *         &lt;element name="Offers" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}OffersList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Product", propOrder = {
    "identifiers",
    "attributeSets",
    "relationships",
    "competitivePricing",
    "salesRankings",
    "lowestOfferListings",
    "offers"
})
public class Product {

    @XmlElement(name = "Identifiers", required = true)
    protected IdentifierType identifiers;
    @XmlElement(name = "AttributeSets")
    protected AttributeSetList attributeSets;
    @XmlElement(name = "Relationships")
    protected RelationshipList relationships;
    @XmlElement(name = "CompetitivePricing")
    protected CompetitivePricingType competitivePricing;
    @XmlElement(name = "SalesRankings")
    protected SalesRankList salesRankings;
    @XmlElement(name = "LowestOfferListings")
    protected LowestOfferListingList lowestOfferListings;
    @XmlElement(name = "Offers")
    protected OffersList offers;

    /**
     * Default constructor
     * 
     */
    public Product() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public Product(final IdentifierType identifiers, final AttributeSetList attributeSets, final RelationshipList relationships, final CompetitivePricingType competitivePricing, final SalesRankList salesRankings, final LowestOfferListingList lowestOfferListings, final OffersList offers) {
        this.identifiers = identifiers;
        this.attributeSets = attributeSets;
        this.relationships = relationships;
        this.competitivePricing = competitivePricing;
        this.salesRankings = salesRankings;
        this.lowestOfferListings = lowestOfferListings;
        this.offers = offers;
    }

    /**
     * Gets the value of the identifiers property.
     * 
     * @return
     *     possible object is
     *     {@link IdentifierType }
     *     
     */
    public IdentifierType getIdentifiers() {
        return identifiers;
    }

    /**
     * Sets the value of the identifiers property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentifierType }
     *     
     */
    public void setIdentifiers(IdentifierType value) {
        this.identifiers = value;
    }

    public boolean isSetIdentifiers() {
        return (this.identifiers!= null);
    }

    /**
     * Gets the value of the attributeSets property.
     * 
     * @return
     *     possible object is
     *     {@link AttributeSetList }
     *     
     */
    public AttributeSetList getAttributeSets() {
        return attributeSets;
    }

    /**
     * Sets the value of the attributeSets property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributeSetList }
     *     
     */
    public void setAttributeSets(AttributeSetList value) {
        this.attributeSets = value;
    }

    public boolean isSetAttributeSets() {
        return (this.attributeSets!= null);
    }

    /**
     * Gets the value of the relationships property.
     * 
     * @return
     *     possible object is
     *     {@link RelationshipList }
     *     
     */
    public RelationshipList getRelationships() {
        return relationships;
    }

    /**
     * Sets the value of the relationships property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelationshipList }
     *     
     */
    public void setRelationships(RelationshipList value) {
        this.relationships = value;
    }

    public boolean isSetRelationships() {
        return (this.relationships!= null);
    }

    /**
     * Gets the value of the competitivePricing property.
     * 
     * @return
     *     possible object is
     *     {@link CompetitivePricingType }
     *     
     */
    public CompetitivePricingType getCompetitivePricing() {
        return competitivePricing;
    }

    /**
     * Sets the value of the competitivePricing property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompetitivePricingType }
     *     
     */
    public void setCompetitivePricing(CompetitivePricingType value) {
        this.competitivePricing = value;
    }

    public boolean isSetCompetitivePricing() {
        return (this.competitivePricing!= null);
    }

    /**
     * Gets the value of the salesRankings property.
     * 
     * @return
     *     possible object is
     *     {@link SalesRankList }
     *     
     */
    public SalesRankList getSalesRankings() {
        return salesRankings;
    }

    /**
     * Sets the value of the salesRankings property.
     * 
     * @param value
     *     allowed object is
     *     {@link SalesRankList }
     *     
     */
    public void setSalesRankings(SalesRankList value) {
        this.salesRankings = value;
    }

    public boolean isSetSalesRankings() {
        return (this.salesRankings!= null);
    }

    /**
     * Gets the value of the lowestOfferListings property.
     * 
     * @return
     *     possible object is
     *     {@link LowestOfferListingList }
     *     
     */
    public LowestOfferListingList getLowestOfferListings() {
        return lowestOfferListings;
    }

    /**
     * Sets the value of the lowestOfferListings property.
     * 
     * @param value
     *     allowed object is
     *     {@link LowestOfferListingList }
     *     
     */
    public void setLowestOfferListings(LowestOfferListingList value) {
        this.lowestOfferListings = value;
    }

    public boolean isSetLowestOfferListings() {
        return (this.lowestOfferListings!= null);
    }

    /**
     * Gets the value of the offers property.
     * 
     * @return
     *     possible object is
     *     {@link OffersList }
     *     
     */
    public OffersList getOffers() {
        return offers;
    }

    /**
     * Sets the value of the offers property.
     * 
     * @param value
     *     allowed object is
     *     {@link OffersList }
     *     
     */
    public void setOffers(OffersList value) {
        this.offers = value;
    }

    public boolean isSetOffers() {
        return (this.offers!= null);
    }

    /**
     * Sets the value of the Identifiers property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Product withIdentifiers(IdentifierType value) {
        setIdentifiers(value);
        return this;
    }

    /**
     * Sets the value of the AttributeSets property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Product withAttributeSets(AttributeSetList value) {
        setAttributeSets(value);
        return this;
    }

    /**
     * Sets the value of the Relationships property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Product withRelationships(RelationshipList value) {
        setRelationships(value);
        return this;
    }

    /**
     * Sets the value of the CompetitivePricing property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Product withCompetitivePricing(CompetitivePricingType value) {
        setCompetitivePricing(value);
        return this;
    }

    /**
     * Sets the value of the SalesRankings property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Product withSalesRankings(SalesRankList value) {
        setSalesRankings(value);
        return this;
    }

    /**
     * Sets the value of the LowestOfferListings property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Product withLowestOfferListings(LowestOfferListingList value) {
        setLowestOfferListings(value);
        return this;
    }

    /**
     * Sets the value of the Offers property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Product withOffers(OffersList value) {
        setOffers(value);
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
        if (isSetIdentifiers()) {
            IdentifierType  identifiers = getIdentifiers();
            xml.append("<Identifiers>");
            xml.append(identifiers.toXMLFragment());
            xml.append("</Identifiers>");
        } 
        if (isSetAttributeSets()) {
            AttributeSetList  attributeSets = getAttributeSets();
            xml.append("<AttributeSets>");
            xml.append(attributeSets.toXMLFragment());
            xml.append("</AttributeSets>");
        } 
        if (isSetRelationships()) {
            RelationshipList  relationships = getRelationships();
            xml.append("<Relationships>");
            xml.append(relationships.toXMLFragment());
            xml.append("</Relationships>");
        } 
        if (isSetCompetitivePricing()) {
            CompetitivePricingType  competitivePricing = getCompetitivePricing();
            xml.append("<CompetitivePricing>");
            xml.append(competitivePricing.toXMLFragment());
            xml.append("</CompetitivePricing>");
        } 
        if (isSetSalesRankings()) {
            SalesRankList  salesRankings = getSalesRankings();
            xml.append("<SalesRankings>");
            xml.append(salesRankings.toXMLFragment());
            xml.append("</SalesRankings>");
        } 
        if (isSetLowestOfferListings()) {
            LowestOfferListingList  lowestOfferListings = getLowestOfferListings();
            xml.append("<LowestOfferListings>");
            xml.append(lowestOfferListings.toXMLFragment());
            xml.append("</LowestOfferListings>");
        } 
        if (isSetOffers()) {
            OffersList  offers = getOffers();
            xml.append("<Offers>");
            xml.append(offers.toXMLFragment());
            xml.append("</Offers>");
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
        if (isSetIdentifiers()) {
            if (!first) json.append(", ");
            json.append("\"Identifiers\" : {");
            IdentifierType  identifiers = getIdentifiers();


            json.append(identifiers.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetAttributeSets()) {
            if (!first) json.append(", ");
            json.append("\"AttributeSets\" : {");
            AttributeSetList  attributeSets = getAttributeSets();


            json.append(attributeSets.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetRelationships()) {
            if (!first) json.append(", ");
            json.append("\"Relationships\" : {");
            RelationshipList  relationships = getRelationships();


            json.append(relationships.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetCompetitivePricing()) {
            if (!first) json.append(", ");
            json.append("\"CompetitivePricing\" : {");
            CompetitivePricingType  competitivePricing = getCompetitivePricing();


            json.append(competitivePricing.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetSalesRankings()) {
            if (!first) json.append(", ");
            json.append("\"SalesRankings\" : {");
            SalesRankList  salesRankings = getSalesRankings();


            json.append(salesRankings.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetLowestOfferListings()) {
            if (!first) json.append(", ");
            json.append("\"LowestOfferListings\" : {");
            LowestOfferListingList  lowestOfferListings = getLowestOfferListings();


            json.append(lowestOfferListings.toJSONFragment());
            json.append("}");
            first = false;
        }
        if (isSetOffers()) {
            if (!first) json.append(", ");
            json.append("\"Offers\" : {");
            OffersList  offers = getOffers();


            json.append(offers.toJSONFragment());
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
