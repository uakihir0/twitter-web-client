package net.socialhub.twitter.web.entity.request.friendship;

import net.socialhub.twitter.web.entity.request.Request;

import java.util.HashMap;
import java.util.Map;

public class CreateFriendshipRequest implements Request {

    private String userId;

    @Override
    public Map<String, String> params() {
        Map<String, String> params = new HashMap<>();
        put(params, "include_profile_interstitial_type", 1);
        put(params, "include_blocking", 1);
        put(params, "include_blocked_by", 1);
        put(params, "include_followed_by", 1);
        put(params, "include_want_retweets", 1);
        put(params, "include_mute_edge", 1);
        put(params, "include_can_dm", 1);
        put(params, "include_can_media_tag", 1);
        put(params, "include_ext_has_nft_avatar", 1);
        put(params, "skip_status", 1);
        put(params, "id", getUserId());
        return params;
    }

    // region
    public static CreateFriendshipRequestBuilder builder() {
        return new CreateFriendshipRequestBuilder();
    }

    public String getUserId() {
        return userId;
    }

    public static final class CreateFriendshipRequestBuilder {
        private String userId;

        private CreateFriendshipRequestBuilder() {
        }

        public CreateFriendshipRequestBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public CreateFriendshipRequest build() {
            CreateFriendshipRequest createFriendshipRequest = new CreateFriendshipRequest();
            createFriendshipRequest.userId = this.userId;
            return createFriendshipRequest;
        }
    }
    // endregion
}
