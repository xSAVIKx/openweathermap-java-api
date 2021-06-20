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


class QueryRequestPartBuilderSpockTest extends Specification {
    @Unroll
    def "should create byCityName request part for #cityName, #countryCode, #type and be equal to #expectedResult"() {
        expect:
        QueryRequestPartBuilder.byCityName(cityName, countryCode, type) == expectedResult

        where:
        cityName  | countryCode | type          | expectedResult
        "kharkiv" | "ua"        | Type.ACCURATE | "q=kharkiv,ua&type=accurate"
        "kharkiv" | ""          | Type.LIKE     | "q=kharkiv&type=like"
        "kharkiv" | "ua"        | null          | "q=kharkiv,ua"
        "kharkiv" | null        | null          | "q=kharkiv"
    }
}
