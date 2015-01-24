package com.lyncode.sushicounter.events.converters;

import com.lyncode.sushicounter.events.repository.EventRepositoryQueryRequest;
import com.lyncode.sushicounter.util.XMLGregorianCalenderUtils;
import org.junit.Test;
import org.niso.schemas.sushi.CustomerReference;
import org.niso.schemas.sushi.Range;
import org.niso.schemas.sushi.ReportDefinition;
import org.niso.schemas.sushi.ReportRequest;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class ReportRequestToRepositoryQueryTest {
    @Test
    public void applyShouldReturnTheBeginDateAsProvidedInTheRequest() throws Exception {
        final Date beginDate = new Date();

        EventRepositoryQueryRequest result = ReportRequestToRepositoryQuery.instance().apply(new ReportRequest() {{
            setReportDefinition(new ReportDefinition() {{
                setFilters(new Filters() {{
                    setUsageDateRange(new Range() {{
                        setBegin(toXML(beginDate));
                    }});
                }});
            }});
        }});

        assertThat(result.getStart().get(), is(equalTo(beginDate)));
        assertThat(result.getEnd().isPresent(), is(false));
    }

    @Test
    public void applyShouldReturnTheEndDateAsProvidedInTheRequest() throws Exception {
        final Date date = new Date();

        EventRepositoryQueryRequest result = ReportRequestToRepositoryQuery.instance().apply(new ReportRequest() {{
            setReportDefinition(new ReportDefinition() {{
                setFilters(new Filters() {{
                    setUsageDateRange(new Range() {{
                        setEnd(toXML(date));
                    }});
                }});
            }});
        }});

        assertThat(result.getEnd().get(), is(equalTo(date)));
        assertThat(result.getStart().isPresent(), is(false));
    }

    @Test
    public void applyShouldReturnTheCostumerReference() throws Exception {
        final String costumerReference = "costumerReference";

        EventRepositoryQueryRequest result = ReportRequestToRepositoryQuery.instance().apply(new ReportRequest() {{
            setCustomerReference(new CustomerReference() {{
                setID(costumerReference);
            }});
        }});

        assertThat(result.getCostumerReference().get(), is(equalTo(costumerReference)));
    }

    private XMLGregorianCalendar toXML(Date date) {
        return XMLGregorianCalenderUtils.fromDate().apply(date);
    }
}