package net.socialhub.twitter.web.entity.request.bookmark;

import net.socialhub.twitter.web.entity.request.GraphRequest;

import java.util.HashMap;
import java.util.Map;

public class GetBookmarkRequest implements GraphRequest {

    private Integer count;
    private String cursor;
    private Boolean includePromotedContent;

    @Override
    public Map<String, Object> params() {

        Map<String, Object> variables = new HashMap<>();
        put(variables, "count", getCount());
        put(variables, "includePromotedContent", getIncludePromotedContent());
        put(variables, "withDownvotePerspective", false);

        if (getCursor() != null) {
            // ページングのためのカーソル設定
            // For paging cursor settings
            put(variables, "cursor", getCursor());
        } else {
            // 初回リクエストの場合は下記フラグを設定
            // If it is the first request, set the following flag
            put(variables, "requestContext", "launch");
        }

        Map<String, Object> features = new HashMap<>();
        put(features, "graphql_timeline_v2_bookmark_timeline", true);
        put(features, "blue_business_profile_image_shape_enabled", false);
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
        put(features, "longform_notetweets_rich_text_read_enabled", false);
        put(features, "responsive_web_enhance_cards_enabled", false);

        Map<String, Object> params = new HashMap<>();
        put(params, "variables", getGson().toJson(variables));
        put(params, "features", getGson().toJson(features));

        return params;
    }

    // region
    public static GetBookmarkRequestBuilder builder() {
        return new GetBookmarkRequestBuilder();
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

    public static final class GetBookmarkRequestBuilder {
        private Integer count = 20;
        private String cursor;
        private Boolean includePromotedContent = true;

        private GetBookmarkRequestBuilder() {
        }

        public GetBookmarkRequestBuilder count(Integer count) {
            this.count = count;
            return this;
        }

        public GetBookmarkRequestBuilder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        public GetBookmarkRequestBuilder includePromotedContent(Boolean includePromotedContent) {
            this.includePromotedContent = includePromotedContent;
            return this;
        }

        public GetBookmarkRequest build() {
            GetBookmarkRequest getBookmarkRequest = new GetBookmarkRequest();
            getBookmarkRequest.includePromotedContent = this.includePromotedContent;
            getBookmarkRequest.cursor = this.cursor;
            getBookmarkRequest.count = this.count;
            return getBookmarkRequest;
        }
    }
    // endregion
}
