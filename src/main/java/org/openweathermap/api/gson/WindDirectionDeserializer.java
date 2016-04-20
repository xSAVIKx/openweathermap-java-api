package org.openweathermap.api.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.openweathermap.api.model.WindDirection;

import java.lang.reflect.Type;

public class WindDirectionDeserializer implements JsonDeserializer<WindDirection> {
    @Override
    public WindDirection deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        int degree = json.getAsJsonPrimitive().getAsInt();
        WindDirection windDirection = new WindDirection();
        windDirection.setDegree(degree);
        return windDirection;
    }
}
