package net.socialhub.twitter.web.entity.request.timeline;

import net.socialhub.twitter.web.entity.request.graphql.GraphRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeTimelineRequest implements GraphRequest {

    private Integer count;
    private String cursor;
    private List<String> seenTweetIds;
    private Boolean includePromotedContent;

    @Override
    public Map<String, Object> params() {

        Map<String, Object> variables = new HashMap<>();
        put(variables, "count", getCount());
        put(variables, "seenTweetIds", getSeenTweetIds());
        put(variables, "includePromotedContent", getIncludePromotedContent());
        put(variables, "latestControlAvailable", true);
        put(variables, "requestContext", "launch");
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
        put(features, "blue_business_profile_image_shape_enabled", false);
        put(features, "responsive_web_graphql_exclude_directive_enabled", true);
        put(features, "verified_phone_label_enabled", false);
        put(features, "responsive_web_graphql_timeline_navigation_enabled", false);
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
        put(params, "queryId", "37RUvMgTiEVYYfrRTVDxpw");
        put(params, "variables", variables);
        put(params, "features", features);

        return params;
    }

    // region
    public static HomeTimelineRequestBuilder builder() {
        return new HomeTimelineRequestBuilder();
    }

    public Integer getCount() {
        return count;
    }

    public String getCursor() {
        return cursor;
    }

    public List<String> getSeenTweetIds() {
        return seenTweetIds;
    }

    public Boolean getIncludePromotedContent() {
        return includePromotedContent;
    }


    public static final class HomeTimelineRequestBuilder {
        private Integer count = 10;
        private String cursor;
        private List<String> seenTweetIds;
        private Boolean includePromotedContent = false;

        private HomeTimelineRequestBuilder() {
        }

        public HomeTimelineRequestBuilder count(Integer count) {
            this.count = count;
            return this;
        }

        public HomeTimelineRequestBuilder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        public HomeTimelineRequestBuilder seenTweetIds(List<String> seenTweetIds) {
            this.seenTweetIds = seenTweetIds;
            return this;
        }

        public HomeTimelineRequestBuilder includePromotedContent(Boolean includePromotedContent) {
            this.includePromotedContent = includePromotedContent;
            return this;
        }

        public HomeTimelineRequest build() {
            HomeTimelineRequest homeTimelineRequest = new HomeTimelineRequest();
            homeTimelineRequest.includePromotedContent = this.includePromotedContent;
            homeTimelineRequest.cursor = this.cursor;
            homeTimelineRequest.count = this.count;
            homeTimelineRequest.seenTweetIds = this.seenTweetIds;
            return homeTimelineRequest;
        }
    }
    // endregion
}
