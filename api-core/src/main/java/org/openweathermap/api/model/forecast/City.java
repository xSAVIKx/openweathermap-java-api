package org.openweathermap.api.model.forecast;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.openweathermap.api.model.Coordinate;

@Data
public class City {
    private long id;
    private String name;
    @SerializedName("coord")
    private Coordinate coordinate;
    private String country;
}
