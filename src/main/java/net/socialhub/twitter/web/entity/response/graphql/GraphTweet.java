package net.socialhub.twitter.web.entity.response.graphql;

import com.google.gson.annotations.SerializedName;
import net.socialhub.twitter.web.entity.response.Tweet;

public class GraphTweet extends Tweet {

    @SerializedName("retweeted_status_result")
    private GraphTweetResult retweetedStatusResult;

    @SerializedName("quoted_status_result")
    private GraphTweetResult quotedStatusResult;

    // region
    public GraphTweetResult getRetweetedStatusResult() {
        return retweetedStatusResult;
    }

    public GraphTweetResult getQuotedStatusResult() {
        return quotedStatusResult;
    }
    // endregion
}
