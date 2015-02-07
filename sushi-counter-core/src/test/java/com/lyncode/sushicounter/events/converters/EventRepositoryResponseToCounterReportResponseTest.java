package com.lyncode.sushicounter.events.converters;

import com.google.common.base.Optional;
import com.lyncode.sushicounter.events.model.ContentType;
import com.lyncode.sushicounter.events.model.EventType;
import com.lyncode.sushicounter.events.model.ItemUsageData;
import com.lyncode.sushicounter.events.repository.EventRepositoryConfiguration;
import com.lyncode.sushicounter.events.repository.EventRepositoryQueryResponse;
import org.junit.Test;
import org.niso.schemas.counter.Identifier;
import org.niso.schemas.counter.IdentifierType;
import org.niso.schemas.sushi.ReportRequest;
import org.niso.schemas.sushi.counter.CounterReportResponse;

import java.util.*;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;

public class EventRepositoryResponseToCounterReportResponseTest {
    private final EventRepositoryConfiguration configuration = mock(EventRepositoryConfiguration.class);
    private final ReportRequest reportRequest = mock(ReportRequest.class);
    private EventRepositoryResponseToCounterReportResponse underTest = new EventRepositoryResponseToCounterReportResponse(configuration, reportRequest);

    @Test
    public void name() throws Exception {
        CounterReportResponse result = underTest.apply(new EventRepositoryQueryResponse() {
            @Override
            public Collection<Error> errors() {
                return Collections.EMPTY_LIST;
            }

            @Override
            public Collection<ItemUsageData> events() {
                return new ArrayList<ItemUsageData>() {{
                    add(itemUsageData("ITEM-2135213", "ONE", eventGroups(
                            group(EventType.REQUEST, 10),
                            group(EventType.SEARCH, 20),
                            group(EventType.ACCESS_DENIED, 400)
                    )));
                }};
            }
        });

        assertThat(result.getReport().getReport().get(0).getCustomer().get(0).getReportItems().get(0).getItemName(), is(equalTo("ONE")));
    }

    private ItemUsageData.ItemStats group(EventType groupType, int count) {
        return new ItemUsageData.ItemStats(groupType, Optional.<Date>absent(), Optional.<Date>absent(), asList(
                new ItemUsageData.ItemEventGroup(ContentType.AUDIO, count)
        ));
    }

    private List<ItemUsageData.ItemStats> eventGroups(ItemUsageData.ItemStats... stats) {
        return asList(stats);
    }

    private ItemUsageData itemUsageData(final String itemId, final String name, final List<ItemUsageData.ItemStats> stats) {
        return new ItemUsageData() {
            @Override
            public Collection<Identifier> getItemIdentifiers() {
                Identifier identifier = new Identifier() {{
                    setType(IdentifierType.PROPRIETARY);
                    setValue(itemId);
                }};
                return asList(identifier);
            }

            @Override
            public String getName() {
                return name;
            }

            @Override
            public Collection<ItemStats> getItemStats() {
                return stats;
            }

            @Override
            public Optional<String> getPublisher() {
                return Optional.absent();
            }
        };
    }
}