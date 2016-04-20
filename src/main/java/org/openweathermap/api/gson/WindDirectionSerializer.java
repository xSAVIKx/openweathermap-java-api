package org.openweathermap.api.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.openweathermap.api.model.WindDirection;

import java.lang.reflect.Type;

public class WindDirectionSerializer implements JsonSerializer<WindDirection> {
    @Override
    public JsonElement serialize(WindDirection src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getDegree());
    }
}
