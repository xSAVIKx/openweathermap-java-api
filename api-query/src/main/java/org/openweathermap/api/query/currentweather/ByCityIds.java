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
import org.apache.commons.lang3.StringUtils;
import org.openweathermap.api.query.AbstractQuery;

import java.util.ArrayList;
import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@Data
public class ByCityIds extends AbstractQuery implements CurrentWeatherMultipleLocationsQuery {
    private final Collection<String> cityIds;

    public ByCityIds(Collection<String> cityIds) {
        this.cityIds = cityIds;
    }

    public ByCityIds() {
        this.cityIds = new ArrayList<>();
    }

    public boolean addCityId(String cityId) {
        return cityIds.add(cityId);
    }

    @Override
    protected String getSearchPath() {
        return "/group";
    }

    @Override
    protected String getRequestPart() {
        return "id=" + StringUtils.join(cityIds, ',');
    }
}
