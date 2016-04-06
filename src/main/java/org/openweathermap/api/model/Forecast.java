package org.openweathermap.api.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openweathermap.api.gson.ISOStringDateTypeAdapter;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class Forecast extends AbstractWeatherInformation {
    @JsonAdapter(ISOStringDateTypeAdapter.class)
    @SerializedName("dt_txt")
    private Date calculationDate;
}
