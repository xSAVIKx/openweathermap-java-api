package org.openweathermap.api.query.builder;

import org.openweathermap.api.query.ByZipCode;

public class ByZipCodeBuilder extends CurrentWeatherQueryBuilder<ByZipCodeBuilder, ByZipCode> {
    private ByZipCode query;

    public ByZipCodeBuilder(String zipCode, String countryCode) {
        this.query = new ByZipCode(zipCode, countryCode);
    }

    @Override
    protected ByZipCodeBuilder self() {
        return this;
    }

    @Override
    protected ByZipCode getQuery() {
        return query;
    }
}
