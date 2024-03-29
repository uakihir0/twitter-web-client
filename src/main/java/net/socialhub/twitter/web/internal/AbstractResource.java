package net.socialhub.twitter.web.internal;

import com.google.gson.Gson;
import net.socialhub.http.HttpMediaType;
import net.socialhub.http.HttpRequestBuilder;
import net.socialhub.http.HttpResponse;
import net.socialhub.logger.Logger;
import net.socialhub.twitter.web.entity.request.Request;
import net.socialhub.twitter.web.entity.response.Response;
import net.socialhub.twitter.web.entity.other.TwitterWebException;
import net.socialhub.twitter.web.entity.request.GraphRequest;
import net.socialhub.twitter.web.utility.Config;
import net.socialhub.twitter.web.utility.Session;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
        params.forEach(builder::param);

        //System.out.println(gson.toJson(params));
        //Map<String, String> variables = singletonMap("variables", gson.toJson(params));
        //variables.forEach(builder::param);

        return get(builder, clazz);
    }

    /**
     * POST Request (GraphQL Endpoint)
     */
    public <T> Response<T> graphPost(String path, GraphRequest request, Class<T> clazz) {
        HttpRequestBuilder builder = getInitializedBuilder(path);

        // ヘッダー & パラメータ を作成
        Map<String, String> headers = getHeader();
        headers.forEach(builder::header);
        builder.json(gson.toJson(request.params()));

        return post(builder, clazz);
    }


    /**
     * Legacy (v1.1) POST Request
     */
    public <T> Response<T> legacyPost(String path, Request request, Class<T> clazz) {
        HttpRequestBuilder builder = getInitializedBuilder(path);

        // ヘッダー & パラメータ を作成
        Map<String, String> headers = getLegacyHeader();
        headers.forEach(builder::header);
        Map<String, String> params = request.params();
        params.forEach(builder::param);

        return post(builder, clazz);
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

            // Save response text for debug
            // FileWriter fw = new FileWriter("response.txt");
            // fw.write(json);
            // fw.close();

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

        header.put("authorization", config.getAuthentication());
        header.put("content-type", HttpMediaType.APPLICATION_JSON);
        header.put("user-agent", config.getUserAgent());
        header.put("x-csrf-token", session.getCt0());
        header.put("x-guest-token", session.getGuestToken());
        header.put("x-twitter-active-user", "yes");

        header.put("cookie", session.getCookie().toString());
        header.put("authority", "api.twitter.com");
        header.put("accept-language", "en-US,en;q=0.9");
        header.put("accept", "*/*");

        return header;
    }

    /**
     * Make legacy header for Twitter Web API
     */
    private Map<String, String> getLegacyHeader() {
        Map<String, String> header = new HashMap<>();

        header.put("authorization", config.getAuthentication());
        header.put("content-type", HttpMediaType.APPLICATION_FORM_URLENCODED);
        header.put("user-agent", config.getUserAgent());
        header.put("x-csrf-token", session.getCt0());
        header.put("x-twitter-active-user", "yes");
        header.put("x-twitter-auth-type", "OAuth2Session");

        header.put("cookie", session.getCookie().toString());
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
