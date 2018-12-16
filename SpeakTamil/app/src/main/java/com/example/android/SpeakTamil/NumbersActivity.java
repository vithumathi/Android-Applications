package com.example.android.SpeakTamil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("One", "Ondru", "ஒன்று", R.drawable.number_one));
        words.add(new Word("Two", "Irantu", "இரண்டு", R.drawable.number_two));
        words.add(new Word("Three", "Moondru", "மூன்று", R.drawable.number_three));
        words.add(new Word("Four", "Nānku", "நான்கு", R.drawable.number_four));
        words.add(new Word("Five", "Aindhu", "ஐந்து", R.drawable.number_five));
        words.add(new Word("Six", "Aru", "ஆறு", R.drawable.number_six));
        words.add(new Word("Seven", "Ezhu", "ஏழு", R.drawable.number_seven));
        words.add(new Word("Eight", "Ettu", "எட்டு", R.drawable.number_eight));
        words.add(new Word("Nine", "Onpadhu", "ஒன்பது", R.drawable.number_nine));
        words.add(new Word("Ten", "Paththu", "பத்து", R.drawable.number_ten));
        WordAdapter itemsAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}
