package org.openweathermap.api

import org.junit.Rule
import org.openweathermap.api.model.Coordinate
import org.openweathermap.api.query.*
import software.betamax.Configuration
import software.betamax.ProxyConfiguration
import software.betamax.TapeMode
import software.betamax.junit.Betamax
import software.betamax.junit.RecorderRule
import spock.lang.Specification

class UrlConnectionWeatherClientSpockBetamaxTest extends Specification {
    private static final String API_KEY = "e727e62532fa3bedf05392e295969719"

    private static final String TAPES_STORAGE = "src/test/resources/org/openweathermap/api/tapes";

    File f = new File(TAPES_STORAGE);
    Configuration configuration = ProxyConfiguration.builder().tapeRoot(f).sslEnabled(true).build();
    @Rule
    RecorderRule recorder = new RecorderRule(configuration);

    @Betamax(tape = "by city id", mode = TapeMode.READ_WRITE)
    def "get Kharkiv weather data"() {
        given:
        def kharkivCityId = "706483"
        def client = new UrlConnectionWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick().currentWeather().oneLocation().byCityId(kharkivCityId)
                .language(Language.UKRAINIAN).unitFormat(UnitFormat.METRIC).build()
        when:
        def result = client.getWeatherData(query)
        then:
        result != null
        assert result.contains(kharkivCityId)
    }

    @Betamax(tape = "by city id", mode = TapeMode.READ_WRITE)
    def "get Kharkiv weather info"() {
        given:
        def kharkivCityId = 706483
        def client = new UrlConnectionWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick().currentWeather().oneLocation().byCityId(String.valueOf(kharkivCityId))
                .language(Language.UKRAINIAN).unitFormat(UnitFormat.METRIC).build()
        when:
        def result = client.getCurrentWeather(query)
        then:
        result != null
        result.cityId == kharkivCityId
    }

    @Betamax(tape = "by coordinates", mode = TapeMode.READ_WRITE)
    def "get Kharkiv weather info by coordinates"() {
        given:
        def longitude = "36.25"
        def latitude = "50"
        def kharkivCoordinate = new Coordinate(longitude, latitude)

        def client = new UrlConnectionWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick().currentWeather().oneLocation().byGeographicCoordinates(kharkivCoordinate)
                .language(Language.UKRAINIAN).unitFormat(UnitFormat.METRIC).build()
        when:
        def result = client.getCurrentWeather(query)
        then:
        result != null
        result.coordinate == kharkivCoordinate
    }

    @Betamax(tape = "by city name", mode = TapeMode.READ_WRITE)
    def "get Kharkiv weather info by city name"() {
        given:
        def cityName = "Kharkiv"
        def countryCode = "ua"
        def client = new UrlConnectionWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick().currentWeather().oneLocation()
                .byCityName(cityName).countryCode(countryCode).type(Type.ACCURATE)
                .language(Language.UKRAINIAN).unitFormat(UnitFormat.METRIC).build()
        when:
        def result = client.getCurrentWeather(query)
        then:
        result != null
        result.cityName == cityName
    }


    @Betamax(tape = "by zip code", mode = TapeMode.READ_WRITE)
    def "get Kharkiv weather info by zip code"() {
        given:
        def zipCode = "94040"
        def countryCode = "us"
        def client = new UrlConnectionWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick().currentWeather().oneLocation().byZipCode(zipCode, countryCode)
                .build()
        when:
        def result = client.getCurrentWeather(query)
        then:
        result != null
        result.cityName == "Mountain View"
    }

    @Betamax(tape = "by rectangle zone", mode = TapeMode.READ_WRITE)
    def "get current weather data by rectangle zone"() {
        given:
        def leftBottom = new Coordinate("12", "32")
        def rightTop = new Coordinate("15", "39")
        def client = new UrlConnectionWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick()
                .currentWeather().multipleLocations().byRectangleZone(leftBottom, rightTop)
                .cluster(Cluster.YES).unitFormat(UnitFormat.METRIC).build()
        when:
        def result = client.getWeatherData(query)
        then:
        result != null
    }

    @Betamax(tape = "by rectangle zone", mode = TapeMode.READ_WRITE)
    def "get current weather info by rectangle zone"() {
        given:
        def leftBottom = new Coordinate("12", "32")
        def rightTop = new Coordinate("15", "39")
        def client = new UrlConnectionWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick()
                .currentWeather().multipleLocations().byRectangleZone(leftBottom, rightTop)
                .cluster(Cluster.YES).unitFormat(UnitFormat.METRIC).build()
        when:
        def result = client.getCurrentWeather(query)
        then:
        result != null
        result.size() == 1
        result[0] != null
        result[0].cityId == 2210247
    }

    @Betamax(tape = "in cycle", mode = TapeMode.READ_WRITE)
    def "get current weather info for cities in cycle"() {
        def centerPoint = new Coordinate("55.5", "37.5")
        def expectedCitiesAmount = 10
        def client = new UrlConnectionWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick()
                .currentWeather().multipleLocations().inCycle(centerPoint, expectedCitiesAmount)
                .cluster(Cluster.YES).build();
        when:
        def result = client.getCurrentWeather(query)
        then:
        result != null
        result.size() == expectedCitiesAmount
    }

    @Betamax(tape = "by city ids", mode = TapeMode.READ_WRITE)
    def "get weather info by cities ID"() {
        given:
        def kharkivCityId = 706483
        def client = new UrlConnectionWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick().currentWeather().multipleLocations().byCityIds().addCityId(String.valueOf(kharkivCityId))
                .language(Language.UKRAINIAN).unitFormat(UnitFormat.METRIC).build()
        when:
        def result = client.getCurrentWeather(query)
        then:
        result != null
        result.size() == 1
        result[0].cityId == kharkivCityId
    }

    @Betamax(tape = "by city name", mode = TapeMode.READ_WRITE)
    def "get Kharkiv forecast by city name"() {
        given:
        def cityName = "Kharkiv"
        def countryCode = "ua"
        def client = new UrlConnectionWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick().forecastInformation()
                .byCityName(cityName).countryCode(countryCode).type(Type.ACCURATE)
                .language(Language.UKRAINIAN).unitFormat(UnitFormat.METRIC).build()
        when:
        def result = client.getForecastInformation(query)
        then:
        result != null
        result.city.name == cityName
    }
}
