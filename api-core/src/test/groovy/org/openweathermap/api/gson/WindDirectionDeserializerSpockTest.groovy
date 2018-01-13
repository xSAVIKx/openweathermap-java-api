package org.openweathermap.api.gson

import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import spock.lang.Specification

class WindDirectionDeserializerSpockTest extends Specification {
    def "should deserialize WindDirection from JsonElement"() {
        given:
        final def degree = 123
        final def jsonPrimitive = new JsonPrimitive(degree)
        final def jsonElement = Mock(JsonElement)
        final def deserializer = new WindDirectionDeserializer()
        when:
        final def result = deserializer.deserialize(jsonElement, null, null)
        then:
        1 * jsonElement.getAsJsonPrimitive() >> jsonPrimitive
        result != null
        result.degree == degree
    }
}
