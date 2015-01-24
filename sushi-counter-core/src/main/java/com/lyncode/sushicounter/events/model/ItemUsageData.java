package com.lyncode.sushicounter.events.model;

import java.util.Collection;

public interface ItemUsageData {
    ItemIdentifier getItemId();
    ItemType getItemType();
    String getName();
    Collection<EventGroup> getGroups();


    public static class EventGroup {
        private final EventGroupType type;
        private final long count;

        public EventGroup(EventGroupType type, long count) {
            this.type = type;
            this.count = count;
        }

        public EventGroupType getType() {
            return type;
        }

        public long getCount() {
            return count;
        }
    }
}
