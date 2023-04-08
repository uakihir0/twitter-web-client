package net.socialhub.twitter.web.internal;

import net.socialhub.twitter.web.TwitterWebClient;
import net.socialhub.twitter.web.api.LoginResource;
import net.socialhub.twitter.web.api.SearchResource;
import net.socialhub.twitter.web.api.TimelineResource;
import net.socialhub.twitter.web.api.TweetResource;
import net.socialhub.twitter.web.api.UserResource;
import net.socialhub.twitter.web.utility.Const;
import net.socialhub.twitter.web.utility.GuestToken;
import net.socialhub.twitter.web.utility.Session;

public class TwitterWebClientImpl implements TwitterWebClient {

    private String uri;
    private Session session;

    private LoginResource login;
    private TweetResource tweet;
    private TimelineResource timeline;
    private UserResource user;
    private SearchResource search;

    public TwitterWebClientImpl(
            String apiUrl) {

        this.uri = apiUrl;
        this.session = new Session();
        this.session.setGuestToken(GuestToken.with(apiUrl));

        this.login = new LoginResourceImpl(this.uri, this.session);
        this.tweet = new TweetResourceImpl(this.uri, this.session);
        this.user = new UserResourceImpl(this.uri, this.session);
        this.timeline = new TimelineResourceImpl(this.uri, this.session);
        this.search = new SearchResourceImpl(this.uri, this.session);
    }

    public TwitterWebClientImpl() {
        this(Const.DefaultApiUrl);
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

    // region
    public String getUri() {
        return uri;
    }

    public Session getSession() {
        return session;
    }
    // endregion
}
