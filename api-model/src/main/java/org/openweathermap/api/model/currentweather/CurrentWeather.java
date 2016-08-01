package org.openweathermap.api.model.currentweather;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openweathermap.api.common.Coordinate;
import org.openweathermap.api.model.AbstractWeatherInformation;
import org.openweathermap.api.model.SystemParameters;

import java.lang.reflect.Type;

@EqualsAndHashCode(callSuper = true)
@Data
public class CurrentWeather extends AbstractWeatherInformation {
    public static final Type TYPE = new TypeToken<CurrentWeather>() {
    }.getType();
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
