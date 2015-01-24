
package org.niso.schemas.sushi.counter;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.niso.schemas.sushi.ReportRequest;



@XmlRegistry
public class ObjectFactory {

    private final static QName _ReportResponse_QNAME = new QName("http://www.niso.org/schemas/sushicounter/counter", "ReportResponse");
    private final static QName _ReportRequest_QNAME = new QName("http://www.niso.org/schemas/sushicounter/counter", "ReportRequest");


    public ObjectFactory() {
    }


    public CounterReportResponse createCounterReportResponse() {
        return new CounterReportResponse();
    }


    @XmlElementDecl(namespace = "http://www.niso.org/schemas/sushicounter/counter", name = "ReportResponse")
    public JAXBElement<CounterReportResponse> createReportResponse(CounterReportResponse value) {
        return new JAXBElement<CounterReportResponse>(_ReportResponse_QNAME, CounterReportResponse.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.niso.org/schemas/sushicounter/counter", name = "ReportRequest")
    public JAXBElement<ReportRequest> createReportRequest(ReportRequest value) {
        return new JAXBElement<ReportRequest>(_ReportRequest_QNAME, ReportRequest.class, null, value);
    }

}
