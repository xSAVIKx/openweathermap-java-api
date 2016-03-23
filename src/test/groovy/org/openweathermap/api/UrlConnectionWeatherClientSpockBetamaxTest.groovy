package org.openweathermap.api

import org.junit.Rule
import org.openweathermap.api.query.Language
import org.openweathermap.api.query.QueryBuilder
import org.openweathermap.api.query.UnitFormat
import software.betamax.Configuration
import software.betamax.ProxyConfiguration
import software.betamax.TapeMode
import software.betamax.junit.Betamax
import software.betamax.junit.RecorderRule
import spock.lang.Specification

/**
 * Created by iuriis on 22.03.2016.
 */
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
        def query = QueryBuilder.byCityId(kharkivCityId).language(Language.UKRAINIAN).unitFormat(UnitFormat.METRIC).build()
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
        def query = QueryBuilder.byCityId(kharkivCityId).language(Language.UKRAINIAN).unitFormat(UnitFormat.METRIC).build()
        when:
        def result = client.getWeatherInfo(query)
        then:
        result != null
        result.getCityId() == kharkivCityId
    }
}
