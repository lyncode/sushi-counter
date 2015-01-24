
package org.niso.schemas.counter;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PerformanceCounter", propOrder = {
    "metricType",
    "count"
})
public class PerformanceCounter {

    @XmlElement(name = "MetricType", required = true)
    @XmlSchemaType(name = "string")
    protected MetricType metricType;
    @XmlElement(name = "Count", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger count;


    public MetricType getMetricType() {
        return metricType;
    }


    public void setMetricType(MetricType value) {
        this.metricType = value;
    }


    public BigInteger getCount() {
        return count;
    }


    public void setCount(BigInteger value) {
        this.count = value;
    }

}
