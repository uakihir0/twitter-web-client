package net.socialhub.twitter.web.internal;

import net.socialhub.twitter.web.TwitterWebClient;
import net.socialhub.twitter.web.api.TimelineResource;
import net.socialhub.twitter.web.utility.Const;
import net.socialhub.twitter.web.utility.Token;

public class TwitterWebClientImpl implements TwitterWebClient {

    private String uri;
    private Token token;

    private TimelineResource timeline;

    public TwitterWebClientImpl(
            String apiUrl,
            String webUrl) {

        this.uri = apiUrl;
        this.token = Token.with(webUrl);

        this.timeline = new TimelineResourceImpl(this.uri, this.token);
    }

    public TwitterWebClientImpl() {
        this(Const.DefaultApiUrl, Const.DefaultWebUrl);
    }

    @Override
    public TimelineResource timeline() {
        return timeline;
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
