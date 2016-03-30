package org.openweathermap.api.query;

public abstract class AbstractCurrentWeatherQuery extends AbstractQuery implements CurrentWeatherQuery {
    @Override
    public String toStringRepresentation(String apiKey) {
        StringBuilder stringBuilder = new StringBuilder(BASE_URL);
        stringBuilder.append(SEARCH_PATH);
        stringBuilder.append(QUESTION_MARK);
        if (getLanguage() != null) {
            stringBuilder.append("lang=").append(getLanguage().getStringRepresentation()).append(AND);
        }
        if (getResponseFormat() != null) {
            stringBuilder.append("mode=").append(getResponseFormat().getStringRepresentation()).append(AND);
        }
        if (getUnitFormat() != null) {
            stringBuilder.append("units=").append(getUnitFormat().getStringRepresentation()).append(AND);
        }
        stringBuilder.append(getRequestPart());
        stringBuilder.append(AND).append("appid=").append(apiKey);
        return stringBuilder.toString();
    }

    protected abstract String getRequestPart();
}
