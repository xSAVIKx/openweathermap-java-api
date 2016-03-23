package org.openweathermap.api.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class LocalDateTimeSerializer implements JsonSerializer<LocalDateTime> {
    @Override
    public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
        long sec = src.toInstant(ZoneOffset.UTC).getEpochSecond();
        return new JsonPrimitive(sec);
    }
}
