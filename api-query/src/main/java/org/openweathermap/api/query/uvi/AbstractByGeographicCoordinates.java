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

package org.openweathermap.api.query.uvi;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openweathermap.api.common.Coordinate;
import org.openweathermap.api.query.AbstractQuery;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class AbstractByGeographicCoordinates extends AbstractQuery implements UviQuery {
    private final Coordinate coordinate;

    protected AbstractByGeographicCoordinates(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    protected String getRequestPart() {
        return String.format("lat=%s&lon=%s", coordinate.getLatitude(), coordinate.getLongitude());
    }

    @Override
    protected String getSearchPath() {
        return UviQuery.SEARCH_PATH;
    }
}
