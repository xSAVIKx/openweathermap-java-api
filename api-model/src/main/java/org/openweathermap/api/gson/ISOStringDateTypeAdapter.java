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
import java.util.TimeZone;

public final class ISOStringDateTypeAdapter extends TypeAdapter<Date> {

    private static final String ISO_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";


    /* visible for tests */ static final ThreadLocal<SimpleDateFormat> DATE_FORMAT =
            new ThreadLocal<SimpleDateFormat>() {
                @Override
                protected SimpleDateFormat initialValue() {
                    SimpleDateFormat result = new SimpleDateFormat(ISO_DATE_FORMAT);
                    result.setTimeZone(TimeZone.getTimeZone("UTC"));
                    return result;
                }
            };

    @Override
    public void write(JsonWriter out, Date value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        String dateFormatAsString = DATE_FORMAT.get().format(value);
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
            return DATE_FORMAT.get().parse(json);
        } catch (ParseException e) {
            throw new JsonSyntaxException(json, e);
        }
    }
}
