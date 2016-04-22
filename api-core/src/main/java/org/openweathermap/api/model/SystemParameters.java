package org.openweathermap.api.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.openweathermap.api.gson.MillisecondsDateTypeAdapter;

import java.util.Date;

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
    @JsonAdapter(MillisecondsDateTypeAdapter.class)
    @SerializedName("sunrise")
    private Date sunrise;
    @JsonAdapter(MillisecondsDateTypeAdapter.class)
    @SerializedName("sunset")
    private Date sunset;
}
