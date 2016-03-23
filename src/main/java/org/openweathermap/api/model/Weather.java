package org.openweathermap.api.model;

import com.google.gson.annotations.SerializedName;

public class Weather extends AbstractModel {
    /**
     * Weather condition id
     */
    @SerializedName("id")
    private String id;
    /**
     * Group of weather parameters (Rain, Snow, Extreme etc.)
     */
    @SerializedName("main")
    private String main;
    /**
     * Weather condition within the group
     */
    @SerializedName("description")
    private String description;
    /**
     * Weather icon id
     */
    @SerializedName("icon")
    private String icon;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
