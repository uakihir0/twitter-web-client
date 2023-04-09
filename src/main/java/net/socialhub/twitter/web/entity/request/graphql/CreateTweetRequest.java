package net.socialhub.twitter.web.entity.request.graphql;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class CreateTweetRequest implements GraphRequest {

    private String text;

    @Override
    public Map<String, Object> params() {
        Map<String, Object> media = new HashMap<>();
        put(media, "media_entities", new String[]{});
        put(media, "possibly_sensitive", false);

        Map<String, Object> variables = new HashMap<>();
        put(variables, "tweet_text", text);
        put(variables, "media", media);
        put(variables, "withDownvotePerspective", false);
        put(variables, "withReactionsMetadata", false);
        put(variables, "withReactionsPerspective", false);
        put(variables, "withSuperFollowsTweetFields", true);
        put(variables, "withSuperFollowsUserFields", false);
        put(variables, "semantic_annotation_ids", new String[]{});
        put(variables, "dark_request", false);
        put(variables, "withBirdwatchPivots", false);

        Map<String, Object> params = new HashMap<>();
        put(params, "queryId", "XyvN0Wv13eeu_gVIHDi10g");
        put(params, "variables", new Gson().toJson(variables));
        return params;
    }

    // region
    public static CreateTweetRequestBuilder builder() {
        return new CreateTweetRequestBuilder();
    }

    public String getText() {
        return text;
    }

    public static final class CreateTweetRequestBuilder {
        private String text;

        private CreateTweetRequestBuilder() {
        }

        public CreateTweetRequestBuilder text(String text) {
            this.text = text;
            return this;
        }

        public CreateTweetRequest build() {
            CreateTweetRequest createTweetRequest = new CreateTweetRequest();
            createTweetRequest.text = this.text;
            return createTweetRequest;
        }
    }
    // endregion
}
