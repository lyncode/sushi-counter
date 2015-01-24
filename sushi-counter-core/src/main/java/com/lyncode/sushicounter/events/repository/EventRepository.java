package com.lyncode.sushicounter.events.repository;

public interface EventRepository {
    EventRepositoryConfiguration configuration ();
    EventRepositoryQueryResponse retrieve (EventRepositoryQueryRequest query);
}
