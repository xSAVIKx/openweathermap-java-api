package org.openweathermap.api.model;

import com.google.gson.annotations.SerializedName;

public class Clouds extends AbstractModel {
    /**
     * Cloudiness, %
     */
    @SerializedName("all")
    private double all;

    public double getAll() {
        return all;
    }

    public void setAll(double all) {
        this.all = all;
    }
}
