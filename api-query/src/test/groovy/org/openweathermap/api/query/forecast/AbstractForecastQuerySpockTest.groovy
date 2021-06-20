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

package org.openweathermap.api.query.forecast

import org.openweathermap.api.query.forecast.hourly.ByCityId
import spock.lang.Specification


class AbstractForecastQuerySpockTest extends Specification {
    def "should return searchPath"() {
        given:
        final AbstractForecastQuery query = new ByCityId('')
        expect:
        query.getSearchPath() == '/forecast'
    }

    def "should create toStringRepresentation"() {
        given:
        final AbstractForecastQuery query = new ByCityId('')
        expect:
        query.toStringRepresentation('apiKey') == 'https://api.openweathermap.org/data/2.5/forecast?id=&appid=apiKey'
    }
}