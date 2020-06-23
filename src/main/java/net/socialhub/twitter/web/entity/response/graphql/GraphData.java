package net.socialhub.twitter.web.entity.response.graphql;

import com.google.gson.annotations.SerializedName;

public class GraphData {

    @SerializedName("user")
    private GraphUser user;

    // region
    public GraphUser getUser() {
        return user;
    }
    // endregion
}
