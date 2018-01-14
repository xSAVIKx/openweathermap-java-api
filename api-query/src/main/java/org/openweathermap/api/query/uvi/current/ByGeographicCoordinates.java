package org.openweathermap.api.query.uvi.current;

import org.openweathermap.api.common.Coordinate;
import org.openweathermap.api.query.uvi.AbstractByGeographicCoordinates;

public class ByGeographicCoordinates extends AbstractByGeographicCoordinates implements CurrentUviQuery {

    public ByGeographicCoordinates(Coordinate coordinate) {
        super(coordinate);
    }
}
