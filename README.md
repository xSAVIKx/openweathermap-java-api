# openweathermap-java-api [![Build Status](https://travis-ci.org/xSAVIKx/openweathermap-java-api.svg?branch=master)](https://travis-ci.org/xSAVIKx/openweathermap-java-api) [ ![Download](https://api.bintray.com/packages/xsavikx/openweathermap-java-api/api-core/images/download.svg) ](https://bintray.com/xsavikx/openweathermap-java-api/api-core/_latestVersion) [![codecov](https://codecov.io/gh/xSAVIKx/openweathermap-java-api/branch/master/graph/badge.svg)](https://codecov.io/gh/xSAVIKx/openweathermap-java-api)


To use the OpenweatherMap API, you need to obtain an API key.  Sign up [here](http://home.openweathermap.org/users/sign_up).

# Features

## Current weather queries

### Call current weather data for one location

- By city name
- By city ID
- By ZIP code
- By geographic coordinates

### Call current weather data for several cities

- Cities within a rectangle zone
- Cities in cycle
- Call for several city IDs

## Forecast queries

### Call 5 day / 3 hour forecast data

- By city name
- By city ID
- By geographic coordinates

### Call 16 day / daily forecast data

- By city name
- By city ID
- By geographic coordinates

## Supported Languages

ENGLISH("en"),
RUSSIAN("ru"),
ITALIAN("it"),
SPANISH("sp"),
UKRAINIAN("ua"),
GERMAN("de"),
PORTUGUESE("pt"),
ROMANIAN("ro"),
POLISH("pl"),
FINNISH("fi"),
DUTCH("nl"),
FRENCH("fr"),
BULGARIAN("bg"),
SWEDISH("sv"),
CHINESE_TRADITIONAL("zh_tw"),
CHINESE_SIMPLIFIED("zh_cn"),
TURKISH("tr"),
CROATIAN("hr"),
CATALAN("ca");

## Supported formats

- JSON (result as String or as WeatherInfo object)
- XML (result only as String now)
- HTML (result only as String)

## Supported Units format

- Standart
- Metric
- Imperial

More information about weather parameters and unit can be found [here](http://openweathermap.org/weather-data).

## Examples

Take a look at [examples module](./api-examples)