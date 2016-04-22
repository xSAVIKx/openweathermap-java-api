package org.openweathermap.api.model.currentweather;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openweathermap.api.model.AbstractWeatherInformation;
import org.openweathermap.api.model.Coordinate;
import org.openweathermap.api.model.SystemParameters;

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
