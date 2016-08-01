package org.openweathermap.api.common;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
