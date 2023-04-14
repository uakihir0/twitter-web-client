package net.socialhub.twitter.web.entity.request.retweet;

import net.socialhub.twitter.web.entity.request.GraphRequest;

import java.util.HashMap;
import java.util.Map;

public class DeleteRetweetRequest implements GraphRequest {

    private String sourceTweetId;

    @Override
    public Map<String, Object> params() {
        Map<String, Object> variables = new HashMap<>();
        put(variables, "source_tweet_id", getSourceTweetId());
        put(variables, "dark_request", false);

        Map<String, Object> params = new HashMap<>();
        put(params, "queryId", "iQtK4dl5hBmXewYZuEOKVw");
        put(params, "variables", getGson().toJson(variables));
        return params;
    }

    // region
    public static DeleteRetweetRequestBuilder builder() {
        return new DeleteRetweetRequestBuilder();
    }

    public String getSourceTweetId() {
        return sourceTweetId;
    }

    public static final class DeleteRetweetRequestBuilder {
        private String sourceTweetId;

        private DeleteRetweetRequestBuilder() {
        }

        public DeleteRetweetRequestBuilder sourceTweetId(String sourceTweetId) {
            this.sourceTweetId = sourceTweetId;
            return this;
        }

        public DeleteRetweetRequest build() {
            DeleteRetweetRequest deleteRetweetRequest = new DeleteRetweetRequest();
            deleteRetweetRequest.sourceTweetId = this.sourceTweetId;
            return deleteRetweetRequest;
        }
    }
    // endregion
}
