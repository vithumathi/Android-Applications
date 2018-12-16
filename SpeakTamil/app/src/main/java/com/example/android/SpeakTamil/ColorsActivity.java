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
        words.add(new Word("Red", "Civappu", "சிவப்பு", R.drawable.color_red));
        words.add(new Word("Yellow", "Mañcaḷ", "மஞ்சள்", R.drawable.color_dusty_yellow));
        words.add(new Word("Green", "Paccai", "பச்சை", R.drawable.color_green));
        words.add(new Word("Brown", "Paḻuppu", "பழுப்பு", R.drawable.color_brown));
        words.add(new Word("Gray", "Cāmpal", "சாம்பல்", R.drawable.color_gray));
        words.add(new Word("Black", "Karuppu", "கருப்பு", R.drawable.color_black));
        words.add(new Word("White", "Veḷḷai", "வெள்ளை", R.drawable.color_white));
        WordAdapter itemsAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}
