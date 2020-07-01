package net.socialhub.twitter.web.entity.response.graphql;

import com.google.gson.annotations.SerializedName;

public class GraphContent {

    @SerializedName("entryType")
    private String entryType;
    @SerializedName("itemContent")
    private GraphItem itemContent;

    // region
    public String getEntryType() {
        return entryType;
    }

    public GraphItem getItemContent() {
        return itemContent;
    }
    // endregion
}
