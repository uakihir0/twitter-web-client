package net.socialhub.twitter.web.entity.response;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id_str")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("screen_name")
    private String screenName;

    @SerializedName("location")
    private String location;
    @SerializedName("description")
    private String description;
    @SerializedName("url")
    private String url;

    @SerializedName("entities")
    private UserEntity entities;

    @SerializedName("followers_count")
    private Long followersCount;
    @SerializedName("fast_followers_count")
    private Long fastFollowersCount;
    @SerializedName("normal_followers_count")
    private Long normalFollowersCount;
    @SerializedName("friends_count")
    private Long friendsCount;
    @SerializedName("listed_count")
    private float listedCount;

    @SerializedName("favourites_count")
    private float favouritesCount;
    @SerializedName("statuses_count")
    private float statusesCount;
    @SerializedName("media_count")
    private float mediaCount;

    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("profile_image_url_https")
    private String profileImageUrlHttps;
    @SerializedName("profile_banner_url")
    private String profileBannerUrl;

    /*
     * FIXME:
     * @SerializedName("profile_banner_extensions_media_availability")
     * private ? profileBannerExtensionsMediaAvailability;
     */
    @SerializedName("profile_image_extensions_alt_text")
    private String profileImageExtensionsAltText;
    @SerializedName("profile_image_extensions")
    private ProfileExtensions profileImageExtensions;

    /*
     * FIXME:
     * @SerializedName("profile_banner_extensions_media_availability")
     * private ? profileBannerExtensionsMediaAvailability;
     */
    @SerializedName("profile_banner_extensions_alt_text")
    private String profileBannerExtensionsAltText;
    @SerializedName("profile_banner_extensions")
    private ProfileExtensions profileBannerExtensions;

    @SerializedName("profile_link_color")
    private String profileLinkColor;
    @SerializedName("has_extended_profile")
    private Boolean hasExtendedProfile;
    @SerializedName("has_custom_timelines")
    private Boolean hasCustomTimelines;

    @SerializedName("default_profile")
    private Boolean defaultProfile;
    @SerializedName("geo_enabled")
    private Boolean geoEnabled;

    /**
     * ID は String で統一するために省略
     * // @SerializedName("pinned_tweet_ids")
     * // private Long[] pinnedTweetIds;
     */

    @SerializedName("pinned_tweet_ids_str")
    private String[] pinnedTweetIds;

    @SerializedName("advertiser_account_type")
    private String advertiserAccountType;
    @SerializedName("advertiser_account_service_levels")
    private String[] advertiserAccountServiceLevels;

    @SerializedName("business_profile_state")
    private String businessProfileState;
    @SerializedName("translator_type")
    private String translatorType;

    @SerializedName("ext")
    private Ext ext;

    // region
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public UserEntity getEntities() {
        return entities;
    }

    public Long getFollowersCount() {
        return followersCount;
    }

    public Long getFastFollowersCount() {
        return fastFollowersCount;
    }

    public Long getNormalFollowersCount() {
        return normalFollowersCount;
    }

    public Long getFriendsCount() {
        return friendsCount;
    }

    public float getListedCount() {
        return listedCount;
    }

    public float getFavouritesCount() {
        return favouritesCount;
    }

    public float getStatusesCount() {
        return statusesCount;
    }

    public float getMediaCount() {
        return mediaCount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getProfileImageUrlHttps() {
        return profileImageUrlHttps;
    }

    public String getProfileBannerUrl() {
        return profileBannerUrl;
    }

    public ProfileExtensions getProfileImageExtensions() {
        return profileImageExtensions;
    }

    public ProfileExtensions getProfileBannerExtensions() {
        return profileBannerExtensions;
    }

    public String getProfileLinkColor() {
        return profileLinkColor;
    }

    public Boolean getHasExtendedProfile() {
        return hasExtendedProfile;
    }

    public Boolean getDefaultProfile() {
        return defaultProfile;
    }

    public String[] getPinnedTweetIds() {
        return pinnedTweetIds;
    }

    public String getAdvertiserAccountType() {
        return advertiserAccountType;
    }

    public String[] getAdvertiserAccountServiceLevels() {
        return advertiserAccountServiceLevels;
    }

    public String getBusinessProfileState() {
        return businessProfileState;
    }

    public String getTranslatorType() {
        return translatorType;
    }

    public Ext getExt() {
        return ext;
    }
    // endregion

    /**
     * TODO:
     * r: {
     * ok: {},
     * missing: null
     * }
     */
    public static class MediaStats {

        @SerializedName("ttl")
        private Long ttl;

        // region
        public Long getTtl() {
            return ttl;
        }
        // endregion
    }

    public static class ProfileExtensions {

        @SerializedName("mediaStats")
        private MediaStats mediaStats;

        // region
        public MediaStats getMediaStats() {
            return mediaStats;
        }
        // endregion
    }

    public static class Ext {

        @SerializedName("highlightedLabel")
        private MediaStats highlightedLabel;

        // region
        public MediaStats getHighlightedLabel() {
            return highlightedLabel;
        }
        // endregion
    }
}