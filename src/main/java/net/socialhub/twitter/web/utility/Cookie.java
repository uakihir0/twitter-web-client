package net.socialhub.twitter.web.utility;

import net.socialhub.http.HttpRequestBuilder;
import net.socialhub.http.HttpResponse;
import net.socialhub.twitter.web.entity.other.TwitterWebException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cookie {

    public Cookie(Config config) {
        this.config = config;
    }

    private static final String URL = "https://twitter.com/";

    private final Map<String, String> params = new HashMap<>();

    private final Config config;

    public String getCt0() {

        // 初回リクエストがまだなので実行
        // リクエストがあれば最低でも空文字が含まれている
        if (params.get("ct0") == null) {
            request();
        }
        return params.get("ct0");
    }

    public void set(List<String> cookies) {
        if (cookies != null) {
            cookies.forEach(cookie -> {
                String[] elements = cookie.split(";")[0].split("=");
                String value = (elements.length > 1) ? elements[1] : "";
                String key = elements[0];
                params.put(key, value);
            });
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        params.forEach((key, value) ->
                builder.append(key)
                        .append("=")
                        .append(value)
                        .append(";"));
        return builder.toString();
    }

    private void request() {

        HttpRequestBuilder builder = new HttpRequestBuilder();
        headers().forEach(builder::header);
        builder.target(URL);

        try {
            HttpResponse response = builder.get();
            response.asString();

            // Cookie を格納
            set(response
                    .getResponseHeaderFields()
                    .get("set-cookie"));

        } catch (Exception e) {
            throw new TwitterWebException(
                    "Cannot cookie from twitter.", e);
        }
    }

    private Map<String, String> headers() {
        Map<String, String> headers = new HashMap<>();
        headers.put("user-agent", config.getUserAgent());
        return headers;
    }
}
