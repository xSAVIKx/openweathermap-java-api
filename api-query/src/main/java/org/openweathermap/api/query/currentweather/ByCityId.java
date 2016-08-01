package org.openweathermap.api.query.currentweather;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ByCityId extends AbstractCurrentWeatherOneLocationQuery {

    private final String cityId;

    public ByCityId(String cityId) {
        this.cityId = cityId;
    }

    @Override
    protected String getRequestPart() {
        return "id=" + cityId;
    }
}
