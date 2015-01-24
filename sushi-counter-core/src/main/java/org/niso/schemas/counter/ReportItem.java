
package org.niso.schemas.counter;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportItem", propOrder = {
    "itemIdentifier",
    "itemPlatform",
    "itemPublisher",
    "itemName",
    "itemDataType",
    "itemPerformance"
})
public class ReportItem {

    @XmlElement(name = "ItemIdentifier")
    protected List<Identifier> itemIdentifier;
    @XmlElement(name = "ItemPlatform", required = true)
    protected String itemPlatform;
    @XmlElement(name = "ItemPublisher")
    protected String itemPublisher;
    @XmlElement(name = "ItemName", required = true)
    protected String itemName;
    @XmlElement(name = "ItemDataType", required = true)
    @XmlSchemaType(name = "string")
    protected DataType itemDataType;
    @XmlElement(name = "ItemPerformance", required = true)
    protected List<Metric> itemPerformance;


    public List<Identifier> getItemIdentifier() {
        if (itemIdentifier == null) {
            itemIdentifier = new ArrayList<Identifier>();
        }
        return this.itemIdentifier;
    }


    public String getItemPlatform() {
        return itemPlatform;
    }


    public void setItemPlatform(String value) {
        this.itemPlatform = value;
    }


    public String getItemPublisher() {
        return itemPublisher;
    }


    public void setItemPublisher(String value) {
        this.itemPublisher = value;
    }


    public String getItemName() {
        return itemName;
    }


    public void setItemName(String value) {
        this.itemName = value;
    }


    public DataType getItemDataType() {
        return itemDataType;
    }


    public void setItemDataType(DataType value) {
        this.itemDataType = value;
    }


    public List<Metric> getItemPerformance() {
        if (itemPerformance == null) {
            itemPerformance = new ArrayList<Metric>();
        }
        return this.itemPerformance;
    }

}
