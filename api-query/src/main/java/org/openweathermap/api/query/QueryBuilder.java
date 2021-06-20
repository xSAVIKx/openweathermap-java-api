/*
 * Copyright 2021, Yurii Serhiichuk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.openweathermap.api.query;

/**
 * Represents a base for any {@link Query} builder and exposes the query itself as well as
 * parameters which are universal for every builder.
 *
 * @param <T> the type of the query builder
 * @param <E> the type of the query the builder is defined for
 */
public abstract class QueryBuilder<T extends QueryBuilder<T, E>, E extends Query> {
    /**
     * Returns a typed {@code this} reference.
     *
     * @return typed {@code this} refefence
     */
    protected abstract T self();

    /**
     * Returns the configured {@code query}.
     *
     * @return the configured {@code query}
     */
    protected abstract E getQuery();

    /**
     * Builds the {@code query}.
     *
     * @return a configured query
     */
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
