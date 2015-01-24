
package org.niso.schemas.counter;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Customer", propOrder = {
    "consortium",
    "institutionalIdentifier"
})
@XmlSeeAlso({
    org.niso.schemas.counter.Report.Customer.class
})
public class Customer
    extends Organization
{

    @XmlElement(name = "Consortium")
    protected Consortium consortium;
    @XmlElement(name = "InstitutionalIdentifier")
    protected List<Identifier> institutionalIdentifier;


    public Consortium getConsortium() {
        return consortium;
    }


    public void setConsortium(Consortium value) {
        this.consortium = value;
    }


    public List<Identifier> getInstitutionalIdentifier() {
        if (institutionalIdentifier == null) {
            institutionalIdentifier = new ArrayList<Identifier>();
        }
        return this.institutionalIdentifier;
    }

}
