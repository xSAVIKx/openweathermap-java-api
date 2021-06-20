/*
 * Copyright 2021, Yurii Serhiichuk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.openweathermap.api;

import org.openweathermap.api.query.Query;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionDataWeatherClient extends AbstractDataWeatherClient {
    private static final String ACCEPT_CHARSET = "Accept-Charset";
    private static final String UTF_8 = "UTF-8";
    private final String apiKey;

    public UrlConnectionDataWeatherClient(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    protected String makeRequest(Query query) {
        String queryString = query.toStringRepresentation(apiKey);
        try {
            URL url = getUrl(queryString);
            URLConnection urlConnection = url.openConnection();
            urlConnection.setRequestProperty(ACCEPT_CHARSET, UTF_8);
            return readResponse(urlConnection);
        } catch (IOException e) {
            throw new WeatherClientRequestException(e);
        }
    }

    private static String readResponse(URLConnection urlConnection) throws IOException {
        StringBuilder response = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
        }
        return response.toString();
    }

    /**
     * Gets url from query string.
     *
     * @param query the query
     * @return the url
     */
    private static URL getUrl(String query) {
        try {
            return new URL(query);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Malformed query", e);
        }
    }

}
