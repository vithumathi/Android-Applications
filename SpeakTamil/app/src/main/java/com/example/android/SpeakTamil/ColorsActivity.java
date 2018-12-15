package com.example.android.SpeakTamil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Red", "Civappu", "சிவப்பு"));
        words.add(new Word("Yellow", "Mañcaḷ", "மஞ்சள்"));
        words.add(new Word("Green", "Paccai", "பச்சை"));
        words.add(new Word("Brown", "Paḻuppu", "பழுப்பு"));
        words.add(new Word("Gray", "Cāmpal", "சாம்பல்"));
        words.add(new Word("Black", "Karuppu", "கருப்பு"));
        words.add(new Word("White", "Veḷḷai", "வெள்ளை"));
        WordAdapter itemsAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}
