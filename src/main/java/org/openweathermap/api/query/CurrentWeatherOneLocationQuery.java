package org.openweathermap.api.query;


public interface CurrentWeatherOneLocationQuery extends Query {
    String SEARCH_PATH = "/weather";

    ResponseFormat getResponseFormat();

    void setResponseFormat(ResponseFormat responseFormat);
}
