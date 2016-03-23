package org.openweathermap.api;

import org.openweathermap.api.model.WeatherInfo;
import org.openweathermap.api.query.Query;

public interface WeatherClient {
    String getWeatherData(Query query);

    WeatherInfo getWeatherInfo(Query query);
}
