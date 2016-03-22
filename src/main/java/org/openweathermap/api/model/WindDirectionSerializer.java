package org.openweathermap.api.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * Created by iuriis on 22.03.2016.
 */
public class WindDirectionSerializer implements JsonSerializer<WindDirection> {
    @Override
    public JsonElement serialize(WindDirection src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getDegree());
    }
}
