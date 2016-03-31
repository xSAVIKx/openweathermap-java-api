package org.openweathermap.api.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class AbstractCurrentWeatherOneLocationQuery extends AbstractQuery implements CurrentWeatherOneLocationQuery {
    private ResponseFormat responseFormat;

    protected String getSearchPath() {
        return CurrentWeatherOneLocationQuery.SEARCH_PATH;
    }

    @Override
    public String toStringRepresentation(String apiKey) {
        StringBuilder stringBuilder = new StringBuilder(super.toStringRepresentation(apiKey));
        if (getResponseFormat() != null) {
            stringBuilder.append(AND).append("mode=").append(getResponseFormat().getStringRepresentation());
        }
        return stringBuilder.toString();
    }
}
