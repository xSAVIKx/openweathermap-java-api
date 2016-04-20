package org.openweathermap.api.model.forecast.hourly;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.openweathermap.api.model.forecast.City;

import java.util.List;

@Data
public class ForecastInformation {
    private String code;
    private String message;
    private City city;
    private int cnt;
    @SerializedName("list")
    private List<Forecast> forecasts;
}
