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

package org.openweathermap.api.query;

public interface Query {

    /**
     * The base URL of the OpenWeatherMap API.
     */
    String BASE_URL = "https://api.openweathermap.org/data/2.5";

    String QUESTION_MARK = "?";
    String AND = "&";

    String toStringRepresentation(String apiKey);

    Language getLanguage();

    void setLanguage(Language language);

    UnitFormat getUnitFormat();

    void setUnitFormat(UnitFormat unitFormat);

    /**
     * Returns the base URL of the query.
     */
    String getBaseUrl();

    /**
     * Sets the base URL of the query to the specified {@code baseURL}.
     *
     * @param baseUrl the base URL the query uses to connect to the API
     */
    void setBaseUrl(String baseUrl);
}
