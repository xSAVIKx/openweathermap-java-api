package org.openweathermap.api.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.openweathermap.api.gson.SecondsDateTypeAdapter;

import java.util.Date;
import java.util.List;

@Data
public class AbstractWeatherResponse {
    @JsonAdapter(SecondsDateTypeAdapter.class)
    @SerializedName("dt")
    private Date dateTime;
    private List<Weather> weather;
}
