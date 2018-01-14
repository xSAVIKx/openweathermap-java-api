package org.openweathermap.api.model.uvi;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import org.openweathermap.api.gson.SecondsDateTypeAdapter;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

@Data
public class Uvi {
    public static final Type TYPE = TypeToken.get(Uvi.class).getType();
    public static final Type TYPE_LIST = TypeToken.getParameterized(List.class, TYPE).getType();
    @SerializedName("lon")
    private String longitude;

    @SerializedName("lat")
    private String latitude;

    @JsonAdapter(SecondsDateTypeAdapter.class)
    @SerializedName("date")
    private Date date;

    @SerializedName("date_iso")
    private String isoDate;

    @SerializedName("value")
    private double ultravioletIndex;
}
