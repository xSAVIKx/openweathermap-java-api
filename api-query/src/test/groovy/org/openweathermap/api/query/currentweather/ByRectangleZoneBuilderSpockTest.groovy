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

class ByRectangleZoneBuilderSpockTest extends Specification {
    def "should create ByRectangleZone query"() {
        given:
        final def cluster = Cluster.NO
        final def leftBottom = new Coordinate("2", "3")
        final def rightTop = new Coordinate("1", "4")
        final def builder = new ByRectangleZoneBuilder(leftBottom, rightTop)
        when:
        builder.cluster(cluster)
        final def result = builder.getQuery()
        then:
        result.cluster == cluster
        result.leftBottom == leftBottom
        result.rightTop == rightTop
        result.language == null
        result.unitFormat == null
        builder == builder.self()
        result.getSearchPath() == '/box/city'
        result.getRequestPart() == 'bbox=2,3,1,4&cluster=no'
    }
}
