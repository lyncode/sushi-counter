
package org.niso.schemas.sushi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.niso.schemas.sushi.counter.CounterReportResponse;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportResponse", propOrder = {
    "exception",
    "requestor",
    "customerReference",
    "reportDefinition"
})
@XmlSeeAlso({
    CounterReportResponse.class
})
public class ReportResponse {

    @XmlElement(name = "Exception", nillable = true)
    protected List<Exception> exception;
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


    public List<Exception> getException() {
        if (exception == null) {
            exception = new ArrayList<Exception>();
        }
        return this.exception;
    }


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
