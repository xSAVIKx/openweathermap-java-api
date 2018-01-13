package org.openweathermap.api.query.currentweather;

import org.openweathermap.api.common.Coordinate;
import org.openweathermap.api.query.Cluster;

public class ByRectangleZoneBuilder extends CurrentWeatherMultipleLocationsQueryBuilder<ByRectangleZoneBuilder, ByRectangleZone> {
    private final ByRectangleZone query;

    public ByRectangleZoneBuilder(Coordinate leftBottom, Coordinate rightTop) {
        query = new ByRectangleZone(leftBottom, rightTop);
    }

    public ByRectangleZoneBuilder cluster(Cluster cluster) {
        query.setCluster(cluster);
        return self();
    }

    @Override
    protected ByRectangleZoneBuilder self() {
        return this;
    }

    @Override
    protected ByRectangleZone getQuery() {
        return query;
    }
}
