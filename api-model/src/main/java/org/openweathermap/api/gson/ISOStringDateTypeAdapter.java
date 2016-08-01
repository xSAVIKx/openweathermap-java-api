package org.openweathermap.api.gson;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ISOStringDateTypeAdapter extends TypeAdapter<Date> {
    private static final String ISO_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(ISO_DATE_FORMAT);

    @Override
    public void write(JsonWriter out, Date value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        String dateFormatAsString = SIMPLE_DATE_FORMAT.format(value);
        out.value(dateFormatAsString);
    }

    @Override
    public Date read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        String json = in.nextString();
        try {
            return SIMPLE_DATE_FORMAT.parse(json);
        } catch (ParseException e) {
            throw new JsonSyntaxException(json, e);
        }
    }
}
