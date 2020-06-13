package net.socialhub.twitter.web.entity.response;

import com.google.gson.annotations.SerializedName;

public class Entity {

    @SerializedName("urls")
    private Url[] urls;
    @SerializedName("user_mentions")
    private Mention[] userMentions;
    @SerializedName("media")
    private Media[] media;

    // region
    public Url[] getUrls() {
        return urls;
    }

    public Mention[] getUserMentions() {
        return userMentions;
    }
    // endregion

    public static class Url {

        @SerializedName("url")
        private String url;
        @SerializedName("expanded_url")
        private String expandedUrl;
        @SerializedName("display_url")
        private String displayUrl;
        @SerializedName("indices")
        private Integer[] indices;

        // region
        public String getUrl() {
            return url;
        }

        public String getExpandedUrl() {
            return expandedUrl;
        }

        public String getDisplayUrl() {
            return displayUrl;
        }

        public Integer[] getIndices() {
            return indices;
        }
        // endregion
    }

    public static class Mention {

        @SerializedName("id_str")
        private String id;
        @SerializedName("screen_name")
        private String screenName;
        @SerializedName("name")
        private String name;
        @SerializedName("indices")
        private Integer[] indices;

        // region
        public String getId() {
            return id;
        }

        public String getScreenName() {
            return screenName;
        }

        public String getName() {
            return name;
        }

        public Integer[] getIndices() {
            return indices;
        }
        // endregion
    }
}
