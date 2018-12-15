package com.example.android.SpeakTamil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Father", "Appā", "அப்பா"));
        words.add(new Word("Mother", "Ammā", "அம்மா"));
        words.add(new Word("Son", "Makan", "மகன்"));
        words.add(new Word("Daughter", "Makal", "மகள்"));
        words.add(new Word("Older brother", "Anna", "அண்ணா"));
        words.add(new Word("Younger brother", "Tampi", "தம்பி"));
        words.add(new Word("Older sister", "Akka", "அக்கா"));
        words.add(new Word("Younger sister", "Tankai", "தங்கை"));
        words.add(new Word("Grandmother", "Patti", "பாட்டி"));
        words.add(new Word("Grandfather", "Thatha", "தாத்தா"));
        WordAdapter itemsAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}
