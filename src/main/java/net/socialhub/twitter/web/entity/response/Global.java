package net.socialhub.twitter.web.entity.response;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Global Response Object
 * レスポンスのグローバルオブジェクト
 *
 * TODO:
 * "moments": {},
 * "cards": {},
 * "places": {},
 * "media": {},
 * "broadcasts": {},
 * "topics": {},
 * "lists": {}
 */
public class Global {

    @SerializedName("tweets")
    private Map<String /* TweetID */, Tweet> tweets;

    @SerializedName("users")
    private Map<String /* UserID */, User> users;

    // region
    public Map<String, Tweet> getTweets() {
        return tweets;
    }

    public Map<String, User> getUsers() {
        return users;
    }
    // endregion
}
