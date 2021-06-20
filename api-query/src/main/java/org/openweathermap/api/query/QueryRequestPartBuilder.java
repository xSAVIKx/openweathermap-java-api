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

import org.apache.commons.lang3.StringUtils;

import static org.openweathermap.api.query.Query.AND;

public final class QueryRequestPartBuilder {
    public static String byCityName(CharSequence cityName, CharSequence countryCode, Type type) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("q=").append(cityName);
        if (StringUtils.isNotBlank(countryCode)) {
            stringBuilder.append(',').append(countryCode);
        }
        if (type != null) {
            stringBuilder.append(AND).append("type=").append(type.getStringRepresentation());
        }
        return stringBuilder.toString();
    }
}
