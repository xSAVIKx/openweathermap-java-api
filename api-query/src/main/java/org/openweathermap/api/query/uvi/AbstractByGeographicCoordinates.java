package org.openweathermap.api.query.uvi;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openweathermap.api.common.Coordinate;
import org.openweathermap.api.query.AbstractQuery;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class AbstractByGeographicCoordinates extends AbstractQuery implements UviQuery {
    private final Coordinate coordinate;

    protected AbstractByGeographicCoordinates(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    protected String getRequestPart() {
        return String.format("lat=%s&lon=%s", coordinate.getLatitude(), coordinate.getLongitude());
    }

    @Override
    protected String getSearchPath() {
        return UviQuery.SEARCH_PATH;
    }
}
