
package org.niso.schemas.counter;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Report", propOrder = {
    "vendor",
    "customer"
})
public class Report {

    @XmlElement(name = "Vendor", required = true)
    protected Vendor vendor;
    @XmlElement(name = "Customer", required = true)
    protected List<Report.Customer> customer;
    @XmlAttribute(name = "Created")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar created;
    @XmlAttribute(name = "ID", required = true)
    protected String id;
    @XmlAttribute(name = "Version")
    protected String version;
    @XmlAttribute(name = "Name")
    protected String name;
    @XmlAttribute(name = "Title")
    protected String title;


    public Vendor getVendor() {
        return vendor;
    }


    public void setVendor(Vendor value) {
        this.vendor = value;
    }


    public List<Report.Customer> getCustomer() {
        if (customer == null) {
            customer = new ArrayList<Report.Customer>();
        }
        return this.customer;
    }


    public XMLGregorianCalendar getCreated() {
        return created;
    }


    public void setCreated(XMLGregorianCalendar value) {
        this.created = value;
    }


    public String getID() {
        return id;
    }


    public void setID(String value) {
        this.id = value;
    }


    public String getVersion() {
        return version;
    }


    public void setVersion(String value) {
        this.version = value;
    }


    public String getName() {
        return name;
    }


    public void setName(String value) {
        this.name = value;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String value) {
        this.title = value;
    }



    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "reportItems"
    })
    public static class Customer
        extends org.niso.schemas.counter.Customer
    {

        @XmlElement(name = "ReportItems", required = true)
        protected List<ReportItem> reportItems;


        public List<ReportItem> getReportItems() {
            if (reportItems == null) {
                reportItems = new ArrayList<ReportItem>();
            }
            return this.reportItems;
        }

    }

}
