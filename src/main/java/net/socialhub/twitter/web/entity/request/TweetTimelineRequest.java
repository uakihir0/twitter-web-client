package net.socialhub.twitter.web.entity.request;

import java.util.Map;

public class TweetTimelineRequest extends TimelineRequest {

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

