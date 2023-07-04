package net.socialhub.twitter.web.entity.response.graphql.request;

import com.google.gson.annotations.SerializedName;
import net.socialhub.twitter.web.entity.response.graphql.GraphTimeline;

public class GraphHomeTimeline {

    @SerializedName("home_timeline_urt")
    private GraphTimeline homeTimelineUrt;

    // region
    public GraphTimeline getHomeTimelineUrt() {
        return homeTimelineUrt;
    }
    // endregion
}
