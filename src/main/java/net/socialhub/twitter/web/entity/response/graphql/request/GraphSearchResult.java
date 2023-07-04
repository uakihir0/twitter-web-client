package net.socialhub.twitter.web.entity.response.graphql.request;

import com.google.gson.annotations.SerializedName;

public class GraphSearchResult {

    @SerializedName("search_timeline")
    private GraphTimelineResult searchTimeline;

    // region
    public GraphTimelineResult getSearchTimeline() {
        return searchTimeline;
    }
    // endregion
}
