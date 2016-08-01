package org.openweathermap.api.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Weather {
    /**
     * Weather condition id
     */
    @SerializedName("id")
    private String id;
    /**
     * Group of weather parameters (Rain, Snow, Extreme etc.)
     */
    @SerializedName("main")
    private String main;
    /**
     * Weather condition within the group
     */
    @SerializedName("description")
    private String description;
    /**
     * Weather icon id
     */
    @SerializedName("icon")
    private String icon;
}
