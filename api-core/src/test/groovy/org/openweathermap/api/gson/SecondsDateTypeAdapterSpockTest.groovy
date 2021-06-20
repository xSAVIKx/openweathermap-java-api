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

import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import spock.lang.Specification

import java.util.concurrent.TimeUnit


class SecondsDateTypeAdapterSpockTest extends Specification {
    SecondsDateTypeAdapter adapter = new SecondsDateTypeAdapter()

    def "should write Date into JsonWriter as long"() {
        given:
        final def jsonWriter = Mock(JsonWriter)
        final def date = new Date(116, 5, 5)
        when:
        adapter.write(jsonWriter, date)
        then:
        1 * jsonWriter.value(_ as Long)

    }

    def "should write null into JsonWriter when date is null"() {
        given:
        final def jsonWriter = Mock(JsonWriter)
        final def date = null
        when:
        adapter.write(jsonWriter, date)
        then:
        1 * jsonWriter.nullValue()
    }

    def "should return null when reading null from JsonReader"() {
        given:
        final def jsonReader = Mock(JsonReader)
        when:
        final def actual = adapter.read(jsonReader)
        then:
        1 * jsonReader.peek() >> JsonToken.NULL
        1 * jsonReader.nextNull()
        actual == null
    }

    def "should return Date when reading seconds from JsonReader"() {
        given:
        final def jsonReader = Mock(JsonReader)
        final def timeInSeconds = 1465074000L
        when:
        final def actual = adapter.read(jsonReader)
        then:
        1 * jsonReader.peek() >> JsonToken.NUMBER
        1 * jsonReader.nextLong() >> timeInSeconds
        actual.getTime() == TimeUnit.SECONDS.toMillis(timeInSeconds)
    }
}
