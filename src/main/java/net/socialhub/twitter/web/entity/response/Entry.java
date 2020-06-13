package net.socialhub.twitter.web.entity.response;

import com.google.gson.annotations.SerializedName;

public class Entry {

    @SerializedName("entryId")
    private String entryId;
    @SerializedName("sortIndex")
    private String sortIndex;
    @SerializedName("content")
    private Content content;

    // region
    public String getEntryId() {
        return entryId;
    }

    public String getSortIndex() {
        return sortIndex;
    }

    public Content getContent() {
        return content;
    }
    // endregion
}


