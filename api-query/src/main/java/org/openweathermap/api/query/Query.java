package org.openweathermap.api.query;

public interface Query {

    /**
     * The base URL of the OpenWeatherMap API.
     */
    String BASE_URL = "https://api.openweathermap.org/data/2.5";

    String QUESTION_MARK = "?";
    String AND = "&";

    String toStringRepresentation(String apiKey);

    Language getLanguage();

    void setLanguage(Language language);

    UnitFormat getUnitFormat();

    void setUnitFormat(UnitFormat unitFormat);

    /**
     * Returns the base URL of the query.
     */
    String getBaseUrl();

    /**
     * Sets the base URL of the query to the specified {@code baseURL}.
     *
     * @param baseUrl the base URL the query uses to connect to the API
     */
    void setBaseUrl(String baseUrl);
}
