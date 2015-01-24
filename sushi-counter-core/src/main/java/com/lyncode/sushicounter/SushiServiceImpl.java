package com.lyncode.sushicounter;

import com.lyncode.sushicounter.events.converters.EventRepositoryResponseToCounterReportResponse;
import com.lyncode.sushicounter.events.converters.ReportRequestToRepositoryQuery;
import com.lyncode.sushicounter.events.repository.EventRepository;
import org.niso.schemas.sushi.ReportRequest;
import org.niso.schemas.sushi.counter.CounterReportResponse;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService(endpointInterface = "com.lyncode.sushicounter.SushiServiceInterface")
public class SushiServiceImpl implements SushiServiceInterface {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:12000/", new SushiServiceImpl(null));
    }

    private final EventRepository eventRepository;

    public SushiServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public CounterReportResponse getReport(ReportRequest request) {
        return new EventRepositoryResponseToCounterReportResponse(eventRepository.configuration(), request).apply(
                eventRepository.retrieve(ReportRequestToRepositoryQuery.instance().apply(request))
        );
    }
}
