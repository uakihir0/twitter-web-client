package net.socialhub.twitter.web.entity.request.favorite;

import com.google.gson.Gson;
import net.socialhub.twitter.web.entity.request.graphql.GraphRequest;

import java.util.HashMap;
import java.util.Map;

public class UnfavoriteTweetRequest implements GraphRequest {

    private String tweetId;

    @Override
    public Map<String, Object> params() {
        Map<String, Object> variables = new HashMap<>();
        put(variables, "tweet_id", getTweetId());

        Map<String, Object> params = new HashMap<>();
        put(params, "queryId", "ZYKSe-w7KEslx3JhSIk5LA");
        put(params, "variables", new Gson().toJson(variables));
        return params;
    }

    // region
    public static UnfavoriteTweetRequestBuilder builder() {
        return new UnfavoriteTweetRequestBuilder();
    }

    public String getTweetId() {
        return tweetId;
    }

    public static final class UnfavoriteTweetRequestBuilder {
        private String tweetId;

        private UnfavoriteTweetRequestBuilder() {
        }


        public UnfavoriteTweetRequestBuilder tweetId(String tweetId) {
            this.tweetId = tweetId;
            return this;
        }

        public UnfavoriteTweetRequest build() {
            UnfavoriteTweetRequest unfavoriteTweetRequest = new UnfavoriteTweetRequest();
            unfavoriteTweetRequest.tweetId = this.tweetId;
            return unfavoriteTweetRequest;
        }
    }
    // endregion
}
