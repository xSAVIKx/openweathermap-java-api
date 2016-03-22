package org.openweathermap.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by iuriis on 22.03.2016.
 */
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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
