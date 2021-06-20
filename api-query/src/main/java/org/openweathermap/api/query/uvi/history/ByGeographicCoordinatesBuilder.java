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

package org.openweathermap.api.query.uvi.history;

import org.openweathermap.api.common.Coordinate;
import org.openweathermap.api.query.uvi.UviQueryBuilder;

public class ByGeographicCoordinatesBuilder
        extends UviQueryBuilder<ByGeographicCoordinatesBuilder, ByGeographicCoordinates> {
    private final ByGeographicCoordinates query;

    public ByGeographicCoordinatesBuilder(Coordinate coordinate) {
        query = new ByGeographicCoordinates(coordinate);
    }

    @Override
    protected ByGeographicCoordinatesBuilder self() {
        return this;
    }

    @Override
    protected ByGeographicCoordinates getQuery() {
        return query;
    }

    public ByGeographicCoordinatesBuilder count(int count) {
        getQuery().setCount(count);
        return self();
    }

    public ByGeographicCoordinatesBuilder start(long start) {
        getQuery().setStart(start);
        return self();
    }

    public ByGeographicCoordinatesBuilder end(long end) {
        getQuery().setEnd(end);
        return self();
    }
}
