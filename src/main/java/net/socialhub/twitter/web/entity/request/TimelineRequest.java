package net.socialhub.twitter.web.entity.request;

import net.socialhub.twitter.web.entity.request.Request;

import java.util.HashMap;
import java.util.Map;

public class TimelineRequest implements Request {

    protected Integer includeProfileInterstitialType = 0;
    protected Integer includeBlocking = 0;
    protected Integer includeBlockedBy = 1;
    protected Integer includeWantRetweets = 0;
    protected Integer includeMuteEdge = 0;
    protected Integer includeCanDm = 0;
    protected Integer includeCanMediaTag = 1;
    protected Integer includeCards = 1;
    protected Integer includeReplyCount = 1;

    protected Boolean includeComposerSource = false;
    protected Boolean includeExtAltText = true;
    protected Boolean includeEntities = true;
    protected Boolean includeUserEntities = true;
    protected Boolean includeExtMediaColor = false;
    protected Boolean includeExtMediaAvailability = true;
    protected Boolean includeQuoteCount = true;

    protected Boolean sendErrorCodes = true;
    protected Boolean simpleQuotedTweet = true;

    protected Integer skipStatus = 1;
    protected Integer count = 20;
    protected String cursor = null;

    protected String cardsPlatform = "Web-12";
    protected String tweetMode = "extended";
    protected String ext = "mediaStats,highlightedLabel,cameraMoment";

    @Override
    public Map<String, String> params() {

        Map<String, String> params = new HashMap<>();

        put(params, "include_profile_interstitial_type", includeProfileInterstitialType);
        put(params, "include_blocking", includeBlocking);
        put(params, "include_blocked_by", includeBlockedBy);
        put(params, "include_want_retweets", includeWantRetweets);
        put(params, "include_mute_edge", includeMuteEdge);
        put(params, "include_can_dm", includeCanDm);
        put(params, "include_can_media_tag", includeCanMediaTag);
        put(params, "include_cards", includeCards);
        put(params, "include_reply_count", includeReplyCount);

        put(params, "include_composer_source", includeComposerSource);
        put(params, "include_ext_alt_text", includeExtAltText);
        put(params, "include_entities", includeEntities);
        put(params, "include_user_entities", includeUserEntities);
        put(params, "include_ext_media_color", includeExtMediaColor);
        put(params, "include_ext_media_availability", includeExtMediaAvailability);
        put(params, "include_quote_count", includeQuoteCount);
        put(params, "send_error_codes", sendErrorCodes);
        put(params, "simple_quoted_tweet", simpleQuotedTweet);

        put(params, "skip_status", skipStatus);
        put(params, "count", count);
        put(params, "cursor", cursor);

        put(params, "cards_platform", cardsPlatform);
        put(params, "tweet_mode", tweetMode);
        put(params, "ext", ext);

        return params;
    }

    // region
    public Integer getIncludeProfileInterstitialType() {
        return includeProfileInterstitialType;
    }

    public Integer getIncludeBlocking() {
        return includeBlocking;
    }

    public Integer getIncludeBlockedBy() {
        return includeBlockedBy;
    }

    public Integer getIncludeWantRetweets() {
        return includeWantRetweets;
    }

    public Integer getIncludeMuteEdge() {
        return includeMuteEdge;
    }

    public Integer getIncludeCanDm() {
        return includeCanDm;
    }

    public Integer getIncludeCanMediaTag() {
        return includeCanMediaTag;
    }

    public Integer getIncludeCards() {
        return includeCards;
    }

    public Integer getIncludeReplyCount() {
        return includeReplyCount;
    }

    public Boolean getIncludeComposerSource() {
        return includeComposerSource;
    }

    public Boolean getIncludeExtAltText() {
        return includeExtAltText;
    }

    public Boolean getIncludeEntities() {
        return includeEntities;
    }

    public Boolean getIncludeUserEntities() {
        return includeUserEntities;
    }

    public Boolean getIncludeExtMediaColor() {
        return includeExtMediaColor;
    }

    public Boolean getIncludeExtMediaAvailability() {
        return includeExtMediaAvailability;
    }

    public Boolean getIncludeQuoteCount() {
        return includeQuoteCount;
    }

    public Boolean getSendErrorCodes() {
        return sendErrorCodes;
    }

    public Boolean getSimpleQuotedTweet() {
        return simpleQuotedTweet;
    }

    public Integer getSkipStatus() {
        return skipStatus;
    }

    public Integer getCount() {
        return count;
    }

    public String getCursor() {
        return cursor;
    }

    public String getCardsPlatform() {
        return cardsPlatform;
    }

    public String getTweetMode() {
        return tweetMode;
    }

    public String getExt() {
        return ext;
    }
    // endregion
}
