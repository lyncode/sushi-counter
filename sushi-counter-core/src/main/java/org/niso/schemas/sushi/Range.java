
package org.niso.schemas.sushi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Range", propOrder = {
    "begin",
    "end"
})
public class Range {

    @XmlElement(name = "Begin", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar begin;
    @XmlElement(name = "End", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar end;


    public XMLGregorianCalendar getBegin() {
        return begin;
    }


    public void setBegin(XMLGregorianCalendar value) {
        this.begin = value;
    }


    public XMLGregorianCalendar getEnd() {
        return end;
    }


    public void setEnd(XMLGregorianCalendar value) {
        this.end = value;
    }

}
