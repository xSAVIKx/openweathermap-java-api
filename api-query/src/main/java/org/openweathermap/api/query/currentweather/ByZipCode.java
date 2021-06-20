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

package org.openweathermap.api.query.currentweather;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ByZipCode extends AbstractCurrentWeatherOneLocationQuery {
    private final String zipCode;
    private final String countryCode;

    public ByZipCode(String zipCode, String countryCode) {
        this.zipCode = zipCode;
        this.countryCode = countryCode;
    }

    @Override
    protected String getRequestPart() {
        return String.format("zip=%s,%s", zipCode, countryCode);
    }

}
