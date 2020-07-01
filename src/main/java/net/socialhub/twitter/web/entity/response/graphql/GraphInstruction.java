package net.socialhub.twitter.web.entity.response.graphql;

import com.google.gson.annotations.SerializedName;

public class GraphInstruction {

    @SerializedName("type")
    private String type;
    @SerializedName("direction")
    private String direction;
    @SerializedName("entries")
    private GraphEntry[] entries;

    // region
    public String getType() {
        return type;
    }

    public String getDirection() {
        return direction;
    }

    public GraphEntry[] getEntries() {
        return entries;
    }
    // endregion
}
