package net.socialhub.twitter.web.entity.response.graphql;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GraphContent {

    @SerializedName("entryType")
    private String entryType;
    @SerializedName("itemContent")
    private GraphItem itemContent;
    @SerializedName("items")
    private List<GraphContentItem> items;

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

    public List<GraphContentItem> getItems() {
        return items;
    }

    public String getValue() {
        return value;
    }

    public String getCursorType() {
        return cursorType;
    }
    // endregion
}
