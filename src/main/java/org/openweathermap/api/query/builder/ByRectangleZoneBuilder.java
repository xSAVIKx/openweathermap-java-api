package org.openweathermap.api.query.builder;

import org.openweathermap.api.model.Coordinate;
import org.openweathermap.api.query.ByRectangleZone;

public class ByRectangleZoneBuilder extends CurrentWeatherManyLocationsQueryBuilder<ByRectangleZoneBuilder, ByRectangleZone> {
    private ByRectangleZone query;

    public ByRectangleZoneBuilder(Coordinate leftBottom, Coordinate rightTop) {
        query = new ByRectangleZone(leftBottom, rightTop);
    }

    public ByRectangleZoneBuilder cluster(ByRectangleZone.Cluster cluster) {
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
