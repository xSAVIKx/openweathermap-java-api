package org.openweathermap.api.query;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openweathermap.api.model.Coordinate;


@EqualsAndHashCode(callSuper = true)
@Data
public class ByRectangleZone extends AbstractQuery implements CurrentWeatherManyLocationsQuery {
    private Coordinate leftBottom;
    private Coordinate rightTop;
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
        stringBuilder.append(leftBottom.getLongitude()).append(',').append(leftBottom.getLatitude()).append(',').append(rightTop.getLongitude()).append(',').append(rightTop.getLatitude());
        if (cluster != null) {
            stringBuilder.append(AND).append("cluster=").append(cluster.getStringRepresentation());
        }
        return stringBuilder.toString();
    }

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
}
