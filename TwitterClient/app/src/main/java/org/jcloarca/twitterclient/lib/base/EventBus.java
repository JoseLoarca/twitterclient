package org.jcloarca.twitterclient.lib.base;

/**
 * Created by JCLoarca on 6/17/2016 10:34 PM.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister (Object unsubscriber);
    void post (Object event);

}
