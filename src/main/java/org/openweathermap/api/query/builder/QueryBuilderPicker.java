package org.openweathermap.api.query.builder;

import org.openweathermap.api.model.Coordinate;

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

    public CurrentWeatherQueryPicker currentWeatherQuery() {
        return new CurrentWeatherQueryPicker();
    }

    private class CurrentWeatherQueryPicker {
        public ByCityIdBuilder byCityId(String cityId) {
            return new ByCityIdBuilder(cityId);
        }

        public ByGeographicCoordinatesBuilder byGeographicCoordinates(Coordinate coordinate) {
            return new ByGeographicCoordinatesBuilder(coordinate);
        }
    }
}
