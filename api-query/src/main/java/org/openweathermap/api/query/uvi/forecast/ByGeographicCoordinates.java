package org.openweathermap.api.query.uvi.forecast;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openweathermap.api.common.Coordinate;
import org.openweathermap.api.query.uvi.AbstractByGeographicCoordinates;

@EqualsAndHashCode(callSuper = true)
@Data
public class ByGeographicCoordinates extends AbstractByGeographicCoordinates implements ForecastUviQuery {
    private int count;

    public ByGeographicCoordinates(Coordinate coordinate) {
        super(coordinate);
    }

    @Override
    protected String getSearchPath() {
        return super.getSearchPath() + FORECAST;
    }

    @Override
    public String toStringRepresentation(String apiKey) {
        StringBuilder stringBuilder = new StringBuilder(super.toStringRepresentation(apiKey));
        if (getCount() > 0) {
            stringBuilder.append(AND).append("cnt=").append(getCount());
        }
        return stringBuilder.toString();
    }
}
