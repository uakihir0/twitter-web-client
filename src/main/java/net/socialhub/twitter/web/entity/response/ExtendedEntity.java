package net.socialhub.twitter.web.entity.response;

import com.google.gson.annotations.SerializedName;

public class ExtendedEntity {

    @SerializedName("media")
    private ExtendedMedia[] media;

    // region
    public ExtendedMedia[] getMedia() {
        return media;
    }
    // endregion
}
