
package org.niso.schemas.counter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Contact", propOrder = {
    "contact",
    "eMail"
})
public class Contact {

    @XmlElement(name = "Contact")
    protected String contact;
    @XmlElement(name = "E-mail")
    protected String eMail;


    public String getContact() {
        return contact;
    }


    public void setContact(String value) {
        this.contact = value;
    }


    public String getEMail() {
        return eMail;
    }


    public void setEMail(String value) {
        this.eMail = value;
    }

}
