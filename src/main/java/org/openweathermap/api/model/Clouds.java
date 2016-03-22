package org.openweathermap.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by iuriis on 22.03.2016.
 */
public class Clouds {
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
