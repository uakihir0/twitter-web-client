package net.socialhub.twitter.web.entity.request.tweet;

import net.socialhub.twitter.web.entity.request.GraphTimelineRequest;

import java.util.HashMap;
import java.util.Map;

public class TweetDetailRequest implements GraphTimelineRequest {

    private String focalTweetId;
    private Boolean withRuxInjections;
    private Boolean includePromotedContent;
    private Boolean withCommunity;
    private Boolean withQuickPromoteEligibilityTweetFields;
    private Boolean withArticleRichContent;
    private Boolean withBirdwatchNotes;
    private Boolean withVoice;
    private Boolean withV2Timeline;


    @Override
    public Map<String, Object> params() {

        Map<String, Object> variables = new HashMap<>();
        put(variables, "focalTweetId", getFocalTweetId());
        put(variables, "with_rux_injections", getWithRuxInjections());
        put(variables, "includePromotedContent", getIncludePromotedContent());
        put(variables, "withCommunity", getWithCommunity());
        put(variables, "withQuickPromoteEligibilityTweetFields", getWithQuickPromoteEligibilityTweetFields());
        put(variables, "withArticleRichContent", getWithArticleRichContent());
        put(variables, "withBirdwatchNotes", getWithBirdwatchNotes());
        put(variables, "withVoice", getWithVoice());
        put(variables, "withV2Timeline", getWithV2Timeline());

        Map<String, Object> params = new HashMap<>();
        put(params, "variables", getGson().toJson(variables));
        put(params, "features", getGson().toJson(getFeaturesMap()));
        put(params, "fieldToggles", getGson().toJson(getFieldTogglesMap()));
        return params;
    }

    // region
    public static TweetDetailRequestBuilder builder() {
        return new TweetDetailRequestBuilder();
    }

    public String getFocalTweetId() {
        return focalTweetId;
    }

    public Boolean getWithRuxInjections() {
        return withRuxInjections;
    }

    public Boolean getIncludePromotedContent() {
        return includePromotedContent;
    }

    public Boolean getWithCommunity() {
        return withCommunity;
    }

    public Boolean getWithQuickPromoteEligibilityTweetFields() {
        return withQuickPromoteEligibilityTweetFields;
    }

    public Boolean getWithArticleRichContent() {
        return withArticleRichContent;
    }

    public Boolean getWithBirdwatchNotes() {
        return withBirdwatchNotes;
    }

    public Boolean getWithVoice() {
        return withVoice;
    }

    public Boolean getWithV2Timeline() {
        return withV2Timeline;
    }

    public static final class TweetDetailRequestBuilder {

        private String focalTweetId;
        private Boolean withRuxInjections = false;
        private Boolean includePromotedContent = true;
        private Boolean withCommunity = true;
        private Boolean withQuickPromoteEligibilityTweetFields = true;
        private Boolean withArticleRichContent = false;
        private Boolean withBirdwatchNotes = true;
        private Boolean withVoice = true;
        private Boolean withV2Timeline = true;

        private TweetDetailRequestBuilder() {
        }

        public TweetDetailRequestBuilder focalTweetId(String focalTweetId) {
            this.focalTweetId = focalTweetId;
            return this;
        }

        public TweetDetailRequestBuilder withRuxInjections(Boolean withRuxInjections) {
            this.withRuxInjections = withRuxInjections;
            return this;
        }

        public TweetDetailRequestBuilder includePromotedContent(Boolean includePromotedContent) {
            this.includePromotedContent = includePromotedContent;
            return this;
        }

        public TweetDetailRequestBuilder withCommunity(Boolean withCommunity) {
            this.withCommunity = withCommunity;
            return this;
        }

        public TweetDetailRequestBuilder withQuickPromoteEligibilityTweetFields(Boolean withQuickPromoteEligibilityTweetFields) {
            this.withQuickPromoteEligibilityTweetFields = withQuickPromoteEligibilityTweetFields;
            return this;
        }

        public TweetDetailRequestBuilder withArticleRichContent(Boolean withArticleRichContent) {
            this.withArticleRichContent = withArticleRichContent;
            return this;
        }

        public TweetDetailRequestBuilder withBirdwatchNotes(Boolean withBirdwatchNotes) {
            this.withBirdwatchNotes = withBirdwatchNotes;
            return this;
        }

        public TweetDetailRequestBuilder withVoice(Boolean withVoice) {
            this.withVoice = withVoice;
            return this;
        }

        public TweetDetailRequestBuilder withV2Timeline(Boolean withV2Timeline) {
            this.withV2Timeline = withV2Timeline;
            return this;
        }

        public TweetDetailRequest build() {
            TweetDetailRequest tweetDetailRequest = new TweetDetailRequest();
            tweetDetailRequest.focalTweetId = this.focalTweetId;
            tweetDetailRequest.withQuickPromoteEligibilityTweetFields = this.withQuickPromoteEligibilityTweetFields;
            tweetDetailRequest.withRuxInjections = this.withRuxInjections;
            tweetDetailRequest.withArticleRichContent = this.withArticleRichContent;
            tweetDetailRequest.withBirdwatchNotes = this.withBirdwatchNotes;
            tweetDetailRequest.withCommunity = this.withCommunity;
            tweetDetailRequest.withV2Timeline = this.withV2Timeline;
            tweetDetailRequest.includePromotedContent = this.includePromotedContent;
            tweetDetailRequest.withVoice = this.withVoice;
            return tweetDetailRequest;
        }
    }
    // endregion
}
