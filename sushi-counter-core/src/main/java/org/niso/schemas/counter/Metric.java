
package org.niso.schemas.counter;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Metric", propOrder = {
    "period",
    "category",
    "instance"
})
public class Metric {

    @XmlElement(name = "Period", required = true)
    protected DateRange period;
    @XmlElement(name = "Category", required = true)
    @XmlSchemaType(name = "string")
    protected Category category;
    @XmlElement(name = "Instance", required = true)
    protected List<PerformanceCounter> instance;
    @XmlAttribute(name = "PubYr")
    @XmlSchemaType(name = "gYear")
    protected XMLGregorianCalendar pubYr;
    @XmlAttribute(name = "PubYrFrom")
    @XmlSchemaType(name = "gYear")
    protected XMLGregorianCalendar pubYrFrom;
    @XmlAttribute(name = "PubYrTo")
    @XmlSchemaType(name = "gYear")
    protected XMLGregorianCalendar pubYrTo;


    public DateRange getPeriod() {
        return period;
    }


    public void setPeriod(DateRange value) {
        this.period = value;
    }


    public Category getCategory() {
        return category;
    }


    public void setCategory(Category value) {
        this.category = value;
    }


    public List<PerformanceCounter> getInstance() {
        if (instance == null) {
            instance = new ArrayList<PerformanceCounter>();
        }
        return this.instance;
    }


    public XMLGregorianCalendar getPubYr() {
        return pubYr;
    }


    public void setPubYr(XMLGregorianCalendar value) {
        this.pubYr = value;
    }


    public XMLGregorianCalendar getPubYrFrom() {
        return pubYrFrom;
    }


    public void setPubYrFrom(XMLGregorianCalendar value) {
        this.pubYrFrom = value;
    }


    public XMLGregorianCalendar getPubYrTo() {
        return pubYrTo;
    }


    public void setPubYrTo(XMLGregorianCalendar value) {
        this.pubYrTo = value;
    }

}
