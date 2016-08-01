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
