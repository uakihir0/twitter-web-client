package net.socialhub.twitter.web.entity.request;

import java.util.Map;

public class SpecifiedTweetRequest extends TimelineRequest {

    private String tweetId;

    @Override
    public Map<String, String> params() {
        Map<String, String> params = super.params();
        put(params, "tweet_id", getTweetId());
        return params;
    }

    // region
    public static SpecifiedTweetRequestBuilder builder() {
        return new SpecifiedTweetRequestBuilder();
    }

    public String getTweetId() {
        return tweetId;
    }

    public static final class SpecifiedTweetRequestBuilder {
        private String tweetId;
        private Integer count;
        private String cursor;

        private SpecifiedTweetRequestBuilder() {
        }

        public SpecifiedTweetRequestBuilder tweetId(String tweetId) {
            this.tweetId = tweetId;
            return this;
        }

        public SpecifiedTweetRequestBuilder count(Integer count) {
            this.count = count;
            return this;
        }

        public SpecifiedTweetRequestBuilder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        public SpecifiedTweetRequest build() {
            SpecifiedTweetRequest specifiedTweetRequest = new SpecifiedTweetRequest();
            specifiedTweetRequest.tweetId = this.tweetId;
            specifiedTweetRequest.cursor = this.cursor;
            specifiedTweetRequest.count = this.count;
            return specifiedTweetRequest;
        }
    }
    // endregion
}
