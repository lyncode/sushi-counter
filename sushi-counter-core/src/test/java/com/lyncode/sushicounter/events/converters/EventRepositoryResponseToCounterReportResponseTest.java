package com.lyncode.sushicounter.events.converters;

import com.lyncode.sushicounter.events.model.EventGroupType;
import com.lyncode.sushicounter.events.model.ItemIdentifier;
import com.lyncode.sushicounter.events.model.ItemType;
import com.lyncode.sushicounter.events.model.ItemUsageData;
import com.lyncode.sushicounter.events.repository.EventRepositoryConfiguration;
import com.lyncode.sushicounter.events.repository.EventRepositoryQueryResponse;
import org.junit.Test;
import org.niso.schemas.counter.Identifier;
import org.niso.schemas.counter.IdentifierType;
import org.niso.schemas.sushi.ReportRequest;
import org.niso.schemas.sushi.counter.CounterReportResponse;

import java.util.*;

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
                    add(itemUsageData("ITEM-2135213", "ONE", ItemType.AUDIO, eventGroups(
                            group(EventGroupType.REQUEST, 10),
                            group(EventGroupType.SEARCH, 20),
                            group(EventGroupType.ACCESS_DENIED, 400)
                    )));
                }};
            }
        });

        assertThat(result.getReport().getReport().get(0).getCustomer().get(0).getReportItems().get(0).getItemName(), is(equalTo("ONE")));
    }

    private ItemUsageData.EventGroup group(EventGroupType groupType, int count) {
        return new ItemUsageData.EventGroup(groupType, count);
    }

    private List<ItemUsageData.EventGroup> eventGroups(ItemUsageData.EventGroup... eventGroups) {
        return Arrays.asList(eventGroups);
    }

    private ItemUsageData itemUsageData(final String itemId, final String name, final ItemType itemType, final List<ItemUsageData.EventGroup> eventGroups) {
        return new ItemUsageData() {
            @Override
            public ItemIdentifier getItemId() {
                return new ItemIdentifier() {
                    @Override
                    public Identifier toIdentifier() {
                        return new Identifier() {{
                            setType(IdentifierType.ISBN);
                            setValue(itemId);
                        }};
                    }
                };
            }

            @Override
            public ItemType getItemType() {
                return itemType;
            }

            @Override
            public String getName() {
                return name;
            }

            @Override
            public Collection<EventGroup> getGroups() {
                return eventGroups;
            }
        };
    }
}