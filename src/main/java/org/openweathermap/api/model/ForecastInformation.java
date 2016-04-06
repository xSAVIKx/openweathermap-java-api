package org.openweathermap.api.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

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
