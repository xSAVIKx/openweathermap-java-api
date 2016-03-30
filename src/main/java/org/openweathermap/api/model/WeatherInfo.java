package org.openweathermap.api.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class WeatherInfo {
    @SerializedName("coord")
    private Coordinate coordinate;
    private List<Weather> weather;
    private String base;
    @SerializedName("name")
    private String cityName;
    @SerializedName("id")
    private String cityId;
    private String cod;
    private String visibility;
    @SerializedName("wind")
    private Wind wind;
    @SerializedName("clouds")
    private Clouds clouds;
    @SerializedName("rain")
    private Rain rain;
    @SerializedName("snow")
    private Snow snow;
    @SerializedName("dt")
    private LocalDateTime dateTime;
    @SerializedName("sys")
    private SystemParameters systemParameters;
    @SerializedName("main")
    private MainParameters mainParameters;
}
