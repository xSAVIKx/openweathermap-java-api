package org.openweathermap.api.example;

import org.openweathermap.api.DataWeatherClient;
import org.openweathermap.api.UrlConnectionDataWeatherClient;
import org.openweathermap.api.common.Coordinate;
import org.openweathermap.api.model.uvi.Uvi;
import org.openweathermap.api.query.Language;
import org.openweathermap.api.query.UnitFormat;
import org.openweathermap.api.query.uvi.UviQuery;
import org.openweathermap.api.query.uvi.current.ByGeographicCoordinates;

public class UviCurrentExample {
    private static final String API_KEY = "e727e62532fa3bedf05392e295969719";

    public static void main(String[] args) {
        DataWeatherClient client = new UrlConnectionDataWeatherClient(API_KEY);
        Coordinate coordinate = new Coordinate("36.230383", "49.9935");
        ByGeographicCoordinates query = UviQuery.Current.byGeographicCoordinates(coordinate)
                .language(Language.ENGLISH)
                .unitFormat(UnitFormat.METRIC)
                .build();
        Uvi result = client.getCurrentUvi(query);
        System.out.println(result);
    }
}
