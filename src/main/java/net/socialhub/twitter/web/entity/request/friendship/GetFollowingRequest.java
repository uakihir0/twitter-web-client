package net.socialhub.twitter.web.entity.request.friendship;

import net.socialhub.twitter.web.entity.request.GraphRequest;

import java.util.HashMap;
import java.util.Map;

public class GetFollowingRequest implements GraphRequest {

    private String userId;
    private Integer count;
    private String cursor;
    private Boolean includePromotedContent;

    @Override
    public Map<String, Object> params() {

        Map<String, Object> variables = new HashMap<>();
        put(variables, "userId", getUserId());
        put(variables, "count", getCount());
        put(variables, "cursor", getCursor());
        put(variables, "includePromotedContent", getIncludePromotedContent());

        Map<String, Object> features = new HashMap<>();
        put(features, "blue_business_profile_image_shape_enabled", true);
        put(features, "responsive_web_graphql_exclude_directive_enabled", true);
        put(features, "verified_phone_label_enabled", false);
        put(features, "responsive_web_graphql_timeline_navigation_enabled", true);
        put(features, "responsive_web_graphql_skip_user_profile_image_extensions_enabled", false);
        put(features, "tweetypie_unmention_optimization_enabled", true);
        put(features, "vibe_api_enabled", true);
        put(features, "responsive_web_edit_tweet_api_enabled", true);
        put(features, "graphql_is_translatable_rweb_tweet_is_translatable_enabled", true);
        put(features, "view_counts_everywhere_api_enabled", true);
        put(features, "longform_notetweets_consumption_enabled", true);
        put(features, "tweet_awards_web_tipping_enabled", false);
        put(features, "freedom_of_speech_not_reach_fetch_enabled", false);
        put(features, "standardized_nudges_misinfo", true);
        put(features, "tweet_with_visibility_results_prefer_gql_limited_actions_policy_enabled", false);
        put(features, "interactive_text_enabled", true);
        put(features, "responsive_web_text_conversations_enabled", false);
        put(features, "longform_notetweets_rich_text_read_enabled", true);
        put(features, "responsive_web_enhance_cards_enabled", false);

        Map<String, Object> params = new HashMap<>();
        put(params, "variables", getGson().toJson(variables));
        put(params, "features", getGson().toJson(features));
        return params;
    }

    // region
    public static GetFollowingRequestBuilder builder() {
        return new GetFollowingRequestBuilder();
    }

    public String getUserId() {
        return userId;
    }

    public Integer getCount() {
        return count;
    }

    public String getCursor() {
        return cursor;
    }

    public Boolean getIncludePromotedContent() {
        return includePromotedContent;
    }

    public static final class GetFollowingRequestBuilder {
        private String userId;
        private Integer count;
        private String cursor;
        private Boolean includePromotedContent = false;

        private GetFollowingRequestBuilder() {
        }

        public GetFollowingRequestBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public GetFollowingRequestBuilder count(Integer count) {
            this.count = count;
            return this;
        }

        public GetFollowingRequestBuilder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        public GetFollowingRequestBuilder includePromotedContent(Boolean includePromotedContent) {
            this.includePromotedContent = includePromotedContent;
            return this;
        }

        public GetFollowingRequest build() {
            GetFollowingRequest getFollowingRequest = new GetFollowingRequest();
            getFollowingRequest.userId = this.userId;
            getFollowingRequest.count = this.count;
            getFollowingRequest.cursor = this.cursor;
            getFollowingRequest.includePromotedContent = this.includePromotedContent;
            return getFollowingRequest;
        }
    }
    // endregion
}
