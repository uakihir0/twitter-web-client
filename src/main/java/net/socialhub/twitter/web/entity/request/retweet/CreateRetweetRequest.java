package net.socialhub.twitter.web.entity.request.retweet;

import com.google.gson.Gson;
import net.socialhub.twitter.web.entity.request.graphql.GraphRequest;

import java.util.HashMap;
import java.util.Map;

public class CreateRetweetRequest  implements GraphRequest {

    private String tweetId;

    @Override
    public Map<String, Object> params() {
        Map<String, Object> variables = new HashMap<>();
        put(variables, "tweet_id", getTweetId());
        put(variables, "dark_request", false);

        Map<String, Object> params = new HashMap<>();
        put(params, "queryId", "ojPdsZsimiJrUGLR1sjUtA");
        put(params, "variables", new Gson().toJson(variables));
        return params;
    }

    // region
    public static CreateRetweetRequestBuilder builder() {
        return new CreateRetweetRequestBuilder();
    }

    public String getTweetId() {
        return tweetId;
    }

    public static final class CreateRetweetRequestBuilder {
        private String tweetId;

        private CreateRetweetRequestBuilder() {
        }


        public CreateRetweetRequestBuilder tweetId(String tweetId) {
            this.tweetId = tweetId;
            return this;
        }

        public CreateRetweetRequest build() {
            CreateRetweetRequest createRetweetRequest = new CreateRetweetRequest();
            createRetweetRequest.tweetId = this.tweetId;
            return createRetweetRequest;
        }
    }
    // endregion
}
