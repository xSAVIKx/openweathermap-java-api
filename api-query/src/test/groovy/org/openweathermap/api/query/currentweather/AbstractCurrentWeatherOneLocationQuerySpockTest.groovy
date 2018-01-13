package org.openweathermap.api.query.currentweather

import spock.lang.Specification


class AbstractCurrentWeatherOneLocationQuerySpockTest extends Specification {
    def "should return search path"() {
        given:
        final AbstractCurrentWeatherOneLocationQuery query = new ByCityId('')
        expect:
        query.getSearchPath() == "/weather"
    }
}