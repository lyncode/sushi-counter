
package org.niso.schemas.sushi;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Exception", propOrder = {
    "number",
    "severity",
    "message",
    "helpUrl",
    "data"
})
public class Exception {

    @XmlElement(name = "Number")
    protected int number;
    @XmlElement(name = "Severity", required = true)
    @XmlSchemaType(name = "string")
    protected ExceptionSeverity severity;
    @XmlElement(name = "Message", required = true)
    protected String message;
    @XmlElementRef(name = "HelpUrl", namespace = "http://www.niso.org/schemas/sushicounter", type = JAXBElement.class, required = false)
    protected JAXBElement<String> helpUrl;
    @XmlElementRef(name = "Data", namespace = "http://www.niso.org/schemas/sushicounter", type = JAXBElement.class, required = false)
    protected JAXBElement<Object> data;
    @XmlAttribute(name = "Created")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar created;


    public int getNumber() {
        return number;
    }


    public void setNumber(int value) {
        this.number = value;
    }


    public ExceptionSeverity getSeverity() {
        return severity;
    }


    public void setSeverity(ExceptionSeverity value) {
        this.severity = value;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String value) {
        this.message = value;
    }


    public JAXBElement<String> getHelpUrl() {
        return helpUrl;
    }


    public void setHelpUrl(JAXBElement<String> value) {
        this.helpUrl = value;
    }


    public JAXBElement<Object> getData() {
        return data;
    }


    public void setData(JAXBElement<Object> value) {
        this.data = value;
    }


    public XMLGregorianCalendar getCreated() {
        return created;
    }


    public void setCreated(XMLGregorianCalendar value) {
        this.created = value;
    }

}
