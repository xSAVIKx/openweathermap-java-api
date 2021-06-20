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

import lombok.Data;

@Data
public abstract class AbstractQuery implements Query {

    @SuppressWarnings({"FieldCanBeLocal", "FieldMayBeFinal"}) /* We'd like to be able to override the base URL. */
    private String baseUrl = BASE_URL;
    private UnitFormat unitFormat;
    private Language language;

    @Override
    public String toStringRepresentation(String apiKey) {
        StringBuilder stringBuilder = new StringBuilder(baseUrl);
        stringBuilder.append(getSearchPath());
        stringBuilder.append(QUESTION_MARK);
        if (getLanguage() != null) {
            stringBuilder.append("lang=").append(getLanguage().getStringRepresentation()).append(AND);
        }
        if (getUnitFormat() != null) {
            stringBuilder.append("units=").append(getUnitFormat().getStringRepresentation()).append(AND);
        }
        stringBuilder.append(getRequestPart());
        stringBuilder.append(AND).append("appid=").append(apiKey);
        return stringBuilder.toString();
    }

    protected abstract String getSearchPath();

    protected abstract String getRequestPart();
}
