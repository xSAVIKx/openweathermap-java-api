package org.openweathermap.api

import org.junit.Rule
import org.openweathermap.api.model.Coordinate
import org.openweathermap.api.query.Language
import org.openweathermap.api.query.UnitFormat
import org.openweathermap.api.query.builder.QueryBuilderPicker
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

    @Betamax(tape = "kharkiv weather", mode = TapeMode.READ_WRITE)
    def "get Kharkiv weather data"() {
        given:
        def kharkivCityId = "706483"
        def client = new UrlConnectionWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick().currentWeatherQuery().byCityId(kharkivCityId)
                .language(Language.UKRAINIAN).unitFormat(UnitFormat.METRIC).build()
        when:
        def result = client.getWeatherData(query)
        then:
        result != null
        assert result.contains(kharkivCityId)
    }

    @Betamax(tape = "kharkiv weather", mode = TapeMode.READ_WRITE)
    def "get Kharkiv weather info"() {
        given:
        def kharkivCityId = "706483"
        def client = new UrlConnectionWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick().currentWeatherQuery().byCityId(kharkivCityId)
                .language(Language.UKRAINIAN).unitFormat(UnitFormat.METRIC).build()
        when:
        def result = client.getWeatherInfo(query)
        then:
        result != null
        result.getCityId() == kharkivCityId
    }

    @Betamax(tape = "kharkiv weather", mode = TapeMode.READ_WRITE)
    def "get Kharkiv weather info by coordinates"() {
        given:
        def longitude = "36.25"
        def latitude = "50"
        def kharkivCoordinate = new Coordinate(longitude, latitude)

        def client = new UrlConnectionWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick().currentWeatherQuery().byGeographicCoordinates(kharkivCoordinate)
                .language(Language.UKRAINIAN).unitFormat(UnitFormat.METRIC).build()
        when:
        def result = client.getWeatherInfo(query)
        then:
        result != null
        result.getCoordinate() == kharkivCoordinate
    }

    @Betamax(tape = "kharkiv weather", mode = TapeMode.READ_WRITE)
    def "get Kharkiv weather info by city name"() {
        given:
        def cityName = "Kharkiv"
        def countryCode = "ua"
        def client = new UrlConnectionWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick().currentWeatherQuery().byCityName(cityName).countryCode(countryCode)
                .language(Language.UKRAINIAN).unitFormat(UnitFormat.METRIC).build()
        when:
        def result = client.getWeatherInfo(query)
        then:
        result != null
        result.getCityName() == cityName
    }

    @Betamax(tape = "kharkiv weather", mode = TapeMode.READ_WRITE)
    def "get Kharkiv weather info by zip code"() {
        given:
        def zipCode = "94040"
        def countryCode = "us"
        def client = new UrlConnectionWeatherClient(API_KEY)
        def query = QueryBuilderPicker.pick().currentWeatherQuery().byZipCode(zipCode, countryCode)
                .language(Language.UKRAINIAN).unitFormat(UnitFormat.METRIC).build()
        when:
        def result = client.getWeatherInfo(query)
        then:
        result != null
        result.getCityName() == "Mountain View"
    }
}
