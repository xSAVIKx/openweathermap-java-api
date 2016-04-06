package org.openweathermap.api.query;

import org.openweathermap.api.model.Coordinate;
import org.openweathermap.api.query.currentweather.*;

import java.util.Collection;

public class QueryBuilderPicker {
    private static QueryBuilderPicker instance;

    private QueryBuilderPicker() {
        //
    }

    public static QueryBuilderPicker pick() {
        if (instance == null) {
            instance = new QueryBuilderPicker();
        }
        return instance;
    }

    public CurrentWeatherOneLocationQueryPicker currentWeatherOneLocationQuery() {
        return new CurrentWeatherOneLocationQueryPicker();
    }

    public CurrentWeatherManyLocationsQueryPicker currentWeatherManyLocationsQueryPicker() {
        return new CurrentWeatherManyLocationsQueryPicker();
    }

    private class CurrentWeatherOneLocationQueryPicker {
        public ByCityIdBuilder byCityId(String cityId) {
            return new ByCityIdBuilder(cityId);
        }

        public ByGeographicCoordinatesBuilder byGeographicCoordinates(Coordinate coordinate) {
            return new ByGeographicCoordinatesBuilder(coordinate);
        }

        public ByCityNameBuilder byCityName(String cityName) {
            return new ByCityNameBuilder(cityName);
        }

        public ByZipCodeBuilder byZipCode(String zipCode, String countryCode) {
            return new ByZipCodeBuilder(zipCode, countryCode);
        }
    }

    private class CurrentWeatherManyLocationsQueryPicker {
        public ByRectangleZoneBuilder byRectangleZone(Coordinate leftBottom, Coordinate rightTop) {
            return new ByRectangleZoneBuilder(leftBottom, rightTop);
        }

        public InCycleBuilder inCycle(Coordinate centerPoint, int expectedNumberOfCities) {
            return new InCycleBuilder(centerPoint, expectedNumberOfCities);
        }

        public ByCityIdsBuilder byCityIds(Collection<String> cityIds) {
            return new ByCityIdsBuilder(cityIds);
        }

        public ByCityIdsBuilder byCityIds() {
            return new ByCityIdsBuilder();
        }
    }
}
