package net.socialhub.twitter.web.internal;

import com.google.gson.Gson;
import net.socialhub.http.HttpRequestBuilder;
import net.socialhub.http.HttpResponse;
import net.socialhub.logger.Logger;
import net.socialhub.twitter.web.entity.Request;
import net.socialhub.twitter.web.entity.Response;
import net.socialhub.twitter.web.entity.other.TwitterWebException;
import net.socialhub.twitter.web.utility.Agent;
import net.socialhub.twitter.web.utility.Const;
import net.socialhub.twitter.web.utility.Token;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractResource {

    public static final Gson gson = new Gson();
    public static final Logger log = Logger.getLogger(AbstractResource.class);

    private String baseUrl;
    private Token token;

    public AbstractResource(String baseUrl, Token token) {
        this.baseUrl = baseUrl;
        this.token = token;
    }

    /**
     * GET Request
     */
    public <T> Response<T> get(String path, Request request, Class<T> clazz) {

        HttpRequestBuilder builder = new HttpRequestBuilder();

        // ヘッダー & パラメータ を作成
        Map<String, String> headers = getHeader();
        headers.forEach(builder::header);
        Map<String, String> params = request.params();
        params.forEach(builder::param);

        // UA は設定済みなので上書き防止
        builder.userAgent(null);

        // パスの設定
        builder.target(baseUrl);
        builder.path(path);

        try {
            HttpResponse response = builder.get();
            String json = response.asString();
            T value = gson.fromJson(json, clazz);
            return new Response<>(value);

        } catch (Exception e) {
            throw new TwitterWebException(
                    "Error in request to twitter.", e);
        }
    }

    /**
     * Make header for Twitter Web API
     * https://github.com/zedeus/nitter/blob/master/src/apiutils.nim
     */
    private Map<String, String> getHeader() {
        Map<String, String> header = new HashMap<>();

        header.put("DNT", "1");
        header.put("authorization", Const.AUTH);
        header.put("content-type", "application/json");
        header.put("user-agent", Agent.get());
        header.put("x-guest-token", token());
        header.put("x-twitter-active-user", "yes");
        header.put("authority", "api.twitter.com");
        header.put("accept-language", "en-US,en;q=0.9");
        header.put("accept", "*/*");

        return header;
    }

    // トークンの表現を取得
    private String token() {
        return (token != null) ? token.get() : "";
    }
}
