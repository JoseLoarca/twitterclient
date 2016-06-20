package org.jcloarca.twitterclient.images.di;

import org.jcloarca.twitterclient.images.ImagesPresenter;
import org.jcloarca.twitterclient.images.ui.ImagesFragment;
import org.jcloarca.twitterclient.lib.di.LibsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by JCLoarca on 6/19/2016 8:43 PM.
 */
@Singleton @Component(modules = {LibsModule.class, ImagesModule.class})
public interface ImagesComponent {
    void inject(ImagesFragment fragment);
    ImagesPresenter getPresenter();
}
