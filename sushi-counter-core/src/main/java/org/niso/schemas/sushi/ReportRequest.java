
package org.niso.schemas.sushi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportRequest", propOrder = {
    "requestor",
    "customerReference",
    "reportDefinition"
})
public class ReportRequest {

    @XmlElement(name = "Requestor", required = true)
    protected Requestor requestor;
    @XmlElement(name = "CustomerReference", required = true)
    protected CustomerReference customerReference;
    @XmlElement(name = "ReportDefinition", required = true)
    protected ReportDefinition reportDefinition;
    @XmlAttribute(name = "Created")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar created;
    @XmlAttribute(name = "ID")
    protected String id;


    public Requestor getRequestor() {
        return requestor;
    }


    public void setRequestor(Requestor value) {
        this.requestor = value;
    }


    public CustomerReference getCustomerReference() {
        return customerReference;
    }


    public void setCustomerReference(CustomerReference value) {
        this.customerReference = value;
    }


    public ReportDefinition getReportDefinition() {
        return reportDefinition;
    }


    public void setReportDefinition(ReportDefinition value) {
        this.reportDefinition = value;
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

}
