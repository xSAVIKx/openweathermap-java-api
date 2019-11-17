package org.openweathermap.api.model.forecast;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.openweathermap.api.common.Coordinate;
import org.openweathermap.api.gson.SecondsDateTypeAdapter;

import java.util.Date;

@Data
public class City {
    private long id;
    private String name;
    @SerializedName("coord")
    private Coordinate coordinate;
    private String country;
    private int population;
    /**
     * Seconds shift from UTC.
     */
    private long timezone;
    @JsonAdapter(SecondsDateTypeAdapter.class)
    @SerializedName("sunrise")
    private Date sunrise;
    @JsonAdapter(SecondsDateTypeAdapter.class)
    @SerializedName("sunset")
    private Date sunset;
}
