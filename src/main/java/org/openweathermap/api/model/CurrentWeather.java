package org.openweathermap.api.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CurrentWeather extends AbstractWeatherInformation {
    @SerializedName("coord")
    private Coordinate coordinate;
    private String base;
    @SerializedName("name")
    private String cityName;
    @SerializedName("id")
    private long cityId;
    private String cod;
    private String visibility;
    @SerializedName("sys")
    private SystemParameters systemParameters;
}
