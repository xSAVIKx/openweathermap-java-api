package org.openweathermap.api;

import com.google.gson.*;
import org.openweathermap.api.gson.WindDirectionDeserializer;
import org.openweathermap.api.gson.WindDirectionSerializer;
import org.openweathermap.api.model.WindDirection;
import org.openweathermap.api.model.currentweather.CurrentWeather;
import org.openweathermap.api.model.forecast.Forecast;
import org.openweathermap.api.model.forecast.ForecastInformation;
import org.openweathermap.api.model.forecast.daily.DailyForecast;
import org.openweathermap.api.model.forecast.hourly.HourlyForecast;
import org.openweathermap.api.query.Query;
import org.openweathermap.api.query.ResponseFormat;
import org.openweathermap.api.query.currentweather.CurrentWeatherMultipleLocationsQuery;
import org.openweathermap.api.query.currentweather.CurrentWeatherOneLocationQuery;
import org.openweathermap.api.query.forecast.ForecastQuery;
import org.openweathermap.api.query.forecast.daily.DailyForecastQuery;
import org.openweathermap.api.query.forecast.hourly.HourlyForecastQuery;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public abstract class AbstractWeatherClient implements WeatherClient {
    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(WindDirection.class, new WindDirectionDeserializer())
            .registerTypeAdapter(WindDirection.class, new WindDirectionSerializer())
            .create();
    private final JsonParser jsonParser = new JsonParser();

    @Override
    public ForecastInformation<HourlyForecast> getForecastInformation(HourlyForecastQuery query) {
        return toForecastInformation(query, HourlyForecast.TYPE);
    }

    @Override
    public ForecastInformation<DailyForecast> getForecastInformation(DailyForecastQuery query) {
        return toForecastInformation(query, DailyForecast.TYPE);
    }

    @Override
    public String getWeatherData(Query query) {
        return makeRequest(query);
    }


    @Override
    public CurrentWeather getCurrentWeather(CurrentWeatherOneLocationQuery query) {
        return toCurrentWeather(query);
    }

    @Override
    public List<CurrentWeather> getCurrentWeather(CurrentWeatherMultipleLocationsQuery query) {
        return toCurrentWeather(query);
    }

    protected abstract String makeRequest(Query query);

    private CurrentWeather toCurrentWeather(CurrentWeatherOneLocationQuery query) {
        String data = getWeatherData(query);
        ResponseFormat responseFormat = query.getResponseFormat();
        if (responseFormat == null || responseFormat == ResponseFormat.JSON) {
            return gson.fromJson(data, CurrentWeather.class);
        }
        return null;
    }

    private List<CurrentWeather> toCurrentWeather(CurrentWeatherMultipleLocationsQuery query) {
        String data = getWeatherData(query);
        JsonObject jsonObject = jsonParser.parse(data).getAsJsonObject();
        JsonArray list = jsonObject.getAsJsonArray("list");
        List<CurrentWeather> weatherInfoList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            CurrentWeather weatherInfo = gson.fromJson(list.get(i), CurrentWeather.class);
            weatherInfoList.add(weatherInfo);
        }
        return weatherInfoList;
    }

    private <T extends Forecast> ForecastInformation<T> toForecastInformation(ForecastQuery query, Type type) {
        String data = getWeatherData(query);
        ResponseFormat responseFormat = query.getResponseFormat();
        if (responseFormat == null || responseFormat == ResponseFormat.JSON) {
            return gson.fromJson(data, type);
        }
        return null;
    }
}
