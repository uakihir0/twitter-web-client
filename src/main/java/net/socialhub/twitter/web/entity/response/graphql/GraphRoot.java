package net.socialhub.twitter.web.entity.response.graphql;

import com.google.gson.annotations.SerializedName;

public class GraphRoot {

    @SerializedName("data")
    private GraphData data;

    // region
    public GraphData getData() {
        return data;
    }
    // endregion
}
