
package org.niso.schemas.counter;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;



@XmlType(name = "DataType")
@XmlEnum
public enum DataType {

    @XmlEnumValue("Journal")
    JOURNAL("Journal"),
    @XmlEnumValue("Database")
    DATABASE("Database"),
    @XmlEnumValue("Platform")
    PLATFORM("Platform"),
    @XmlEnumValue("Book")
    BOOK("Book"),
    @XmlEnumValue("Collection")
    COLLECTION("Collection"),
    @XmlEnumValue("Multimedia")
    MULTIMEDIA("Multimedia");
    private final String value;

    DataType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DataType fromValue(String v) {
        for (DataType c: DataType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
