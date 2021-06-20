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

package org.openweathermap.api.query.forecast.hourly

import org.openweathermap.api.query.Type
import spock.lang.Specification

class ByCityNameBuilderSpockTest extends Specification {
    def "should create ByCityName query"() {
        given:
        final def apiKey = 'apiKey'
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
        builder == builder.self()
        result.getRequestPart() == "q=${cityName},${countryCode}&type=${type.stringRepresentation}"
        result.toStringRepresentation(apiKey) == "https://api.openweathermap.org/data/2.5/forecast?q=${cityName},${countryCode}&type=${type.stringRepresentation}&appid=${apiKey}"
    }
}
