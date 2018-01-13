package org.openweathermap.api.query.forecast.hourly

import spock.lang.Specification

class ByCityIdBuilderSpocTest extends Specification {
    def "should create ByCityId query"() {
        given:
        final def apiKey = 'apiKey'
        final def cityId = 'cityId'
        final def builder = new ByCityIdBuilder(cityId)
        when:
        final def result = builder.getQuery()
        then:
        result.cityId == cityId
        result.language == null
        result.responseFormat == null
        result.unitFormat == null
        builder == builder.self()
        result.getRequestPart() == "id=${cityId}"
        result.toStringRepresentation(apiKey) == "http://api.openweathermap.org/data/2.5/forecast?id=${cityId}&appid=${apiKey}"
    }
}
