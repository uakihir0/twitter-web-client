package net.socialhub.twitter.web;

import net.socialhub.twitter.web.api.TweetResource;
import net.socialhub.twitter.web.api.UserResource;
import net.socialhub.twitter.web.internal.TwitterWebClientImpl;

public interface TwitterWebClient {

    TweetResource timeline();

    UserResource user();

    class Builder {
        public TwitterWebClient build() {
            return new TwitterWebClientImpl();
        }
    }
}
