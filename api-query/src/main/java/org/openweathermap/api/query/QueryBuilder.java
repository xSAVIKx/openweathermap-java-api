package org.openweathermap.api.query;

public abstract class QueryBuilder<T extends QueryBuilder<T, E>, E extends Query> {
    protected abstract T self();

    protected abstract E getQuery();

    public E build() {
        return getQuery();
    }

    public T language(Language language) {
        getQuery().setLanguage(language);
        return self();
    }

    public T unitFormat(UnitFormat unitFormat) {
        getQuery().setUnitFormat(unitFormat);
        return self();
    }

    /**
     * Sets the base URL of the query to the specified {@code baseURL}.
     *
     * @param baseUrl the base URL the query uses to connect to the API
     * @return this builder
     */
    public T baseUrl(String baseUrl) {
        getQuery().setBaseUrl(baseUrl);
        return self();
    }
}
