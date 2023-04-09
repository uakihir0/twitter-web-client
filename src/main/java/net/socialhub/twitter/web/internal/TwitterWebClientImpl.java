package net.socialhub.twitter.web.internal;

import net.socialhub.twitter.web.TwitterWebClient;
import net.socialhub.twitter.web.api.LoginResource;
import net.socialhub.twitter.web.api.SearchResource;
import net.socialhub.twitter.web.api.TimelineResource;
import net.socialhub.twitter.web.api.TweetResource;
import net.socialhub.twitter.web.api.UserResource;
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

    public TwitterWebClientImpl(Config config) {

        this.session = new Session(config);
        this.session.setGuestToken(new GuestToken(this.session));

        this.login = new LoginResourceImpl(this.session);
        this.tweet = new TweetResourceImpl(this.session);
        this.user = new UserResourceImpl(this.session);
        this.timeline = new TimelineResourceImpl(this.session);
        this.search = new SearchResourceImpl(this.session);
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
    public Session getSession() {
        return session;
    }
}
