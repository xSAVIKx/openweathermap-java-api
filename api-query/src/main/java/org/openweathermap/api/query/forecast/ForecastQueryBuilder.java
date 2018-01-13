package org.openweathermap.api.query.forecast;

import org.openweathermap.api.query.QueryBuilderWithResponseFormat;


public abstract class ForecastQueryBuilder<T extends ForecastQueryBuilder<T, E>, E extends ForecastQuery>
        extends QueryBuilderWithResponseFormat<T, E> {
    public T count(int count) {
        getQuery().setCount(count);
        return self();
    }
}
