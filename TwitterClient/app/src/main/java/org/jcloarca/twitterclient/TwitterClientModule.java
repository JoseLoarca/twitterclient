package org.jcloarca.twitterclient;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JCLoarca on 6/20/2016 12:22 AM.
 */
@Module
public class TwitterClientModule {
    Context context;

    public TwitterClientModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return this.context;
    }
}
