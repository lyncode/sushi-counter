
package org.niso.schemas.sushi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportDefinition", propOrder = {
    "filters"
})
public class ReportDefinition {

    @XmlElement(name = "Filters", required = true)
    protected ReportDefinition.Filters filters;
    @XmlAttribute(name = "Name", required = true)
    protected String name;
    @XmlAttribute(name = "Release", required = true)
    protected String release;


    public ReportDefinition.Filters getFilters() {
        return filters;
    }


    public void setFilters(ReportDefinition.Filters value) {
        this.filters = value;
    }


    public String getName() {
        return name;
    }


    public void setName(String value) {
        this.name = value;
    }


    public String getRelease() {
        return release;
    }


    public void setRelease(String value) {
        this.release = value;
    }



    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "usageDateRange"
    })
    public static class Filters {

        @XmlElement(name = "UsageDateRange", required = true)
        protected Range usageDateRange;


        public Range getUsageDateRange() {
            return usageDateRange;
        }


        public void setUsageDateRange(Range value) {
            this.usageDateRange = value;
        }

    }

}
