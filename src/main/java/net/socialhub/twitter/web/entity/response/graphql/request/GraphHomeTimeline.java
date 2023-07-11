package net.socialhub.twitter.web.entity.response.graphql.request;

import com.google.gson.annotations.SerializedName;
import net.socialhub.twitter.web.entity.response.graphql.GraphInstructions;

public class GraphHomeTimeline {

    @SerializedName("home_timeline_urt")
    private GraphInstructions homeTimelineUrt;

    // region
    public GraphInstructions getHomeTimelineUrt() {
        return homeTimelineUrt;
    }
    // endregion
}
