/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mathiap.mynews;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static java.net.HttpURLConnection.HTTP_OK;

/**
 * Helper methods related to requesting and receiving news article data from the Guardian.
 */
public final class QueryUtils {
    /**
     * Tag for the log messages
     */
    private static final String LOG_TAG = QueryUtils.class.getSimpleName();
    private static final int READ_TIMEOUT = 10000;
    private static final int CONNECT_TIMEOUT = 15000;

    /**
     * Create a private constructor because no one should ever create a {@link QueryUtils} object.
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly from the class name QueryUtils (and an object instance of QueryUtils is not needed).
     */
    private QueryUtils() {
    }

    /**
     * Query the Guardian dataset and return a list of {@link NewsArticle} objects.
     */
    public static List<NewsArticle> fetchNewsArticleData(String requestUrl) {
        // Create URL object
        URL url = createUrl(requestUrl);
        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }
        // Extract relevant fields from the JSON response and create a list of {@link NewsArticle}s
        List<NewsArticle> nwsArticle = extractFeatureFromJson(jsonResponse);
        // Return the list of {@link Earthquake}s
        return nwsArticle;
    }

    /**
     * Returns new URL object from the given string URL.
     */
    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Problem building the URL ", e);
        }
        return url;
    }

    /**
     * Make an HTTP request to the given URL and return a String as the response.
     */
    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";
        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(READ_TIMEOUT /* milliseconds */);
            urlConnection.setConnectTimeout(CONNECT_TIMEOUT /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == HTTP_OK) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the news article JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                // Closing the input stream could throw an IOException, which is why
                // the makeHttpRequest(URL url) method signature specifies than an IOException
                // could be thrown.
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    /**
     * Convert the {@link InputStream} into a String which contains the
     * whole JSON response from the server.
     */
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    /**
     * Return a list of {@link NewsArticle} objects that has been built up from
     * parsing the given JSON response.
     */
    private static List<NewsArticle> extractFeatureFromJson(String articleJSON) {
        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(articleJSON)) {
            return null;
        }
        // Create an empty ArrayList that we can start adding new articles to
        List<NewsArticle> articles = new ArrayList<>();
        // Try to parse the JSON response string. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {
            // Create a JSONObject from the JSON response string
            JSONObject baseJsonResponse = new JSONObject(articleJSON);
            JSONObject base1JsonRes = baseJsonResponse.getJSONObject("response");
            // Extract the JSONArray associated with the key called "results",
            // which represents a list of articles and its properties.
            JSONArray articleArray = base1JsonRes.getJSONArray("results");
            // For each article in the articleArray, create an {@link NewsArticle} object
            for (int i = 0; i < articleArray.length(); i++) {
                // Get a single article at position i within the list of articles
                JSONObject currentArticle = articleArray.getJSONObject(i);
                // Extract the value for the key called "webTitle"
                String title = currentArticle.getString("webTitle");
                // Extract the value for the key called "sectionName"
                String section = currentArticle.getString("sectionName");
                // Extract the value for the key called "webPublicationDate"
                String date = currentArticle.getString("webPublicationDate");
                // Extract the value for the key called "url"
                String url = currentArticle.getString("webUrl");
                JSONArray tags = currentArticle.getJSONArray("tags");
                int j = 0;
                String author = null;
                int aCount = 0;
                StringBuilder strBuilder = new StringBuilder();
                JSONObject tag = tags.optJSONObject(j);
                while (tag != null) {
                    if (aCount != 0) {
                        strBuilder.append(", ").append(tag.optString("webTitle"));
                    } else {
                        strBuilder.append(tag.optString("webTitle"));
                    }
                    aCount++;
                    j++;
                    tag = tags.optJSONObject(j);
                }
                author = strBuilder.toString();
                // Create a new {@link NewsArticle} object with the title, section, date,
                // and url from the JSON response.
                NewsArticle aArticle = new NewsArticle(title, author, section, date, url);
                // Add the new {@link NewsArticle} to the list of news articles.
                articles.add(aArticle);
            }
        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the news article JSON results", e);
        }
        // Return the list of news articles
        return articles;
    }
}