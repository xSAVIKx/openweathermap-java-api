package org.openweathermap.api.query.currentweather

import spock.lang.Specification

class ByCityIdsBuilderSpockTest extends Specification {
    def "should return ByCityIds query with empty city id collection"() {
        given:
        ByCityIdsBuilder builder = new ByCityIdsBuilder()
        when:
        def result = builder.getQuery()
        then:
        assert result.cityIds.isEmpty()
        result.language == null
        result.unitFormat == null
        result.getRequestPart() == "id="
        result.getSearchPath() == "/group"
    }

    def "should return ByCityIds query"() {
        given:
        def cityId = "cityId"
        ByCityIdsBuilder builder = new ByCityIdsBuilder()
        builder.addCityId(cityId)
        when:
        def result = builder.getQuery()
        then:
        result.cityIds[0] == cityId
        result.language == null
        result.unitFormat == null
        result.getRequestPart() == "id=cityId"
    }

    def "should return ByCityIds query with given city id collection"() {
        given:
        def cityIds = ["cityId1", "cityId2"]
        ByCityIdsBuilder builder = new ByCityIdsBuilder(cityIds)
        when:
        def result = builder.getQuery()
        then:
        result.cityIds == cityIds
        result.language == null
        result.unitFormat == null
        result.getRequestPart() == "id=cityId1,cityId2"
    }
}
