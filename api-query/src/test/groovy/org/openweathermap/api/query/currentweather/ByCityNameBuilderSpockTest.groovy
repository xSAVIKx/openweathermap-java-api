package org.openweathermap.api.query.currentweather

import org.openweathermap.api.query.Type
import spock.lang.Specification

class ByCityNameBuilderSpockTest extends Specification {
    def "should create ByCityName query"() {
        given:
        final def cityName = "cityName"
        final def countryCode = "ua"
        final def type = Type.LIKE
        final def builder = new ByCityNameBuilder(cityName)
        when:
        builder.countryCode(countryCode)
        builder.type(type)
        final def result = builder.getQuery()
        then:
        result.cityName == cityName
        result.type == type
        result.countryCode == countryCode
        result.language == null
        result.responseFormat == null
        result.unitFormat == null
        result.getRequestPart() == "q=cityName,ua&type=like"
    }
}
