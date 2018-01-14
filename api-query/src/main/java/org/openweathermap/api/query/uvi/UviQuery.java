package org.openweathermap.api.query.uvi;

import org.openweathermap.api.common.Coordinate;
import org.openweathermap.api.query.Query;

public interface UviQuery extends Query {
    String SEARCH_PATH = "/uvi";

    final class Current {
        private Current() {
        }

        public static org.openweathermap.api.query.uvi.current.ByGeographicCoordinatesBuilder byGeographicCoordinates(Coordinate coordinate) {
            return new org.openweathermap.api.query.uvi.current.ByGeographicCoordinatesBuilder(coordinate);
        }
    }

    final class Forecast {
        private Forecast() {
        }

        public static org.openweathermap.api.query.uvi.forecast.ByGeographicCoordinatesBuilder byGeographicCoordinates(Coordinate coordinate) {
            return new org.openweathermap.api.query.uvi.forecast.ByGeographicCoordinatesBuilder(coordinate);
        }
    }

    final class History {
        private History() {
        }

        public static org.openweathermap.api.query.uvi.history.ByGeographicCoordinatesBuilder byGeographicCoordinates(Coordinate coordinate) {
            return new org.openweathermap.api.query.uvi.history.ByGeographicCoordinatesBuilder(coordinate);
        }
    }
}
