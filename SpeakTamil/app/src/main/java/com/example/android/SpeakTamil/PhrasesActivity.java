package com.example.android.SpeakTamil;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?", "Ni enke pokirai?", "நீ எங்கே போகிறாய்?", R.raw.where_are_you_going));
        words.add(new Word("What is your name?", "Unkal peyar enna?", "உங்கள் பெயர் என்ன?", R.raw.what_is_your_name));
        words.add(new Word("My name is...", "En peyar...", "என் பெயர்", R.raw.my_name_is));
        words.add(new Word("How are you?", "Ninkal eppadi irukkirirkal", "நீங்கள் எப்படி இருக்கிறீர்கள்", R.raw.how_are_you));
        words.add(new Word("I’m doing well.", "Nan nanraka irukiren", "நான் நன்றாக இருகிறேன்", R.raw.im_doing_well));
        words.add(new Word("Are you coming?", "Ni varukiraya?", "நீ வருகிறாயா?", R.raw.are_you_coming));
        words.add(new Word("Yes, I’m coming.", "Am, nan varukiren", "ஆம், நான் வருகிறேன்", R.raw.yes_i_am_coming));
        words.add(new Word("Let’s go.", "lets_go", "போகலாம்", R.raw.lets_go));
        words.add(new Word("Come here.", "Inke va", "இங்கே வா", R.raw.come_here));
        WordAdapter itemsAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Word word = words.get(position);
                MediaPlayer mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getmAduioResourceId());
                mMediaPlayer.start();
            }
        });


    }
}
