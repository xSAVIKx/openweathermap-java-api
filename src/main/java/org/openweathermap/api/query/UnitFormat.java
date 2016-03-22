package org.openweathermap.api.query;

/**
 * Created by iuriis on 22.03.2016.
 */
public enum UnitFormat {
    STANDARD("standard"),
    IMPERIAL("imperial"),
    METRIC("metric");
    private final String stringRepresentation;

    UnitFormat(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    public static UnitFormat fromStringRepresentation(String stringRepresentation) {
        for (UnitFormat unitFormat : values()) {
            if (unitFormat.stringRepresentation.equals(stringRepresentation)) {
                return unitFormat;
            }
        }
        return null;
    }

    public String getStringRepresentation() {
        return stringRepresentation;
    }
}
