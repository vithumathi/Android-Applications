package com.example.android.SpeakTamil;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Red", "Civappu", "சிவப்பு", R.drawable.color_red, R.raw.red));
        words.add(new Word("Yellow", "Mañcaḷ", "மஞ்சள்", R.drawable.color_dusty_yellow, R.raw.yellow));
        words.add(new Word("Green", "Paccai", "பச்சை", R.drawable.color_green, R.raw.green));
        words.add(new Word("Brown", "Paḻuppu", "பழுப்பு", R.drawable.color_brown, R.raw.brown));
        words.add(new Word("Gray", "Cāmpal", "சாம்பல்", R.drawable.color_gray, R.raw.gray));
        words.add(new Word("Black", "Karuppu", "கருப்பு", R.drawable.color_black, R.raw.black));
        words.add(new Word("White", "Veḷḷai", "வெள்ளை", R.drawable.color_white, R.raw.white));
        WordAdapter itemsAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Word word = words.get(position);
                MediaPlayer mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getmAduioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}
