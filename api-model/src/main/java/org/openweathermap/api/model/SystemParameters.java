package org.openweathermap.api.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.openweathermap.api.gson.SecondsDateTypeAdapter;

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
    @JsonAdapter(SecondsDateTypeAdapter.class)
    @SerializedName("sunrise")
    private Date sunrise;
    @JsonAdapter(SecondsDateTypeAdapter.class)
    @SerializedName("sunset")
    private Date sunset;
}
