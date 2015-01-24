
package org.niso.schemas.sushi;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;



@XmlRegistry
public class ObjectFactory {

    private final static QName _ReportRequest_QNAME = new QName("http://www.niso.org/schemas/sushicounter", "ReportRequest");
    private final static QName _ReportResponse_QNAME = new QName("http://www.niso.org/schemas/sushicounter", "ReportResponse");
    private final static QName _CustomerReferenceName_QNAME = new QName("http://www.niso.org/schemas/sushicounter", "Name");
    private final static QName _ExceptionHelpUrl_QNAME = new QName("http://www.niso.org/schemas/sushicounter", "HelpUrl");
    private final static QName _ExceptionData_QNAME = new QName("http://www.niso.org/schemas/sushicounter", "Data");


    public ObjectFactory() {
    }


    public ReportDefinition createReportDefinition() {
        return new ReportDefinition();
    }


    public ReportResponse createReportResponse() {
        return new ReportResponse();
    }


    public ReportRequest createReportRequest() {
        return new ReportRequest();
    }


    public CustomerReference createCustomerReference() {
        return new CustomerReference();
    }


    public Activity createActivity() {
        return new Activity();
    }


    public Requestor createRequestor() {
        return new Requestor();
    }


    public Range createRange() {
        return new Range();
    }


    public Exception createException() {
        return new Exception();
    }


    public ReportDefinition.Filters createReportDefinitionFilters() {
        return new ReportDefinition.Filters();
    }


    @XmlElementDecl(namespace = "http://www.niso.org/schemas/sushicounter", name = "ReportRequest")
    public JAXBElement<ReportRequest> createReportRequest(ReportRequest value) {
        return new JAXBElement<ReportRequest>(_ReportRequest_QNAME, ReportRequest.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.niso.org/schemas/sushicounter", name = "ReportResponse")
    public JAXBElement<ReportResponse> createReportResponse(ReportResponse value) {
        return new JAXBElement<ReportResponse>(_ReportResponse_QNAME, ReportResponse.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.niso.org/schemas/sushicounter", name = "Name", scope = CustomerReference.class)
    public JAXBElement<String> createCustomerReferenceName(String value) {
        return new JAXBElement<String>(_CustomerReferenceName_QNAME, String.class, CustomerReference.class, value);
    }


    @XmlElementDecl(namespace = "http://www.niso.org/schemas/sushicounter", name = "HelpUrl", scope = Exception.class)
    public JAXBElement<String> createExceptionHelpUrl(String value) {
        return new JAXBElement<String>(_ExceptionHelpUrl_QNAME, String.class, Exception.class, value);
    }


    @XmlElementDecl(namespace = "http://www.niso.org/schemas/sushicounter", name = "Data", scope = Exception.class)
    public JAXBElement<Object> createExceptionData(Object value) {
        return new JAXBElement<Object>(_ExceptionData_QNAME, Object.class, Exception.class, value);
    }

}
