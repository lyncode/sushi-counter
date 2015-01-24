package com.lyncode.sushicounter.events.model;

import org.niso.schemas.counter.Category;

public enum EventGroupType {
    SEARCH(Category.SEARCHES),
    REQUEST(Category.REQUESTS),
    ACCESS_DENIED(Category.ACCESS_DENIED);

    private final Category category;

    EventGroupType(Category category) {

        this.category = category;
    }

    public Category toCategory() {
        return category;
    }
}
