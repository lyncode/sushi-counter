
package org.niso.schemas.counter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Consortium", propOrder = {
    "code",
    "wellKnownName"
})
public class Consortium {

    @XmlElement(name = "Code")
    protected String code;
    @XmlElement(name = "WellKnownName", required = true)
    protected String wellKnownName;


    public String getCode() {
        return code;
    }


    public void setCode(String value) {
        this.code = value;
    }


    public String getWellKnownName() {
        return wellKnownName;
    }


    public void setWellKnownName(String value) {
        this.wellKnownName = value;
    }

}
