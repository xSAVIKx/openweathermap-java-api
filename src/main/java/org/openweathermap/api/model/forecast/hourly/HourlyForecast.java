package org.openweathermap.api.model.forecast.hourly;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openweathermap.api.gson.ISOStringDateTypeAdapter;
import org.openweathermap.api.model.AbstractWeatherInformation;
import org.openweathermap.api.model.forecast.Forecast;

import java.lang.reflect.Type;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class HourlyForecast extends AbstractWeatherInformation implements Forecast {
    public static final Type TYPE = new TypeToken<org.openweathermap.api.model.forecast.ForecastInformation<HourlyForecast>>() {
    }.getType();
    @JsonAdapter(ISOStringDateTypeAdapter.class)
    @SerializedName("dt_txt")
    private Date calculationDate;
}
