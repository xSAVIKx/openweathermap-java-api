package org.openweathermap.api.query.forecast.daily;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openweathermap.api.query.QueryRequestPartBuilder;
import org.openweathermap.api.query.Type;

@EqualsAndHashCode(callSuper = true)
@Data
public class ByCityName extends AbstractDailyForecastQuery implements DailyForecastQuery {
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
