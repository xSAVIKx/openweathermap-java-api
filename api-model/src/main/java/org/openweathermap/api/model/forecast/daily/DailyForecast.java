package org.openweathermap.api.model.forecast.daily;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openweathermap.api.model.AbstractWeatherResponse;
import org.openweathermap.api.model.WindDirection;
import org.openweathermap.api.model.forecast.Forecast;
import org.openweathermap.api.model.forecast.ForecastInformation;

import java.lang.reflect.Type;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class DailyForecast extends AbstractWeatherResponse implements Forecast {
    public static final Type TYPE = new TypeToken<ForecastInformation<DailyForecast>>() {
    }.getType();
    public static final Type TYPE_LIST = TypeToken.getParameterized(List.class, TYPE).getType();

    @SerializedName("temp")
    private Temperature temperature;
    private double humidity;
    private double speed;
    private double clouds;
    private double rain;
    @SerializedName("deg")
    private WindDirection direction;
}
