package com.example.android.SpeakTamil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?", "Ni enke pokirai?", "நீ எங்கே போகிறாய்?"));
        words.add(new Word("What is your name?", "Unkal peyar enna?", "உங்கள் பெயர் என்ன?"));
        words.add(new Word("My name is...", "En peyar...", "என் பெயர்"));
        words.add(new Word("How are you feeling?", "Ni eppadi irukkirai", "நீ எப்படி இருக்கிறாய்"));
        words.add(new Word("I’m doing good.", "Nan nanraka irukiren", "நான் நன்றாக இருகிறேன்"));
        words.add(new Word("Are you coming?", "Ni varukiraya?", "நீ வருகிறாயா?"));
        words.add(new Word("Yes, I’m coming.", "Am, nan varukiren", "ஆம், நான் வருகிறேன்"));
        words.add(new Word("Let’s go.", "Nam pokalam", "நாம் போகலாம்"));
        words.add(new Word("Come here.", "Inke va", "இங்கே வா"));
        WordAdapter itemsAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}
