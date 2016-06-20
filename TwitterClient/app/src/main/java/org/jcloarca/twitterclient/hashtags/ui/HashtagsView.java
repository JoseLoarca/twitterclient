package org.jcloarca.twitterclient.hashtags.ui;

import org.jcloarca.twitterclient.entities.Hashtag;

import java.util.List;

/**
 * Created by JCLoarca on 6/20/2016 12:06 AM.
 */
public interface HashtagsView {
    void showList();
    void hideList();
    void showProgress();
    void hideProgress();

    void onHashtagsError(String error);
    void setHashtags(List<Hashtag> items);
}
