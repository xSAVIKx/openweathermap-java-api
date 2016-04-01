package org.openweathermap.api.query.builder;

import org.openweathermap.api.model.Coordinate;
import org.openweathermap.api.query.Cluster;
import org.openweathermap.api.query.InCycle;

public class InCycleBuilder extends CurrentWeatherManyLocationsQueryBuilder<InCycleBuilder, InCycle> {
    InCycle query;

    public InCycleBuilder(Coordinate centerPoint, int expectedNumberOfCities) {
        query = new InCycle(centerPoint, expectedNumberOfCities);
    }

    public InCycleBuilder cluster(Cluster cluster) {
        query.setCluster(cluster);
        return self();
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
