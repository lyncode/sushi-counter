
package org.niso.schemas.counter;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Organization", propOrder = {
    "name",
    "id",
    "contact",
    "webSiteUrl",
    "logoUrl"
})
@XmlSeeAlso({
    Customer.class,
    Vendor.class
})
public class Organization {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "ID", required = true)
    protected String id;
    @XmlElement(name = "Contact")
    protected List<Contact> contact;
    @XmlElement(name = "WebSiteUrl")
    @XmlSchemaType(name = "anyURI")
    protected String webSiteUrl;
    @XmlElement(name = "LogoUrl")
    @XmlSchemaType(name = "anyURI")
    protected String logoUrl;


    public String getName() {
        return name;
    }


    public void setName(String value) {
        this.name = value;
    }


    public String getID() {
        return id;
    }


    public void setID(String value) {
        this.id = value;
    }


    public List<Contact> getContact() {
        if (contact == null) {
            contact = new ArrayList<Contact>();
        }
        return this.contact;
    }


    public String getWebSiteUrl() {
        return webSiteUrl;
    }


    public void setWebSiteUrl(String value) {
        this.webSiteUrl = value;
    }


    public String getLogoUrl() {
        return logoUrl;
    }


    public void setLogoUrl(String value) {
        this.logoUrl = value;
    }

}
