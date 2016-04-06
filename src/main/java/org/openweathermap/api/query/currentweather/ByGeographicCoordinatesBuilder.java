package org.openweathermap.api.query.currentweather;

import org.openweathermap.api.model.Coordinate;

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
