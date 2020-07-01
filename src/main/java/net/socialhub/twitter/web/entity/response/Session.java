package net.socialhub.twitter.web.entity.response;

import com.google.gson.annotations.SerializedName;

public class Session {

    @SerializedName("guest_token")
    private String guestToken;

    // region
    public String getGuestToken() {
        return guestToken;
    }
    // endregion
}
