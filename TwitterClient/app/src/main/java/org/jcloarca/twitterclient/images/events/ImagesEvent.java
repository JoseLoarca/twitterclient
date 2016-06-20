package org.jcloarca.twitterclient.images.events;

import org.jcloarca.twitterclient.entities.Image;

import java.util.List;

/**
 * Created by JCLoarca on 6/19/2016 1:38 AM.
 */
public class ImagesEvent {
    private String error;
    private List<Image> images;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
