package net.socialhub.twitter.web.internal;

import com.google.gson.Gson;
import net.socialhub.http.HttpRequestBuilder;
import net.socialhub.http.HttpResponse;
import net.socialhub.logger.Logger;
import net.socialhub.twitter.web.entity.request.graphql.GraphRequest;
import net.socialhub.twitter.web.entity.Request;
import net.socialhub.twitter.web.entity.Response;
import net.socialhub.twitter.web.entity.other.TwitterWebException;
import net.socialhub.twitter.web.utility.Agent;
import net.socialhub.twitter.web.utility.Const;
import net.socialhub.twitter.web.utility.Token;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static java.util.Collections.singletonMap;

public abstract class AbstractResource {

    public static final Gson gson = new Gson();
    public static final Logger log = Logger.getLogger(AbstractResource.class);

    private final String baseUrl;
    private final Token token;

    public AbstractResource(String baseUrl, Token token) {
        this.baseUrl = baseUrl;
        this.token = token;
    }

    /**
     * GET Request
     */
    public <T> Response<T> get(String path, Request request, Class<T> clazz) {
        HttpRequestBuilder builder = getInitializedBuilder(path);

        // ヘッダー & パラメータ を作成
        Map<String, String> headers = getHeader();
        headers.forEach(builder::header);
        Map<String, String> params = request.params();
        params.forEach(builder::param);

        return get(builder, clazz);
    }

    /**
     * GET Request (GraphQL Endpoint)
     */
    public <T> Response<T> graphGet(String path, GraphRequest request, Class<T> clazz) {
        HttpRequestBuilder builder = getInitializedBuilder(path);

        // ヘッダー & パラメータ を作成
        Map<String, String> headers = getHeader();
        headers.forEach(builder::header);
        Map<String, Object> params = request.params();
        System.out.println(gson.toJson(params));
        Map<String, String> variables = singletonMap("variables", gson.toJson(params));
        variables.forEach(builder::param);

        return get(builder, clazz);
    }

    /**
     * 初期設定済みのリクエストクライアントを作成
     */
    private HttpRequestBuilder getInitializedBuilder(String path) {
        HttpRequestBuilder builder = new HttpRequestBuilder();

        // UA は設定済みなので上書き防止
        builder.userAgent(null);

        // パスの設定
        builder.target(baseUrl);
        builder.path(path);
        return builder;
    }

    /**
     * リクエストを送信
     */
    private <T> Response<T> get(HttpRequestBuilder builder, Class<T> clazz) {

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

    private String graphToken() {
        return UUID.randomUUID().toString();
    }
}
