package org.openweathermap.api.query.currentweather;


import org.openweathermap.api.query.QueryWithResponseFormat;

public interface CurrentWeatherOneLocationQuery extends QueryWithResponseFormat {
    String SEARCH_PATH = "/weather";
}
