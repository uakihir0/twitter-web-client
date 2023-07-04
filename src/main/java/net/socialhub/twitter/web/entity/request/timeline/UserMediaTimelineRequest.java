package net.socialhub.twitter.web.entity.request.timeline;

import net.socialhub.twitter.web.entity.request.GraphTimelineRequest;

import java.util.HashMap;
import java.util.Map;

public class UserMediaTimelineRequest implements GraphTimelineRequest {

    private String userId;
    private Integer count;
    private String cursor;
    private Boolean includePromotedContent;
    private Boolean withClientEventToken;
    private Boolean withBirdwatchNotes;
    private Boolean withVoice;
    private Boolean withV2Timeline;

    @Override
    public Map<String, Object> params() {

        Map<String, Object> variables = new HashMap<>();
        put(variables, "userId", getUserId());
        put(variables, "count", getCount());
        put(variables, "cursor", getCursor());
        put(variables, "includePromotedContent", getIncludePromotedContent());
        put(variables, "withClientEventToken", getWithClientEventToken());
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
    public static UserMediaTimelineRequestBuilder builder() {
        return new UserMediaTimelineRequestBuilder();
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

    public Boolean getWithClientEventToken() {
        return withClientEventToken;
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

    public static final class UserMediaTimelineRequestBuilder {
        private String userId;
        private Integer count = 20;
        private String cursor;
        private Boolean includePromotedContent = false;
        private Boolean withClientEventToken = false;
        private Boolean withBirdwatchNotes = false;
        private Boolean withVoice = true;
        private Boolean withV2Timeline = true;

        private UserMediaTimelineRequestBuilder() {
        }


        public UserMediaTimelineRequestBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserMediaTimelineRequestBuilder count(Integer count) {
            this.count = count;
            return this;
        }

        public UserMediaTimelineRequestBuilder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        public UserMediaTimelineRequestBuilder includePromotedContent(Boolean includePromotedContent) {
            this.includePromotedContent = includePromotedContent;
            return this;
        }

        public UserMediaTimelineRequestBuilder withClientEventToken(Boolean withClientEventToken) {
            this.withClientEventToken = withClientEventToken;
            return this;
        }

        public UserMediaTimelineRequestBuilder withBirdwatchNotes(Boolean withBirdwatchNotes) {
            this.withBirdwatchNotes = withBirdwatchNotes;
            return this;
        }

        public UserMediaTimelineRequestBuilder withVoice(Boolean withVoice) {
            this.withVoice = withVoice;
            return this;
        }

        public UserMediaTimelineRequestBuilder withV2Timeline(Boolean withV2Timeline) {
            this.withV2Timeline = withV2Timeline;
            return this;
        }

        public UserMediaTimelineRequest build() {
            UserMediaTimelineRequest userMediaTimelineRequest = new UserMediaTimelineRequest();
            userMediaTimelineRequest.includePromotedContent = this.includePromotedContent;
            userMediaTimelineRequest.userId = this.userId;
            userMediaTimelineRequest.count = this.count;
            userMediaTimelineRequest.withClientEventToken = this.withClientEventToken;
            userMediaTimelineRequest.withVoice = this.withVoice;
            userMediaTimelineRequest.withBirdwatchNotes = this.withBirdwatchNotes;
            userMediaTimelineRequest.cursor = this.cursor;
            userMediaTimelineRequest.withV2Timeline = this.withV2Timeline;
            return userMediaTimelineRequest;
        }
    }
    // endregion
}
