package org.openweathermap.api;

import com.google.gson.*;
import org.openweathermap.api.model.*;
import org.openweathermap.api.query.ResponseFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public abstract class AbstractWeatherClient implements WeatherClient {
    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
            .registerTypeAdapter(WindDirection.class, new WindDirectionDeserializer())
            .registerTypeAdapter(WindDirection.class, new WindDirectionSerializer())
            .create();
    private final JsonParser jsonParser = new JsonParser();

    protected WeatherInfo toWeatherInfo(String data, ResponseFormat responseFormat) {
        if (responseFormat == null || responseFormat == ResponseFormat.JSON) {
            return fromJson(data);
        }
        return null;
    }

    protected List<WeatherInfo> toWeatherInfo(String data) {
        JsonObject jsonObject = jsonParser.parse(data).getAsJsonObject();
        JsonArray list = jsonObject.getAsJsonArray("list");
        List<WeatherInfo> weatherInfoList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            WeatherInfo weatherInfo = gson.fromJson(list.get(i), WeatherInfo.class);
            weatherInfoList.add(weatherInfo);
        }
        return weatherInfoList;
    }

    private WeatherInfo fromJson(String json) {
        return gson.fromJson(json, WeatherInfo.class);
    }
}
