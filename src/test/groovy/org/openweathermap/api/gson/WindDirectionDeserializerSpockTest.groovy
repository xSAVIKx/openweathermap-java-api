package org.openweathermap.api.gson

import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import spock.lang.Specification

class WindDirectionDeserializerSpockTest extends Specification {
    def "should deserialize WindDirection from JsonElement"() {
        given:
        def degree = 123
        def jsonPrimitive = new JsonPrimitive(degree)
        def jsonElement = Mock(JsonElement)
        def deserializer = new WindDirectionDeserializer()
        when:
        def result = deserializer.deserialize(jsonElement, null, null)
        then:
        1 * jsonElement.getAsJsonPrimitive() >> jsonPrimitive
        result != null
        result.degree == degree
    }
}
