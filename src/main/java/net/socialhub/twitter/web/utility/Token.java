package net.socialhub.twitter.web.utility;

import com.google.gson.Gson;
import net.socialhub.http.HttpRequestBuilder;
import net.socialhub.http.HttpResponse;
import net.socialhub.twitter.web.entity.other.TwitterWebException;
import net.socialhub.twitter.web.entity.response.Session;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Token about twitter web api.
 * https://github.com/zedeus/nitter/blob/master/src/tokens.nim
 */
public final class Token {

    private static final Gson gson = new Gson();

    private String url;
    private String value;
    private Date expired;

    private Token(String url) {
        this.url = url;
    }

    /**
     * Get token object with specified url.
     * 特定の URL を指定してトークンを取得
     */
    public static Token with(String baseUrl) {
        return new Token(baseUrl + Endpoint.Activate.path());
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

        HttpRequestBuilder builder = new HttpRequestBuilder();
        headers().forEach(builder::header);
        builder.target(url);

        try {
            HttpResponse response = builder.post();
            Session session = gson.fromJson(response.asString(), Session.class);

            this.value = session.getGuestToken();
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
        headers.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        headers.put("accept-language", "en-US,en;q=0.5");
        headers.put("connection", "keep-alive");
        headers.put("authorization", Const.AUTH);
        headers.put("user-agent", Agent.get());

        return headers;
    }
}
