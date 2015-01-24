
package org.niso.schemas.counter;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;



@XmlType(name = "IdentifierType")
@XmlEnum
public enum IdentifierType {

    @XmlEnumValue("Online_ISSN")
    ONLINE_ISSN("Online_ISSN"),
    @XmlEnumValue("Print_ISSN")
    PRINT_ISSN("Print_ISSN"),
    EISSN("EISSN"),
    ISSN("ISSN"),
    ISBN("ISBN"),
    @XmlEnumValue("Online_ISBN")
    ONLINE_ISBN("Online_ISBN"),
    @XmlEnumValue("Print_ISBN")
    PRINT_ISBN("Print_ISBN"),
    DOI("DOI"),
    @XmlEnumValue("Proprietary")
    PROPRIETARY("Proprietary");
    private final String value;

    IdentifierType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IdentifierType fromValue(String v) {
        for (IdentifierType c: IdentifierType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
