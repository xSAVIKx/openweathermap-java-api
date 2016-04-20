package org.openweathermap.api.query.forecast.hourly;

import org.openweathermap.api.query.forecast.ForecastQueryBuilder;

public abstract class HourlyForecastQueryBuilder<T extends HourlyForecastQueryBuilder<T, E>, E extends HourlyForecastQuery> extends ForecastQueryBuilder<T, E> {
}
