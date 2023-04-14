package net.socialhub.twitter.web.entity.request.timeline;

import net.socialhub.twitter.web.entity.request.TimelineRequest;

import java.util.Map;

public class UserTimelineRequest extends TimelineRequest {

    private String userId;

    private Boolean includeTweetReplies = true;

    @Override
    public Map<String, String> params() {
        Map<String, String> params = super.params();
        put(params, "userId", getUserId());
        put(params, "include_tweet_replies", getIncludeTweetReplies());
        return params;
    }

    // region
    public static UserTimelineRequestBuilder builder() {
        return new UserTimelineRequestBuilder();
    }

    public String getUserId() {
        return userId;
    }

    public Boolean getIncludeTweetReplies() {
        return includeTweetReplies;
    }

    public static final class UserTimelineRequestBuilder {
        private Integer count;
        private String cursor;
        private String userId;
        private Boolean includeTweetReplies;

        private UserTimelineRequestBuilder() {
        }

        public UserTimelineRequestBuilder count(Integer count) {
            this.count = count;
            return this;
        }

        public UserTimelineRequestBuilder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        public UserTimelineRequestBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserTimelineRequestBuilder includeTweetReplies(Boolean includeTweetReplies) {
            this.includeTweetReplies = includeTweetReplies;
            return this;
        }

        public UserTimelineRequest build() {
            UserTimelineRequest userTimelineRequest = new UserTimelineRequest();
            userTimelineRequest.userId = this.userId;
            userTimelineRequest.cursor = this.cursor;
            userTimelineRequest.includeTweetReplies = this.includeTweetReplies;
            userTimelineRequest.count = this.count;
            return userTimelineRequest;
        }
    }
    // endregion
}
