package net.socialhub.twitter.web.entity.request;

import net.socialhub.twitter.web.entity.request.timeline.TimelineRequest;

import java.util.Map;

public class SpecifiedTweetRequest extends TimelineRequest {

    private String tweetId;

    @Override
    public Map<String, String> params() {
        Map<String, String> params = super.params();
        put(params, "tweet_id", tweetId);
        return params;
    }

    // region
    public String getTweetId() {
        return tweetId;
    }

    public void setTweetId(String tweetId) {
        this.tweetId = tweetId;
    }
    // endregion
}
