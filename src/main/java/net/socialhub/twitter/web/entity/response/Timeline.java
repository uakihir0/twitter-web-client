package net.socialhub.twitter.web.entity.response;

import com.google.gson.annotations.SerializedName;

/**
 * TODO:
 * "responseObjects": {
 * "feedbackActions": {}
 * }
 */
public class Timeline {

    @SerializedName("id")
    private String id;
    @SerializedName("instructions")
    private Instruction[] instructions;

    // region
    public String getId() {
        return id;
    }

    public Instruction[] getInstructions() {
        return instructions;
    }
    // endregion
}
