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
        words.add(new Word("Father", "Appā", "அப்பா", R.drawable.family_father));
        words.add(new Word("Mother", "Ammā", "அம்மா", R.drawable.family_mother));
        words.add(new Word("Son", "Makan", "மகன்", R.drawable.family_son));
        words.add(new Word("Daughter", "Makal", "மகள்", R.drawable.family_daughter));
        words.add(new Word("Older brother", "Anna", "அண்ணா", R.drawable.family_older_brother));
        words.add(new Word("Younger brother", "Tampi", "தம்பி", R.drawable.family_younger_brother));
        words.add(new Word("Older sister", "Akka", "அக்கா", R.drawable.family_older_sister));
        words.add(new Word("Younger sister", "Tankai", "தங்கை", R.drawable.family_younger_sister));
        words.add(new Word("Grandmother", "Patti", "பாட்டி", R.drawable.family_grandmother));
        words.add(new Word("Grandfather", "Thatha", "தாத்தா", R.drawable.family_father));
        WordAdapter itemsAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}
