package org.openweathermap.api.query;

import org.openweathermap.api.model.Coordinate;

/**
 * Created by iuriis on 31.03.2016.
 */
public class InCycle extends AbstractQuery implements CurrentWeatherManyLocationsQuery {
    private Coordinate centerPoint;
    private int expectedNumberOfCities;

    public InCycle(Coordinate centerPoint, int expectedNumberOfCities) {
        this.centerPoint = centerPoint;
        this.expectedNumberOfCities = expectedNumberOfCities;
    }

    @Override
    protected String getSearchPath() {
        return "/find";
    }

    @Override
    protected String getRequestPart() {
        return String.format("lat=%s&lon=%s&cnt=%d", centerPoint.getLatitude(), centerPoint.getLongitude(), expectedNumberOfCities);
    }
}
