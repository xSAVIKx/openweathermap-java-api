package org.openweathermap.api.query.forecast;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openweathermap.api.query.AbstractQueryWithResponseFormat;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class AbstractForecastQuery extends AbstractQueryWithResponseFormat implements ForecastQuery {
    private int count;

    @Override
    protected String getSearchPath() {
        return ForecastQuery.SEARCH_PATH;
    }

    @Override
    public String toStringRepresentation(String apiKey) {
        StringBuilder stringBuilder = new StringBuilder(super.toStringRepresentation(apiKey));
        if (getCount() > 0) {
            stringBuilder.append(AND).append("cnt=").append(getCount());
        }
        return stringBuilder.toString();
    }
}
