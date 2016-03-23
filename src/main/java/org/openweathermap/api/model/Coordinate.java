package org.openweathermap.api.model;

import com.google.gson.annotations.SerializedName;

public class Coordinate extends AbstractModel {
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
