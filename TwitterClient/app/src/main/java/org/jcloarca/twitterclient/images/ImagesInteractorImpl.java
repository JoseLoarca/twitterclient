package org.jcloarca.twitterclient.images;

/**
 * Created by JCLoarca on 6/19/2016 1:38 AM.
 */
public class ImagesInteractorImpl implements ImagesInteractor{
    private ImagesRepository repository;

    public ImagesInteractorImpl(ImagesRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getImages();
    }
}
