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
public class ByRectangleZone extends AbstractQuery implements CurrentWeatherMultipleLocationsQuery {
    private final Coordinate leftBottom;
    private final Coordinate rightTop;
    private Cluster cluster;

    public ByRectangleZone(Coordinate leftBottom, Coordinate rightTop) {
        this.leftBottom = leftBottom == null ? new Coordinate("", "") : leftBottom;
        this.rightTop = rightTop == null ? new Coordinate("", "") : rightTop;
    }

    @Override
    protected String getSearchPath() {
        return "/box/city";
    }

    @Override
    protected String getRequestPart() {
        StringBuilder stringBuilder = new StringBuilder("bbox=");
        stringBuilder.append(leftBottom.getLongitude()).append(',').append(leftBottom.getLatitude()).append(',');
        stringBuilder.append(rightTop.getLongitude()).append(',').append(rightTop.getLatitude());
        if (cluster != null) {
            stringBuilder.append(AND).append("cluster=").append(cluster.getStringRepresentation());
        }
        return stringBuilder.toString();
    }
}
