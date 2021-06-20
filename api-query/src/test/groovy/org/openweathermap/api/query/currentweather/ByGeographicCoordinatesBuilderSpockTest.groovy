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

import org.openweathermap.api.common.Coordinate
import spock.lang.Specification


class ByGeographicCoordinatesBuilderSpockTest extends Specification {
    def "should create ByGeographicCoordinates query"() {
        given:
        final def longitude = "1"
        final def latitude = "2"
        final def coordinate = new Coordinate(longitude, latitude)
        final def builder = new ByGeographicCoordinatesBuilder(coordinate)
        when:
        final def result = builder.getQuery()
        then:
        result.coordinate == coordinate
        result.language == null
        result.responseFormat == null
        result.unitFormat == null
        builder == builder.self()
        result.getRequestPart() == "lat=2&lon=1"
    }
}
