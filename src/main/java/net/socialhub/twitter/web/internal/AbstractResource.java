package net.socialhub.twitter.web.internal;

import com.google.gson.Gson;
import net.socialhub.http.HttpRequestBuilder;
import net.socialhub.http.HttpResponse;
import net.socialhub.logger.Logger;
import net.socialhub.twitter.web.entity.request.graphql.GraphRequest;
import net.socialhub.twitter.web.entity.Request;
import net.socialhub.twitter.web.entity.Response;
import net.socialhub.twitter.web.entity.other.TwitterWebException;
import net.socialhub.twitter.web.utility.Config;
import net.socialhub.twitter.web.utility.Session;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static java.util.Collections.singletonMap;

public abstract class AbstractResource {
    public static final Logger log = Logger.getLogger(AbstractResource.class);

    public static final Gson gson = new Gson();
    private final Session session;
    private final Config config;

    public AbstractResource(Session session) {
        this.config = session.getConfig();
        this.session = session;
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
     * POST Request
     */
    public <T> Response<T> post(String path, String json, Class<T> clazz) {
        HttpRequestBuilder builder = getInitializedBuilder(path);

        // ヘッダー & パラメータ を作成
        Map<String, String> headers = getHeader();
        headers.forEach(builder::header);
        builder.json(json);

        return post(builder, clazz);
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
     * リクエストを送信
     */
    protected <T> Response<T> get(HttpRequestBuilder builder, Class<T> clazz) {

        try {
            HttpResponse response = builder.get();
            String json = response.asString();

            session.getCookie().set(response
                    .getResponseHeaderFields()
                    .get("set-cookie"));

            T value = gson.fromJson(json, clazz);
            return new Response<>(value);

        } catch (Exception e) {
            throw new TwitterWebException(
                    "Error in request to twitter.", e);
        }
    }

    /**
     * リクエストを送信
     */
    protected <T> Response<T> post(HttpRequestBuilder builder, Class<T> clazz) {

        try {
            HttpResponse response = builder.post();
            String json = response.asString();

            session.getCookie().set(response
                    .getResponseHeaderFields()
                    .get("set-cookie"));

            T value = gson.fromJson(json, clazz);
            return new Response<>(value);

        } catch (Exception e) {
            throw new TwitterWebException(
                    "Error in request to twitter.", e);
        }
    }

    /**
     * Make header for Twitter Web API
     * <a href="https://github.com/zedeus/nitter/blob/master/src/apiutils.nim">Reference</a>
     */
    private Map<String, String> getHeader() {
        Map<String, String> header = new HashMap<>();

        header.put("DNT", "1");
        header.put("authorization", config.getAuthentication());
        header.put("content-type", "application/json");
        header.put("user-agent", config.getUserAgent());
        header.put("x-csrf-token", session.getCt0());
        header.put("x-guest-token", session.getGuestToken());
        header.put("x-twitter-active-user", "yes");
        header.put("cookie", session.getCookie().toString());
        // header.put("x-twitter-auth-type", "OAuth2Session");
        header.put("authority", "api.twitter.com");
        header.put("accept-language", "en-US,en;q=0.9");
        header.put("accept", "*/*");

        return header;
    }


    /**
     * 初期設定済みのリクエストクライアントを作成
     */
    protected HttpRequestBuilder getInitializedBuilder(String path) {
        HttpRequestBuilder builder = new HttpRequestBuilder();

        // UA は設定済みなので上書き防止
        builder.userAgent(null);

        // パスの設定
        builder.target(config.getApiUri());
        builder.path(path);
        return builder;
    }

    private String graphToken() {
        return UUID.randomUUID().toString();
    }
}
