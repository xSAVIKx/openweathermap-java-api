package org.openweathermap.api.query.forecast.daily

import org.openweathermap.api.common.Coordinate
import spock.lang.Specification


class ByGeographicCoordinatesBuilderSpockTest extends Specification {
    def "should create ByGeographicCoordinates query"() {
        given:
        final def apiKey = 'apiKey'
        final def longitude = '1'
        final def latitude = '2'
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
        result.getRequestPart() == "lat=${latitude}&lon=${longitude}"
        result.toStringRepresentation(apiKey) == "http://api.openweathermap.org/data/2.5/forecast/daily?lat=${latitude}&lon=${longitude}&appid=${apiKey}"
    }
}
