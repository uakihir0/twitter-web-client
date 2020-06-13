package net.socialhub.twitter.web.entity.response;

import com.google.gson.annotations.SerializedName;

public class ExtendedMedia extends Media {

    @SerializedName("media_key")
    private String mediaKey;
    @SerializedName("original_info")
    private OriginalInfo originalInfo;
    @SerializedName("ext_media_availability")
    private ExtMediaAvailability extMediaAvailability;
    @SerializedName("ext")
    private Ext ext;

    // region
    public String getMediaKey() {
        return mediaKey;
    }

    public OriginalInfo getOriginalInfo() {
        return originalInfo;
    }

    public ExtMediaAvailability getExtMediaAvailability() {
        return extMediaAvailability;
    }

    public Ext getExt() {
        return ext;
    }

    // endregion

    public static class OriginalInfo {

        @SerializedName("width")
        private Float width;
        @SerializedName("height")
        private Float height;
        @SerializedName("focus_rects")
        private Rect[] focusRects;

        // region
        public Float getWidth() {
            return width;
        }

        public Float getHeight() {
            return height;
        }

        public Rect[] getFocusRects() {
            return focusRects;
        }
        // endregion
    }

    public static class Rect {

        @SerializedName("x")
        private Float x;
        @SerializedName("y")
        private Float y;
        @SerializedName("h")
        private Float h;
        @SerializedName("w")
        private Float w;

        // region
        public Float getX() {
            return x;
        }

        public Float getY() {
            return y;
        }

        public Float getH() {
            return h;
        }

        public Float getW() {
            return w;
        }
        // endregion
    }

    public static class ExtMediaAvailability {

        @SerializedName("status")
        private String status;

        // region
        public String getStatus() {
            return status;
        }
        // endregion
    }

    public static class Ext {

        @SerializedName("mediaStats")
        private MediaStats mediaStats;

        // region
        public MediaStats getMediaStats() {
            return mediaStats;
        }
        // endregion
    }

    public static class MediaStats {

        @SerializedName("r")
        private String r;
        @SerializedName("ttl")
        private Float ttl;

        // region
        public String getR() {
            return r;
        }

        public Float getTtl() {
            return ttl;
        }
        // endregion
    }
}
