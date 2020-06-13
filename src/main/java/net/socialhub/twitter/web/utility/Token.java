package net.socialhub.twitter.web.utility;

import net.socialhub.http.HttpRequestBuilder;
import net.socialhub.http.HttpResponse;
import net.socialhub.twitter.web.entity.other.TwitterWebException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Token about twitter web api.
 * https://github.com/zedeus/nitter/blob/master/src/tokens.nim
 */
public final class Token {

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
    public static Token with(String url) {
        return new Token(url);
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
            HttpResponse response = builder.get();
            String html = response.asString();

            Pattern pattern = Pattern.compile("gt=([0-9]+); Max-Age=([0-9]+);");
            Matcher matcher = pattern.matcher(html);

            if (matcher.find()) {
                this.value = matcher.group(1);

                // 有効期限を設定 (一分だけ早く有効期限切れとみなす)
                long maxAge = (Long.parseLong(matcher.group(2)) - 60);
                long maxAgeMSec = TimeUnit.SECONDS.toMillis(maxAge);
                this.expired = new Date(new Date().getTime() + maxAgeMSec);
            }

        } catch (Exception e) {
            throw new TwitterWebException(
                    "Cannot get token from twitter.", e);
        }
    }

    // Request header
    private Map<String, String> headers() {
        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        headers.put("user-agent", "Mozilla/5.0 (X11; Linux x86_64; rv:75.0) Gecko/20100101 Firefox/75.0");
        headers.put("accept-language", "en-US,en;q=0.5");
        headers.put("connection", "keep-alive");
        return headers;
    }
}
