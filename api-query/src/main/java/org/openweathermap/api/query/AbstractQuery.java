package org.openweathermap.api.query;

import lombok.Data;

@Data
public abstract class AbstractQuery implements Query {
    private UnitFormat unitFormat;
    private Language language;

    @Override
    public String toStringRepresentation(String apiKey) {
        StringBuilder stringBuilder = new StringBuilder(BASE_URL);
        stringBuilder.append(getSearchPath());
        stringBuilder.append(QUESTION_MARK);
        if (getLanguage() != null) {
            stringBuilder.append("lang=").append(getLanguage().getStringRepresentation()).append(AND);
        }
        if (getUnitFormat() != null) {
            stringBuilder.append("units=").append(getUnitFormat().getStringRepresentation()).append(AND);
        }
        stringBuilder.append(getRequestPart());
        stringBuilder.append(AND).append("appid=").append(apiKey);
        return stringBuilder.toString();
    }

    protected abstract String getSearchPath();

    protected abstract String getRequestPart();
}
