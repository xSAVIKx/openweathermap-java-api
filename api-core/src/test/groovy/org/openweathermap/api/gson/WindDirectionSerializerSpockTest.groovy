package org.openweathermap.api.gson

import org.openweathermap.api.model.WindDirection
import spock.lang.Specification


class WindDirectionSerializerSpockTest extends Specification {
    def "should serialize WindDirection into int value"() {
        given:
        final def degree = 123
        final def windDirection = new WindDirection(degree: degree)
        final def serializer = new WindDirectionSerializer()
        when:
        final def result = serializer.serialize(windDirection, null, null)
        then:
        result != null
        result.getAsInt() == degree
    }
}
