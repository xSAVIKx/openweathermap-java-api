package org.openweathermap.api

import org.openweathermap.api.query.Language
import org.openweathermap.api.query.QueryBuilder
import org.openweathermap.api.query.UnitFormat
import spock.lang.Specification

/**
 * Created by iuriis on 23.03.2016.
 */
class UrlConnectionWeatherClientSpockTest extends Specification {
    public static final String API_KEY = "apiKey"
    public static
    final String RESPONSE = '{"coord":{"lon":36.25,"lat":50},"weather":[{"id":803,"main":"Clouds","description":"хмарно","icon":"04d"}],' +
            '"base":"cmc stations","main":{"temp":8,"pressure":1008,"humidity":90,"temp_min":8,"temp_max":8},' +
            '"wind":{"speed":5,"deg":300},"clouds":{"all":75},"dt":1458734400,' +
            '"sys":{"type":1,"id":7355,"message":0.0179,"country":"UA","sunrise":1458703779,"sunset":1458748434},' +
            '"id":706483,"name":"Kharkiv","cod":200}'
    def urlStreamHandler = Mock(URLStreamHandler)
    def urlConnection = Mock(URLConnection)
    def client = Spy(UrlConnectionWeatherClient, constructor_args: [API_KEY])

    def "setup"() {
        urlStreamHandler.openConnection(_) >> urlConnection
    }

    def "get Kharkiv weather data"() {
        given:
        def kharkivCityId = "706483"
        def query = QueryBuilder.byCityId(kharkivCityId).language(Language.UKRAINIAN).unitFormat(UnitFormat.METRIC).build()
        def url = new URL("foo", "bar", 99, "/foobar", urlStreamHandler);
        when:
        def result = client.getWeatherData(query)
        then:
        1 * client.getUrl(_) >> url
        1 * client.readResponse(urlConnection) >> RESPONSE
        result != null
        assert result.contains(kharkivCityId)
    }

    def "get Kharkiv weather info"() {
        given:
        def kharkivCityId = "706483"
        def query = QueryBuilder.byCityId(kharkivCityId).language(Language.UKRAINIAN).unitFormat(UnitFormat.METRIC).build()
        def url = new URL("foo", "bar", 99, "/foobar", urlStreamHandler);
        when:
        def result = client.getWeatherInfo(query)
        then:
        1 * client.getUrl(_) >> url
        1 * client.readResponse(urlConnection) >> RESPONSE
        result != null
        result.getCityId() == kharkivCityId
    }
}
