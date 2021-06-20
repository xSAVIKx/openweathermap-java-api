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

import org.openweathermap.api.query.Type;

public class ByCityNameBuilder extends CurrentWeatherOneLocationQueryBuilder<ByCityNameBuilder, ByCityName> {
    private final ByCityName query;

    public ByCityNameBuilder(String cityName) {
        query = new ByCityName(cityName);
    }

    public ByCityNameBuilder countryCode(String countryCode) {
        query.setCountryCode(countryCode);
        return self();
    }

    public ByCityNameBuilder type(Type type) {
        query.setType(type);
        return self();
    }

    @Override
    protected ByCityNameBuilder self() {
        return this;
    }

    @Override
    protected ByCityName getQuery() {
        return query;
    }
}
