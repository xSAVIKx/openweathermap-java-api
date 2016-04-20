package org.openweathermap.api.query

import spock.lang.Specification
import spock.lang.Unroll

class TypeSpockTest extends Specification {
    @Unroll
    def "fromStringRepresentation should return #expected for '#stringRepresentation'"() {
        expect:
        Type.fromStringRepresentation(stringRepresentation) == expected
        where:
        stringRepresentation || expected
        "accurate"           || Type.ACCURATE
        "like"               || Type.LIKE
    }

    def "fromStringRepresentation should throw IllegalArgumentException when no value is found"() {
        when:
        Type.fromStringRepresentation("noSuchValue")
        then:
        thrown(IllegalArgumentException)
    }
}
