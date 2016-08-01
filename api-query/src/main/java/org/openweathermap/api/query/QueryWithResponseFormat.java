package org.openweathermap.api.query;

public interface QueryWithResponseFormat extends Query {
    ResponseFormat getResponseFormat();

    void setResponseFormat(ResponseFormat responseFormat);
}
