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
import org.openweathermap.api.model.forecast.ForecastInformation;
import org.openweathermap.api.model.forecast.daily.DailyForecast;
import org.openweathermap.api.query.Language;
import org.openweathermap.api.query.QueryBuilderPicker;
import org.openweathermap.api.query.UnitFormat;
import org.openweathermap.api.query.forecast.daily.ByCityName;

public class DailyForecastExample {
    private static final String API_KEY = System.getenv("OPENWEATHERMAP_API_KEY");

    public static void main(String[] args) {
        DataWeatherClient client = new UrlConnectionDataWeatherClient(API_KEY);
        ByCityName byCityNameForecast = QueryBuilderPicker.pick()
                .forecast()                                         // get forecast
                .daily()                                            // it should be dailt
                .byCityName("Kharkiv")                              // for Kharkiv city
                .countryCode("UA")                                  // in Ukraine
                .unitFormat(UnitFormat.METRIC)                      // in Metric units
                .language(Language.ENGLISH)                         // in English
                .build();
        ForecastInformation<DailyForecast> forecastInformation = client.getForecastInformation(byCityNameForecast);
        System.out.println(forecastInformation.getCity());
        for (DailyForecast forecast : forecastInformation.getForecasts()) {
            System.out.println(String.format("Temperature on %s will be: %s",
                    forecast.getDateTime().toString(), forecast.getTemperature().toString()));
        }
    }
}
