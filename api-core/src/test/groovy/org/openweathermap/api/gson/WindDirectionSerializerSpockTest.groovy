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

package org.openweathermap.api.gson

import org.openweathermap.api.model.WindDirection
import spock.lang.Specification


class WindDirectionSerializerSpockTest extends Specification {
    def "should serialize WindDirection into int value"() {
        given:
        final def degree = 123
        final def windDirection = new WindDirection(degree: degree)
        final def serializer = new WindDirectionSerializer()
        when:
        final def result = serializer.serialize(windDirection, null, null)
        then:
        result != null
        result.getAsInt() == degree
    }
}
