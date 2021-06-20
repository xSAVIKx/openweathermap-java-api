/*
 * Copyright 2021, Yurii Serhiichuk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

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
