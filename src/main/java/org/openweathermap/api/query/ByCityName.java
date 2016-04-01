package org.openweathermap.api.query;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

@EqualsAndHashCode(callSuper = true)
@Data
public class ByCityName extends AbstractCurrentWeatherOneLocationQuery {
    private final String cityName;
    private String countryCode;
    private Type type;

    public ByCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    protected String getRequestPart() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("q=").append(cityName);
        if (StringUtils.isNotBlank(countryCode)) {
            stringBuilder.append(',').append(countryCode);
        }
        if (type != null) {
            stringBuilder.append(AND).append("type=").append(type.getStringRepresentation());
        }
        return stringBuilder.toString();
    }

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
            throw new IllegalArgumentException("No Cluster was found with value:" + stringRepresentation);
        }

        public String getStringRepresentation() {
            return stringRepresentation;
        }
    }
}
