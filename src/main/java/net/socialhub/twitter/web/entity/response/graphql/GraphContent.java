package net.socialhub.twitter.web.entity.response.graphql;

import com.google.gson.annotations.SerializedName;

public class GraphContent {

    @SerializedName("entryType")
    private String entryType;
    @SerializedName("itemContent")
    private GraphItem itemContent;

    // Cursor
    @SerializedName("value")
    private String value;
    @SerializedName("cursorType")
    private String cursorType;

    // region
    public String getEntryType() {
        return entryType;
    }

    public GraphItem getItemContent() {
        return itemContent;
    }

    public String getValue() {
        return value;
    }

    public String getCursorType() {
        return cursorType;
    }
    // endregion
}
