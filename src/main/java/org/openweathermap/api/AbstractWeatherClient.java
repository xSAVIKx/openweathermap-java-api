package org.openweathermap.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.openweathermap.api.model.*;
import org.openweathermap.api.query.ResponseFormat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

/**
 * Created by iuriis on 22.03.2016.
 */
public abstract class AbstractWeatherClient implements WeatherClient {
    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
            .registerTypeAdapter(WindDirection.class, new WindDirectionDeserializer())
            .registerTypeAdapter(WindDirection.class, new WindDirectionSerializer())
            .create();

    protected WeatherInfo toWeatherInfo(String data, ResponseFormat responseFormat) {
        if (responseFormat == null || responseFormat == ResponseFormat.JSON) {
            return fromJson(data);
        }
        return null;
    }

    private WeatherInfo fromJson(String json) {
        WeatherInfo weatherInfo = gson.fromJson(json, WeatherInfo.class);
        return weatherInfo;
    }
}
