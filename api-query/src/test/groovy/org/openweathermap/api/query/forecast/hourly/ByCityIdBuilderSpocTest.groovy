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
        result.toStringRepresentation(apiKey) == "https://api.openweathermap.org/data/2.5/forecast?id=${cityId}&appid=${apiKey}"
    }
}
