package org.openweathermap.api.query.currentweather

import spock.lang.Specification


class ByZipCodeBuilderSpockTest extends Specification {

    def "should create ByZipCode query"() {
        given:
        def zipCode = "zipCode"
        def countryCode = "countryCode"
        def builder = new ByZipCodeBuilder(zipCode, countryCode)
        when:
        def result = builder.getQuery()
        then:
        result.countryCode == countryCode
        result.zipCode == zipCode
        result.language == null
        result.responseFormat == null
        result.unitFormat == null
    }
}
