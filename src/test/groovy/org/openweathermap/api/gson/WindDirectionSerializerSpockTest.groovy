package org.openweathermap.api.gson

import org.openweathermap.api.model.WindDirection
import spock.lang.Specification


class WindDirectionSerializerSpockTest extends Specification {
    def "should serialize WindDirection into int value"() {
        given:
        def degree = 123
        def windDirection = new WindDirection(degree: degree)
        def serializer = new WindDirectionSerializer()
        when:
        def result = serializer.serialize(windDirection, null, null)
        then:
        result != null
        result.getAsInt() == degree
    }
}
