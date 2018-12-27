package com.mathiap.mynews;

/**
 * An {@link NewsArticle} object contains information related to a single new's article.
 */
public class NewsArticle {
    /**
     * Magnitude of the earthquake
     */
    private String mTile;
    /**
     * Location of the earthquake
     */
    private String mSection;
    /**
     * Time of the earthquake
     */
    private String mDate;
    /**
     * Website URL of the earthquake
     */
    private String mUrl;

    /**
     * Constructs a new {@link NewsArticle} object.
     *
     * @param title   is the title of the news article
     * @param section is the section of the news article
     * @param date    is the date the article is written
     * @param url     is the website URL to read and find more information about the article
     */
    public NewsArticle(String title, String section, String date, String url) {
        mTile = title;
        mSection = section;
        mDate = date;
        mUrl = url;
    }

    /**
     * @return the title of the article
     */
    public String getmTile() {
        return mTile;
    }

    /**
     * @return the section of the article
     */
    public String getmSection() {
        return mSection;
    }

    /**
     * return the date the article is written
     *
     * @return
     */
    public String getmDate() {
        return mDate;
    }

    /**
     * @return the url of the article
     */
    public String getmUrl() {
        return mUrl;
    }
}
