package org.openweathermap.api.example;

import org.openweathermap.api.DataWeatherClient;
import org.openweathermap.api.UrlConnectionDataWeatherClient;
import org.openweathermap.api.model.forecast.ForecastInformation;
import org.openweathermap.api.model.forecast.daily.DailyForecast;
import org.openweathermap.api.query.Language;
import org.openweathermap.api.query.QueryBuilderPicker;
import org.openweathermap.api.query.UnitFormat;
import org.openweathermap.api.query.forecast.daily.ByCityName;

public class DailyForecastExample {
    private static final String API_KEY = "API_KEY_VALUE";

    public static void main(String[] args) {
        DataWeatherClient client = new UrlConnectionDataWeatherClient(API_KEY);
        ByCityName byCityNameForecast = QueryBuilderPicker.pick()
                .forecast()                                         // get forecast
                .daily()                                            // it should be dailt
                .byCityName("Kharkiv")                              // for Kharkiv city
                .countryCode("UA")                                  // in Ukraine
                .unitFormat(UnitFormat.METRIC)                      // in Metric units
                .language(Language.ENGLISH)                         // in English
                .build();
        ForecastInformation<DailyForecast> forecastInformation = client.getForecastInformation(byCityNameForecast);
        System.out.println(forecastInformation.getCity());
        for (DailyForecast forecast : forecastInformation.getForecasts()) {
            System.out.println(String.format("Temperature on %s will be: %s",
                    forecast.getDateTime().toString(), forecast.getTemperature().toString()));
        }
    }
}
