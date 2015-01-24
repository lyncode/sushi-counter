
package org.niso.schemas.counter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Identifier", propOrder = {
    "type",
    "value"
})
public class Identifier {

    @XmlElement(name = "Type", required = true)
    @XmlSchemaType(name = "string")
    protected IdentifierType type;
    @XmlElement(name = "Value", required = true)
    protected String value;


    public IdentifierType getType() {
        return type;
    }


    public void setType(IdentifierType value) {
        this.type = value;
    }


    public String getValue() {
        return value;
    }


    public void setValue(String value) {
        this.value = value;
    }

}
