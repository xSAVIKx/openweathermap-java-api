package org.openweathermap.api.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SecondsDateTypeAdapter extends TypeAdapter<Date> {

    @Override
    public void write(JsonWriter out, Date value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        out.value(TimeUnit.MILLISECONDS.toSeconds(value.getTime()));
    }

    @Override
    public Date read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        long timeInSeconds = in.nextLong();
        long timeInMillis = TimeUnit.SECONDS.toMillis(timeInSeconds);
        return new Date(timeInMillis);
    }
}
