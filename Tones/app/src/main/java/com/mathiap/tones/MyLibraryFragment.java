package com.mathiap.tones;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
        songs.add(new Song("Hey hello", "Hello", "Chris", R.drawable.cover1));
        songs.add(new Song("Blast off", "Renegade", "Yuvan", R.drawable.cover2));
        songs.add(new Song("Mask off", "Future", "Future", R.drawable.cover4));
        songs.add(new Song("God's Plan", "Views", "Drake", R.drawable.cover5));
        songs.add(new Song("Up Now", "Saw", "London On Da", R.drawable.cover6));
        songs.add(new Song("Might Be", "Mght Be", "T-Pain", R.drawable.cover7));
        songs.add(new Song("Undercover", "Uc Cover", "Ljay Currie", R.drawable.cover8));
        songs.add(new Song("Doubt Me", "Dbt Me", "Konkrete", R.drawable.cover9));
        songs.add(new Song("Go Crazy", "Go Crazy", "Le Sinner", R.drawable.cover10));
        songs.add(new Song("Broken Heart", "Broken Heart", "Bow Wow", R.drawable.cover3));
        SongAdapter itemAdapter = new SongAdapter(getActivity(), songs);
        GridView gridView = (GridView) rootView.findViewById(R.id.list);
        gridView.setAdapter(itemAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Song song = songs.get(position);
                NowPlayingFragment nowPlaying = new NowPlayingFragment();
                Bundle bundle = new Bundle();
                bundle.putString("Song", song.getmSongName());
                bundle.putString("Artist", song.getmArtistName());
                bundle.putString("Album", song.getmAlbumName());
                bundle.putInt("AlbumCover", song.getmAlbumCover());
                nowPlaying.setArguments(bundle);
                Intent intent = getActivity().getIntent();
                intent.putExtras(bundle);
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().add(R.id.main_view, nowPlaying, "nowPlayingFragment").commit();
            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }
}
