package org.openweathermap.api;

import org.openweathermap.api.model.WeatherInfo;
import org.openweathermap.api.query.Query;
import org.openweathermap.api.query.currentweather.CurrentWeatherManyLocationsQuery;
import org.openweathermap.api.query.currentweather.CurrentWeatherOneLocationQuery;

import java.util.List;

public interface WeatherClient {
    String getWeatherData(Query query);

    WeatherInfo getWeatherInfo(CurrentWeatherOneLocationQuery query);

    List<WeatherInfo> getWeatherInfo(CurrentWeatherManyLocationsQuery query);
}
