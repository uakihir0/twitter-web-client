package net.socialhub.twitter.web.entity.response.graphql;

import com.google.gson.annotations.SerializedName;

public class GraphBookmarkTimeline {

    @SerializedName("timeline")
    private GraphTimeline timeline;

    // region
    public GraphTimeline getTimeline() {
        return timeline;
    }
    // endregion
}
