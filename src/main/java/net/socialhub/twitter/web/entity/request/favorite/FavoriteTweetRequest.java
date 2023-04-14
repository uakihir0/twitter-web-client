package net.socialhub.twitter.web.entity.request.favorite;

import net.socialhub.twitter.web.entity.request.GraphRequest;

import java.util.HashMap;
import java.util.Map;

public class FavoriteTweetRequest implements GraphRequest {

    private String tweetId;

    @Override
    public Map<String, Object> params() {
        Map<String, Object> variables = new HashMap<>();
        put(variables, "tweet_id", getTweetId());

        Map<String, Object> params = new HashMap<>();
        put(params, "queryId", "lI07N6Otwv1PhnEgXILM7A");
        put(params, "variables", getGson().toJson(variables));
        return params;
    }

    // region
    public static FavoriteTweetRequestBuilder builder() {
        return new FavoriteTweetRequestBuilder();
    }

    public String getTweetId() {
        return tweetId;
    }

    public static final class FavoriteTweetRequestBuilder {
        private String tweetId;

        private FavoriteTweetRequestBuilder() {
        }

        public FavoriteTweetRequestBuilder tweetId(String tweetId) {
            this.tweetId = tweetId;
            return this;
        }

        public FavoriteTweetRequest build() {
            FavoriteTweetRequest favoriteTweetRequest = new FavoriteTweetRequest();
            favoriteTweetRequest.tweetId = this.tweetId;
            return favoriteTweetRequest;
        }
    }
}
