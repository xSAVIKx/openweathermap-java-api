package org.openweathermap.api.model.forecast;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class ForecastInformation<T extends Forecast> {
    private String code;
    private String message;
    private City city;
    private int cnt;
    @SerializedName("list")
    private List<T> forecasts;
}
