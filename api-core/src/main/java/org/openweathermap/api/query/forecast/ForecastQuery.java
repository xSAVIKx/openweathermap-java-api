package org.openweathermap.api.query.forecast;

import org.openweathermap.api.query.QueryWithResponseFormat;

public interface ForecastQuery extends QueryWithResponseFormat {
    String SEARCH_PATH = "/forecast";

    int getCount();

    void setCount(int count);
}
