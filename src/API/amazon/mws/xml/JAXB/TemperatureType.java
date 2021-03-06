//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.05.03 at 03:15:27 PM EDT 
//


package API.amazon.mws.xml.JAXB;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TemperatureType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TemperatureType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="degrees_celsius"/>
 *     &lt;enumeration value="degrees_fahrenheit"/>
 *     &lt;enumeration value="kelvin"/>
 *     &lt;enumeration value="btus"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TemperatureType")
@XmlEnum
public enum TemperatureType {

    @XmlEnumValue("degrees_celsius")
    DEGREES_CELSIUS("degrees_celsius"),
    @XmlEnumValue("degrees_fahrenheit")
    DEGREES_FAHRENHEIT("degrees_fahrenheit"),
    @XmlEnumValue("kelvin")
    KELVIN("kelvin"),
    @XmlEnumValue("btus")
    BTUS("btus");
    private final String value;

    TemperatureType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TemperatureType fromValue(String v) {
        for (TemperatureType c: TemperatureType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
