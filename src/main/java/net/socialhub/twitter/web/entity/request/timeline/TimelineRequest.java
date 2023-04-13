package net.socialhub.twitter.web.entity.request.timeline;

import net.socialhub.twitter.web.entity.Request;

import java.util.HashMap;
import java.util.Map;

public class TimelineRequest implements Request {

    private Integer includeProfileInterstitialType = 0;
    private Integer includeBlocking = 0;
    private Integer includeBlockedBy = 1;
    private Integer includeWantRetweets = 0;
    private Integer includeMuteEdge = 0;
    private Integer includeCanDm = 0;
    private Integer includeCanMediaTag = 1;
    private Integer includeCards = 1;
    private Integer includeReplyCount = 1;

    private Boolean includeComposerSource = false;
    private Boolean includeExtAltText = true;
    private Boolean includeEntities = true;
    private Boolean includeUserEntities = true;
    private Boolean includeExtMediaColor = false;
    private Boolean includeExtMediaAvailability = true;
    private Boolean includeQuoteCount = true;

    private Boolean sendErrorCodes = true;
    private Boolean simpleQuotedTweet = true;

    private Integer skipStatus = 1;
    private Integer count = 20;
    private String cursor = null;

    private String cardsPlatform = "Web-12";
    private String tweetMode = "extended";
    private String ext = "mediaStats,highlightedLabel,cameraMoment";

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

    public void setIncludeProfileInterstitialType(Integer includeProfileInterstitialType) {
        this.includeProfileInterstitialType = includeProfileInterstitialType;
    }

    public Integer getIncludeBlocking() {
        return includeBlocking;
    }

    public void setIncludeBlocking(Integer includeBlocking) {
        this.includeBlocking = includeBlocking;
    }

    public Integer getIncludeBlockedBy() {
        return includeBlockedBy;
    }

    public void setIncludeBlockedBy(Integer includeBlockedBy) {
        this.includeBlockedBy = includeBlockedBy;
    }

    public Integer getIncludeWantRetweets() {
        return includeWantRetweets;
    }

    public void setIncludeWantRetweets(Integer includeWantRetweets) {
        this.includeWantRetweets = includeWantRetweets;
    }

    public Integer getIncludeMuteEdge() {
        return includeMuteEdge;
    }

    public void setIncludeMuteEdge(Integer includeMuteEdge) {
        this.includeMuteEdge = includeMuteEdge;
    }

    public Integer getIncludeCanDm() {
        return includeCanDm;
    }

    public void setIncludeCanDm(Integer includeCanDm) {
        this.includeCanDm = includeCanDm;
    }

    public Integer getIncludeCanMediaTag() {
        return includeCanMediaTag;
    }

    public void setIncludeCanMediaTag(Integer includeCanMediaTag) {
        this.includeCanMediaTag = includeCanMediaTag;
    }

    public Integer getIncludeCards() {
        return includeCards;
    }

    public void setIncludeCards(Integer includeCards) {
        this.includeCards = includeCards;
    }

    public Integer getIncludeReplyCount() {
        return includeReplyCount;
    }

    public void setIncludeReplyCount(Integer includeReplyCount) {
        this.includeReplyCount = includeReplyCount;
    }

    public Boolean getIncludeComposerSource() {
        return includeComposerSource;
    }

    public void setIncludeComposerSource(Boolean includeComposerSource) {
        this.includeComposerSource = includeComposerSource;
    }

    public Boolean getIncludeExtAltText() {
        return includeExtAltText;
    }

    public void setIncludeExtAltText(Boolean includeExtAltText) {
        this.includeExtAltText = includeExtAltText;
    }

    public Boolean getIncludeEntities() {
        return includeEntities;
    }

    public void setIncludeEntities(Boolean includeEntities) {
        this.includeEntities = includeEntities;
    }

    public Boolean getIncludeUserEntities() {
        return includeUserEntities;
    }

    public void setIncludeUserEntities(Boolean includeUserEntities) {
        this.includeUserEntities = includeUserEntities;
    }

    public Boolean getIncludeExtMediaColor() {
        return includeExtMediaColor;
    }

    public void setIncludeExtMediaColor(Boolean includeExtMediaColor) {
        this.includeExtMediaColor = includeExtMediaColor;
    }

    public Boolean getIncludeExtMediaAvailability() {
        return includeExtMediaAvailability;
    }

    public void setIncludeExtMediaAvailability(Boolean includeExtMediaAvailability) {
        this.includeExtMediaAvailability = includeExtMediaAvailability;
    }

    public Boolean getIncludeQuoteCount() {
        return includeQuoteCount;
    }

    public void setIncludeQuoteCount(Boolean includeQuoteCount) {
        this.includeQuoteCount = includeQuoteCount;
    }

    public Boolean getSendErrorCodes() {
        return sendErrorCodes;
    }

    public void setSendErrorCodes(Boolean sendErrorCodes) {
        this.sendErrorCodes = sendErrorCodes;
    }

    public Boolean getSimpleQuotedTweet() {
        return simpleQuotedTweet;
    }

    public void setSimpleQuotedTweet(Boolean simpleQuotedTweet) {
        this.simpleQuotedTweet = simpleQuotedTweet;
    }

    public Integer getSkipStatus() {
        return skipStatus;
    }

    public void setSkipStatus(Integer skipStatus) {
        this.skipStatus = skipStatus;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public String getCardsPlatform() {
        return cardsPlatform;
    }

    public void setCardsPlatform(String cardsPlatform) {
        this.cardsPlatform = cardsPlatform;
    }

    public String getTweetMode() {
        return tweetMode;
    }

    public void setTweetMode(String tweetMode) {
        this.tweetMode = tweetMode;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }
    // endregion
}
