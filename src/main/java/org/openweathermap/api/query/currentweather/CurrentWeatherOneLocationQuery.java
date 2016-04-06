package org.openweathermap.api.query.currentweather;


import org.openweathermap.api.query.Query;
import org.openweathermap.api.query.ResponseFormat;

public interface CurrentWeatherOneLocationQuery extends Query {
    String SEARCH_PATH = "/weather";

    ResponseFormat getResponseFormat();

    void setResponseFormat(ResponseFormat responseFormat);
}
