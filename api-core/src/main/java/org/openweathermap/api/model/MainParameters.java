package org.openweathermap.api.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class MainParameters {
    @SerializedName("temp")
    private double temperature;
    @SerializedName("pressure")
    private double pressure;
    @SerializedName("humidity")
    private double humidity;
    @SerializedName("temp_min")
    private double minimumTemperature;
    @SerializedName("temp_max")
    private double maximumTemperature;
    @SerializedName("sea_level")
    private double seaLevelPressure;
    @SerializedName("grnd_level")
    private double groundLevelPressure;
}
