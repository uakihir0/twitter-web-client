package net.socialhub.twitter.web.entity.response.graphql.request;

import com.google.gson.annotations.SerializedName;
import net.socialhub.twitter.web.entity.response.Profile;
import net.socialhub.twitter.web.entity.response.User;
import net.socialhub.twitter.web.entity.response.graphql.GraphUser;
import net.socialhub.twitter.web.entity.response.graphql.GraphUserTimeline;

public class GraphUserResult {

    @SerializedName("id")
    private String id;
    @SerializedName("rest_id")
    private String restId;
    @SerializedName("legacy")
    private GraphUser legacy;
    @SerializedName("result")
    private GraphResult result;
    @SerializedName("legacy_extended_profile")
    private Profile legacyExtendedProfile;
    @SerializedName("followers_timeline")
    private GraphUserTimeline followersTimeline;

    // region
    public String getId() {
        return id;
    }

    public String getRestId() {
        return restId;
    }

    public GraphUser getLegacy() {
        return legacy;
    }

    public GraphResult getResult() {
        return result;
    }

    public Profile getLegacyExtendedProfile() {
        return legacyExtendedProfile;
    }
    
    public GraphUserTimeline getFollowersTimeline() {
        return followersTimeline;
    }
    // endregion
}
