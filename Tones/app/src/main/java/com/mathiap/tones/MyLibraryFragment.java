package com.mathiap.tones;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyLibraryFragment extends Fragment {
    public MyLibraryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.song_list, container, false);
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Song1", "Album1", "Artist1", R.drawable.cafe_coffee));
        songs.add(new Song("Song2", "Album1", "Artist1", R.drawable.cafe_coffee));
        songs.add(new Song("Song3", "Album1", "Artist1", R.drawable.cafe_coffee));
        songs.add(new Song("Song1", "Album1", "Artist1", R.drawable.cafe_coffee));
        songs.add(new Song("Song2", "Album1", "Artist1", R.drawable.cafe_coffee));
        songs.add(new Song("Song3", "Album1", "Artist1", R.drawable.cafe_coffee));
        songs.add(new Song("Song1", "Album1", "Artist1", R.drawable.cafe_coffee));
        songs.add(new Song("Song2", "Album1", "Artist1", R.drawable.cafe_coffee));
        songs.add(new Song("Song3", "Album1", "Artist1", R.drawable.cafe_coffee));
        songs.add(new Song("Song1", "Album1", "Artist1", R.drawable.cafe_coffee));
        songs.add(new Song("Song2", "Album1", "Artist1", R.drawable.cafe_coffee));
        songs.add(new Song("Song3", "Album1", "Artist1", R.drawable.cafe_coffee));
        songs.add(new Song("Song1", "Album1", "Artist1", R.drawable.cafe_coffee));
        songs.add(new Song("Song2", "Album1", "Artist1", R.drawable.cafe_coffee));
        songs.add(new Song("Song3", "Album1", "Artist1", R.drawable.cafe_coffee));
        songs.add(new Song("Song1", "Album1", "Artist1", R.drawable.cafe_coffee));
        songs.add(new Song("Song2", "Album1", "Artist1", R.drawable.cafe_coffee));
        songs.add(new Song("Song3", "Album1", "Artist1", R.drawable.cafe_coffee));
        songs.add(new Song("Song1", "Album1", "Artist1", R.drawable.cafe_coffee));
        songs.add(new Song("Song2", "Album1", "Artist1", R.drawable.cafe_coffee));
        songs.add(new Song("Song3", "Album1", "Artist1", R.drawable.cafe_coffee));
        SongAdapter itemAdapter = new SongAdapter(getActivity(), songs);
        GridView gridView = (GridView) rootView.findViewById(R.id.list);
        gridView.setAdapter(itemAdapter);
        // Inflate the layout for this fragment
        return rootView;
    }
}
