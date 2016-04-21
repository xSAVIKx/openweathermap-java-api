package org.openweathermap.api.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AbstractWeatherInformation extends AbstractWeatherResponse {
    @SerializedName("main")
    private MainParameters mainParameters;
    private Wind wind;
    private Clouds clouds;
    private Rain rain;
    private Snow snow;
}
