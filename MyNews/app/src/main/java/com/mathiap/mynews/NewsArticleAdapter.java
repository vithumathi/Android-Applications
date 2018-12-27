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

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * An {@link NewsArticleAdapter} knows how to create a list item layout for each earthquake
 * in the data source (a list of {@link NewsArticle} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsArticleAdapter extends ArrayAdapter<NewsArticle> {

    /**
     * The part of the location string from the USGS service that we use to determine
     * whether or not there is a location offset present ("5km N of Cairo, Egypt").
     */
    private static final String DATE_SEPARATOR = "T";

    /**
     * Constructs a new {@link NewsArticleAdapter}.
     *
     * @param context of the app
     * @param nwsArticles is the list of news articles, which is the data source of the adapter
     */
    public NewsArticleAdapter(Context context, List<NewsArticle> nwsArticles) {
        super(context, 0, nwsArticles);
    }

    /**
     * Returns a list item view that displays information about the earthquake at the given position
     * in the list of earthquakes.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_articles_list_item, parent, false);
        }

        // Find the earthquake at the given position in the list of earthquakes
        NewsArticle currentArticle = getItem(position);


        // Find the TextView with view ID location
        TextView artlTile = (TextView) listItemView.findViewById(R.id.artl_ttl_txt_view);
        // Display the location of the current earthquake in that TextView
        artlTile.setText(currentArticle.getmTile());

        // Find the TextView with view ID location offset
        TextView artlSection = (TextView) listItemView.findViewById(R.id.artl_sec_txt_view);
        // Display the location offset of the current earthquake in that TextView
        artlSection.setText(currentArticle.getmSection());



        String articleDate = currentArticle.getmDate();
        String displayDate = " ";
        // Check whether the originalLocation string contains the " of " text
        if (articleDate.contains(DATE_SEPARATOR)) {
            // Split the string into different parts (as an array of Strings)
            // based on the " of " text. We expect an array of 2 Strings, where
            // the first String will be "5km N" and the second String will be "Cairo, Egypt".
            String[] parts = articleDate.split(DATE_SEPARATOR);
            // Location offset should be "5km N " + " of " --> "5km N of"
            displayDate = parts[0];
        }

        // Find the TextView with view ID location offset
        TextView artlDate = (TextView) listItemView.findViewById(R.id.artl_date_txt_view);
        artlDate.setText(displayDate);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }
}