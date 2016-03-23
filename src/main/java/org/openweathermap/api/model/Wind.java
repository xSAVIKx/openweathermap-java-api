package org.openweathermap.api.model;

import com.google.gson.annotations.SerializedName;

public class Wind extends AbstractModel {
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
