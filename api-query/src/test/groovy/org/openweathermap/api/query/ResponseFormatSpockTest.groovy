package org.openweathermap.api.query

import spock.lang.Specification
import spock.lang.Unroll


class ResponseFormatSpockTest extends Specification {
    @Unroll
    def "fromStringRepresentation should return #expected for '#stringRepresentation'"() {
        expect:
        ResponseFormat.fromStringRepresentation(stringRepresentation) == expected
        where:
        stringRepresentation || expected
        "html"               || ResponseFormat.HTML
        "json"               || ResponseFormat.JSON
        "xml"                || ResponseFormat.XML
    }

    def "fromStringRepresentation should throw IllegalArgumentException when no value is found"() {
        when:
        ResponseFormat.fromStringRepresentation("noSuchValue")
        then:
        thrown(IllegalArgumentException)
    }
}
