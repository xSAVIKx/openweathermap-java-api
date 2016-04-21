package org.openweathermap.api.query.forecast.daily;

import org.openweathermap.api.query.forecast.ForecastQueryBuilder;

public abstract class DailyForecastQueryBuilder<T extends DailyForecastQueryBuilder<T, E>, E extends DailyForecastQuery> extends ForecastQueryBuilder<T, E> {
}
