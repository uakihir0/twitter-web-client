package net.socialhub.twitter.web.entity.response.graphql;

import com.google.gson.annotations.SerializedName;

public class GraphContentItem {

    @SerializedName("entryId")
    private String entryId;
    @SerializedName("item")
    private GraphContent item;

    // region
    public String getEntryId() {
        return entryId;
    }

    public GraphContent getItem() {
        return item;
    }
    // endregion
}
