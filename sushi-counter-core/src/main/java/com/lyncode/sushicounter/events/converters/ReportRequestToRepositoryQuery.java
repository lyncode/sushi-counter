package com.lyncode.sushicounter.events.converters;

import com.google.common.base.Function;
import com.lyncode.sushicounter.events.repository.EventRepositoryQueryRequest;
import com.lyncode.sushicounter.util.XMLGregorianCalenderUtils;
import org.niso.schemas.sushi.CustomerReference;
import org.niso.schemas.sushi.Range;
import org.niso.schemas.sushi.ReportDefinition;
import org.niso.schemas.sushi.ReportRequest;

public class ReportRequestToRepositoryQuery implements Function<ReportRequest, EventRepositoryQueryRequest> {
    private static final ReportRequestToRepositoryQuery instance = new ReportRequestToRepositoryQuery();
    public static ReportRequestToRepositoryQuery instance () {
        return instance;
    }

    @Override
    public EventRepositoryQueryRequest apply(ReportRequest reportRequest) {
        Range usageDateRange = usageDateRange(reportRequest);

        return new EventRepositoryQueryRequest.Builder()
                .start(XMLGregorianCalenderUtils.toDate().apply(usageDateRange.getBegin()))
                .end(XMLGregorianCalenderUtils.toDate().apply(usageDateRange.getEnd()))
                .costumerReference(getCostumerReferenceId(reportRequest))
                .reportType(reportType(reportRequest))
                .reportVersion(reportVersion(reportRequest))
                .build();
    }

    private String reportVersion(ReportRequest reportRequest) {
        ReportDefinition reportDefinition = reportRequest.getReportDefinition();
        if (reportDefinition == null) return null;
        return reportDefinition.getRelease();
    }

    private String reportType(ReportRequest reportRequest) {
        ReportDefinition reportDefinition = reportRequest.getReportDefinition();
        if (reportDefinition == null) return null;
        return reportDefinition.getName();
    }

    private String getCostumerReferenceId(ReportRequest reportRequest) {
        CustomerReference customerReference = reportRequest.getCustomerReference();
        if (customerReference == null) return null;
        return customerReference.getID();
    }

    private Range usageDateRange(ReportRequest reportRequest) {
        if (reportRequest == null) return new Range();
        if (reportRequest.getReportDefinition() == null) return new Range();
        if (reportRequest.getReportDefinition().getFilters() == null) return new Range();
        return reportRequest.getReportDefinition().getFilters().getUsageDateRange();
    }
}
