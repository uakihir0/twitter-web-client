package net.socialhub.twitter.web;

import net.socialhub.twitter.web.api.FavoriteResource;
import net.socialhub.twitter.web.api.LoginResource;
import net.socialhub.twitter.web.api.RetweetResource;
import net.socialhub.twitter.web.api.SearchResource;
import net.socialhub.twitter.web.api.TimelineResource;
import net.socialhub.twitter.web.api.TweetResource;
import net.socialhub.twitter.web.api.UserResource;
import net.socialhub.twitter.web.utility.Session;

public interface TwitterWebClient {

    LoginResource login();
    TweetResource tweet();
    TimelineResource timeline();
    UserResource user();
    SearchResource search();
    FavoriteResource favorite();
    RetweetResource retweet();

    Session getSession();

    class Builder {
        public TwitterWebClient build() {
            return new TwitterWebClientImpl();
        }
    }
}
