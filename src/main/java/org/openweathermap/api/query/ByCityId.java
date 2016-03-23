package org.openweathermap.api.query;

public class ByCityId extends AbstractCurrentWeatherQuery {

    private final String cityId;

    public ByCityId(String cityId) {
        this.cityId = cityId;
    }

    @Override
    protected String getRequestPart() {
        return "id=" + cityId;
    }

    public String getCityId() {
        return cityId;
    }
}
