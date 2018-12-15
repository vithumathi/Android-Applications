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

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmTamilTranslation() {
        return mTamilTranslation;
    }

    public String getmTamilWord() {
        return mTamilWord;
    }
}
