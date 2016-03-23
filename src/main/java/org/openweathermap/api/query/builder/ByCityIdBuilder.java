package org.openweathermap.api.query.builder;

import org.openweathermap.api.query.ByCityId;

public class ByCityIdBuilder extends CurrentWeatherQueryBuilder<ByCityIdBuilder, ByCityId> {
    private ByCityId query;

    public ByCityIdBuilder(String cityId) {
        query = new ByCityId(cityId);
    }

    @Override
    protected ByCityIdBuilder self() {
        return this;
    }

    @Override
    protected ByCityId getQuery() {
        return query;
    }
}
