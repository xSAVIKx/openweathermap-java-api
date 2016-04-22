package org.openweathermap.api.query.forecast.daily;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ByCityId extends AbstractDailyForecastQuery implements DailyForecastQuery {

    private final String cityId;

    public ByCityId(String cityId) {
        this.cityId = cityId;
    }

    @Override
    protected String getRequestPart() {
        return "id=" + cityId;
    }
}
