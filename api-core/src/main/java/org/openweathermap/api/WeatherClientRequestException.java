package org.openweathermap.api;

public class WeatherClientRequestException extends RuntimeException {

    private static final long serialVersionUID = -4756475257326496398L;

    public WeatherClientRequestException() {
    }

    public WeatherClientRequestException(String s) {
        super(s);
    }

    public WeatherClientRequestException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public WeatherClientRequestException(Throwable throwable) {
        super(throwable);
    }

    public WeatherClientRequestException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
