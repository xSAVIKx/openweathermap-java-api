package org.openweathermap.api.query.forecast.daily;


import org.openweathermap.api.query.forecast.ForecastQuery;

public interface DailyForecastQuery extends ForecastQuery {
    String SEARCH_PATH = "/daily";
}
