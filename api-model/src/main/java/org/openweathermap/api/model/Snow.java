package org.openweathermap.api.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Snow {
    /**
     * Snow volume for the last 3 hours
     */
    @SerializedName("3h")
    private double threeHours;
}
