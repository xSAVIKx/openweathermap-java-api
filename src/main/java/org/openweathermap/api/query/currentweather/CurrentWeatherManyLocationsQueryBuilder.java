package org.openweathermap.api.query.currentweather;

import org.openweathermap.api.query.QueryBuilder;

public abstract class CurrentWeatherManyLocationsQueryBuilder<T extends CurrentWeatherManyLocationsQueryBuilder<T, E>, E extends CurrentWeatherManyLocationsQuery> extends QueryBuilder<T, E> {
    protected abstract E getQuery();
}
