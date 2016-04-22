package org.openweathermap.api.gson

import com.google.gson.JsonSyntaxException
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import spock.lang.Specification

class ISOStringDateTypeAdapterSpockTest extends Specification {
    ISOStringDateTypeAdapter adapter = new ISOStringDateTypeAdapter()

    def "should write Date into JsonWriter"() {
        given:
        def jsonWriter = Mock(JsonWriter)
        def date = new Date(116, 5, 5)
        when:
        adapter.write(jsonWriter, date)
        then:
        1 * jsonWriter.value("2016-06-05 00:00:00");
    }

    def "should write null into JsonWriter when date is null"() {
        given:
        def jsonWriter = Mock(JsonWriter)
        def date = null
        when:
        adapter.write(jsonWriter, date)
        then:
        1 * jsonWriter.nullValue();
    }

    def "should read Date from JsonReader"() {
        given:
        def jsonReader = Mock(JsonReader)
        def expected = new Date(116, 5, 5)
        def stringValue = "2016-06-05 00:00:00"
        when:
        def actual = adapter.read(jsonReader)
        then:
        1 * jsonReader.peek() >> JsonToken.STRING
        1 * jsonReader.nextString() >> stringValue
        expected == actual
    }

    def "should return null when reading null from JsonReader"() {
        given:
        def jsonReader = Mock(JsonReader)
        when:
        def actual = adapter.read(jsonReader)
        then:
        1 * jsonReader.peek() >> JsonToken.NULL
        1 * jsonReader.nextNull()
        actual == null
    }

    def "should throw JsonSyntaxException on SimpleDateFormat ParseException"() {
        given:
        def jsonReader = Mock(JsonReader)
        def stringValue = "non-parsable-date"
        when:
        actual = adapter.read(jsonReader)
        then:
        1 * jsonReader.peek() >> JsonToken.STRING
        1 * jsonReader.nextString() >> stringValue
        thrown(JsonSyntaxException)
    }
}
