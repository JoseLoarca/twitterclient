package org.jcloarca.twitterclient.lib.di;

import android.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import org.jcloarca.twitterclient.lib.GlideImageLoader;
import org.jcloarca.twitterclient.lib.GreenRobotEventBus;
import org.jcloarca.twitterclient.lib.base.EventBus;
import org.jcloarca.twitterclient.lib.base.ImageLoader;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JCLoarca on 6/17/2016 11:20 PM.
 */
@Module
public class LibsModule {
    private Fragment fragment;

    @Provides
    @Singleton
    ImageLoader providesImageLoader(RequestManager requestManager){
        return new GlideImageLoader(requestManager);
    }

    @Provides
    @Singleton
    RequestManager providesRequestManager(Fragment fragment){
        return Glide.with(fragment);
    }

    @Provides
    @Singleton
    Fragment providesFragment(){
        return this.fragment;
    }

    @Provides
    @Singleton
    EventBus providesEventBus(org.greenrobot.eventbus.EventBus eventBus){
        return new GreenRobotEventBus(eventBus);
    }

    @Provides
    @Singleton
    org.greenrobot.eventbus.EventBus providesLibraryEventBus(){
        return org.greenrobot.eventbus.EventBus.getDefault();
    }
}
