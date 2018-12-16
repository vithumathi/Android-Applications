package com.example.android.SpeakTamil;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {
    MediaPlayer mMediaPlayer;
    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed playing the audio file
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Father", "Appā", "அப்பா", R.drawable.family_father, R.raw.father));
        words.add(new Word("Mother", "Ammā", "அம்மா", R.drawable.family_mother, R.raw.mother));
        words.add(new Word("Son", "Makan", "மகன்", R.drawable.family_son, R.raw.son));
        words.add(new Word("Daughter", "Makal", "மகள்", R.drawable.family_daughter, R.raw.daughter));
        words.add(new Word("Older brother", "Anna", "அண்ணா", R.drawable.family_older_brother, R.raw.older_brother));
        words.add(new Word("Younger brother", "Tampi", "தம்பி", R.drawable.family_younger_brother, R.raw.younger_brother));
        words.add(new Word("Older sister", "Akka", "அக்கா", R.drawable.family_older_sister, R.raw.older_sister));
        words.add(new Word("Younger sister", "Tankai", "தங்கை", R.drawable.family_younger_sister, R.raw.younger_sister));
        words.add(new Word("Grandmother", "Patti", "பாட்டி", R.drawable.family_grandmother, R.raw.grandmother));
        words.add(new Word("Grandfather", "Thatha", "தாத்தா", R.drawable.family_father, R.raw.grandfather));
        WordAdapter itemsAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Word word = words.get(position);
                // Release the media player if it currently exist
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(FamilyMembersActivity.this, word.getmAduioResourceId());
                mMediaPlayer.start();
                // Setup a listener on the media player, so that we can stop and release the media player once the sound has finished playing
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }
    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
