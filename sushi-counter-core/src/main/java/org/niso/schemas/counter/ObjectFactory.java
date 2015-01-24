
package org.niso.schemas.counter;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;



@XmlRegistry
public class ObjectFactory {

    private final static QName _Reports_QNAME = new QName("http://www.niso.org/schemas/counter", "Reports");


    public ObjectFactory() {
    }


    public Report createReport() {
        return new Report();
    }


    public Reports createReports() {
        return new Reports();
    }


    public Organization createOrganization() {
        return new Organization();
    }


    public org.niso.schemas.counter.Customer createCustomer() {
        return new org.niso.schemas.counter.Customer();
    }


    public Vendor createVendor() {
        return new Vendor();
    }


    public ReportItem createReportItem() {
        return new ReportItem();
    }


    public Contact createContact() {
        return new Contact();
    }


    public DateRange createDateRange() {
        return new DateRange();
    }


    public Identifier createIdentifier() {
        return new Identifier();
    }


    public Consortium createConsortium() {
        return new Consortium();
    }


    public Metric createMetric() {
        return new Metric();
    }


    public PerformanceCounter createPerformanceCounter() {
        return new PerformanceCounter();
    }


    public IPAddress createIPAddress() {
        return new IPAddress();
    }


    public Report.Customer createReportCustomer() {
        return new Report.Customer();
    }


    @XmlElementDecl(namespace = "http://www.niso.org/schemas/counter", name = "Reports")
    public JAXBElement<Reports> createReports(Reports value) {
        return new JAXBElement<Reports>(_Reports_QNAME, Reports.class, null, value);
    }

}
