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

package org.openweathermap.api.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.openweathermap.api.gson.SecondsDateTypeAdapter;

import java.util.Date;

@Data
public class SystemParameters {
    @SerializedName("type")
    private String type;
    @SerializedName("id")
    private String id;
    @SerializedName("message")
    private String message;
    @SerializedName("country")
    private String country;
    @JsonAdapter(SecondsDateTypeAdapter.class)
    @SerializedName("sunrise")
    private Date sunrise;
    @JsonAdapter(SecondsDateTypeAdapter.class)
    @SerializedName("sunset")
    private Date sunset;
}
