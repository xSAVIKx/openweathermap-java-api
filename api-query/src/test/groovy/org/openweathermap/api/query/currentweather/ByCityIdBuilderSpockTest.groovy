package org.openweathermap.api.query.currentweather

import spock.lang.Specification

class ByCityIdBuilderSpockTest extends Specification {

    def "should create ByCityId query"() {
        given:
        def cityId = "cityId"
        def builder = new ByCityIdBuilder(cityId)
        when:
        def result = builder.getQuery()
        then:
        result.cityId == cityId
        result.language == null
        result.responseFormat == null
        result.unitFormat == null
        result.getRequestPart() == "id=cityId"
        builder == builder.self()
    }
}
