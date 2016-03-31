package org.openweathermap.api.query.builder;

import org.openweathermap.api.query.CurrentWeatherManyLocationsQuery;

public abstract class CurrentWeatherManyLocationsQueryBuilder<T extends CurrentWeatherManyLocationsQueryBuilder<T, E>, E extends CurrentWeatherManyLocationsQuery> extends QueryBuilder<T, E> {
    protected abstract E getQuery();
}
