package org.openweathermap.api.query

import spock.lang.Specification
import spock.lang.Unroll


class LanguageSpockTest extends Specification {
    @Unroll
    def "fromStringRepresentation should return #expected for '#stringRepresentation'"() {
        expect:
        Language.fromStringRepresentation(stringRepresentation) == expected
        where:
        stringRepresentation || expected
        "ua"                 || Language.UKRAINIAN
        "ro"                 || Language.ROMANIAN
        "en"                 || Language.ENGLISH
    }

    def "fromStringRepresentation should throw IllegalArgumentException when no value is found"() {
        when:
        Language.fromStringRepresentation("noSuchValue")
        then:
        thrown(IllegalArgumentException)
    }
}
