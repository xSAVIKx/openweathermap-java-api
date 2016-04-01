package org.openweathermap.api.query.builder;

import org.openweathermap.api.model.Coordinate;
import org.openweathermap.api.query.InCycle;

/**
 * Created by iuriis on 31.03.2016.
 */
public class InCycleBuilder extends CurrentWeatherManyLocationsQueryBuilder<InCycleBuilder, InCycle> {
    InCycle query;

    public InCycleBuilder(Coordinate centerPoint, int expectedNumberOfCities) {
        query = new InCycle(centerPoint, expectedNumberOfCities);
    }

    @Override
    protected InCycleBuilder self() {
        return this;
    }

    @Override
    protected InCycle getQuery() {
        return query;
    }
}
