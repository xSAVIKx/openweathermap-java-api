package org.openweathermap.api.query.forecast;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ByCityId extends AbstractForecastQuery {

    private final String cityId;

    public ByCityId(String cityId) {
        this.cityId = cityId;
    }

    @Override
    protected String getRequestPart() {
        return "id=" + cityId;
    }
}
