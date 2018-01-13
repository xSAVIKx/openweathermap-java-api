package org.openweathermap.api.query.currentweather

import spock.lang.Specification

class ByCityIdsBuilderSpockTest extends Specification {
    def "should return ByCityIds query with empty city id collection"() {
        given:
        final ByCityIdsBuilder builder = new ByCityIdsBuilder()
        when:
        final def result = builder.getQuery()
        then:
        assert result.cityIds.isEmpty()
        result.language == null
        result.unitFormat == null
        result.getRequestPart() == "id="
        result.getSearchPath() == "/group"
    }

    def "should return ByCityIds query"() {
        given:
        final def cityId = "cityId"
        final ByCityIdsBuilder builder = new ByCityIdsBuilder()
        builder.addCityId(cityId)
        when:
        final def result = builder.getQuery()
        then:
        result.cityIds[0] == cityId
        result.language == null
        result.unitFormat == null
        result.getRequestPart() == "id=cityId"
    }

    def "should return ByCityIds query with given city id collection"() {
        given:
        final def cityIds = ["cityId1", "cityId2"]
        final ByCityIdsBuilder builder = new ByCityIdsBuilder(cityIds)
        when:
        final def result = builder.getQuery()
        then:
        result.cityIds == cityIds
        result.language == null
        result.unitFormat == null
        result.getRequestPart() == "id=cityId1,cityId2"
    }
}
