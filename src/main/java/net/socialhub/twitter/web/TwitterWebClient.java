package net.socialhub.twitter.web;

import net.socialhub.twitter.web.api.LoginResource;
import net.socialhub.twitter.web.api.SearchResource;
import net.socialhub.twitter.web.api.TimelineResource;
import net.socialhub.twitter.web.api.TweetResource;
import net.socialhub.twitter.web.api.UserResource;
import net.socialhub.twitter.web.internal.TwitterWebClientImpl;
import net.socialhub.twitter.web.utility.Session;

public interface TwitterWebClient {

    LoginResource login();
    TweetResource tweet();
    TimelineResource timeline();
    UserResource user();
    SearchResource search();

    Session getSession();
    String getBaseUri();

    class Builder {
        public TwitterWebClient build() {
            return new TwitterWebClientImpl();
        }
    }
}
