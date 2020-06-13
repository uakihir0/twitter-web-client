package net.socialhub.twitter.web.entity.response;

import com.google.gson.annotations.SerializedName;

public class Media {

    @SerializedName("id_str")
    private String id;
    @SerializedName("indices")
    private Integer[] indices;

    @SerializedName("url")
    private String url;
    @SerializedName("media_url")
    private String mediaUrl;
    @SerializedName("media_url_https")
    private String mediaUrlHttps;
    @SerializedName("display_url")
    private String displayUrl;
    @SerializedName("expanded_url")
    private String expandedUrl;

    @SerializedName("type")
    private String type;
    @SerializedName("sizes")
    private Sizes sizes;

    // region
    public String getId() {
        return id;
    }

    public Integer[] getIndices() {
        return indices;
    }

    public String getUrl() {
        return url;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public String getMediaUrlHttps() {
        return mediaUrlHttps;
    }

    public String getDisplayUrl() {
        return displayUrl;
    }

    public String getExpandedUrl() {
        return expandedUrl;
    }

    public String getType() {
        return type;
    }

    public Sizes getSizes() {
        return sizes;
    }
    // endregion

    public static class Sizes {

        @SerializedName("thumb")
        private Size thumb;
        @SerializedName("small")
        private Size small;
        @SerializedName("medium")
        private Size medium;
        @SerializedName("large")
        private Size large;

        // region
        public Size getThumb() {
            return thumb;
        }

        public Size getSmall() {
            return small;
        }

        public Size getMedium() {
            return medium;
        }

        public Size getLarge() {
            return large;
        }
        // endregion
    }

    public static class Size {

        @SerializedName("w")
        private Float w;
        @SerializedName("h")
        private Float h;
        @SerializedName("resize")
        private String resize;

        // region
        public Float getW() {
            return w;
        }

        public Float getH() {
            return h;
        }

        public String getResize() {
            return resize;
        }
        // endregion

    }
}
