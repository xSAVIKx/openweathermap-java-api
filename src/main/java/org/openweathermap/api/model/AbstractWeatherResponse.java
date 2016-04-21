package org.openweathermap.api.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.openweathermap.api.gson.MillisecondsDateTypeAdapter;

import java.util.Date;
import java.util.List;

@Data
public class AbstractWeatherResponse {
    @JsonAdapter(MillisecondsDateTypeAdapter.class)
    @SerializedName("dt")
    private Date dateTime;
    private List<Weather> weather;
}
