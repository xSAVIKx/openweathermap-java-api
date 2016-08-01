package org.openweathermap.api.query.forecast.hourly;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openweathermap.api.common.Coordinate;
import org.openweathermap.api.query.forecast.AbstractForecastQuery;

@EqualsAndHashCode(callSuper = true)
@Data
public class ByGeographicCoordinates extends AbstractForecastQuery implements HourlyForecastQuery {
    private final Coordinate coordinate;

    public ByGeographicCoordinates(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    protected String getRequestPart() {
        return String.format("lat=%s&lon=%s", coordinate.getLatitude(), coordinate.getLongitude());
    }
}
