package org.openweathermap.api.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Wind {
    @SerializedName("speed")
    private double speed;
    @SerializedName("deg")
    private WindDirection direction;
}
