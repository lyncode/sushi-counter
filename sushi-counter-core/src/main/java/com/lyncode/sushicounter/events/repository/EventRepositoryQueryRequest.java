package com.lyncode.sushicounter.events.repository;

import com.google.common.base.Optional;

import java.util.Date;

public class EventRepositoryQueryRequest {
    private final String reportType;
    private final String reportVersion;
    private final Date start;
    private final Date end;
    private final String costumerReference;

    private EventRepositoryQueryRequest(Builder builder) {
        this.reportType = builder.reportType;
        this.reportVersion = builder.reportVersion;
        this.start = builder.start;
        this.end = builder.end;
        this.costumerReference = builder.costumerReference;
    }

    public Optional<String> getReportType() {
        return Optional.fromNullable(reportType);
    }

    public Optional<String> getReportVersion() {
        return Optional.fromNullable(reportVersion);
    }

    public Optional<Date> getStart() {
        return Optional.fromNullable(start);
    }

    public Optional<Date> getEnd() {
        return Optional.fromNullable(end);
    }

    public Optional<String> getCostumerReference() {
        return Optional.fromNullable(costumerReference);
    }


    public static class Builder {
        private String reportType;
        private String reportVersion;
        private Date start;
        private Date end;
        private String costumerReference;

        public Builder reportType(String reportType) {
            this.reportType = reportType;
            return this;
        }

        public Builder reportVersion(String reportVersion) {
            this.reportVersion = reportVersion;
            return this;
        }

        public Builder start(Date start) {
            this.start = start;
            return this;
        }

        public Builder end(Date end) {
            this.end = end;
            return this;
        }

        public Builder costumerReference(String costumerReference) {
            this.costumerReference = costumerReference;
            return this;
        }

        public Builder fromPrototype(EventRepositoryQueryRequest prototype) {
            reportType = prototype.reportType;
            reportVersion = prototype.reportVersion;
            start = prototype.start;
            end = prototype.end;
            costumerReference = prototype.costumerReference;
            return this;
        }

        public EventRepositoryQueryRequest build() {
            return new EventRepositoryQueryRequest(this);
        }
    }
}
