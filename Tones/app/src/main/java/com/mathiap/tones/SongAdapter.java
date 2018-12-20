package com.mathiap.tones;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Vithu on 2018-12-15.
 */
public class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(Activity context, ArrayList<Song> mSongs) {
        super(context, 0, mSongs);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The AdapterView position that is requesting a view
     * @param convertView The Recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation
     * @return The view for the position in the AdapterView
     */
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the {@link Song} object located at this position in the list
        Song currentSong = getItem(position);
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView songTextView = (TextView) listItemView.findViewById(R.id.song_name_text_view);
        songTextView.setText(currentSong.getmSongName());
        TextView albumTextView = (TextView) listItemView.findViewById(R.id.album_name_text_view);
        albumTextView.setText(currentSong.getmAlbumName());
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist_name_text_view);
        artistTextView.setText(currentSong.getmArtistName());
        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        image.setImageResource(currentSong.getmAlbumCover());
        image.setVisibility(View.VISIBLE);
        return listItemView;
    }
}
