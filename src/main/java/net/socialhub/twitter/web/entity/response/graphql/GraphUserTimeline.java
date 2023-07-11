package net.socialhub.twitter.web.entity.response.graphql;

import com.google.gson.annotations.SerializedName;

public class GraphUserTimeline {

    @SerializedName("timeline")
    private GraphInstructions timeline;

    // region
    public GraphInstructions getTimeline() {
        return timeline;
    }
    // endregion

}
