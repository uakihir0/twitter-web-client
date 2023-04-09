package net.socialhub.twitter.web.utility;

import com.google.gson.Gson;
import net.socialhub.http.HttpRequestBuilder;
import net.socialhub.http.HttpResponse;
import net.socialhub.twitter.web.entity.other.TwitterWebException;
import net.socialhub.twitter.web.entity.response.GuestSession;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Token about twitter web api.
 * <a href="https://github.com/zedeus/nitter/blob/master/src/tokens.nim">Reference</a>
 */
public final class GuestToken {

    private static final Gson gson = new Gson();
    private final Session session;
    private String value;
    private Date expired;

    public GuestToken(Session session) {
        this.session = session;
    }

    /**
     * Get token value.
     * (request if needed.)
     */
    public String get() {

        // 期限が設定されていない (初回) or 期限切れの場合
        if (expired == null || expired.before(new Date())) {
            request();
        }
        return value;
    }

    // Request
    private void request() {

        String url = session.getConfig().getApiUri() + Endpoint.Activate.path();
        HttpRequestBuilder builder = new HttpRequestBuilder();
        headers().forEach(builder::header);
        builder.target(url);

        try {
            HttpResponse response = builder.post();
            GuestSession guestSession = gson.fromJson(response.asString(), GuestSession.class);

            this.value = guestSession.getGuestToken();
            long maxAgeMSec = TimeUnit.MINUTES.toMillis(15);
            this.expired = new Date(new Date().getTime() + maxAgeMSec);

        } catch (Exception e) {
            throw new TwitterWebException(
                    "Cannot get token from twitter.", e);
        }
    }

    // Request header
    private Map<String, String> headers() {
        Map<String, String> headers = new HashMap<>();

        headers.put("connection", "keep-alive");
        headers.put("accept-language", "en-US,en;q=0.9");
        headers.put("accept", "*/*");

        headers.put("authorization", session.getConfig().getAuthentication());
        headers.put("user-agent", session.getConfig().getUserAgent());

        return headers;
    }
}
