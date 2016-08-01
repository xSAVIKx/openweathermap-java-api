package org.openweathermap.api.query.forecast.daily;

import org.openweathermap.api.query.forecast.AbstractForecastQuery;

public abstract class AbstractDailyForecastQuery extends AbstractForecastQuery {
    @Override
    protected String getSearchPath() {
        return super.getSearchPath() + DailyForecastQuery.SEARCH_PATH;
    }
}
