package org.openweathermap.api.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class City {
    private long id;
    private String name;
    @SerializedName("coord")
    private Coordinate coordinate;
    private String country;
}
