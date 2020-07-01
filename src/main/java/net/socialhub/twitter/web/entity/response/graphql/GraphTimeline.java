package net.socialhub.twitter.web.entity.response.graphql;

import com.google.gson.annotations.SerializedName;

public class GraphTimeline {

    @SerializedName("instructions")
    private GraphInstruction[] instructions;

    // region
    public GraphInstruction[] getInstructions() {
        return instructions;
    }
    // endregion
}
