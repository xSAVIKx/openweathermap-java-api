package org.openweathermap.api.query.builder;

import org.openweathermap.api.query.ByCityName;

public class ByCityNameBuilder extends CurrentWeatherQueryBuilder<ByCityNameBuilder, ByCityName> {
    private ByCityName query;

    public ByCityNameBuilder(String cityName) {
        query = new ByCityName(cityName);
    }

    public ByCityNameBuilder countryCode(String countryCode) {
        query.setCountryCode(countryCode);
        return self();
    }

    @Override
    protected ByCityNameBuilder self() {
        return this;
    }

    @Override
    protected ByCityName getQuery() {
        return query;
    }
}
