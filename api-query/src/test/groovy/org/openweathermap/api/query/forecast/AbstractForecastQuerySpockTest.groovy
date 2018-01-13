package org.openweathermap.api.query.forecast

import org.openweathermap.api.query.forecast.hourly.ByCityId
import spock.lang.Specification


class AbstractForecastQuerySpockTest extends Specification {
    def "should return searchPath"() {
        given:
        final AbstractForecastQuery query = new ByCityId('')
        expect:
        query.getSearchPath() == '/forecast'
    }

    def "should create toStringRepresentation"() {
        given:
        final AbstractForecastQuery query = new ByCityId('')
        expect:
        query.toStringRepresentation('apiKey') == 'http://api.openweathermap.org/data/2.5/forecast?id=&appid=apiKey'
    }
}