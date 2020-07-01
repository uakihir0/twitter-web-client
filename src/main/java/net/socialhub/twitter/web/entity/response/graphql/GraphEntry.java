package net.socialhub.twitter.web.entity.response.graphql;

import com.google.gson.annotations.SerializedName;

public class GraphEntry {

    @SerializedName("entryId")
    private String entryId;
    @SerializedName("sortIndex")
    private String sortIndex;
    @SerializedName("content")
    private GraphContent content;

    // region
    public String getEntryId() {
        return entryId;
    }

    public String getSortIndex() {
        return sortIndex;
    }

    public GraphContent getContent() {
        return content;
    }
    // endregion
}
