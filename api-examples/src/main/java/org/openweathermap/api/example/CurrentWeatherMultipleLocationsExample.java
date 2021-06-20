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
import org.openweathermap.api.model.currentweather.CurrentWeather;
import org.openweathermap.api.query.Language;
import org.openweathermap.api.query.QueryBuilderPicker;
import org.openweathermap.api.query.UnitFormat;
import org.openweathermap.api.query.currentweather.InCycle;

import java.util.List;

public class CurrentWeatherMultipleLocationsExample {
    private static final String API_KEY = "API_KEY_VALUE";

    public static void main(String[] args) {
        DataWeatherClient client = new UrlConnectionDataWeatherClient(API_KEY);

        InCycle inCycle = QueryBuilderPicker.pick()
                .currentWeather()                                       // get current weather
                .multipleLocations()                                    // for multiple locations
                .inCycle(new Coordinate("36.230383", "49.9935"), 5)    // get weather for 10 closest to coordinate cities
                .language(Language.ENGLISH)                             // in English language
                .unitFormat(UnitFormat.METRIC)                          // in metric units
                .build();
        List<CurrentWeather> currentWeatherList = client.getCurrentWeather(inCycle);
        for (CurrentWeather currentWeather : currentWeatherList) {
            System.out.println(prettyPrint(currentWeather));
        }
    }


    private static String prettyPrint(CurrentWeather currentWeather) {
        return String.format(
                "Current weather in %s(%s):\ntemperature: %.1f ℃\nhumidity: %.1f %%\npressure: %.1f hPa\n",
                currentWeather.getCityName(), currentWeather.getSystemParameters().getCountry(),
                currentWeather.getMainParameters().getTemperature(),
                currentWeather.getMainParameters().getHumidity(),
                currentWeather.getMainParameters().getPressure()
        );
    }
}
