package org.openweathermap.api.query;

import lombok.Data;

@Data
public abstract class AbstractQuery implements Query {
    private ResponseFormat responseFormat;
    private UnitFormat unitFormat;
    private Language language;
}
