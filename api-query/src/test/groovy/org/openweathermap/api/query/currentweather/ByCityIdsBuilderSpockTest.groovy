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
