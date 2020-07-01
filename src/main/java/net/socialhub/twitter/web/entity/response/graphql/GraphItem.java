package net.socialhub.twitter.web.entity.response.graphql;

import com.google.gson.annotations.SerializedName;

public class GraphItem {

    @SerializedName("itemType")
    private String itemType;

    // User
    @SerializedName("user")
    private GraphUser user;
    @SerializedName("userDisplayType")
    private String userDisplayType;

    // region
    public String getItemType() {
        return itemType;
    }

    public GraphUser getUser() {
        return user;
    }

    public String getUserDisplayType() {
        return userDisplayType;
    }
    // endregion
}
