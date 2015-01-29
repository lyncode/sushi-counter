package com.lyncode.sushicounter.events.model;

import org.niso.schemas.counter.Category;

public enum EventType {
    SEARCH(Category.SEARCHES),
    REQUEST(Category.REQUESTS),
    ACCESS_DENIED(Category.ACCESS_DENIED);

    private final Category category;

    EventType(Category category) {

        this.category = category;
    }

    public Category toCategory() {
        return category;
    }
}
