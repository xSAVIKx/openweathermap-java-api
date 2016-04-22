package org.openweathermap.api.query.forecast.hourly;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openweathermap.api.query.forecast.AbstractForecastQuery;

@EqualsAndHashCode(callSuper = true)
@Data
public class ByCityId extends AbstractForecastQuery implements HourlyForecastQuery {

    private final String cityId;

    public ByCityId(String cityId) {
        this.cityId = cityId;
    }

    @Override
    protected String getRequestPart() {
        return "id=" + cityId;
    }
}
