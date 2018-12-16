package com.example.android.SpeakTamil;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("One", "Ondru", "ஒன்று", R.drawable.number_one, R.raw.one));
        words.add(new Word("Two", "Irantu", "இரண்டு", R.drawable.number_two, R.raw.two));
        words.add(new Word("Three", "Moondru", "மூன்று", R.drawable.number_three, R.raw.three));
        words.add(new Word("Four", "Nānku", "நான்கு", R.drawable.number_four, R.raw.four));
        words.add(new Word("Five", "Aindhu", "ஐந்து", R.drawable.number_five, R.raw.five));
        words.add(new Word("Six", "Aru", "ஆறு", R.drawable.number_six, R.raw.six));
        words.add(new Word("Seven", "Ezhu", "ஏழு", R.drawable.number_seven, R.raw.seven));
        words.add(new Word("Eight", "Ettu", "எட்டு", R.drawable.number_eight, R.raw.eight));
        words.add(new Word("Nine", "Onpadhu", "ஒன்பது", R.drawable.number_nine, R.raw.nine));
        words.add(new Word("Ten", "Paththu", "பத்து", R.drawable.number_ten, R.raw.ten));
        WordAdapter itemsAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} created above so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Word word = words.get(position);
                MediaPlayer mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getmAduioResourceId());
                mMediaPlayer.start();
            }
        });

    }
}
