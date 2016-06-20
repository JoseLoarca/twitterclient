package org.jcloarca.twitterclient.hashtags;

import org.greenrobot.eventbus.Subscribe;
import org.jcloarca.twitterclient.entities.Hashtag;
import org.jcloarca.twitterclient.hashtags.events.HashtagsEvent;
import org.jcloarca.twitterclient.hashtags.ui.HashtagsView;
import org.jcloarca.twitterclient.lib.base.EventBus;

import java.util.List;

/**
 * Created by JCLoarca on 6/20/2016 12:24 AM.
 */
public class HashtagsPresenterImpl implements HashtagsPresenter {
    private EventBus eventBus;
    private HashtagsView hashtagsView;
    private HashtagsInteractor hashtagsInteractor;

    public HashtagsPresenterImpl(HashtagsView hashtagsView, HashtagsInteractor hashtagsInteractor, EventBus eventBus) {
        this.eventBus = eventBus;
        this.hashtagsView = hashtagsView;
        this.hashtagsInteractor = hashtagsInteractor;
    }

    @Override
    public void onPause() {
        eventBus.unregister(this);
    }

    @Override
    public void onResume() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        this.hashtagsView = null;
    }

    @Override
    public void getHashtagTweets(){
        if (this.hashtagsView != null){
            hashtagsView.hideList();
            hashtagsView.showProgress();
        }
        this.hashtagsInteractor.getHashtagItemsList();
    }

    @Override
    @Subscribe
    public void onEventMainThread(HashtagsEvent event) {
        String errorMsg = event.getError();
        if (this.hashtagsView != null) {
            hashtagsView.showList();
            hashtagsView.hideProgress();
            if (errorMsg != null) {
                this.hashtagsView.onHashtagsError(errorMsg);
            } else {
                List<Hashtag> items = event.getHashtags();
                if (items != null && !items.isEmpty()) {
                    this.hashtagsView.setHashtags(items);
                }
            }
        }
    }
}
