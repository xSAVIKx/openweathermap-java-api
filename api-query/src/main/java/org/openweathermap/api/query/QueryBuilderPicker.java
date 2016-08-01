package org.openweathermap.api.query;

import org.openweathermap.api.common.Coordinate;
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

    public ForecastPicker forecast() {
        return new ForecastPicker();
    }


    public static class CurrentWeatherPicker {
        public CurrentWeatherOneLocationQueryPicker oneLocation() {
            return new CurrentWeatherOneLocationQueryPicker();
        }

        public CurrentWeatherMultipleLocationsQueryPicker multipleLocations() {
            return new CurrentWeatherMultipleLocationsQueryPicker();
        }

        public static class CurrentWeatherOneLocationQueryPicker {
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

        public static class CurrentWeatherMultipleLocationsQueryPicker {
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

    public static class ForecastPicker {

        public HourlyForecastPicker hourly() {
            return new HourlyForecastPicker();
        }

        public DailyForecastPicker daily() {
            return new DailyForecastPicker();
        }

        public static class HourlyForecastPicker {
            public org.openweathermap.api.query.forecast.hourly.ByCityNameBuilder byCityName(String cityName) {
                return new org.openweathermap.api.query.forecast.hourly.ByCityNameBuilder(cityName);
            }

            public org.openweathermap.api.query.forecast.hourly.ByCityIdBuilder byCityId(String cityId) {
                return new org.openweathermap.api.query.forecast.hourly.ByCityIdBuilder(cityId);
            }

            public org.openweathermap.api.query.forecast.hourly.ByGeographicCoordinatesBuilder byGeographicCoordinates(Coordinate coordinate) {
                return new org.openweathermap.api.query.forecast.hourly.ByGeographicCoordinatesBuilder(coordinate);
            }
        }


        public static class DailyForecastPicker {
            public org.openweathermap.api.query.forecast.daily.ByCityNameBuilder byCityName(String cityName) {
                return new org.openweathermap.api.query.forecast.daily.ByCityNameBuilder(cityName);
            }

            public org.openweathermap.api.query.forecast.daily.ByCityIdBuilder byCityId(String cityId) {
                return new org.openweathermap.api.query.forecast.daily.ByCityIdBuilder(cityId);
            }

            public org.openweathermap.api.query.forecast.daily.ByGeographicCoordinatesBuilder byGeographicCoordinates(Coordinate coordinate) {
                return new org.openweathermap.api.query.forecast.daily.ByGeographicCoordinatesBuilder(coordinate);
            }
        }
    }
}
