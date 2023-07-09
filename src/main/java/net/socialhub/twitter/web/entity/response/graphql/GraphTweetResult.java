package net.socialhub.twitter.web.entity.response.graphql;

import com.google.gson.annotations.SerializedName;

public class GraphTweetResult {

    @SerializedName("id")
    private String id;
    @SerializedName("rest_id")
    private String restId;
    @SerializedName("core")
    private GraphCore core;
    @SerializedName("legacy")
    private GraphTweet legacy;

    // region
    public String getId() {
        return id;
    }

    public String getRestId() {
        return restId;
    }

    public GraphCore getCore() {
        return core;
    }

    public GraphTweet getLegacy() {
        return legacy;
    }

    @Override
    public String toString() {
        return "GraphTweetResult{" +
                "id='" + id + '\'' +
                ", restId='" + restId + '\'' +
                ", core=" + core +
                ", legacy=" + legacy +
                '}';
    }
    // endregion
}
