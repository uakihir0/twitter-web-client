package net.socialhub.twitter.web.entity.response.graphql.request;

import com.google.gson.annotations.SerializedName;
import net.socialhub.twitter.web.entity.response.graphql.GraphTimeline;

public class GraphResult {

    @SerializedName("timeline_v2")
    private GraphTimelineResult timeline;

    // region
    public GraphTimelineResult getTimeline() {
        return timeline;
    }
    // region
}
