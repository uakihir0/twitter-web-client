package net.socialhub.twitter.web.entity.response.graphql.request;

import com.google.gson.annotations.SerializedName;
import net.socialhub.twitter.web.entity.response.graphql.GraphTimeline;

public class GraphTimelineResult {

    @SerializedName("timeline")
    private GraphTimeline timeline;

    // region
    public GraphTimeline getTimeline() {
        return timeline;
    }
    // endregion
}
