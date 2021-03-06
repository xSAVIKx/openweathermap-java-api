/*
 * Copyright 2021, Yurii Serhiichuk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.openweathermap.api

import org.junit.Rule
import org.openweathermap.api.common.Coordinate
import org.openweathermap.api.query.*
import org.openweathermap.api.query.uvi.UviQuery
import software.betamax.Configuration
import software.betamax.TapeMode
import software.betamax.junit.Betamax
import software.betamax.junit.RecorderRule
import spock.lang.Specification

class UrlConnectionWeatherClientSpockBetamaxTest extends Specification {
    private static final String HTTP_BASE_URL = "http://api.openweathermap.org/data/2.5"
    private static final String API_KEY = "API_KEY"

    private static final String TAPES_STORAGE = "src/test/resources/org/openweathermap/api/tapes"

    File f = new File(TAPES_STORAGE)
    Configuration configuration = Configuration.builder().tapeRoot(f).sslEnabled(true).build()
    @Rule
    RecorderRule recorder = new RecorderRule(configuration)

    @Betamax(tape = "by city id", mode = TapeMode.READ_WRITE)
    def "should return query data"() {
        given:
        final def kharkivCityId = "706483"
        final def client = new UrlConnectionDataWeatherClient(API_KEY)
        final def query = QueryBuilderPicker.pick()
                .currentWeather()
                .oneLocation()
                .byCityId(kharkivCityId)
                .language(Language.ENGLISH)
                .unitFormat(UnitFormat.IMPERIAL)
                .responseFormat(ResponseFormat.JSON)
                .baseUrl(HTTP_BASE_URL)
                .build()
        when:
        final def result = client.getWeatherData(query)
        then:
        result != null
        assert result.contains(kharkivCityId)
    }

    @Betamax(tape = "by city id", mode = TapeMode.READ_WRITE)
    def "should return current weather by city ID"() {
        given:
        final def kharkivCityId = 706483
        final def client = new UrlConnectionDataWeatherClient(API_KEY)
        final def query = QueryBuilderPicker.pick()
                .currentWeather()
                .oneLocation()
                .byCityId(String.valueOf(kharkivCityId))
                .language(Language.UKRAINIAN)
                .unitFormat(UnitFormat.STANDARD)
                .baseUrl(HTTP_BASE_URL)
                .build()
        when:
        final def result = client.getCurrentWeather(query)
        then:
        result != null
        result.cityId == kharkivCityId
    }

    @Betamax(tape = "by city id", mode = TapeMode.READ_WRITE)
    def "should return null for current weather by city ID in HTML response format"() {
        given:
        final def kharkivCityId = 706483
        final def client = new UrlConnectionDataWeatherClient(API_KEY)
        final def query = QueryBuilderPicker.pick()
                .currentWeather()
                .oneLocation()
                .byCityId(String.valueOf(kharkivCityId))
                .responseFormat(ResponseFormat.HTML)
                .baseUrl(HTTP_BASE_URL)
                .build()
        when:
        final def result = client.getCurrentWeather(query)
        then:
        result == null
    }

    @Betamax(tape = "by coordinates", mode = TapeMode.READ_WRITE)
    def "should return current weather by coordinates"() {
        given:
        final def longitude = "36.25"
        final def latitude = "50"
        final def kharkivCoordinate = new Coordinate(longitude, latitude)

        final def client = new UrlConnectionDataWeatherClient(API_KEY)
        final def query = QueryBuilderPicker.pick()
                .currentWeather()
                .oneLocation()
                .byGeographicCoordinates(kharkivCoordinate)
                .language(Language.UKRAINIAN)
                .unitFormat(UnitFormat.METRIC)
                .baseUrl(HTTP_BASE_URL)
                .build()
        when:
        final def result = client.getCurrentWeather(query)
        then:
        result != null
        result.coordinate == kharkivCoordinate
    }

    @Betamax(tape = "by city name", mode = TapeMode.READ_WRITE)
    def "should return current weather by city name"() {
        given:
        final def cityName = "Kharkiv"
        final def countryCode = "ua"
        final def client = new UrlConnectionDataWeatherClient(API_KEY)
        final def query = QueryBuilderPicker.pick()
                .currentWeather()
                .oneLocation()
                .byCityName(cityName)
                .countryCode(countryCode)
                .type(Type.ACCURATE)
                .language(Language.UKRAINIAN)
                .unitFormat(UnitFormat.METRIC)
                .baseUrl(HTTP_BASE_URL)
                .build()
        when:
        final def result = client.getCurrentWeather(query)
        then:
        result != null
        result.cityName == cityName
    }

    @Betamax(tape = "by zip code", mode = TapeMode.READ_WRITE)
    def "should return current weather by zip code"() {
        given:
        final def zipCode = "94401"
        final def countryCode = "us"
        final def client = new UrlConnectionDataWeatherClient(API_KEY)
        final def query = QueryBuilderPicker.pick()
                .currentWeather()
                .oneLocation()
                .byZipCode(zipCode, countryCode)
                .baseUrl(HTTP_BASE_URL)
                .build()
        when:
        final def result = client.getCurrentWeather(query)
        then:
        result != null
        result.cityName == "San Mateo"
    }

    @Betamax(tape = "by rectangle zone", mode = TapeMode.READ_WRITE)
    def "should return current weather by rectangle zone"() {
        given:
        final def leftBottom = new Coordinate("12", "32")
        final def rightTop = new Coordinate("15", "39")
        final def client = new UrlConnectionDataWeatherClient(API_KEY)
        final def query = QueryBuilderPicker.pick()
                .currentWeather()
                .multipleLocations()
                .byRectangleZone(leftBottom, rightTop)
                .cluster(Cluster.YES)
                .unitFormat(UnitFormat.METRIC)
                .baseUrl(HTTP_BASE_URL)
                .build()
        when:
        final def result = client.getCurrentWeather(query)
        then:
        result != null
        result.size() == 1
        result[0] != null
        result[0].cityId == 2210247
    }

    @Betamax(tape = "in cycle", mode = TapeMode.READ_WRITE)
    def "should return current weather for cities in cycle"() {
        final def centerPoint = new Coordinate("55.5", "37.5")
        final def expectedCitiesAmount = 9
        final def client = new UrlConnectionDataWeatherClient(API_KEY)
        final def query = QueryBuilderPicker.pick()
                .currentWeather()
                .multipleLocations()
                .inCycle(centerPoint, expectedCitiesAmount)
                .cluster(Cluster.YES)
                .baseUrl(HTTP_BASE_URL)
                .build()
        when:
        final def result = client.getCurrentWeather(query)
        then:
        result != null
        result.size() == expectedCitiesAmount
    }

    @Betamax(tape = "by city ids", mode = TapeMode.READ_WRITE)
    def "should return current weather for cities ID"() {
        given:
        final def kharkivCityId = 706483
        final def client = new UrlConnectionDataWeatherClient(API_KEY)
        final def query = QueryBuilderPicker.pick()
                .currentWeather()
                .multipleLocations()
                .byCityIds()
                .addCityId(String.valueOf(kharkivCityId))
                .language(Language.UKRAINIAN)
                .unitFormat(UnitFormat.METRIC)
                .baseUrl(HTTP_BASE_URL)
                .build()
        when:
        final def result = client.getCurrentWeather(query)
        then:
        result != null
        result.size() == 1
        result[0].cityId == kharkivCityId
    }

    @Betamax(tape = "by city name", mode = TapeMode.READ_WRITE)
    def "should return hourly forecast by city name"() {
        given:
        final def cityName = "Kharkiv"
        final def countryCode = "ua"
        final def client = new UrlConnectionDataWeatherClient(API_KEY)
        final def query = QueryBuilderPicker.pick()
                .forecast()
                .hourly()
                .byCityName(cityName)
                .countryCode(countryCode)
                .type(Type.ACCURATE)
                .language(Language.UKRAINIAN)
                .unitFormat(UnitFormat.METRIC)
                .count(10)
                .baseUrl(HTTP_BASE_URL)
                .build()
        when:
        final def result = client.getForecastInformation(query)
        then:
        result != null
        result.city.name == cityName
        result.city.timezone == 10800
        result.cnt == 10
        result.forecasts.size() == 10
    }

    @Betamax(tape = "by city id", mode = TapeMode.READ_WRITE)
    def "should return hourly forecast by city id"() {
        given:
        final def kharkivCityId = 706483
        final def client = new UrlConnectionDataWeatherClient(API_KEY)
        final def query = QueryBuilderPicker.pick()
                .forecast()
                .hourly()
                .byCityId(String.valueOf(kharkivCityId))
                .language(Language.UKRAINIAN)
                .unitFormat(UnitFormat.METRIC)
                .count(10)
                .baseUrl(HTTP_BASE_URL)
                .build()
        when:
        final def result = client.getForecastInformation(query)
        then:
        result != null
        result.city.id == kharkivCityId
        result.cnt == 10
        result.forecasts.size() == 10
    }

    @Betamax(tape = "by coordinates", mode = TapeMode.READ_WRITE)
    def "should return hourly forecast by coordinates"() {
        given:
        final def longitude = "36.25"
        final def latitude = "50"
        final def kharkivCoordinate = new Coordinate(longitude, latitude)

        final def client = new UrlConnectionDataWeatherClient(API_KEY)
        final def query = QueryBuilderPicker.pick()
                .forecast()
                .hourly()
                .byGeographicCoordinates(kharkivCoordinate)
                .language(Language.UKRAINIAN)
                .unitFormat(UnitFormat.METRIC)
                .count(10)
                .baseUrl(HTTP_BASE_URL)
                .build()
        when:
        final def result = client.getForecastInformation(query)
        then:
        result != null
        result.city.coordinate == kharkivCoordinate
        result.cnt == 10
        result.forecasts.size() == 10
    }


    @Betamax(tape = "by city name", mode = TapeMode.READ_WRITE)
    def "should return daily forecast by city name"() {
        given:
        final def cityName = "Kharkiv"
        final def countryCode = "ua"
        final def client = new UrlConnectionDataWeatherClient(API_KEY)
        final def query = QueryBuilderPicker.pick()
                .forecast()
                .daily()
                .byCityName(cityName)
                .countryCode(countryCode)
                .type(Type.ACCURATE)
                .language(Language.UKRAINIAN)
                .unitFormat(UnitFormat.METRIC)
                .count(5)
                .baseUrl(HTTP_BASE_URL)
                .build()
        when:
        final def result = client.getForecastInformation(query)
        then:
        result != null
        result.city.name == cityName
        result.cnt == 5
        result.forecasts.size() == 5
    }

    @Betamax(tape = "by city id", mode = TapeMode.READ_WRITE)
    def "should return daily forecast by city id"() {
        given:
        final def kharkivCityId = 706483
        final def client = new UrlConnectionDataWeatherClient(API_KEY)
        final def query = QueryBuilderPicker.pick()
                .forecast()
                .daily()
                .byCityId(String.valueOf(kharkivCityId))
                .language(Language.UKRAINIAN)
                .unitFormat(UnitFormat.METRIC)
                .count(5)
                .baseUrl(HTTP_BASE_URL)
                .build()
        when:
        final def result = client.getForecastInformation(query)
        then:
        result != null
        result.city.id == kharkivCityId
        result.cnt == 5
        result.forecasts.size() == 5
    }

    @Betamax(tape = "by coordinates", mode = TapeMode.READ_WRITE)
    def "should return daily forecast by coordinates"() {
        given:
        final def longitude = "36.25"
        final def latitude = "50"
        final def kharkivCoordinate = new Coordinate(longitude, latitude)

        final def client = new UrlConnectionDataWeatherClient(API_KEY)
        final def query = QueryBuilderPicker.pick()
                .forecast()
                .daily()
                .byGeographicCoordinates(kharkivCoordinate)
                .language(Language.UKRAINIAN)
                .unitFormat(UnitFormat.METRIC)
                .count(5)
                .baseUrl(HTTP_BASE_URL)
                .build()
        when:
        final def result = client.getForecastInformation(query)
        then:
        result != null
        result.city.coordinate == kharkivCoordinate
        result.cnt == 5
        result.forecasts.size() == 5
    }

    @Betamax(tape = "by coordinates", mode = TapeMode.READ_WRITE)
    def "should return null for daily forecast by coordinates with XML format"() {
        given:
        final def longitude = "36.25"
        final def latitude = "50"
        final def kharkivCoordinate = new Coordinate(longitude, latitude)
        final def client = new UrlConnectionDataWeatherClient(API_KEY)
        final def query = QueryBuilderPicker.pick()
                .forecast()
                .daily()
                .byGeographicCoordinates(kharkivCoordinate)
                .responseFormat(ResponseFormat.XML)
                .baseUrl(HTTP_BASE_URL)
                .build()
        expect:
        client.getForecastInformation(query) == null
    }

    @Betamax(tape = "by coordinates", mode = TapeMode.READ_WRITE)
    def "should return current Uvi value by coordinates"() {
        given:
        final def longitude = "36.25"
        final def latitude = "50"
        final def kharkivCoordinate = new Coordinate(longitude, latitude)
        final def client = new UrlConnectionDataWeatherClient(API_KEY)
        final def query = UviQuery.Current.byGeographicCoordinates(kharkivCoordinate)
                .language(Language.ENGLISH)
                .unitFormat(UnitFormat.METRIC)
                .baseUrl(HTTP_BASE_URL)
                .build()
        when:
        final def result = client.getCurrentUvi(query)
        then:
        result.longitude == longitude
        result.latitude == latitude
        result.isoDate == '2021-06-20T12:00:00Z'
        result.date == new Date(1624190400000L)
        result.ultravioletIndex == 8.39d
    }

    @Betamax(tape = "by coordinates", mode = TapeMode.READ_WRITE)
    def "should return Uvi forecast by coordinates"() {
        given:
        final def longitude = "36.25"
        final def latitude = "50"
        final def kharkivCoordinate = new Coordinate(longitude, latitude)
        final def client = new UrlConnectionDataWeatherClient(API_KEY)
        final def query = UviQuery.Forecast.byGeographicCoordinates(kharkivCoordinate)
                .language(Language.ENGLISH)
                .unitFormat(UnitFormat.METRIC)
                .count(1)
                .baseUrl(HTTP_BASE_URL)
                .build()
        when:
        final def result = client.getUviForecast(query)
        then:
        result.size() == 2
        result[0].longitude == longitude
        result[0].latitude == latitude
        result[0].isoDate == '2021-06-21T12:00:00Z'
        result[0].date == new Date(1624276800000L)
        result[0].ultravioletIndex == 7.97d

        result[1].longitude == longitude
        result[1].latitude == latitude
        result[1].isoDate == '2021-06-22T12:00:00Z'
        result[1].date == new Date(1624363200000L)
        result[1].ultravioletIndex == 8.07d
    }
}
