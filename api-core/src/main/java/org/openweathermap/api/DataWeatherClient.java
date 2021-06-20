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

package org.openweathermap.api;

import org.openweathermap.api.model.currentweather.CurrentWeather;
import org.openweathermap.api.model.forecast.ForecastInformation;
import org.openweathermap.api.model.forecast.daily.DailyForecast;
import org.openweathermap.api.model.forecast.hourly.HourlyForecast;
import org.openweathermap.api.model.uvi.Uvi;
import org.openweathermap.api.query.currentweather.CurrentWeatherMultipleLocationsQuery;
import org.openweathermap.api.query.currentweather.CurrentWeatherOneLocationQuery;
import org.openweathermap.api.query.forecast.daily.DailyForecastQuery;
import org.openweathermap.api.query.forecast.hourly.HourlyForecastQuery;
import org.openweathermap.api.query.uvi.current.CurrentUviQuery;
import org.openweathermap.api.query.uvi.forecast.ForecastUviQuery;
import org.openweathermap.api.query.uvi.history.HistoryUviQuery;

import java.util.List;

public interface DataWeatherClient extends WeatherClient {

    CurrentWeather getCurrentWeather(CurrentWeatherOneLocationQuery query);

    List<CurrentWeather> getCurrentWeather(CurrentWeatherMultipleLocationsQuery query);

    ForecastInformation<HourlyForecast> getForecastInformation(HourlyForecastQuery query);

    ForecastInformation<DailyForecast> getForecastInformation(DailyForecastQuery query);

    Uvi getCurrentUvi(CurrentUviQuery query);

    List<Uvi> getUviForecast(ForecastUviQuery query);

    List<Uvi> getUviHistory(HistoryUviQuery query);
}
