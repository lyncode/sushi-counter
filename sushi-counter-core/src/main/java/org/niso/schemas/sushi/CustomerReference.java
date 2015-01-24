
package org.niso.schemas.sushi;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerReference", propOrder = {
    "id",
    "name"
})
public class CustomerReference {

    @XmlElement(name = "ID", required = true)
    protected String id;
    @XmlElementRef(name = "Name", namespace = "http://www.niso.org/schemas/sushicounter", type = JAXBElement.class, required = false)
    protected JAXBElement<String> name;


    public String getID() {
        return id;
    }


    public void setID(String value) {
        this.id = value;
    }


    public JAXBElement<String> getName() {
        return name;
    }


    public void setName(JAXBElement<String> value) {
        this.name = value;
    }

}
