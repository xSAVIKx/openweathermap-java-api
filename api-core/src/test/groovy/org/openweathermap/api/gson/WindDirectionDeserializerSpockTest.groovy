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

import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import spock.lang.Specification

class WindDirectionDeserializerSpockTest extends Specification {
    def "should deserialize WindDirection from JsonElement"() {
        given:
        final def degree = 123
        final def jsonPrimitive = new JsonPrimitive(degree)
        final def jsonElement = Mock(JsonElement)
        final def deserializer = new WindDirectionDeserializer()
        when:
        final def result = deserializer.deserialize(jsonElement, null, null)
        then:
        1 * jsonElement.getAsJsonPrimitive() >> jsonPrimitive
        result != null
        result.degree == degree
    }
}
