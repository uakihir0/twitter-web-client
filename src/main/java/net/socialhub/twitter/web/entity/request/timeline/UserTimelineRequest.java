package net.socialhub.twitter.web.entity.request.timeline;

import net.socialhub.twitter.web.entity.request.GraphTimelineRequest;
import net.socialhub.twitter.web.entity.request.TimelineRequest;

import java.util.HashMap;
import java.util.Map;

public class UserTimelineRequest implements GraphTimelineRequest {

    private String userId;
    private Integer count;
    private String cursor;
    private Boolean includePromotedContent;
    private Boolean withQuickPromoteEligibilityTweetFields;
    private Boolean withVoice;
    private Boolean withV2Timeline;

    @Override
    public Map<String, Object> params() {

        Map<String, Object> variables = new HashMap<>();
        put(variables, "userId", getUserId());
        put(variables, "count", getCount());
        put(variables, "cursor", getCursor());
        put(variables, "includePromotedContent", getIncludePromotedContent());
        put(variables, "withQuickPromoteEligibilityTweetFields", getWithQuickPromoteEligibilityTweetFields());
        put(variables, "withVoice", getWithVoice());
        put(variables, "withV2Timeline", getWithV2Timeline());

        Map<String, Object> params = new HashMap<>();
        put(params, "variables", getGson().toJson(variables));
        put(params, "features", getGson().toJson(getFeaturesMap()));
        put(params, "fieldToggles", getGson().toJson(getFieldTogglesMap()));
        return params;
    }

    // region
    public static UserTimelineRequestBuilder builder() {
        return new UserTimelineRequestBuilder();
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

    public Boolean getWithQuickPromoteEligibilityTweetFields() {
        return withQuickPromoteEligibilityTweetFields;
    }

    public Boolean getWithVoice() {
        return withVoice;
    }

    public Boolean getWithV2Timeline() {
        return withV2Timeline;
    }

    public static final class UserTimelineRequestBuilder {
        private String userId;
        private Integer count = 20;
        private String cursor;
        private Boolean includePromotedContent = true;
        private Boolean withQuickPromoteEligibilityTweetFields = true;
        private Boolean withVoice = true;
        private Boolean withV2Timeline = true;

        private UserTimelineRequestBuilder() {
        }

        public UserTimelineRequestBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserTimelineRequestBuilder count(Integer count) {
            this.count = count;
            return this;
        }

        public UserTimelineRequestBuilder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        public UserTimelineRequestBuilder includePromotedContent(Boolean includePromotedContent) {
            this.includePromotedContent = includePromotedContent;
            return this;
        }

        public UserTimelineRequestBuilder withQuickPromoteEligibilityTweetFields(Boolean withQuickPromoteEligibilityTweetFields) {
            this.withQuickPromoteEligibilityTweetFields = withQuickPromoteEligibilityTweetFields;
            return this;
        }

        public UserTimelineRequestBuilder withVoice(Boolean withVoice) {
            this.withVoice = withVoice;
            return this;
        }

        public UserTimelineRequestBuilder withV2Timeline(Boolean withV2Timeline) {
            this.withV2Timeline = withV2Timeline;
            return this;
        }

        public UserTimelineRequest build() {
            UserTimelineRequest userTimelineRequest = new UserTimelineRequest();
            userTimelineRequest.includePromotedContent = this.includePromotedContent;
            userTimelineRequest.withVoice = this.withVoice;
            userTimelineRequest.userId = this.userId;
            userTimelineRequest.withV2Timeline = this.withV2Timeline;
            userTimelineRequest.count = this.count;
            userTimelineRequest.withQuickPromoteEligibilityTweetFields = this.withQuickPromoteEligibilityTweetFields;
            userTimelineRequest.cursor = this.cursor;
            return userTimelineRequest;
        }
    }
    // endregion
}
