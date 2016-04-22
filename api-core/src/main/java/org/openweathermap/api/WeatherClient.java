package org.openweathermap.api;

import org.openweathermap.api.model.currentweather.CurrentWeather;
import org.openweathermap.api.model.forecast.ForecastInformation;
import org.openweathermap.api.model.forecast.daily.DailyForecast;
import org.openweathermap.api.model.forecast.hourly.HourlyForecast;
import org.openweathermap.api.query.Query;
import org.openweathermap.api.query.currentweather.CurrentWeatherMultipleLocationsQuery;
import org.openweathermap.api.query.currentweather.CurrentWeatherOneLocationQuery;
import org.openweathermap.api.query.forecast.daily.DailyForecastQuery;
import org.openweathermap.api.query.forecast.hourly.HourlyForecastQuery;

import java.util.List;

public interface WeatherClient {
    String getWeatherData(Query query);

    CurrentWeather getCurrentWeather(CurrentWeatherOneLocationQuery query);

    List<CurrentWeather> getCurrentWeather(CurrentWeatherMultipleLocationsQuery query);

    ForecastInformation<HourlyForecast> getForecastInformation(HourlyForecastQuery query);

    ForecastInformation<DailyForecast> getForecastInformation(DailyForecastQuery query);
}
