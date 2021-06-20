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
import org.openweathermap.api.query.Cluster
import spock.lang.Specification

class InCycleBuilderSpockTest extends Specification {

    def "should create InCycle query"() {
        given:
        final def expectedNumberOfCities = 10
        final def centerPoint = new Coordinate("1", "2")
        final def builder = new InCycleBuilder(centerPoint, expectedNumberOfCities)
        builder.cluster(Cluster.YES)
        when:
        final def result = builder.getQuery()
        then:
        result.expectedNumberOfCities == expectedNumberOfCities
        result.centerPoint == centerPoint
        result.language == null
        result.unitFormat == null
        result.cluster == Cluster.YES
        result.getRequestPart() == 'lat=2&lon=1&cnt=10&cluster=yes'
        result.getSearchPath() == '/find'
        builder == builder.self()
    }

}
