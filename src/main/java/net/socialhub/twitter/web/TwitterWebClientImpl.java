package net.socialhub.twitter.web;

import net.socialhub.twitter.web.TwitterWebClient;
import net.socialhub.twitter.web.api.FavoriteResource;
import net.socialhub.twitter.web.api.LoginResource;
import net.socialhub.twitter.web.api.RetweetResource;
import net.socialhub.twitter.web.api.SearchResource;
import net.socialhub.twitter.web.api.TimelineResource;
import net.socialhub.twitter.web.api.TweetResource;
import net.socialhub.twitter.web.api.UserResource;
import net.socialhub.twitter.web.internal.FavoriteResourceImpl;
import net.socialhub.twitter.web.internal.LoginResourceImpl;
import net.socialhub.twitter.web.internal.RetweetResourceImpl;
import net.socialhub.twitter.web.internal.SearchResourceImpl;
import net.socialhub.twitter.web.internal.TimelineResourceImpl;
import net.socialhub.twitter.web.internal.TweetResourceImpl;
import net.socialhub.twitter.web.internal.UserResourceImpl;
import net.socialhub.twitter.web.utility.Config;
import net.socialhub.twitter.web.utility.GuestToken;
import net.socialhub.twitter.web.utility.Session;

public class TwitterWebClientImpl implements TwitterWebClient {

    private final Session session;

    private final LoginResource login;
    private final TweetResource tweet;
    private final TimelineResource timeline;
    private final UserResource user;
    private final SearchResource search;
    private final FavoriteResource favorite;
    private final RetweetResource retweet;

    public TwitterWebClientImpl(Config config) {

        this.session = new Session(config);
        this.session.setGuestToken(new GuestToken(this.session));

        this.login = new LoginResourceImpl(this.session);
        this.tweet = new TweetResourceImpl(this.session);
        this.user = new UserResourceImpl(this.session);
        this.timeline = new TimelineResourceImpl(this.session);
        this.search = new SearchResourceImpl(this.session);
        this.favorite = new FavoriteResourceImpl(this.session);
        this.retweet = new RetweetResourceImpl(this.session);
    }

    public TwitterWebClientImpl() {
        this(new Config());
    }

    @Override
    public LoginResource login() {
        return login;
    }

    @Override
    public TweetResource tweet() {
        return tweet;
    }

    @Override
    public TimelineResource timeline() {
        return timeline;
    }

    @Override
    public UserResource user() {
        return user;
    }

    @Override
    public SearchResource search() {
        return search;
    }

    @Override
    public FavoriteResource favorite() {
        return favorite;
    }

    @Override
    public RetweetResource retweet() {
        return retweet;
    }

    @Override
    public Session getSession() {
        return session;
    }
}
