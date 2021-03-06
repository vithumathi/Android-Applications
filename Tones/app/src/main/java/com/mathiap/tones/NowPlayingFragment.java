package com.mathiap.tones;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * {@link Fragment} that displays the user selected song and its details.
 */
public class NowPlayingFragment extends Fragment {
    protected String sName;
    protected String aName;
    protected String albName;
    protected int albCover;

    public NowPlayingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_now_playing, container, false);
        // Create an {@link Bundle} & pass user selected song details back to now playing fragment to populate the view
        Bundle bundle = getArguments();
        if (bundle != null) {
            sName = bundle.getString("Song");
            TextView songName = (TextView) rootView.findViewById(R.id.now_playing_text_view);
            songName.setText(sName);
            aName = bundle.getString("Artist");
            TextView artistName = (TextView) rootView.findViewById(R.id.artist_name_text_view);
            artistName.setText(aName);
            albName = bundle.getString("Album");
            TextView albumName = (TextView) rootView.findViewById(R.id.album_name_text_view);
            albumName.setText(albName);
            albCover = bundle.getInt("AlbumCover");
            ImageView albumCover = (ImageView) rootView.findViewById(R.id.now_playing_image_view);
            albumCover.setImageResource(albCover);
        }
        // Inflate the layout for this fragment
        return rootView;
    }
}
