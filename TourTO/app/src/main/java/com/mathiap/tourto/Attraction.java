package com.mathiap.tourto;

/**
 * {@link Attraction} represents a attraction.
 * It contains the attraction name, a short description, address and an image.
 */
public class Attraction {
    /**
     * Name of the attraction
     */
    private String mAttrName;
    /**
     *  Short description of the attraction
     */
    private String mAttrDisc;
    /**
     * Address of the attraction
     */
    private String mAttrAddr;
    /**
     * Image resource ID for the attraction
     */
    private int mAttrImage;

    /**
     * Create a new song object.
     *
     * @param attrName   is the attraction name
     * @param attrDisc  is the attraction description
     * @param attrAddr is address of the attraction
     * @param attrImage is the image resource id of the attraction
     */
    public Attraction(String attrName, String attrDisc, String attrAddr, int attrImage) {
        this.mAttrName = attrName;
        this.mAttrDisc = attrDisc;
        this.mAttrAddr = attrAddr;
        this.mAttrImage = attrImage;
    }

    /**
     * @return the attraction name
     */
    public String getmAttrName() {
        return mAttrName;
    }

    /**
     * @return the the attraction description
     */
    public String getmAttrDisc() {
        return mAttrDisc;
    }

    /**
     * @return the address of the attraction
     */
    public String getmAttrAddr() {
        return mAttrAddr;
    }

    /**
     * @return the image resource ID of the attraction
     */
    public int getmAttrImage() {
        return mAttrImage;
    }

    /**
     * Returns the string representation of the {@link Attraction} object.
     */
    @Override
    public String toString() {
        return "Song{" +
                "mSongName='" + mAttrName + '\'' +
                "mAlbumName='" + mAttrDisc + '\'' +
                ", mArtistName='" + mAttrAddr + '\'' +
                ", mAlbumCover='" + mAttrImage +
                '}';
    }
}
