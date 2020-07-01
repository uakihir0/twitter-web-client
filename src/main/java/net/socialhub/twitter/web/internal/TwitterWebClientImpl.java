package net.socialhub.twitter.web.internal;

import net.socialhub.twitter.web.TwitterWebClient;
import net.socialhub.twitter.web.api.TweetResource;
import net.socialhub.twitter.web.api.UserResource;
import net.socialhub.twitter.web.utility.Const;
import net.socialhub.twitter.web.utility.Token;

public class TwitterWebClientImpl implements TwitterWebClient {

    private String uri;
    private Token token;

    private TweetResource timeline;
    private UserResource user;

    public TwitterWebClientImpl(
            String apiUrl) {

        this.uri = apiUrl;
        this.token = Token.with(apiUrl);

        this.timeline = new TweetResourceImpl(this.uri, this.token);
        this.user = new UserResourceImpl(this.uri, this.token);
    }

    public TwitterWebClientImpl() {
        this(Const.DefaultApiUrl);
    }

    @Override
    public TweetResource timeline() {
        return timeline;
    }

    @Override
    public UserResource user() {
        return user;
    }

    // region
    public String getUri() {
        return uri;
    }

    public Token getToken() {
        return token;
    }
    // endregion
}
