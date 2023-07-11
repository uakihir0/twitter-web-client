package net.socialhub.twitter.web.entity.response.graphql.request;

import com.google.gson.annotations.SerializedName;
import net.socialhub.twitter.web.entity.response.graphql.GraphInstructions;

public class GraphTimelineResult {

    @SerializedName("timeline")
    private GraphInstructions timeline;

    // region
    public GraphInstructions getTimeline() {
        return timeline;
    }
    // endregion
}
