package net.socialhub.twitter.web;

import net.socialhub.twitter.web.api.TimelineResource;
import net.socialhub.twitter.web.internal.TwitterWebClientImpl;

public interface TwitterWebClient {

    TimelineResource timeline();

    class Builder {
        public TwitterWebClient build() {
            return new TwitterWebClientImpl();
        }
    }
}
