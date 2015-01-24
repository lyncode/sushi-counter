
package org.niso.schemas.counter;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;



@XmlType(name = "MetricType")
@XmlEnum
public enum MetricType {

    @XmlEnumValue("ft_ps")
    FT_PS("ft_ps"),
    @XmlEnumValue("ft_ps_mobile")
    FT_PS_MOBILE("ft_ps_mobile"),
    @XmlEnumValue("ft_pdf")
    FT_PDF("ft_pdf"),
    @XmlEnumValue("ft_pdf_mobile")
    FT_PDF_MOBILE("ft_pdf_mobile"),
    @XmlEnumValue("ft_html")
    FT_HTML("ft_html"),
    @XmlEnumValue("ft_html_mobile")
    FT_HTML_MOBILE("ft_html_mobile"),
    @XmlEnumValue("ft_epub")
    FT_EPUB("ft_epub"),
    @XmlEnumValue("ft_total")
    FT_TOTAL("ft_total"),
    @XmlEnumValue("sectioned_html")
    SECTIONED_HTML("sectioned_html"),
    @XmlEnumValue("toc")
    TOC("toc"),
    @XmlEnumValue("abstract")
    ABSTRACT("abstract"),
    @XmlEnumValue("reference")
    REFERENCE("reference"),
    @XmlEnumValue("data_set")
    DATA_SET("data_set"),
    @XmlEnumValue("audio")
    AUDIO("audio"),
    @XmlEnumValue("video")
    VIDEO("video"),
    @XmlEnumValue("image")
    IMAGE("image"),
    @XmlEnumValue("podcast")
    PODCAST("podcast"),
    @XmlEnumValue("multimedia")
    MULTIMEDIA("multimedia"),
    @XmlEnumValue("record_view")
    RECORD_VIEW("record_view"),
    @XmlEnumValue("result_click")
    RESULT_CLICK("result_click"),
    @XmlEnumValue("search_reg")
    SEARCH_REG("search_reg"),
    @XmlEnumValue("search_fed")
    SEARCH_FED("search_fed"),
    @XmlEnumValue("turnaway")
    TURNAWAY("turnaway"),
    @XmlEnumValue("no_license")
    NO_LICENSE("no_license"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    MetricType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MetricType fromValue(String v) {
        for (MetricType c: MetricType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
