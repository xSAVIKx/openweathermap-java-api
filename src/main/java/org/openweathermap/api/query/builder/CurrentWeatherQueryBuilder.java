package org.openweathermap.api.query.builder;

import org.openweathermap.api.query.CurrentWeatherQuery;

public abstract class CurrentWeatherQueryBuilder<T extends CurrentWeatherQueryBuilder<T, E>, E extends CurrentWeatherQuery> extends QueryBuilder<T, E> {
    protected abstract E getQuery();
}
