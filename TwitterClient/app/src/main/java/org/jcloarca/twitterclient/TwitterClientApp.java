package org.jcloarca.twitterclient;

import android.app.Application;
import android.support.v4.app.Fragment;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import org.jcloarca.twitterclient.images.di.DaggerImagesComponent;
import org.jcloarca.twitterclient.images.di.ImagesComponent;
import org.jcloarca.twitterclient.images.di.ImagesModule;
import org.jcloarca.twitterclient.images.ui.ImagesView;
import org.jcloarca.twitterclient.images.ui.adapter.OnItemClickListener;
import org.jcloarca.twitterclient.lib.di.LibsModule;

import io.fabric.sdk.android.Fabric;

/**
 * Created by JCLoarca on 6/17/2016 1:02 AM.
 */
public class TwitterClientApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initFabric();
    }

    private void initFabric() {
        TwitterAuthConfig authConfig = new TwitterAuthConfig(BuildConfig.TWITTER_KEY, BuildConfig.TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
    }

    public ImagesComponent getImagesComponent(Fragment fragment, ImagesView view, OnItemClickListener clickListener){
        return DaggerImagesComponent
                .builder()
                .libsModule(new LibsModule(fragment))
                .imagesModule(new ImagesModule(view, clickListener))
                .build();
    }
}
