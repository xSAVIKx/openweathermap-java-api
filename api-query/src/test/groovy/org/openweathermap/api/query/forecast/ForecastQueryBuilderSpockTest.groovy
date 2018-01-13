package org.openweathermap.api.query.forecast

import org.openweathermap.api.query.forecast.hourly.ByCityIdBuilder
import spock.lang.Specification

class ForecastQueryBuilderSpockTest extends Specification {
    def "should set count field of query"() {
        given:
        final ForecastQueryBuilder builder = new ByCityIdBuilder('')
        when:
        builder.count(1)
        then:
        builder.build().getCount() == 1
    }
}