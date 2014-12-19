
package API.amazon.mws.orders.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Address complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Address">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AddressLine1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AddressLine2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AddressLine3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="County" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="District" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StateOrRegion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CountryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Address", propOrder = {
    "name",
    "addressLine1",
    "addressLine2",
    "addressLine3",
    "city",
    "county",
    "district",
    "stateOrRegion",
    "postalCode",
    "countryCode",
    "phone"
})
public class Address {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "AddressLine1")
    protected String addressLine1;
    @XmlElement(name = "AddressLine2")
    protected String addressLine2;
    @XmlElement(name = "AddressLine3")
    protected String addressLine3;
    @XmlElement(name = "City")
    protected String city;
    @XmlElement(name = "County")
    protected String county;
    @XmlElement(name = "District")
    protected String district;
    @XmlElement(name = "StateOrRegion")
    protected String stateOrRegion;
    @XmlElement(name = "PostalCode")
    protected String postalCode;
    @XmlElement(name = "CountryCode")
    protected String countryCode;
    @XmlElement(name = "Phone")
    protected String phone;

    /**
     * Default constructor
     * 
     */
    public Address() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public Address(final String name, final String addressLine1, final String addressLine2, final String addressLine3, final String city, final String county, final String district, final String stateOrRegion, final String postalCode, final String countryCode, final String phone) {
        this.name = name;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.city = city;
        this.county = county;
        this.district = district;
        this.stateOrRegion = stateOrRegion;
        this.postalCode = postalCode;
        this.countryCode = countryCode;
        this.phone = phone;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    public boolean isSetName() {
        return (this.name!= null);
    }

    /**
     * Gets the value of the addressLine1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * Sets the value of the addressLine1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressLine1(String value) {
        this.addressLine1 = value;
    }

    public boolean isSetAddressLine1() {
        return (this.addressLine1 != null);
    }

    /**
     * Gets the value of the addressLine2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * Sets the value of the addressLine2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressLine2(String value) {
        this.addressLine2 = value;
    }

    public boolean isSetAddressLine2() {
        return (this.addressLine2 != null);
    }

    /**
     * Gets the value of the addressLine3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressLine3() {
        return addressLine3;
    }

    /**
     * Sets the value of the addressLine3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressLine3(String value) {
        this.addressLine3 = value;
    }

    public boolean isSetAddressLine3() {
        return (this.addressLine3 != null);
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    public boolean isSetCity() {
        return (this.city!= null);
    }

    /**
     * Gets the value of the county property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCounty() {
        return county;
    }

    /**
     * Sets the value of the county property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCounty(String value) {
        this.county = value;
    }

    public boolean isSetCounty() {
        return (this.county!= null);
    }

    /**
     * Gets the value of the district property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Sets the value of the district property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistrict(String value) {
        this.district = value;
    }

    public boolean isSetDistrict() {
        return (this.district!= null);
    }

    /**
     * Gets the value of the stateOrRegion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateOrRegion() {
        return stateOrRegion;
    }

    /**
     * Sets the value of the stateOrRegion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateOrRegion(String value) {
        this.stateOrRegion = value;
    }

    public boolean isSetStateOrRegion() {
        return (this.stateOrRegion!= null);
    }

    /**
     * Gets the value of the postalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    public boolean isSetPostalCode() {
        return (this.postalCode!= null);
    }

    /**
     * Gets the value of the countryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    public boolean isSetCountryCode() {
        return (this.countryCode!= null);
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone(String value) {
        this.phone = value;
    }

    public boolean isSetPhone() {
        return (this.phone!= null);
    }

    /**
     * Sets the value of the Name property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Address withName(String value) {
        setName(value);
        return this;
    }

    /**
     * Sets the value of the AddressLine1 property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Address withAddressLine1(String value) {
        setAddressLine1(value);
        return this;
    }

    /**
     * Sets the value of the AddressLine2 property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Address withAddressLine2(String value) {
        setAddressLine2(value);
        return this;
    }

    /**
     * Sets the value of the AddressLine3 property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Address withAddressLine3(String value) {
        setAddressLine3(value);
        return this;
    }

    /**
     * Sets the value of the City property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Address withCity(String value) {
        setCity(value);
        return this;
    }

    /**
     * Sets the value of the County property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Address withCounty(String value) {
        setCounty(value);
        return this;
    }

    /**
     * Sets the value of the District property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Address withDistrict(String value) {
        setDistrict(value);
        return this;
    }

    /**
     * Sets the value of the StateOrRegion property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Address withStateOrRegion(String value) {
        setStateOrRegion(value);
        return this;
    }

    /**
     * Sets the value of the PostalCode property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Address withPostalCode(String value) {
        setPostalCode(value);
        return this;
    }

    /**
     * Sets the value of the CountryCode property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Address withCountryCode(String value) {
        setCountryCode(value);
        return this;
    }

    /**
     * Sets the value of the Phone property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Address withPhone(String value) {
        setPhone(value);
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
        if (isSetName()) {
            xml.append("<Name>");
            xml.append(escapeXML(getName()));
            xml.append("</Name>");
        }
        if (isSetAddressLine1()) {
            xml.append("<AddressLine1>");
            xml.append(escapeXML(getAddressLine1()));
            xml.append("</AddressLine1>");
        }
        if (isSetAddressLine2()) {
            xml.append("<AddressLine2>");
            xml.append(escapeXML(getAddressLine2()));
            xml.append("</AddressLine2>");
        }
        if (isSetAddressLine3()) {
            xml.append("<AddressLine3>");
            xml.append(escapeXML(getAddressLine3()));
            xml.append("</AddressLine3>");
        }
        if (isSetCity()) {
            xml.append("<City>");
            xml.append(escapeXML(getCity()));
            xml.append("</City>");
        }
        if (isSetCounty()) {
            xml.append("<County>");
            xml.append(escapeXML(getCounty()));
            xml.append("</County>");
        }
        if (isSetDistrict()) {
            xml.append("<District>");
            xml.append(escapeXML(getDistrict()));
            xml.append("</District>");
        }
        if (isSetStateOrRegion()) {
            xml.append("<StateOrRegion>");
            xml.append(escapeXML(getStateOrRegion()));
            xml.append("</StateOrRegion>");
        }
        if (isSetPostalCode()) {
            xml.append("<PostalCode>");
            xml.append(escapeXML(getPostalCode()));
            xml.append("</PostalCode>");
        }
        if (isSetCountryCode()) {
            xml.append("<CountryCode>");
            xml.append(escapeXML(getCountryCode()));
            xml.append("</CountryCode>");
        }
        if (isSetPhone()) {
            xml.append("<Phone>");
            xml.append(escapeXML(getPhone()));
            xml.append("</Phone>");
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
        if (isSetName()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("Name"));
            json.append(" : ");
            json.append(quoteJSON(getName()));
            first = false;
        }
        if (isSetAddressLine1()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("AddressLine1"));
            json.append(" : ");
            json.append(quoteJSON(getAddressLine1()));
            first = false;
        }
        if (isSetAddressLine2()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("AddressLine2"));
            json.append(" : ");
            json.append(quoteJSON(getAddressLine2()));
            first = false;
        }
        if (isSetAddressLine3()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("AddressLine3"));
            json.append(" : ");
            json.append(quoteJSON(getAddressLine3()));
            first = false;
        }
        if (isSetCity()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("City"));
            json.append(" : ");
            json.append(quoteJSON(getCity()));
            first = false;
        }
        if (isSetCounty()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("County"));
            json.append(" : ");
            json.append(quoteJSON(getCounty()));
            first = false;
        }
        if (isSetDistrict()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("District"));
            json.append(" : ");
            json.append(quoteJSON(getDistrict()));
            first = false;
        }
        if (isSetStateOrRegion()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("StateOrRegion"));
            json.append(" : ");
            json.append(quoteJSON(getStateOrRegion()));
            first = false;
        }
        if (isSetPostalCode()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("PostalCode"));
            json.append(" : ");
            json.append(quoteJSON(getPostalCode()));
            first = false;
        }
        if (isSetCountryCode()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("CountryCode"));
            json.append(" : ");
            json.append(quoteJSON(getCountryCode()));
            first = false;
        }
        if (isSetPhone()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("Phone"));
            json.append(" : ");
            json.append(quoteJSON(getPhone()));
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
