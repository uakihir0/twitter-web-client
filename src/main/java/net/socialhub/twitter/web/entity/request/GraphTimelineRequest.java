package net.socialhub.twitter.web.entity.request;

import java.util.HashMap;
import java.util.Map;

public interface GraphTimelineRequest extends GraphRequest {

    default Map<String, Object> getFeaturesMap() {
        Map<String, Object> features = new HashMap<>();
        put(features, "rweb_lists_timeline_redesign_enabled", true);
        put(features, "responsive_web_graphql_exclude_directive_enabled", true);
        put(features, "verified_phone_label_enabled", false);
        put(features, "creator_subscriptions_tweet_preview_api_enabled", true);
        put(features, "responsive_web_graphql_timeline_navigation_enabled", true);
        put(features, "responsive_web_graphql_skip_user_profile_image_extensions_enabled", false);
        put(features, "tweetypie_unmention_optimization_enabled", true);
        put(features, "responsive_web_edit_tweet_api_enabled", true);
        put(features, "graphql_is_translatable_rweb_tweet_is_translatable_enabled", true);
        put(features, "view_counts_everywhere_api_enabled", true);
        put(features, "longform_notetweets_consumption_enabled", true);
        put(features, "responsive_web_twitter_article_tweet_consumption_enabled", false);
        put(features, "tweet_awards_web_tipping_enabled", false);
        put(features, "freedom_of_speech_not_reach_fetch_enabled", true);
        put(features, "standardized_nudges_misinfo", true);
        put(features, "tweet_with_visibility_results_prefer_gql_limited_actions_policy_enabled", true);
        put(features, "longform_notetweets_rich_text_read_enabled", true);
        put(features, "longform_notetweets_inline_media_enabled", true);
        put(features, "responsive_web_media_download_video_enabled", false);
        put(features, "responsive_web_enhance_cards_enabled", false);
        return features;
    }

    default Map<String, Object> getFieldTogglesMap() {
        Map<String, Object> fieldToggles = new HashMap<>();
        put(fieldToggles, "withArticleRichContentState", false);
        return fieldToggles;
    }
}
