package net.socialhub.twitter.web.entity.response.graphql;

import com.google.gson.annotations.SerializedName;
import net.socialhub.twitter.web.entity.response.graphql.request.GraphUserResult;

public class GraphUserResults {

    @SerializedName("result")
    private GraphUserResult result;

    // region
    public GraphUserResult getResult() {
        return result;
    }
    // endregion

}
