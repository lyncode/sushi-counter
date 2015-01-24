package com.lyncode.sushicounter.events.repository;

import com.lyncode.sushicounter.events.model.ItemUsageData;

import java.util.Collection;

public interface EventRepositoryQueryResponse {
    Collection<Error> errors();
    Collection<ItemUsageData> events();

    public static class Error {
        private final String message;

        public Error(String message) {
            this.message = message;
        }
        public String getMessage() {
            return message;
        }
    }
}
