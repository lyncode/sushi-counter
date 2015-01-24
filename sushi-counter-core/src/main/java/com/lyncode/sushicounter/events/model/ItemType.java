package com.lyncode.sushicounter.events.model;

import org.niso.schemas.counter.MetricType;

public enum ItemType {
    FT_PS,
    FT_PS_MOBILE,
    FT_PDF,
    FT_PDF_MOBILE,
    FT_HTML,
    FT_HTML_MOBILE,
    FT_EPUB,
    FT_TOTAL,
    SECTIONED_HTML,
    TOC,
    ABSTRACT,
    REFERENCE,
    DATA_SET,
    AUDIO,
    VIDEO,
    IMAGE,
    PODCAST,
    MULTIMEDIA,
    RECORD_VIEW,
    RESULT_CLICK,
    SEARCH_REG,
    SEARCH_FED,
    TURNAWAY,
    NO_LICENSE,
    OTHER
    ;

    public MetricType toMetricType() {
        return MetricType.valueOf(name());
    }
}
