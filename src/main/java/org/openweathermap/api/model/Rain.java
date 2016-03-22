package org.openweathermap.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by iuriis on 22.03.2016.
 */
public class Rain {
    /**
     * Rain volume for the last 3 hours
     */
    @SerializedName("3h")
    private int threeHours;

    public int getThreeHours() {
        return threeHours;
    }

    public void setThreeHours(int threeHours) {
        this.threeHours = threeHours;
    }
}
