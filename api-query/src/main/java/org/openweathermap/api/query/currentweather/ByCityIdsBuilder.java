package org.openweathermap.api.query.currentweather;

import java.util.Collection;

public class ByCityIdsBuilder extends CurrentWeatherMultipleLocationsQueryBuilder<ByCityIdsBuilder, ByCityIds> {
    private final ByCityIds query;

    public ByCityIdsBuilder(Collection<String> cityIds) {
        query = new ByCityIds(cityIds);
    }

    public ByCityIdsBuilder() {
        query = new ByCityIds();
    }

    public ByCityIdsBuilder addCityId(String cityId) {
        query.addCityId(cityId);
        return self();
    }

    @Override
    protected ByCityIdsBuilder self() {
        return this;
    }

    @Override
    protected ByCityIds getQuery() {
        return query;
    }
}
