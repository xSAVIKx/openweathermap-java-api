/*
 *    Copyright 2021, Yurii Serhiichuk
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

package org.openweathermap.api.query


import spock.lang.Specification

class AbstractQuerySpockTest extends Specification {

    def "should expose public APIs of the `Query` interface"() {
        given:
        def baseUrl = "some-base"
        def requestPart = "/help/me"
        def searchPath = "id=test"
        def query = new TheQuery()
        query.setBaseUrl(baseUrl)
        query.setRequestPart(requestPart)
        query.setSearchPath(searchPath)
        query.setLanguage(Language.BULGARIAN)
        query.setUnitFormat(UnitFormat.STANDARD)
        expect:
        query.getBaseUrl() == baseUrl
        query.getRequestPart() == requestPart
        query.getSearchPath() == searchPath
        query.getLanguage() == Language.BULGARIAN
        query.getUnitFormat() == UnitFormat.STANDARD
    }
}
