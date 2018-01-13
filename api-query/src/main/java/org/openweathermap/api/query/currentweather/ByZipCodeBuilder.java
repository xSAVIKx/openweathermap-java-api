package org.openweathermap.api.query.currentweather;

public class ByZipCodeBuilder extends CurrentWeatherOneLocationQueryBuilder<ByZipCodeBuilder, ByZipCode> {
    private final ByZipCode query;

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
