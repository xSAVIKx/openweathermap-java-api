package org.openweathermap.api.query.uvi.history;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openweathermap.api.common.Coordinate;
import org.openweathermap.api.query.uvi.AbstractByGeographicCoordinates;

@EqualsAndHashCode(callSuper = true)
@Data
public class ByGeographicCoordinates extends AbstractByGeographicCoordinates implements HistoryUviQuery {
    private long start;
    private long end;
    private int count;


    public ByGeographicCoordinates(Coordinate coordinate) {
        super(coordinate);
    }

    @Override
    protected String getSearchPath() {
        return super.getSearchPath() + HISTORY;
    }

    @Override
    public String toStringRepresentation(String apiKey) {
        StringBuilder stringBuilder = new StringBuilder(super.toStringRepresentation(apiKey));
        stringBuilder.append(AND).append("start=").append(getStart());
        stringBuilder.append(AND).append("end=").append(getEnd());
        if (getCount() > 0) {
            stringBuilder.append(AND).append("cnt=").append(getCount());
        }
        return stringBuilder.toString();
    }
}
