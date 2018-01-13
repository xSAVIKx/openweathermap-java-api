package org.openweathermap.api.query.currentweather

import org.openweathermap.api.common.Coordinate
import spock.lang.Specification


class ByGeographicCoordinatesBuilderSpockTest extends Specification {
    def "should create ByGeographicCoordinates query"() {
        given:
        final def longitude = "1"
        final def latitude = "2"
        final def coordinate = new Coordinate(longitude, latitude)
        final def builder = new ByGeographicCoordinatesBuilder(coordinate)
        when:
        final def result = builder.getQuery()
        then:
        result.coordinate == coordinate
        result.language == null
        result.responseFormat == null
        result.unitFormat == null
        builder == builder.self()
        result.getRequestPart() == "lat=2&lon=1"
    }
}
