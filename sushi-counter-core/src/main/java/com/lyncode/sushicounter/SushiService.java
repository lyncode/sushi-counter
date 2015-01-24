package com.lyncode.sushicounter;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;


@WebServiceClient(name = "SushiService", 
                  wsdlLocation = "http://www.niso.org/schemas/sushi/counter_sushi4_0.wsdl",
                  targetNamespace = "SushiService") 
public class SushiService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("SushiService", "SushiService");
    public final static QName SushiServicePort = new QName("SushiService", "SushiServicePort");
    static {
        URL url = SushiService.class.getClassLoader().getResource("countersushi/counter_sushi4_0.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(SushiService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "countersushi/counter_sushi4_0.wsdl");
        }       
        WSDL_LOCATION = url;
    }

    public SushiService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public SushiService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SushiService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public SushiService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public SushiService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public SushiService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    


    @WebEndpoint(name = "SushiServicePort")
    public SushiServiceInterface getSushiServicePort() {
        return super.getPort(SushiServicePort, SushiServiceInterface.class);
    }


    @WebEndpoint(name = "SushiServicePort")
    public SushiServiceInterface getSushiServicePort(WebServiceFeature... features) {
        return super.getPort(SushiServicePort, SushiServiceInterface.class, features);
    }

}
