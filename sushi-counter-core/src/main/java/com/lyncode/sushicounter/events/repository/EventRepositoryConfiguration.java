package com.lyncode.sushicounter.events.repository;

import org.niso.schemas.counter.DataType;

public interface EventRepositoryConfiguration {
    String getPlatformName();
    String getInstitutionName();
    DataType getDataType();
}
