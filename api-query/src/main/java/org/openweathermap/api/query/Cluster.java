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

public enum Cluster {
    YES("yes"), NO("no");
    private final String stringRepresentation;

    Cluster(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    public static Cluster fromStringRepresentation(String stringRepresentation) {
        for (Cluster cluster : values()) {
            if (cluster.stringRepresentation.equals(stringRepresentation)) {
                return cluster;
            }
        }
        throw new IllegalArgumentException("No Cluster was found with value:" + stringRepresentation);
    }

    public String getStringRepresentation() {
        return stringRepresentation;
    }
}
