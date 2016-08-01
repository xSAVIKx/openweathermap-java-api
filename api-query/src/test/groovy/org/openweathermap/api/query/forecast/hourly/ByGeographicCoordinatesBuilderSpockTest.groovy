package org.openweathermap.api.query.forecast.hourly

import org.openweathermap.api.common.Coordinate
import spock.lang.Specification


class ByGeographicCoordinatesBuilderSpockTest extends Specification {
    def "should create ByGeographicCoordinates query"() {
        given:
        def longitude = "1"
        def latitude = "2"
        def coordinate = new Coordinate(longitude, latitude)
        def builder = new ByGeographicCoordinatesBuilder(coordinate)
        when:
        def result = builder.getQuery()
        then:
        result.coordinate == coordinate
        result.language == null
        result.responseFormat == null
        result.unitFormat == null
        builder == builder.self()
        result.getRequestPart() == 'lat=2&lon=1'
    }
}
