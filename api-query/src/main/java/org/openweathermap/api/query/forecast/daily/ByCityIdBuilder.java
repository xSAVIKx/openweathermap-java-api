package org.openweathermap.api.query.forecast.daily;

public class ByCityIdBuilder extends DailyForecastQueryBuilder<ByCityIdBuilder, ByCityId> {
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
