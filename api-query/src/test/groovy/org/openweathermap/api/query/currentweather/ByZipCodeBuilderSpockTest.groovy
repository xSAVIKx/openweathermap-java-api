package org.openweathermap.api.query.currentweather

import spock.lang.Specification


class ByZipCodeBuilderSpockTest extends Specification {

    def "should create ByZipCode query"() {
        given:
        final def zipCode = "zipCode"
        final def countryCode = "countryCode"
        final def builder = new ByZipCodeBuilder(zipCode, countryCode)
        when:
        final def result = builder.getQuery()
        then:
        result.countryCode == countryCode
        result.zipCode == zipCode
        result.language == null
        result.responseFormat == null
        result.unitFormat == null
        builder == builder.self()
        result.getRequestPart() == 'zip=zipCode,countryCode'
    }
}
