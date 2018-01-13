package org.openweathermap.api.query.currentweather;

import org.openweathermap.api.query.AbstractQueryWithResponseFormat;

public abstract class AbstractCurrentWeatherOneLocationQuery
        extends AbstractQueryWithResponseFormat
        implements CurrentWeatherOneLocationQuery {
    @Override
    protected String getSearchPath() {
        return CurrentWeatherOneLocationQuery.SEARCH_PATH;
    }
}
