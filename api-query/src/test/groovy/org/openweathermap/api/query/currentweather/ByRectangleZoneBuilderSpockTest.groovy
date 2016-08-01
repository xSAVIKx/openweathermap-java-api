package org.openweathermap.api.query.currentweather

import org.openweathermap.api.common.Coordinate
import org.openweathermap.api.query.Cluster
import spock.lang.Specification

class ByRectangleZoneBuilderSpockTest extends Specification {
    def "should create ByRectangleZone query"() {
        given:
        def cluster = Cluster.NO
        def leftBottom = new Coordinate("2", "3")
        def rightTop = new Coordinate("1", "4")
        def builder = new ByRectangleZoneBuilder(leftBottom, rightTop)
        when:
        builder.cluster(cluster)
        def result = builder.getQuery()
        then:
        result.cluster == cluster
        result.leftBottom == leftBottom
        result.rightTop == rightTop
        result.language == null
        result.unitFormat == null
        builder == builder.self()
        result.getSearchPath() == '/box/city'
        result.getRequestPart() == 'bbox=2,3,1,4&cluster=no'
    }
}
