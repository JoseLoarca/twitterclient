package org.jcloarca.twitterclient.images;

import org.jcloarca.twitterclient.entities.Image;

import java.util.List;

/**
 * Created by JCLoarca on 6/19/2016 1:30 AM.
 */
public interface ImagesView {
    void showElements();
    void hideElements();
    void showProgress();
    void hideProgress();

    void onError(String error);
    void setContent(List<Image>items);
}
