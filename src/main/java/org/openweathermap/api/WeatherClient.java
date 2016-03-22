package org.openweathermap.api;

import org.openweathermap.api.model.WeatherInfo;
import org.openweathermap.api.query.Query;

/**
 * Created by iuriis on 22.03.2016.
 */
public interface WeatherClient {
    String getWeatherData(Query query);

    WeatherInfo getWeatherInfo(Query query);
}
