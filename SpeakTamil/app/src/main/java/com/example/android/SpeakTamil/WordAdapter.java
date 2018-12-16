package com.example.android.SpeakTamil;

import android.app.Activity;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Vithu on 2018-12-15.
 */
public class WordAdapter extends ArrayAdapter<Word> {






    public WordAdapter(Activity context, ArrayList<Word> mWords){
        super(context, 0, mWords);
    }

    /**
     *  Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The AdapterView position that is requesting a view
     * @param convertView The Recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation
     * @return The view for the position in the AdapterView
     */
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }


        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getmDefaultTranslation());


        TextView tamilEnTextView = (TextView) listItemView.findViewById(R.id.tamil_en_text_view);
        tamilEnTextView.setText(currentWord.getmTamilTranslation());


        TextView tamilTextView = (TextView) listItemView.findViewById(R.id.tamil_text_view);
        tamilTextView.setText(currentWord.getmTamilWord());

        ImageView image = (ImageView) listItemView.findViewById(R.id.image);

        if(currentWord.hasImage()){
            image.setImageResource(currentWord.getmImageResourceId());
            image.setVisibility(View.VISIBLE);
        }else{
            image.setVisibility(View.GONE);
        }





        return listItemView;
    }
}
