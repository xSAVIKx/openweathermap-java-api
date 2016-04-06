package org.openweathermap.api.query;

import org.apache.commons.lang3.StringUtils;

import static org.openweathermap.api.query.Query.AND;

public final class QueryRequestPartBuilder {
    public static String byCityName(CharSequence cityName, CharSequence countryCode, Type type) {
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
}
