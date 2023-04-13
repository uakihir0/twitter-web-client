package net.socialhub.twitter.web.entity.response.graphql;

import com.google.gson.annotations.SerializedName;

public class GraphItem {

    @SerializedName("itemType")
    private String itemType;
    @SerializedName("user")
    private GraphUserResult user;
    @SerializedName("userDisplayType")
    private String userDisplayType;
    @SerializedName("tweet_results")
    private GraphTweetResults tweetResults;
    @SerializedName("tweetDisplayType")
    private String tweetDisplayType;

    // region
    public String getItemType() {
        return itemType;
    }

    public GraphUserResult getUser() {
        return user;
    }

    public String getUserDisplayType() {
        return userDisplayType;
    }

    public GraphTweetResults getTweetResults() {
        return tweetResults;
    }
    // endregion
}
