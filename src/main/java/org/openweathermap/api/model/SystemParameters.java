package org.openweathermap.api.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SystemParameters {
    @SerializedName("type")
    private String type;
    @SerializedName("id")
    private String id;
    @SerializedName("message")
    private String message;
    @SerializedName("country")
    private String country;
    @SerializedName("sunrise")
    private LocalDateTime sunrise;
    @SerializedName("sunset")
    private LocalDateTime sunset;
}
