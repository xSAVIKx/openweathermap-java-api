package org.openweathermap.api.model.forecast.daily;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Temperature {
    private double day;
    private double min;
    private double max;
    private double night;
    @SerializedName("eve")
    private double evening;
    @SerializedName("morn")
    private double morning;
}
