package org.openweathermap.api.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Clouds {
    /**
     * Cloudiness, %
     */
    @SerializedName("all")
    private double all;
}
