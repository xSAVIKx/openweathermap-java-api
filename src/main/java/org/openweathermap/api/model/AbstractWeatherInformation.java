package org.openweathermap.api.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.openweathermap.api.gson.MillisecondsDateTypeAdapter;

import java.util.Date;
import java.util.List;

@Data
public class AbstractWeatherInformation {
    @JsonAdapter(MillisecondsDateTypeAdapter.class)
    @SerializedName("dt")
    private Date dateTime;
    @SerializedName("main")
    private MainParameters mainParameters;
    private Wind wind;
    private Clouds clouds;
    private Rain rain;
    private Snow snow;
    private List<Weather> weather;
}
