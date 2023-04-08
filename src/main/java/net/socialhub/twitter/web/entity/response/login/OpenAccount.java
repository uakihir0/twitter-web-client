package net.socialhub.twitter.web.entity.response.login;

import com.google.gson.annotations.SerializedName;
import net.socialhub.twitter.web.entity.response.User;

public class OpenAccount {

    /**
     * Only include the following fields
     * 以下のフィールドのみが含まれる
     * {
     *     "id": 1234567890,
     *     "id_str": "1234567890",
     *     "name": "Twitter Web Client",
     *     "screen_name": "twitter_web_client",
     * }
     */
    @SerializedName("user")
    private User user;

    // region
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    // endregion
}
