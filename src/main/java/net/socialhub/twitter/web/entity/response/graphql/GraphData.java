package net.socialhub.twitter.web.entity.response.graphql;

import com.google.gson.annotations.SerializedName;

public class GraphData {

    @SerializedName("user")
    private GraphUserResult user;
    @SerializedName("home")
    private GraphHomeTimeline home;

    // region
    public GraphUserResult getUser() {
        return user;
    }
    public GraphHomeTimeline getHome() {
        return home;
    }
    // endregion
}
