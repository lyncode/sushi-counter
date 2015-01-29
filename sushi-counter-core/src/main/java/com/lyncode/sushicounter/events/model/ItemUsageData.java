package com.lyncode.sushicounter.events.model;

import com.google.common.base.Optional;
import org.niso.schemas.counter.Identifier;

import java.util.Collection;
import java.util.Date;

public interface ItemUsageData {
    Collection<Identifier> getItemIdentifiers();
    String getName();
    Collection<ItemStats> getItemStats();
    Optional<String> getPublisher();


    public static class ItemStats {
        private final EventType itemType;
        private final Optional<Date> start;
        private final Optional<Date> end;
        private final Collection<ItemEventGroup> groups;

        public ItemStats(EventType itemType, Optional<Date> start, Optional<Date> end, Collection<ItemEventGroup> groups) {
            this.itemType = itemType;
            this.start = start;
            this.end = end;
            this.groups = groups;
        }

        public Optional<Date> getStart() {
            return start;
        }

        public Optional<Date> getEnd() {
            return end;
        }

        public Collection<ItemEventGroup> getGroups() {
            return groups;
        }

        public EventType getType() {
            return itemType;
        }
    }

    public static class ItemEventGroup {
        private final ContentType type;
        private final long count;

        public ItemEventGroup(ContentType type, long count) {
            this.type = type;
            this.count = count;
        }

        public ContentType getType() {
            return type;
        }

        public long getCount() {
            return count;
        }
    }
}
