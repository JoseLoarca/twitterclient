package org.jcloarca.twitterclient.hashtags.di;

import org.jcloarca.twitterclient.TwitterClientModule;
import org.jcloarca.twitterclient.hashtags.ui.HashtagsFragment;
import org.jcloarca.twitterclient.lib.di.LibsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by JCLoarca on 6/20/2016 12:20 AM.
 */
@Singleton
@Component(modules = {HashtagsModule.class, LibsModule.class, TwitterClientModule.class})
public interface HashtagsComponent {
    void inject(HashtagsFragment fragment);
}
