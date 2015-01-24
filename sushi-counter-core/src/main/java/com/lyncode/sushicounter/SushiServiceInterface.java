package com.lyncode.sushicounter;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


@WebService(targetNamespace = "SushiService", name = "SushiServiceInterface")
@XmlSeeAlso({org.niso.schemas.counter.ObjectFactory.class, org.niso.schemas.sushi.ObjectFactory.class, org.niso.schemas.sushi.counter.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface SushiServiceInterface {

    @WebMethod(operationName = "GetReport", action = "SushiService:GetReportIn")
    @WebResult(name = "ReportResponse", targetNamespace = "http://www.niso.org/schemas/sushicounter/counter", partName = "messagePart")
    public org.niso.schemas.sushi.counter.CounterReportResponse getReport(
        @WebParam(partName = "messagePart", name = "ReportRequest", targetNamespace = "http://www.niso.org/schemas/sushi/counter")
        org.niso.schemas.sushi.ReportRequest messagePart
    );
}
