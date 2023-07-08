package net.socialhub.twitter.web.entity.response.graphql;

import com.google.gson.annotations.SerializedName;
import net.socialhub.twitter.web.entity.response.graphql.request.GraphUserResult;

public class GraphCore {

    @SerializedName("user_results")
    private GraphUserResults userResults;

    // region
    public GraphUserResults getUserResults() {
        return userResults;
    }
    // endregion
}
