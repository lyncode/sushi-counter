package com.lyncode.sushicounter.events.converters;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.lyncode.sushicounter.events.model.ItemUsageData;
import com.lyncode.sushicounter.events.repository.EventRepositoryConfiguration;
import com.lyncode.sushicounter.events.repository.EventRepositoryQueryResponse;
import com.lyncode.sushicounter.util.XMLGregorianCalenderUtils;
import org.niso.schemas.counter.*;
import org.niso.schemas.sushi.*;
import org.niso.schemas.sushi.Exception;
import org.niso.schemas.sushi.counter.CounterReportResponse;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.util.Collection;

public class EventRepositoryResponseToCounterReportResponse implements Function<EventRepositoryQueryResponse, CounterReportResponse> {
    private final EventRepositoryConfiguration configuration;
    private final ReportRequest request;

    public EventRepositoryResponseToCounterReportResponse(EventRepositoryConfiguration configuration, ReportRequest request) {
        this.configuration = configuration;
        this.request = request;
    }

    @Override
    public CounterReportResponse apply(final EventRepositoryQueryResponse eventRepositoryQueryResponse) {
        return new CounterReportResponse() {{
            setCreated(XMLGregorianCalenderUtils.now());
            setReportDefinition(request.getReportDefinition());
            setID(request.getID());
            setCustomerReference(request.getCustomerReference());
            setRequestor(request.getRequestor());
            setReport(new Reports() {{
                Collection<EventRepositoryQueryResponse.Error> errors = eventRepositoryQueryResponse.errors();
                if (!errors.isEmpty()) {
                    getException().addAll(Collections2.transform(errors, toExceptions()));
                } else {
                    getReport().add(toReport().apply(eventRepositoryQueryResponse.events()));
                }
            }});
        }};
    }

    private Function<Collection<ItemUsageData>, Report> toReport() {
        return new Function<Collection<ItemUsageData>, Report>() {
            @Override
            public Report apply(final Collection<ItemUsageData> itemUsageDatas) {
                return new Report() {{
                    setCreated(XMLGregorianCalenderUtils.now());
                    setVendor(new Vendor() {{
                        getCustomer().add(new Customer() {{
                            getReportItems().addAll(Collections2.transform(itemUsageDatas, toReportItem()));
                        }});
                    }});
                }};
            }
        };
    }

    private Function<ItemUsageData, ReportItem> toReportItem() {
        return new Function<ItemUsageData, ReportItem>() {
            @Override
            public ReportItem apply(final ItemUsageData itemUsageData) {
                return new ReportItem() {{
                    setItemDataType(configuration.getDataType());
                    setItemName(itemUsageData.getName());
                    getItemIdentifier().add(itemUsageData.getItemId().toIdentifier());
                    setItemPlatform(configuration.getPlatformName());
                    setItemPublisher(configuration.getInstitutionName());
                    getItemPerformance().addAll(Collections2.transform(itemUsageData.getGroups(), toMetric(itemUsageData)));
                }};
            }
        };
    }

    private Function<ItemUsageData.EventGroup, Metric> toMetric(final ItemUsageData itemUsageData) {
        return new Function<ItemUsageData.EventGroup, Metric>() {
            @Override
            public Metric apply(final ItemUsageData.EventGroup eventGroup) {
                return new Metric() {{
                    setCategory(eventGroup.getType().toCategory());
                    setPeriod(new DateRange() {{
                        setBegin(reportBeginDate());
                        setEnd(reportEndDate());
                    }});
                    getInstance().add(new PerformanceCounter() {{
                        setMetricType(itemUsageData.getItemType().toMetricType());
                        setCount(new BigInteger(String.valueOf(eventGroup.getCount())));
                    }});
                }};
            }
        };
    }

    private XMLGregorianCalendar reportBeginDate() {
        ReportDefinition reportDefinition = request.getReportDefinition();
        if (reportDefinition == null) return null;
        ReportDefinition.Filters filters = reportDefinition.getFilters();
        if (filters == null) return null;
        Range usageDateRange = filters.getUsageDateRange();
        if (usageDateRange == null) return null;
        return usageDateRange.getBegin();
    }
    private XMLGregorianCalendar reportEndDate() {
        ReportDefinition reportDefinition = request.getReportDefinition();
        if (reportDefinition == null) return null;
        ReportDefinition.Filters filters = reportDefinition.getFilters();
        if (filters == null) return null;
        Range usageDateRange = filters.getUsageDateRange();
        if (usageDateRange == null) return null;
        return usageDateRange.getEnd();
    }

    private Function<EventRepositoryQueryResponse.Error, Exception> toExceptions() {
        return new Function<EventRepositoryQueryResponse.Error, Exception>() {
            @Override
            public Exception apply(final EventRepositoryQueryResponse.Error error) {
                return new Exception() {{
                    setCreated(XMLGregorianCalenderUtils.now());
                    setMessage(error.getMessage());
                    setNumber(1);
                    setSeverity(ExceptionSeverity.ERROR);
                }};
            }
        };
    }
}
