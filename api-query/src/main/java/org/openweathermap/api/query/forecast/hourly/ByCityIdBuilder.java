package org.openweathermap.api.query.forecast.hourly;

public class ByCityIdBuilder extends HourlyForecastQueryBuilder<ByCityIdBuilder, ByCityId> {
    private final ByCityId query;

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
