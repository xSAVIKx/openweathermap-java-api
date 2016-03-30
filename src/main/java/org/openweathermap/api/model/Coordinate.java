package org.openweathermap.api.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Coordinate {
    /**
     * City geo location, longitude
     */
    @SerializedName("lon")
    private String longitude;

    /**
     * City geo location, latitude
     */
    @SerializedName("lat")
    private String latitude;

    public Coordinate() {
        //
    }

    public Coordinate(String longitude, String latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
