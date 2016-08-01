package org.openweathermap.api.query.currentweather;

import org.openweathermap.api.common.Coordinate;
import org.openweathermap.api.query.Cluster;

public class InCycleBuilder extends CurrentWeatherMultipleLocationsQueryBuilder<InCycleBuilder, InCycle> {
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
