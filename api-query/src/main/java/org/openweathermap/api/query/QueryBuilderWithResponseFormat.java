package org.openweathermap.api.query;


public abstract class QueryBuilderWithResponseFormat<T extends QueryBuilderWithResponseFormat<T, E>, E extends QueryWithResponseFormat>
        extends QueryBuilder<T, E> {
    public T responseFormat(ResponseFormat responseFormat) {
        getQuery().setResponseFormat(responseFormat);
        return self();
    }
}
