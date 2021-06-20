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

package org.openweathermap.api.query.uvi.forecast;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openweathermap.api.common.Coordinate;
import org.openweathermap.api.query.uvi.AbstractByGeographicCoordinates;

@EqualsAndHashCode(callSuper = true)
@Data
public class ByGeographicCoordinates extends AbstractByGeographicCoordinates implements ForecastUviQuery {
    private int count;

    public ByGeographicCoordinates(Coordinate coordinate) {
        super(coordinate);
    }

    @Override
    protected String getSearchPath() {
        return super.getSearchPath() + FORECAST;
    }

    @Override
    public String toStringRepresentation(String apiKey) {
        StringBuilder stringBuilder = new StringBuilder(super.toStringRepresentation(apiKey));
        if (getCount() > 0) {
            stringBuilder.append(AND).append("cnt=").append(getCount());
        }
        return stringBuilder.toString();
    }
}
