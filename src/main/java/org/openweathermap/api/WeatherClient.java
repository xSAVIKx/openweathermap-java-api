package org.openweathermap.api;

import org.openweathermap.api.model.WeatherInfo;
import org.openweathermap.api.query.CurrentWeatherManyLocationsQuery;
import org.openweathermap.api.query.CurrentWeatherOneLocationQuery;
import org.openweathermap.api.query.Query;

import java.util.List;

public interface WeatherClient {
    String getWeatherData(Query query);

    WeatherInfo getWeatherInfo(CurrentWeatherOneLocationQuery query);

    List<WeatherInfo> getWeatherInfo(CurrentWeatherManyLocationsQuery query);
}
