package org.openweathermap.api.query

import spock.lang.Specification
import spock.lang.Unroll


class QueryRequestPartBuilderSpockTest extends Specification {
    @Unroll
    def "should create byCityName request part for #cityName, #countryCode, #type and be equal to #expectedResult"() {
        expect:
        QueryRequestPartBuilder.byCityName(cityName, countryCode, type) == expectedResult

        where:
        cityName  | countryCode | type          | expectedResult
        "kharkiv" | "ua"        | Type.ACCURATE | "q=kharkiv,ua&type=accurate"
        "kharkiv" | ""          | Type.LIKE     | "q=kharkiv&type=like"
        "kharkiv" | "ua"        | null          | "q=kharkiv,ua"
        "kharkiv" | null        | null          | "q=kharkiv"
    }
}
