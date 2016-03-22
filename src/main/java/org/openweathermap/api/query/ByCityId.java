package org.openweathermap.api.query;

/**
 * Created by iuriis on 22.03.2016.
 */
public class ByCityId extends AbstractCurrentWeatherQuery {

    private final String cityId;

    public ByCityId(String cityId) {
        this.cityId = cityId;
    }

    @Override
    protected String getRequestPart() {
        return "id=" + cityId;
    }
}
