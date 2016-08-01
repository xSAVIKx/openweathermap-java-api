package org.openweathermap.api

import org.junit.Rule
import org.openweathermap.api.common.Coordinate
import org.openweathermap.api.query.*
import software.betamax.Configuration
import software.betamax.TapeMode
import software.betamax.junit.Betamax
import software.betamax.junit.RecorderRule
import spock.lang.Specification

class UrlConnectionWeatherClientSpockBetamaxTest extends Specification {
    private static final String API_KEY = "API_KEY_VALUE"

    private static final String TAPES_STORAGE = "src/test/resources/org/openweathermap/api/tapes";

    File f = new File(TAPES_STORAGE);
    Configuration configuration = Configuration.builder().tapeRoot(f).sslEnabled(true).build();
    @Rule
    RecorderRule recorder = new RecorderRule(configuration);

    @Betamax(tape = "by city id", mode = TapeMode.READ_WRITE)
    def "should return query data"() {
        given:
        def kharkivCityId = "706483"
        def client = new UrlConnectionDataWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick()
                .currentWeather()
                .oneLocation()
                .byCityId(kharkivCityId)
                .language(Language.ENGLISH)
                .unitFormat(UnitFormat.IMPERIAL)
                .responseFormat(ResponseFormat.JSON)
                .build()
        when:
        def result = client.getWeatherData(query)
        then:
        result != null
        assert result.contains(kharkivCityId)
    }

    @Betamax(tape = "by city id", mode = TapeMode.READ_WRITE)
    def "should return current weather by city ID"() {
        given:
        def kharkivCityId = 706483
        def client = new UrlConnectionDataWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick()
                .currentWeather()
                .oneLocation()
                .byCityId(String.valueOf(kharkivCityId))
                .language(Language.UKRAINIAN)
                .unitFormat(UnitFormat.STANDARD)
                .build()
        when:
        def result = client.getCurrentWeather(query)
        then:
        result != null
        result.cityId == kharkivCityId
    }

    @Betamax(tape = "by city id", mode = TapeMode.READ_WRITE)
    def "should return null for current weather by city ID in HTML response format"() {
        given:
        def kharkivCityId = 706483
        def client = new UrlConnectionDataWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick()
                .currentWeather()
                .oneLocation()
                .byCityId(String.valueOf(kharkivCityId))
                .responseFormat(ResponseFormat.HTML)
                .build()
        when:
        def result = client.getCurrentWeather(query)
        then:
        result == null
    }

    @Betamax(tape = "by coordinates", mode = TapeMode.READ_WRITE)
    def "should return current weather by coordinates"() {
        given:
        def longitude = "36.25"
        def latitude = "50"
        def kharkivCoordinate = new Coordinate(longitude, latitude)

        def client = new UrlConnectionDataWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick()
                .currentWeather()
                .oneLocation()
                .byGeographicCoordinates(kharkivCoordinate)
                .language(Language.UKRAINIAN)
                .unitFormat(UnitFormat.METRIC)
                .build()
        when:
        def result = client.getCurrentWeather(query)
        then:
        result != null
        result.coordinate == kharkivCoordinate
    }

    @Betamax(tape = "by city name", mode = TapeMode.READ_WRITE)
    def "should return current weather by city name"() {
        given:
        def cityName = "Kharkiv"
        def countryCode = "ua"
        def client = new UrlConnectionDataWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick()
                .currentWeather()
                .oneLocation()
                .byCityName(cityName)
                .countryCode(countryCode)
                .type(Type.ACCURATE)
                .language(Language.UKRAINIAN)
                .unitFormat(UnitFormat.METRIC)
                .build()
        when:
        def result = client.getCurrentWeather(query)
        then:
        result != null
        result.cityName == cityName
    }

    @Betamax(tape = "by zip code", mode = TapeMode.READ_WRITE)
    def "should return current weather by zip code"() {
        given:
        def zipCode = "94045"
        def countryCode = "us"
        def client = new UrlConnectionDataWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick()
                .currentWeather()
                .oneLocation()
                .byZipCode(zipCode, countryCode)
                .build()
        when:
        def result = client.getCurrentWeather(query)
        then:
        result != null
        result.cityName == "San Mateo County"
    }

    @Betamax(tape = "by rectangle zone", mode = TapeMode.READ_WRITE)
    def "should return current weather by rectangle zone"() {
        given:
        def leftBottom = new Coordinate("12", "32")
        def rightTop = new Coordinate("15", "39")
        def client = new UrlConnectionDataWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick()
                .currentWeather()
                .multipleLocations()
                .byRectangleZone(leftBottom, rightTop)
                .cluster(Cluster.YES)
                .unitFormat(UnitFormat.METRIC)
                .build()
        when:
        def result = client.getCurrentWeather(query)
        then:
        result != null
        result.size() == 1
        result[0] != null
        result[0].cityId == 2210247
    }

    @Betamax(tape = "in cycle", mode = TapeMode.READ_WRITE)
    def "should return current weather for cities in cycle"() {
        def centerPoint = new Coordinate("55.5", "37.5")
        def expectedCitiesAmount = 10
        def client = new UrlConnectionDataWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick()
                .currentWeather()
                .multipleLocations()
                .inCycle(centerPoint, expectedCitiesAmount)
                .cluster(Cluster.YES)
                .build();
        when:
        def result = client.getCurrentWeather(query)
        then:
        result != null
        result.size() == expectedCitiesAmount
    }

    @Betamax(tape = "by city ids", mode = TapeMode.READ_WRITE)
    def "should return current weather for cities ID"() {
        given:
        def kharkivCityId = 706483
        def client = new UrlConnectionDataWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick()
                .currentWeather()
                .multipleLocations()
                .byCityIds()
                .addCityId(String.valueOf(kharkivCityId))
                .language(Language.UKRAINIAN)
                .unitFormat(UnitFormat.METRIC)
                .build()
        when:
        def result = client.getCurrentWeather(query)
        then:
        result != null
        result.size() == 1
        result[0].cityId == kharkivCityId
    }

    @Betamax(tape = "by city name", mode = TapeMode.READ_WRITE)
    def "should return hourly forecast by city name"() {
        given:
        def cityName = "Kharkiv"
        def countryCode = "ua"
        def client = new UrlConnectionDataWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick()
                .forecast()
                .hourly()
                .byCityName(cityName)
                .countryCode(countryCode)
                .type(Type.ACCURATE)
                .language(Language.UKRAINIAN)
                .unitFormat(UnitFormat.METRIC)
                .count(10)
                .build()
        when:
        def result = client.getForecastInformation(query)
        then:
        result != null
        result.city.name == cityName
        result.cnt == 10
        result.forecasts.size() == 10
    }

    @Betamax(tape = "by city id", mode = TapeMode.READ_WRITE)
    def "should return hourly forecast by city id"() {
        given:
        def kharkivCityId = 706483
        def client = new UrlConnectionDataWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick()
                .forecast()
                .hourly()
                .byCityId(String.valueOf(kharkivCityId))
                .language(Language.UKRAINIAN)
                .unitFormat(UnitFormat.METRIC)
                .count(10)
                .build()
        when:
        def result = client.getForecastInformation(query)
        then:
        result != null
        result.city.id == kharkivCityId
        result.cnt == 10
        result.forecasts.size() == 10
    }

    @Betamax(tape = "by coordinates", mode = TapeMode.READ_WRITE)
    def "should return hourly forecast by coordinates"() {
        given:
        def longitude = "36.25"
        def latitude = "50"
        def kharkivCoordinate = new Coordinate(longitude, latitude)

        def client = new UrlConnectionDataWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick()
                .forecast()
                .hourly()
                .byGeographicCoordinates(kharkivCoordinate)
                .language(Language.UKRAINIAN)
                .unitFormat(UnitFormat.METRIC)
                .count(10)
                .build()
        when:
        def result = client.getForecastInformation(query)
        then:
        result != null
        result.city.coordinate == kharkivCoordinate
        result.cnt == 10
        result.forecasts.size() == 10
    }


    @Betamax(tape = "by city name", mode = TapeMode.READ_WRITE)
    def "should return daily forecast by city name"() {
        given:
        def cityName = "Kharkiv"
        def countryCode = "ua"
        def client = new UrlConnectionDataWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick()
                .forecast()
                .daily()
                .byCityName(cityName)
                .countryCode(countryCode)
                .type(Type.ACCURATE)
                .language(Language.UKRAINIAN)
                .unitFormat(UnitFormat.METRIC)
                .count(5)
                .build()
        when:
        def result = client.getForecastInformation(query)
        then:
        result != null
        result.city.name == cityName
        result.cnt == 5
        result.forecasts.size() == 5
    }

    @Betamax(tape = "by city id", mode = TapeMode.READ_WRITE)
    def "should return daily forecast by city id"() {
        given:
        def kharkivCityId = 706483
        def client = new UrlConnectionDataWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick()
                .forecast()
                .daily()
                .byCityId(String.valueOf(kharkivCityId))
                .language(Language.UKRAINIAN)
                .unitFormat(UnitFormat.METRIC)
                .count(5)
                .build()
        when:
        def result = client.getForecastInformation(query)
        then:
        result != null
        result.city.id == kharkivCityId
        result.cnt == 5
        result.forecasts.size() == 5
    }

    @Betamax(tape = "by coordinates", mode = TapeMode.READ_WRITE)
    def "should return daily forecast by coordinates"() {
        given:
        def longitude = "36.25"
        def latitude = "50"
        def kharkivCoordinate = new Coordinate(longitude, latitude)

        def client = new UrlConnectionDataWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick()
                .forecast()
                .daily()
                .byGeographicCoordinates(kharkivCoordinate)
                .language(Language.UKRAINIAN)
                .unitFormat(UnitFormat.METRIC)
                .count(5)
                .build()
        when:
        def result = client.getForecastInformation(query)
        then:
        result != null
        result.city.coordinate == kharkivCoordinate
        result.cnt == 5
        result.forecasts.size() == 5
    }

    @Betamax(tape = "by coordinates", mode = TapeMode.READ_WRITE)
    def "should return null for daily forecast by coordinates with XML format"() {
        given:
        def longitude = "36.25"
        def latitude = "50"
        def kharkivCoordinate = new Coordinate(longitude, latitude)
        def client = new UrlConnectionDataWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick()
                .forecast()
                .daily()
                .byGeographicCoordinates(kharkivCoordinate)
                .responseFormat(ResponseFormat.XML)
                .build()
        expect:
        client.getForecastInformation(query) == null
    }
}
