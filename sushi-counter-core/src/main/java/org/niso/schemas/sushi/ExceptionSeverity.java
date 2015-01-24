
package org.niso.schemas.sushi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;



@XmlType(name = "ExceptionSeverity")
@XmlEnum
public enum ExceptionSeverity {



    @XmlEnumValue("Info")
    INFO("Info"),


    @XmlEnumValue("Debug")
    DEBUG("Debug"),


    @XmlEnumValue("Warning")
    WARNING("Warning"),


    @XmlEnumValue("Error")
    ERROR("Error"),


    @XmlEnumValue("Fatal")
    FATAL("Fatal");
    private final String value;

    ExceptionSeverity(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ExceptionSeverity fromValue(String v) {
        for (ExceptionSeverity c: ExceptionSeverity.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
