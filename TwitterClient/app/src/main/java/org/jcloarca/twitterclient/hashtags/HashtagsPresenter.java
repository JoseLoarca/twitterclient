package org.jcloarca.twitterclient.hashtags;

import org.jcloarca.twitterclient.hashtags.events.HashtagsEvent;

/**
 * Created by JCLoarca on 6/20/2016 12:09 AM.
 */
public interface HashtagsPresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getHashtagTweets();
    void onEventMainThread(HashtagsEvent event);
}
