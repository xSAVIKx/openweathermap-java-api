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
