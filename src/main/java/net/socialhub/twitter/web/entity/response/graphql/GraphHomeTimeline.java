package net.socialhub.twitter.web.entity.response.graphql;

import com.google.gson.annotations.SerializedName;

public class GraphHomeTimeline {

    @SerializedName("home_timeline_urt")
    private GraphTimeline homeTimelineUrt;

    // region
    public GraphTimeline getHomeTimelineUrt() {
        return homeTimelineUrt;
    }
    // endregion
}
