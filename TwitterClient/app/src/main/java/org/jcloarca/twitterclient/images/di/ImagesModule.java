package org.jcloarca.twitterclient.images.di;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Session;

import org.jcloarca.twitterclient.api.CustomTwitterApiClient;
import org.jcloarca.twitterclient.entities.Image;
import org.jcloarca.twitterclient.images.ImagesInteractor;
import org.jcloarca.twitterclient.images.ImagesInteractorImpl;
import org.jcloarca.twitterclient.images.ImagesPresenter;
import org.jcloarca.twitterclient.images.ImagesPresenterImpl;
import org.jcloarca.twitterclient.images.ImagesRepository;
import org.jcloarca.twitterclient.images.ImagesRepositoryImpl;
import org.jcloarca.twitterclient.images.ui.ImagesView;
import org.jcloarca.twitterclient.images.ui.adapter.ImagesAdapter;
import org.jcloarca.twitterclient.images.ui.adapter.OnItemClickListener;
import org.jcloarca.twitterclient.lib.base.EventBus;
import org.jcloarca.twitterclient.lib.base.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JCLoarca on 6/19/2016 8:43 PM.
 */
@Module
public class ImagesModule {
    private ImagesView view;
    private OnItemClickListener clickListener;

    public ImagesModule(ImagesView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    ImagesAdapter providesAdapter(List<Image> dataset, ImageLoader imageLoader, OnItemClickListener clickListener){
        return new ImagesAdapter(dataset, imageLoader, clickListener);
    }

    @Provides
    @Singleton
    OnItemClickListener providesOnItemClickListener(){
        return this.clickListener;
    }

    @Provides
    @Singleton
    List<Image> providesItemsList(){
        return new ArrayList<Image>();
    }

    @Provides
    @Singleton
    ImagesPresenter providesImagePresenter(ImagesView view, EventBus eventBus, ImagesInteractor interactor){
        return new ImagesPresenterImpl(view, eventBus, interactor);
    }

    @Provides
    @Singleton
    ImagesView providesImagesView(){
        return this.view;
    }

    @Provides
    @Singleton
    ImagesInteractor providesImagesInteractor(ImagesRepository repository){
        return new ImagesInteractorImpl(repository);
    }

    @Provides
    @Singleton
    ImagesRepository providesImagesRepository(EventBus eventBus, CustomTwitterApiClient client){
        return new ImagesRepositoryImpl(eventBus, client);
    }

    @Provides
    @Singleton
    CustomTwitterApiClient providesCustomTwitterApiClient(Session session){
        return new CustomTwitterApiClient(session);
    }

    @Provides
    @Singleton
    Session providesTwitter(){
        return Twitter.getSessionManager().getActiveSession();
    }
}
