package net.socialhub.twitter.web.entity.response.graphql;

import com.google.gson.annotations.SerializedName;
import net.socialhub.twitter.web.entity.response.Profile;
import net.socialhub.twitter.web.entity.response.User;

/**
 * TODO:
 * "affiliates_highlighted_label": {}
 */
public class GraphUserResult {

    @SerializedName("id")
    private String id;
    @SerializedName("rest_id")
    private String restId;
    @SerializedName("legacy")
    private GraphUser legacy;
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

    public User getLegacy() {
        return legacy;
    }

    public Profile getLegacyExtendedProfile() {
        return legacyExtendedProfile;
    }
    
    public GraphUserTimeline getFollowersTimeline() {
        return followersTimeline;
    }
    // endregion
}
