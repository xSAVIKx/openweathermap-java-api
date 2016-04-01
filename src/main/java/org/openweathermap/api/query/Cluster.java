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
