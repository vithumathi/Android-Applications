package com.mathiap.tourto;

/**
 * {@link Attraction} represents a attraction.
 * It contains the attraction name, a short description, address and an image.
 */
public class Attraction {

    private static final int NO_IMAGE_PROVIDED = -1;
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
    private int mAttrImage = NO_IMAGE_PROVIDED;

    /**
     * Create a new song object.
     *
     * @param attrName   is the attraction name
     * @param attrDisc  is the attraction description
     * @param attrAddr is address of the attraction
     */
    public Attraction(String attrName, String attrDisc, String attrAddr) {
        this.mAttrName = attrName;
        this.mAttrDisc = attrDisc;
        this.mAttrAddr = attrAddr;
    }

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
     * @return whether or not there is an image for this attraction
     */
    public Boolean hasImage() {
        return mAttrImage != NO_IMAGE_PROVIDED;
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
