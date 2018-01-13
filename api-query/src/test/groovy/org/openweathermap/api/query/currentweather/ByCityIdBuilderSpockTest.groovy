package org.openweathermap.api.query.currentweather

import org.openweathermap.api.query.Language
import org.openweathermap.api.query.ResponseFormat
import org.openweathermap.api.query.UnitFormat
import spock.lang.Specification

class ByCityIdBuilderSpockTest extends Specification {

    def "should create ByCityId query"() {
        given:
        final def cityId = "cityId"
        final def builder = new ByCityIdBuilder(cityId)
        builder.language(Language.ENGLISH)
        builder.responseFormat(ResponseFormat.HTML)
        builder.unitFormat(UnitFormat.IMPERIAL)
        when:
        final def result = builder.getQuery()
        then:
        result.cityId == cityId
        result.language == Language.ENGLISH
        result.responseFormat == ResponseFormat.HTML
        result.unitFormat == UnitFormat.IMPERIAL
        result.getRequestPart() == "id=cityId"
        builder == builder.self()
        result.toStringRepresentation('apiKey') == 'http://api.openweathermap.org/data/2.5/weather?lang=en&units=imperial&id=cityId&appid=apiKey&mode=html'
    }
}
