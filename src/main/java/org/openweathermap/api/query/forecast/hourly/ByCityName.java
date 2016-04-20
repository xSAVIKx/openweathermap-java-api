package org.openweathermap.api.query.forecast.hourly;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openweathermap.api.query.QueryRequestPartBuilder;
import org.openweathermap.api.query.Type;
import org.openweathermap.api.query.forecast.AbstractForecastQuery;

@EqualsAndHashCode(callSuper = true)
@Data
public class ByCityName extends AbstractForecastQuery implements HourlyForecastQuery {
    private final String cityName;
    private String countryCode;
    private Type type;

    public ByCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    protected String getRequestPart() {
        return QueryRequestPartBuilder.byCityName(getCityName(), getCountryCode(), getType());
    }
}
