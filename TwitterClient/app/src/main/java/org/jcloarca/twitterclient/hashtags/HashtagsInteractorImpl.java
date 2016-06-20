package org.jcloarca.twitterclient.hashtags;

/**
 * Created by JCLoarca on 6/20/2016 12:25 AM.
 */
public class HashtagsInteractorImpl implements HashtagsInteractor {
    private HashtagsRepository hashtagsRepository;

    public HashtagsInteractorImpl(HashtagsRepository hashtagsRepository) {
        this.hashtagsRepository = hashtagsRepository;
    }

    @Override
    public void getHashtagItemsList() {
        hashtagsRepository.getHashtags();
    }
}
