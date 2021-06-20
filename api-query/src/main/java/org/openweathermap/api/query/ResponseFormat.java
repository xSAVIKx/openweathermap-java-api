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

public enum ResponseFormat {
    JSON("json"),
    XML("xml"),
    HTML("html");
    private final String stringRepresentation;

    ResponseFormat(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    public static ResponseFormat fromStringRepresentation(String stringRepresentation) {
        for (ResponseFormat responseFormat : values()) {
            if (responseFormat.stringRepresentation.equals(stringRepresentation)) {
                return responseFormat;
            }
        }
        throw new IllegalArgumentException("No ResponseFormat was found with value:" + stringRepresentation);
    }

    public String getStringRepresentation() {
        return stringRepresentation;
    }
}
