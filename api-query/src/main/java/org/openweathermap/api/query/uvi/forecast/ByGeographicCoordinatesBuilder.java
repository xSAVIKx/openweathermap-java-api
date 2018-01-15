package org.openweathermap.api.query.uvi.forecast;

import org.openweathermap.api.common.Coordinate;
import org.openweathermap.api.query.uvi.UviQueryBuilder;

public class ByGeographicCoordinatesBuilder
        extends UviQueryBuilder<ByGeographicCoordinatesBuilder, ByGeographicCoordinates> {
    private final ByGeographicCoordinates query;

    public ByGeographicCoordinatesBuilder(Coordinate coordinate) {
        query = new ByGeographicCoordinates(coordinate);
    }

    @Override
    protected ByGeographicCoordinatesBuilder self() {
        return this;
    }

    @Override
    protected ByGeographicCoordinates getQuery() {
        return query;
    }

    public ByGeographicCoordinatesBuilder count(int count) {
        getQuery().setCount(count);
        return self();
    }
}
