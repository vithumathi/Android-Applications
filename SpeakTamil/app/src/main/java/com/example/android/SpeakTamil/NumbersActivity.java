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
        words.add(new Word("One", "Ondru", "ஒன்று"));
        words.add(new Word("Two", "Irantu", "இரண்டு"));
        words.add(new Word("Three", "Moondru", "மூன்று"));
        words.add(new Word("Four", "Nānku", "நான்கு"));
        words.add(new Word("Five", "Aindhu", "ஐந்து"));
        words.add(new Word("Six", "Aru", "ஆறு"));
        words.add(new Word("Seven", "Ezhu", "ஏழு"));
        words.add(new Word("Eight", "Ettu", "எட்டு"));
        words.add(new Word("Nine", "Onpadhu", "ஒன்பது"));
        words.add(new Word("Ten", "Paththu", "பத்து"));
        WordAdapter itemsAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}
