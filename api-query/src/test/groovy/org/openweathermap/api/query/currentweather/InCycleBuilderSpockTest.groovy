package org.openweathermap.api.query.currentweather

import org.openweathermap.api.common.Coordinate
import spock.lang.Specification

class InCycleBuilderSpockTest extends Specification {

    def "should create InCycle query"() {
        given:
        def expectedNumberOfCities = 10
        def centerPoint = new Coordinate("1", "2")
        def builder = new InCycleBuilder(centerPoint, expectedNumberOfCities)
        when:
        def result = builder.getQuery()
        then:
        result.expectedNumberOfCities == expectedNumberOfCities
        result.centerPoint == centerPoint
        result.language == null
        result.unitFormat == null
        builder == builder.self()
        result.getRequestPart() == 'lat=2&lon=1&cnt=10'
    }

}
