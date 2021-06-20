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

package org.openweathermap.api.query

import spock.lang.Specification
import spock.lang.Unroll


class LanguageSpockTest extends Specification {
    @Unroll
    def "fromStringRepresentation should return #expected for '#stringRepresentation'"() {
        expect:
        Language.fromStringRepresentation(stringRepresentation) == expected
        where:
        stringRepresentation || expected
        "ua"                 || Language.UKRAINIAN
        "ro"                 || Language.ROMANIAN
        "en"                 || Language.ENGLISH
    }

    def "fromStringRepresentation should throw IllegalArgumentException when no value is found"() {
        when:
        Language.fromStringRepresentation("noSuchValue")
        then:
        thrown(IllegalArgumentException)
    }
}
