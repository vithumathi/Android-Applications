package com.example.android.SpeakTamil;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation, and tamil translation for that word, along with word written in Tamil.
 */
public class Word {
    /**
     * Default translation for the word
     */
    private String mDefaultTranslation;
    /**
     * Tamil translation for the word
     */
    private String mTamilTranslation;
    /**
     * The Tamil word
     */
    private String mTamilWord;
    /**
     *  Image resource ID for the word
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;



    /**
     * Create a new word object.

     *
     * @param defaultTranslation is the word in a language that the user is already familiar with (such as English)
     * @param tamilTranslation is the word in the Tamil language
     * @param tamilWord is the word written in Tamil language
     */
    public Word (String defaultTranslation, String tamilTranslation, String tamilWord){
        this.mDefaultTranslation = defaultTranslation;
        this.mTamilTranslation = tamilTranslation;
        this.mTamilWord = tamilWord;
    }

    /**
     * Create a new word object.

     *
     * @param defaultTranslation is the word in a language that the user is already familiar with (such as English)
     * @param tamilTranslation is the word in the Tamil language
     * @param tamilWord is the word written in Tamil language
     * @param imageId is the drawable resource ID for the image asset
     */
    public Word (String defaultTranslation, String tamilTranslation, String tamilWord, int imageId){
        this.mDefaultTranslation = defaultTranslation;
        this.mTamilTranslation = tamilTranslation;
        this.mTamilWord = tamilWord;
        this.mImageResourceId = imageId;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmTamilTranslation() {
        return mTamilTranslation;
    }

    public String getmTamilWord() {
        return mTamilWord;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word
     * @return
     */
    public Boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
