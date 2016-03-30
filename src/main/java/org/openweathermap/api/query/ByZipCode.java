package org.openweathermap.api.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ByZipCode extends AbstractCurrentWeatherQuery {
    private final String zipCode;
    private final String countryCode;

    public ByZipCode(String zipCode, String countryCode) {
        this.zipCode = zipCode;
        this.countryCode = countryCode;
    }

    @Override
    protected String getRequestPart() {
        return String.format("zip=%s,%s", zipCode, countryCode);
    }

}
