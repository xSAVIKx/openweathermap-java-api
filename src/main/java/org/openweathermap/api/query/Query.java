package org.openweathermap.api.query;

/**
 * Created by iuriis on 22.03.2016.
 */
public interface Query {
    String BASE_URL = "http://api.openweathermap.org";

    String QUESTION_MARK = "?";
    String AND = "&";

    String toStringRepresentation(String apiKey);

    Language getLanguage();

    void setLanguage(Language language);

    UnitFormat getUnitFormat();

    void setUnitFormat(UnitFormat unitFormat);

    ResponseFormat getResponseFormat();

    void setResponseFormat(ResponseFormat responseFormat);
}
