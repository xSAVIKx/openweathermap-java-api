package org.openweathermap.api.query.currentweather;

public class ByCityIdBuilder extends CurrentWeatherOneLocationQueryBuilder<ByCityIdBuilder, ByCityId> {
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
