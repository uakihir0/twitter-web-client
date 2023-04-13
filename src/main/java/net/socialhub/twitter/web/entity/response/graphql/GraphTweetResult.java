package net.socialhub.twitter.web.entity.response.graphql;

import com.google.gson.annotations.SerializedName;

public class GraphTweetResult {

    @SerializedName("rest_id")
    private String restId;
    @SerializedName("core")
    private GraphUserResults core;
    @SerializedName("legacy")
    private GraphTweet legacy;

    // region
    public String getRestId() {
        return restId;
    }

    public GraphUserResults getCore() {
        return core;
    }

    public GraphTweet getLegacy() {
        return legacy;
    }
    // endregion
}
