package org.openweathermap.api.query.builder;

import org.openweathermap.api.model.Coordinate;
import org.openweathermap.api.query.ByGeographicCoordinates;

public class ByGeographicCoordinatesBuilder extends CurrentWeatherOneLocationQueryBuilder<ByGeographicCoordinatesBuilder, ByGeographicCoordinates> {
    private ByGeographicCoordinates query;

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
}
