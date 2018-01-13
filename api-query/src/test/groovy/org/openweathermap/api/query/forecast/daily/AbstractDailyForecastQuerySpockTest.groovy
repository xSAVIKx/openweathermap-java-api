package org.openweathermap.api.query.forecast.daily

import spock.lang.Specification


class AbstractDailyForecastQuerySpockTest extends Specification {
    def "should return searchPath"() {
        given:
        final AbstractDailyForecastQuery byCityId = new ByCityId("q")
        expect:
        byCityId.getSearchPath() == '/forecast/daily'
    }
}