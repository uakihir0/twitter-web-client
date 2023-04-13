package net.socialhub.twitter.web.entity.request.timeline;

import java.util.Map;

public class UserTimelineRequest extends TimelineRequest {

    private String userId;

    private Boolean includeTweetReplies = true;

    @Override
    public Map<String, String> params() {
        Map<String, String> params = super.params();

        put(params, "userId", userId);
        put(params, "include_tweet_replies", includeTweetReplies);

        return params;
    }

    // region
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getIncludeTweetReplies() {
        return includeTweetReplies;
    }

    public void setIncludeTweetReplies(Boolean includeTweetReplies) {
        this.includeTweetReplies = includeTweetReplies;
    }
    // endregion
}
