package org.openweathermap.api.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ByCityName extends AbstractCurrentWeatherQuery {
    private final String cityName;
    private String countryCode;

    public ByCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    protected String getRequestPart() {
        if (countryCode != null) {
            return "q=" + cityName + "," + countryCode;
        }
        return "q=" + cityName;
    }
}
