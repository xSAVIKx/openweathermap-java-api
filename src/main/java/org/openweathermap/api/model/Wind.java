package org.openweathermap.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by iuriis on 22.03.2016.
 */
public class Wind {
    @SerializedName("speed")
    private double speed;
    @SerializedName("deg")
    private WindDirection direction;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public WindDirection getDirection() {
        return direction;
    }

    public void setDirection(WindDirection direction) {
        this.direction = direction;
    }
}
