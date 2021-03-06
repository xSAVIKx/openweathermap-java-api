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

package org.openweathermap.api.example;

import org.openweathermap.api.DataWeatherClient;
import org.openweathermap.api.UrlConnectionDataWeatherClient;
import org.openweathermap.api.common.Coordinate;
import org.openweathermap.api.model.uvi.Uvi;
import org.openweathermap.api.query.Language;
import org.openweathermap.api.query.UnitFormat;
import org.openweathermap.api.query.uvi.UviQuery;
import org.openweathermap.api.query.uvi.forecast.ByGeographicCoordinates;

import java.util.List;

public class UviForecastExample {
    private static final String API_KEY = System.getenv("OPENWEATHERMAP_API_KEY");

    public static void main(String[] args) {
        DataWeatherClient client = new UrlConnectionDataWeatherClient(API_KEY);
        Coordinate coordinate = new Coordinate("36.230383", "49.9935");
        ByGeographicCoordinates query = UviQuery.Forecast.byGeographicCoordinates(coordinate)
                .language(Language.RUSSIAN)
                .unitFormat(UnitFormat.IMPERIAL)
                .count(4)
                .build();
        List<Uvi> result = client.getUviForecast(query);
        System.out.println(result);
    }
}
