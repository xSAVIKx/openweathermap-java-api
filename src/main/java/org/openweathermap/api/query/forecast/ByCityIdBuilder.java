package org.openweathermap.api.query.forecast;

public class ByCityIdBuilder extends ForecastQueryBuilder<ByCityIdBuilder, ByCityId> {
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
