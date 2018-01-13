package org.openweathermap.api.query

import org.openweathermap.api.common.Coordinate
import org.openweathermap.api.query.currentweather.*
import spock.lang.Specification

class QueryBuilderPickerSpockTest extends Specification {
    def "should generate only one instance"() {
        given:
        final def picker = QueryBuilderPicker.pick()
        expect:
        picker == QueryBuilderPicker.pick()
        picker == QueryBuilderPicker.pick()
    }

    def "should create picker for current weather"() {
        expect:
        assert QueryBuilderPicker.pick().currentWeather() instanceof QueryBuilderPicker.CurrentWeatherPicker
        assert QueryBuilderPicker.pick().currentWeather().multipleLocations() instanceof QueryBuilderPicker.CurrentWeatherPicker.CurrentWeatherMultipleLocationsQueryPicker
        assert QueryBuilderPicker.pick().currentWeather().oneLocation() instanceof QueryBuilderPicker.CurrentWeatherPicker.CurrentWeatherOneLocationQueryPicker
    }

    def "current weather one location picker should create builders for current weather one location queries"() {
        given:
        final def picker = QueryBuilderPicker.pick().currentWeather().oneLocation()
        expect:
        assert picker.byCityId(null) instanceof ByCityIdBuilder
        assert picker.byCityName(null) instanceof ByCityNameBuilder
        assert picker.byGeographicCoordinates(new Coordinate()) instanceof ByGeographicCoordinatesBuilder
        assert picker.byZipCode(null, null) instanceof ByZipCodeBuilder
    }

    def "current weather multiple location picker should create builders for current weather multiple location queries"() {
        given:
        final def picker = QueryBuilderPicker.pick().currentWeather().multipleLocations()
        expect:
        assert picker.byCityIds() instanceof ByCityIdsBuilder
        assert picker.byCityIds([]) instanceof ByCityIdsBuilder
        assert picker.byRectangleZone(null, null) instanceof ByRectangleZoneBuilder
        assert picker.inCycle(null, 1) instanceof InCycleBuilder
    }

    def "should create picker for forecasts"() {
        expect:
        assert QueryBuilderPicker.pick().forecast() instanceof QueryBuilderPicker.ForecastPicker
        assert QueryBuilderPicker.pick().forecast().daily() instanceof QueryBuilderPicker.ForecastPicker.DailyForecastPicker
        assert QueryBuilderPicker.pick().forecast().hourly() instanceof QueryBuilderPicker.ForecastPicker.HourlyForecastPicker
    }

    def "daily forecasts picker should create builders for daily forecasts queries"() {
        given:
        final def picker = QueryBuilderPicker.pick().forecast().daily()
        expect:
        assert picker.byCityId(null) instanceof org.openweathermap.api.query.forecast.daily.ByCityIdBuilder
        assert picker.byCityName(null) instanceof org.openweathermap.api.query.forecast.daily.ByCityNameBuilder
        assert picker.byGeographicCoordinates(null) instanceof org.openweathermap.api.query.forecast.daily.ByGeographicCoordinatesBuilder
    }

    def "hourly forecasts picker should create builders for daily forecasts queries"() {
        given:
        final def picker = QueryBuilderPicker.pick().forecast().hourly()
        expect:
        assert picker.byCityId(null) instanceof org.openweathermap.api.query.forecast.hourly.ByCityIdBuilder
        assert picker.byCityName(null) instanceof org.openweathermap.api.query.forecast.hourly.ByCityNameBuilder
        assert picker.byGeographicCoordinates(null) instanceof org.openweathermap.api.query.forecast.hourly.ByGeographicCoordinatesBuilder
    }

}