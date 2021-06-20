/*
 * Copyright 2021, Yurii Serhiichuk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

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
        result.toStringRepresentation('apiKey') == 'https://api.openweathermap.org/data/2.5/weather?lang=en&units=imperial&id=cityId&appid=apiKey&mode=html'
    }
}
