package org.openweathermap.api;

import com.google.gson.*;
import org.openweathermap.api.gson.WindDirectionDeserializer;
import org.openweathermap.api.gson.WindDirectionSerializer;
import org.openweathermap.api.model.WindDirection;
import org.openweathermap.api.model.currentweather.CurrentWeather;
import org.openweathermap.api.model.forecast.ForecastInformation;
import org.openweathermap.api.model.forecast.daily.DailyForecast;
import org.openweathermap.api.model.forecast.hourly.HourlyForecast;
import org.openweathermap.api.model.uvi.Uvi;
import org.openweathermap.api.query.Query;
import org.openweathermap.api.query.QueryWithResponseFormat;
import org.openweathermap.api.query.ResponseFormat;
import org.openweathermap.api.query.currentweather.CurrentWeatherMultipleLocationsQuery;
import org.openweathermap.api.query.currentweather.CurrentWeatherOneLocationQuery;
import org.openweathermap.api.query.forecast.daily.DailyForecastQuery;
import org.openweathermap.api.query.forecast.hourly.HourlyForecastQuery;
import org.openweathermap.api.query.uvi.current.CurrentUviQuery;
import org.openweathermap.api.query.uvi.forecast.ForecastUviQuery;
import org.openweathermap.api.query.uvi.history.HistoryUviQuery;

import java.lang.reflect.Type;
import java.util.List;


public abstract class AbstractDataWeatherClient implements DataWeatherClient {

    @Override
    public ForecastInformation<HourlyForecast> getForecastInformation(HourlyForecastQuery query) {
        ForecastInformation<HourlyForecast> result = getResult(query, HourlyForecast.TYPE);
        return result;
    }

    @Override
    public ForecastInformation<DailyForecast> getForecastInformation(DailyForecastQuery query) {
        ForecastInformation<DailyForecast> result = getResult(query, DailyForecast.TYPE);
        return result;
    }

    @Override
    public String getWeatherData(Query query) {
        return makeRequest(query);
    }


    @Override
    public CurrentWeather getCurrentWeather(CurrentWeatherOneLocationQuery query) {
        CurrentWeather result = getResult(query, CurrentWeather.TYPE);
        return result;
    }

    @Override
    public List<CurrentWeather> getCurrentWeather(CurrentWeatherMultipleLocationsQuery query) {
        String data = getWeatherData(query);
        JsonObject jsonObject = jsonParser().parse(data).getAsJsonObject();
        JsonArray list = jsonObject.getAsJsonArray("list");
        List<CurrentWeather> result = gson().fromJson(list, CurrentWeather.TYPE_LIST);
        return result;
    }

    @Override
    public Uvi getCurrentUvi(CurrentUviQuery query) {
        Uvi result = getResult(query, Uvi.TYPE);
        return result;
    }

    @Override
    public List<Uvi> getUviForecast(ForecastUviQuery query) {
        List<Uvi> result = getResult(query, Uvi.TYPE_LIST);
        return result;
    }

    @Override
    public List<Uvi> getUviHistory(HistoryUviQuery query) {
        List<Uvi> result = getResult(query, Uvi.TYPE_LIST);
        return result;
    }

    protected abstract String makeRequest(Query query);

    private <T> T getResult(QueryWithResponseFormat query, Type type) {
        ResponseFormat responseFormat = query.getResponseFormat();
        if (responseFormat == null || responseFormat == ResponseFormat.JSON) {
            return getResult((Query) query, type);
        }
        return null;
    }

    private <T> T getResult(Query query, Type type) {
        String data = getWeatherData(query);
        final T result = gson().fromJson(data, type);
        return result;
    }

    protected static Gson gson() {
        return GsonHolder.INSTANCE.value;
    }

    protected static JsonParser jsonParser() {
        return JsonParserHolder.INSTANCE.value;
    }

    private enum JsonParserHolder {
        INSTANCE;

        @SuppressWarnings({"NonSerializableFieldInSerializableClass", "ImmutableEnumChecker"})
        private final JsonParser value = new JsonParser();

    }

    private enum GsonHolder {
        INSTANCE;
        @SuppressWarnings({"NonSerializableFieldInSerializableClass", "ImmutableEnumChecker"})
        private final Gson value = new GsonBuilder()
                .registerTypeAdapter(WindDirection.class, new WindDirectionDeserializer())
                .registerTypeAdapter(WindDirection.class, new WindDirectionSerializer())
                .create();
    }
}
