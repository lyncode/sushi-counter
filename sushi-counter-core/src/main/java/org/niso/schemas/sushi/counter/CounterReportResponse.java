
package org.niso.schemas.sushi.counter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.niso.schemas.counter.Reports;
import org.niso.schemas.sushi.ReportResponse;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CounterReportResponse", propOrder = {
    "report"
})
public class CounterReportResponse
    extends ReportResponse
{

    @XmlElement(name = "Report", required = true, nillable = true)
    protected Reports report;


    public Reports getReport() {
        return report;
    }


    public void setReport(Reports value) {
        this.report = value;
    }

}
