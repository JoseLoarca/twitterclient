package org.jcloarca.twitterclient.hashtags.events;

import org.jcloarca.twitterclient.entities.Hashtag;

import java.util.List;

/**
 * Created by JCLoarca on 6/20/2016 12:10 AM.
 */
public class HashtagsEvent {
    private String error;
    private List<Hashtag> hashtags;

    public List<Hashtag> getHashtags(){
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags){
        this.hashtags = hashtags;
    }

    public String getError(){
        return error;
    }

    public void setError(String error){
        this.error = error;
    }
}
