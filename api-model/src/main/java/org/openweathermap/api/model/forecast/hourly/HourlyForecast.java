package org.openweathermap.api.model.forecast.hourly;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openweathermap.api.gson.ISOStringDateTypeAdapter;
import org.openweathermap.api.model.AbstractWeatherInformation;
import org.openweathermap.api.model.forecast.Forecast;
import org.openweathermap.api.model.forecast.ForecastInformation;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class HourlyForecast extends AbstractWeatherInformation implements Forecast {
    public static final Type TYPE = new TypeToken<ForecastInformation<HourlyForecast>>() {
    }.getType();
    public static final Type TYPE_LIST = TypeToken.getParameterized(List.class, TYPE).getType();

    @JsonAdapter(ISOStringDateTypeAdapter.class)
    @SerializedName("dt_txt")
    private Date calculationDate;
}
