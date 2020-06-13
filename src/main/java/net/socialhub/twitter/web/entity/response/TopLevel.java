package net.socialhub.twitter.web.entity.response;

import com.google.gson.annotations.SerializedName;

public class TopLevel {

    @SerializedName("globalObjects")
    private Global globalObjects;

    @SerializedName("timeline")
    private Timeline timeline;

    // region
    public Global getGlobalObjects() {
        return globalObjects;
    }

    public Timeline getTimeline() {
        return timeline;
    }
    // endregion
}
