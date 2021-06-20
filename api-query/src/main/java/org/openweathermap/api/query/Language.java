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

public enum Language {
    ENGLISH("en"),
    RUSSIAN("ru"),
    ITALIAN("it"),
    SPANISH("sp"),
    UKRAINIAN("ua"),
    GERMAN("de"),
    PORTUGUESE("pt"),
    ROMANIAN("ro"),
    POLISH("pl"),
    FINNISH("fi"),
    DUTCH("nl"),
    FRENCH("fr"),
    BULGARIAN("bg"),
    SWEDISH("sv"),
    CHINESE_TRADITIONAL("zh_tw"),
    CHINESE_SIMPLIFIED("zh_cn"),
    TURKISH("tr"),
    CROATIAN("hr"),
    CATALAN("ca");
    private final String stringRepresentation;

    Language(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    public static Language fromStringRepresentation(String stringRepresentation) {
        for (Language language : values()) {
            if (language.stringRepresentation.equals(stringRepresentation)) {
                return language;
            }
        }
        throw new IllegalArgumentException("No Language was found with value:" + stringRepresentation);
    }

    public String getStringRepresentation() {
        return stringRepresentation;
    }
}
