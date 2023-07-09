package net.socialhub.twitter.web.entity.response.graphql;

import com.google.gson.annotations.SerializedName;

public class GraphCore {

    @SerializedName("user_results")
    private GraphUserResults userResults;

    // region
    public GraphUserResults getUserResults() {
        return userResults;
    }
    // endregion
}
