
package org.niso.schemas.counter;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;



@XmlType(name = "Category")
@XmlEnum
public enum Category {

    @XmlEnumValue("Requests")
    REQUESTS("Requests"),
    @XmlEnumValue("Searches")
    SEARCHES("Searches"),
    @XmlEnumValue("Access_denied")
    ACCESS_DENIED("Access_denied");
    private final String value;

    Category(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Category fromValue(String v) {
        for (Category c: Category.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
