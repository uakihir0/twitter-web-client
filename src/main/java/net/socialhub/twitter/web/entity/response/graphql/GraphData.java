package net.socialhub.twitter.web.entity.response.graphql;

import com.google.gson.annotations.SerializedName;
import net.socialhub.twitter.web.entity.response.graphql.request.GraphHomeTimeline;
import net.socialhub.twitter.web.entity.response.graphql.request.GraphSearchResult;
import net.socialhub.twitter.web.entity.response.graphql.request.GraphTimelineResult;

public class GraphData {

    @SerializedName("user")
    private GraphUserResult user;
    @SerializedName("home")
    private GraphHomeTimeline home;
    @SerializedName("search_by_raw_query")
    private GraphSearchResult search;
    @SerializedName("bookmark_timeline_v2")
    private GraphTimelineResult bookmark;
    @SerializedName("threaded_conversation_with_injections_v2")
    private GraphInstructions tweetDetail;

    // region
    public GraphUserResult getUser() {
        return user;
    }

    public GraphHomeTimeline getHome() {
        return home;
    }

    public GraphTimelineResult getBookmark() {
        return bookmark;
    }

    public GraphSearchResult getSearch() {
        return search;
    }

    public GraphInstructions getTweetDetail() {
        return tweetDetail;
    }
    // endregion
}
