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

    public CurrentWeatherPicker currentWeather() {
        return new CurrentWeatherPicker();
    }

    public ForecastInformationPicker forecastInformation() {
        return new ForecastInformationPicker();
    }


    private class CurrentWeatherPicker {
        public CurrentWeatherOneLocationQueryPicker oneLocation() {
            return new CurrentWeatherOneLocationQueryPicker();
        }

        public CurrentWeatherMultipleLocationsQueryPicker multipleLocations() {
            return new CurrentWeatherMultipleLocationsQueryPicker();
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

        private class CurrentWeatherMultipleLocationsQueryPicker {
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

    private class ForecastInformationPicker {
        public org.openweathermap.api.query.forecast.ByCityNameBuilder byCityName(String cityName) {
            return new org.openweathermap.api.query.forecast.ByCityNameBuilder(cityName);
        }

        public org.openweathermap.api.query.forecast.ByCityIdBuilder byCityId(String cityId) {
            return new org.openweathermap.api.query.forecast.ByCityIdBuilder(cityId);
        }

        public org.openweathermap.api.query.forecast.ByGeographicCoordinatesBuilder byGeographicCoordinates(Coordinate coordinate) {
            return new org.openweathermap.api.query.forecast.ByGeographicCoordinatesBuilder(coordinate);
        }
    }
}
