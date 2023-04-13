package net.socialhub.twitter.web.entity.response.graphql;

import com.google.gson.annotations.SerializedName;

public class GraphTweetResults {

    @SerializedName("result")
    private GraphTweetResult result;

    // region
    public GraphTweetResult getResult() {
        return result;
    }
    // endregion
}
