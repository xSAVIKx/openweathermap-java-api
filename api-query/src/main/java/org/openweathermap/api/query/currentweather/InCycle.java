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
import org.openweathermap.api.common.Coordinate;
import org.openweathermap.api.query.AbstractQuery;
import org.openweathermap.api.query.Cluster;

@EqualsAndHashCode(callSuper = true)
@Data
public class InCycle extends AbstractQuery implements CurrentWeatherMultipleLocationsQuery {
    private final Coordinate centerPoint;
    private final int expectedNumberOfCities;
    private Cluster cluster;

    public InCycle(Coordinate centerPoint, int expectedNumberOfCities) {
        this.centerPoint = centerPoint;
        this.expectedNumberOfCities = expectedNumberOfCities;
    }

    @Override
    protected String getSearchPath() {
        return "/find";
    }

    @Override
    protected String getRequestPart() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("lat=").append(centerPoint.getLatitude()).append(AND);
        stringBuilder.append("lon=").append(centerPoint.getLongitude()).append(AND);
        stringBuilder.append("cnt=").append(expectedNumberOfCities);
        if (cluster != null) {
            stringBuilder.append(AND).append("cluster=").append(cluster.getStringRepresentation());
        }
        return stringBuilder.toString();
    }
}
