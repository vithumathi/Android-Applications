package com.mathiap.tones;

/**
 * {@link Song} represents a song in the users music library.
 * It contains the song name, artist name and an album cover.
 */
public class Song {
    /**
     * Name of the song
     */
    private String mSongName;
    /**
     * Album name of the song
     */
    private String mAlbumName;
    /**
     * Artist name of the song
     */
    private String mArtistName;
    /**
     * Image resource ID for the word
     */
    private int mAlbumCover;
    /**
     * TODO: Audio resource ID for the word - For future work
     */
    private int mAduioResourceId;

    /**
     * Create a new song object.
     *
     * @param songName   is the song name
     * @param albumName is the artist name
     * @param artistName is the artist name
     * @param albumCover is the image resource id of the album cover
     */
    public Song(String songName, String albumName, String artistName, int albumCover) {
        this.mSongName = songName;
        this.mAlbumName = albumName;
        this.mArtistName = artistName;
        this.mAlbumCover = albumCover;
    }

    /**
     * @return the song name
     */
    public String getmSongName() {
        return mSongName;
    }
    /**
     * @return the album name
     */
    public String getmAlbumName() {
        return mAlbumName;
    }

    /**
     * @return the artist name
     */
    public String getmArtistName() {
        return mArtistName;
    }

    /**
     * @return the image resource ID of the album cover
     */
    public int getmAlbumCover() {
        return mAlbumCover;
    }

    /**
     * Returns the string representation of the {@link Song} object.
     */
    @Override
    public String toString() {
        return "Song{" +
                "mSongName='" + mSongName + '\'' +
                "mAlbumName='" + mAlbumName + '\'' +
                ", mArtistName='" + mArtistName + '\'' +
                ", mAlbumCover='" + mAlbumCover +
                '}';
    }
}
