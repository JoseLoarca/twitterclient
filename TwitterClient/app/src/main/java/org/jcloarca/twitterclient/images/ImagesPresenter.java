package org.jcloarca.twitterclient.images;

import org.jcloarca.twitterclient.images.events.ImagesEvent;

/**
 * Created by JCLoarca on 6/19/2016 1:35 AM.
 */
public interface ImagesPresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getImageTweets();
    void onEventMainThread(ImagesEvent event);
}
