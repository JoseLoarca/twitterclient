package org.jcloarca.twitterclient.hashtags.di;

import android.content.Context;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterSession;

import org.jcloarca.twitterclient.api.CustomTwitterApiClient;
import org.jcloarca.twitterclient.entities.Hashtag;
import org.jcloarca.twitterclient.hashtags.HashtagsInteractor;
import org.jcloarca.twitterclient.hashtags.HashtagsInteractorImpl;
import org.jcloarca.twitterclient.hashtags.HashtagsPresenter;
import org.jcloarca.twitterclient.hashtags.HashtagsPresenterImpl;
import org.jcloarca.twitterclient.hashtags.HashtagsRepository;
import org.jcloarca.twitterclient.hashtags.HashtagsRepositoryImpl;
import org.jcloarca.twitterclient.hashtags.ui.HashtagsView;
import org.jcloarca.twitterclient.hashtags.ui.adapters.HashtagsAdapter;
import org.jcloarca.twitterclient.hashtags.ui.adapters.OnItemClickListener;
import org.jcloarca.twitterclient.lib.base.EventBus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JCLoarca on 6/20/2016 12:14 AM.
 */
@Module
public class HashtagsModule {
    private HashtagsView view;
    private OnItemClickListener clickListener;

    public HashtagsModule(HashtagsView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    List<Hashtag> provideItems() {
        return new ArrayList<Hashtag>();
    }

    @Provides
    @Singleton
    OnItemClickListener provideClickListener() {
        return this.clickListener;
    }

    @Provides
    HashtagsAdapter provideAdapter(Context context, List<Hashtag> items, OnItemClickListener clickListener) {
        return new HashtagsAdapter(context, items, clickListener);
    }

    @Provides
    @Singleton
    HashtagsView provideHashtagsView() {
        return this.view;
    }

    @Provides
    @Singleton
    HashtagsPresenter provideHashtagsPresenter(HashtagsView view, HashtagsInteractor interactor, EventBus eventBus) {
        return new HashtagsPresenterImpl(view, interactor, eventBus);
    }

    @Provides
    @Singleton
    HashtagsInteractor provideHashtagsInteractor(HashtagsRepository repository) {
        return new HashtagsInteractorImpl(repository);
    }

    @Provides
    @Singleton
    HashtagsRepository provideHashtagsRepository(CustomTwitterApiClient client, EventBus eventBus) {
        return new HashtagsRepositoryImpl(client, eventBus);
    }

    @Provides
    @Singleton
    CustomTwitterApiClient provideTwitterApiClient(TwitterSession session) {
        return new CustomTwitterApiClient(session);
    }

    @Provides
    @Singleton
    TwitterSession provideTwitterSession() {
        return Twitter.getSessionManager().getActiveSession();
    }
}
