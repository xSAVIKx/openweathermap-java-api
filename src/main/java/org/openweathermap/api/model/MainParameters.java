package org.openweathermap.api.model;

import com.google.gson.annotations.SerializedName;

public class MainParameters extends AbstractModel {
    @SerializedName("temp")
    private double temperature;
    @SerializedName("pressure")
    private double pressure;
    @SerializedName("humidity")
    private double humidity;
    @SerializedName("temp_min")
    private double minimumTemperature;
    @SerializedName("temp_max")
    private double maximumTemperature;
    @SerializedName("sea_level")
    private double seaLevelPressure;
    @SerializedName("grnd_level")
    private double groundLevelPressure;

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getMinimumTemperature() {
        return minimumTemperature;
    }

    public void setMinimumTemperature(double minimumTemperature) {
        this.minimumTemperature = minimumTemperature;
    }

    public double getMaximumTemperature() {
        return maximumTemperature;
    }

    public void setMaximumTemperature(double maximumTemperature) {
        this.maximumTemperature = maximumTemperature;
    }

    public double getSeaLevelPressure() {
        return seaLevelPressure;
    }

    public void setSeaLevelPressure(double seaLevelPressure) {
        this.seaLevelPressure = seaLevelPressure;
    }

    public double getGroundLevelPressure() {
        return groundLevelPressure;
    }

    public void setGroundLevelPressure(double groundLevelPressure) {
        this.groundLevelPressure = groundLevelPressure;
    }
}
