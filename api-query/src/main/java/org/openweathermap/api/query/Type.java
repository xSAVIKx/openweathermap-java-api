package org.openweathermap.api.query;

public enum Type {
    ACCURATE("accurate"), LIKE("like");
    private final String stringRepresentation;

    Type(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    public static Type fromStringRepresentation(String stringRepresentation) {
        for (Type type : values()) {
            if (type.stringRepresentation.equals(stringRepresentation)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No Type was found with value:" + stringRepresentation);
    }

    public String getStringRepresentation() {
        return stringRepresentation;
    }
}
