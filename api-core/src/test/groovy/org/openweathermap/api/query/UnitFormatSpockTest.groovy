package org.openweathermap.api.query

import spock.lang.Specification
import spock.lang.Unroll

class UnitFormatSpockTest extends Specification {
    @Unroll
    def "fromStringRepresentation should return #expected for '#stringRepresentation'"() {
        expect:
        UnitFormat.fromStringRepresentation(stringRepresentation) == expected
        where:
        stringRepresentation || expected
        "imperial"           || UnitFormat.IMPERIAL
        "metric"             || UnitFormat.METRIC
        "standard"           || UnitFormat.STANDARD
    }

    def "fromStringRepresentation should throw IllegalArgumentException when no value is found"() {
        when:
        UnitFormat.fromStringRepresentation("noSuchValue")
        then:
        thrown(IllegalArgumentException)
    }
}
