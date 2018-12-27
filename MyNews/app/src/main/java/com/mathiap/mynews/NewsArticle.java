package com.mathiap.mynews;

/**
 * An {@link NewsArticle} object contains information related to a single new's article.
 */
public class NewsArticle {
    /**
     * Title of the news article
     */
    private String mTile;
    /**
     * Section of the news article
     */
    private String mSection;
    /**
     * Date the article is published
     */
    private String mDate;
    /**
     * Website URL of the news article
     */
    private String mUrl;
    /**
     * Author(s) of the news article
     */
    private String mAuthors;

    /**
     * Constructs a new {@link NewsArticle} object.
     *
     * @param title   is the title of the news article
     * @param authors is the author(s) of the news article
     * @param section is the section of the news article
     * @param date    is the date the article is written
     * @param url     is the website URL to read and find more information about the article
     */
    public NewsArticle(String title, String authors, String section, String date, String url) {
        mTile = title;
        mAuthors = authors;
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

    public String getmAuthors() {
        return mAuthors;
    }
}
