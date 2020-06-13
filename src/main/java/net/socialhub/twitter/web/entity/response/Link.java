package net.socialhub.twitter.web.entity.response;

import com.google.gson.annotations.SerializedName;

/**
 * Link
 */
public class Link {

    @SerializedName("url")
    private String url;
    @SerializedName("expanded")
    private String expanded;
    @SerializedName("display")
    private String display;

    // region
    public String getUrl() {
        return url;
    }

    public String getExpanded() {
        return expanded;
    }

    public String getDisplay() {
        return display;
    }
    // endregion
}

