package org.openweathermap.api.query;

/**
 * Created by iuriis on 22.03.2016.
 */
public class QueryBuilder {
    private Query query;

    private QueryBuilder(Query query) {
        this.query = query;
    }

    public static CurrentWeatherQueryBuilder byCityId(String cityId) {
        return new CurrentWeatherQueryBuilder(new ByCityId(cityId));
    }

    public Query build() {
        return query;
    }

    public QueryBuilder language(Language language) {
        query.setLanguage(language);
        return this;
    }

    public QueryBuilder unitFormat(UnitFormat unitFormat) {
        query.setUnitFormat(unitFormat);
        return this;
    }

    public QueryBuilder responseFormat(ResponseFormat responseFormat) {
        query.setResponseFormat(responseFormat);
        return this;
    }

    private static class CurrentWeatherQueryBuilder extends QueryBuilder {
        private CurrentWeatherQueryBuilder(CurrentWeatherQuery query) {
            super(query);
        }

        @Override
        public CurrentWeatherQuery build() {
            return (CurrentWeatherQuery) super.build();
        }

        @Override
        public CurrentWeatherQueryBuilder language(Language language) {
            return (CurrentWeatherQueryBuilder) super.language(language);
        }

        @Override
        public CurrentWeatherQueryBuilder unitFormat(UnitFormat unitFormat) {
            return (CurrentWeatherQueryBuilder) super.unitFormat(unitFormat);
        }

        @Override
        public CurrentWeatherQueryBuilder responseFormat(ResponseFormat responseFormat) {
            return (CurrentWeatherQueryBuilder) super.responseFormat(responseFormat);
        }
    }
}
