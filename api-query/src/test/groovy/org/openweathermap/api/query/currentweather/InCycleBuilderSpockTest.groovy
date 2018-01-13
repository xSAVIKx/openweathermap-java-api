package org.openweathermap.api.query.currentweather

import org.openweathermap.api.common.Coordinate
import org.openweathermap.api.query.Cluster
import spock.lang.Specification

class InCycleBuilderSpockTest extends Specification {

    def "should create InCycle query"() {
        given:
        final def expectedNumberOfCities = 10
        final def centerPoint = new Coordinate("1", "2")
        final def builder = new InCycleBuilder(centerPoint, expectedNumberOfCities)
        builder.cluster(Cluster.YES)
        when:
        final def result = builder.getQuery()
        then:
        result.expectedNumberOfCities == expectedNumberOfCities
        result.centerPoint == centerPoint
        result.language == null
        result.unitFormat == null
        result.cluster == Cluster.YES
        result.getRequestPart() == 'lat=2&lon=1&cnt=10&cluster=yes'
        result.getSearchPath() == '/find'
        builder == builder.self()
    }

}
