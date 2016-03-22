package org.openweathermap.api.query;

/**
 * Created by iuriis on 22.03.2016.
 */
public abstract class AbstractQuery implements Query {
    private ResponseFormat responseFormat;
    private UnitFormat unitFormat;
    private Language language;

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public UnitFormat getUnitFormat() {
        return unitFormat;
    }

    public void setUnitFormat(UnitFormat unitFormat) {
        this.unitFormat = unitFormat;
    }


    public ResponseFormat getResponseFormat() {
        return responseFormat;
    }

    public void setResponseFormat(ResponseFormat responseFormat) {
        this.responseFormat = responseFormat;
    }
}
