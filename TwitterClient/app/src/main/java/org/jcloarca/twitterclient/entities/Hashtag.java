package org.jcloarca.twitterclient.entities;

import java.util.List;

/**
 * Created by JCLoarca on 6/20/2016 12:00 AM.
 */
public class Hashtag {
    private String id;
    private String  tweetText;
    private int favoriteCount;
    private List<String> hashtags;
    private final static String BASE_TWEET_URL = "https://twitter.com/null/status/";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }

    public String getTweetURL() {
        return BASE_TWEET_URL + this.id;
    }
}
