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
