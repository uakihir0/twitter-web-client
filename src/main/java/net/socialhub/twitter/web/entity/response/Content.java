package net.socialhub.twitter.web.entity.response;

import com.google.gson.annotations.SerializedName;

public class Content {

    @SerializedName("item")
    private Item item;

    // region
    public Item getItem() {
        return item;
    }
    // endregion

    /**
     * TODO:
     * "clientEventInfo": {
     * "component": "suggest_pinned_tweet",
     * "details": {
     * "timelinesDetails": {
     * "injectionType": "PinnedTweet"
     * }
     * }
     * }
     */
    public static class Item {

        @SerializedName("content")
        private ContentRef content;

        // region
        public ContentRef getContent() {
            return content;
        }
        // endregion
    }

    public static class ContentRef {

        @SerializedName("tweet")
        private ItemRef tweet;
        @SerializedName("user")
        private ItemRef user;

        // region
        public ItemRef getTweet() {
            return tweet;
        }

        public ItemRef getUser() {
            return user;
        }
        // endregion
    }

    /**
     * TODO:
     * "socialContext": {
     * "generalContext": {
     * "contextType": "Pin",
     * "text": "Pinned Tweet"
     * }
     * }
     */
    public static class ItemRef {

        @SerializedName("id")
        private String id;
        @SerializedName("displayType")
        private String displayType;

        // region
        public String getId() {
            return id;
        }

        public String getDisplayType() {
            return displayType;
        }
        // endregion
    }
}
