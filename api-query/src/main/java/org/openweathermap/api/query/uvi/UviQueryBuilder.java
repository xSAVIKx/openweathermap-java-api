package org.openweathermap.api.query.uvi;

import org.openweathermap.api.query.QueryBuilder;

public abstract class UviQueryBuilder<T extends UviQueryBuilder<T, E>, E extends UviQuery>
        extends QueryBuilder<T, E> {
}
