package org.openweathermap.api.query

import spock.lang.Specification
import spock.lang.Unroll


class ClusterSpockTest extends Specification {
    @Unroll
    def "fromStringRepresentation should return #expected for '#stringRepresentation'"() {
        expect:
        Cluster.fromStringRepresentation(stringRepresentation) == expected
        where:
        stringRepresentation || expected
        "no"                 || Cluster.NO
        "yes"                || Cluster.YES
    }

    def "fromStringRepresentation should throw IllegalArgumentException when no value is found"() {
        when:
        Cluster.fromStringRepresentation("noSuchValue")
        then:
        thrown(IllegalArgumentException)
    }
}
