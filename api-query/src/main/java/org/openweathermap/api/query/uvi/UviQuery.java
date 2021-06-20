/*
 * Copyright 2021, Yurii Serhiichuk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

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
