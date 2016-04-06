package org.openweathermap.api.query.forecast;

import org.openweathermap.api.query.QueryBuilder;


public abstract class ForecastQueryBuilder<T extends ForecastQueryBuilder<T, E>, E extends ForecastQuery> extends QueryBuilder<T, E> {
    protected abstract E getQuery();
}
