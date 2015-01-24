
package org.niso.schemas.sushi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Requestor", propOrder = {
    "id",
    "name",
    "email"
})
public class Requestor {

    @XmlElement(name = "ID", required = true)
    protected String id;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Email", required = true)
    protected String email;


    public String getID() {
        return id;
    }


    public void setID(String value) {
        this.id = value;
    }


    public String getName() {
        return name;
    }


    public void setName(String value) {
        this.name = value;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String value) {
        this.email = value;
    }

}
