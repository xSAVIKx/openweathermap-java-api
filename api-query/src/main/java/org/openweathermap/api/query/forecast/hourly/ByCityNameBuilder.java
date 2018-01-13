package org.openweathermap.api.query.forecast.hourly;

import org.openweathermap.api.query.Type;

public class ByCityNameBuilder extends HourlyForecastQueryBuilder<ByCityNameBuilder, ByCityName> {
    private final ByCityName query;

    public ByCityNameBuilder(String cityName) {
        query = new ByCityName(cityName);
    }

    public ByCityNameBuilder countryCode(String countryCode) {
        query.setCountryCode(countryCode);
        return self();
    }

    public ByCityNameBuilder type(Type type) {
        query.setType(type);
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
