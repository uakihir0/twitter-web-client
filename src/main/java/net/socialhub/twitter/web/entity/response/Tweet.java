package net.socialhub.twitter.web.entity.response;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Tweet
 */
public class Tweet {

    @SerializedName("id_str")
    private String id;
    @SerializedName("user_id_str")
    private String userId;
    @SerializedName("conversation_id_str")
    private String conversationId;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("full_text")
    private String fullText;
    @SerializedName("text")
    private String text;

    @SerializedName("display_text_range")
    private Integer[] displayTextRange;
    @SerializedName("source")
    private String source;
    @SerializedName("lang")
    private String lang;

    @SerializedName("entities")
    private Entity entities;
    @SerializedName("extended_entities")
    private ExtendedEntity extendedEntities;

    @SerializedName("retweet_count")
    private Long retweetCount;
    @SerializedName("favorite_count")
    private Long favoriteCount;
    @SerializedName("reply_count")
    private Long replyCount;
    @SerializedName("quote_count")
    private Long quoteCount;

    @SerializedName("is_quote_status")
    private Boolean isQuoteStatus;
    @SerializedName("quoted_status_id_str")
    private String quotedStatusId;
    @SerializedName("quoted_status_permalink")
    private Link quotedStatusPermalink;

    @SerializedName("in_reply_to_status_id_str")
    private String inReplyToStatusId;
    @SerializedName("in_reply_to_user_id_str")
    private String inReplyToUserId;
    @SerializedName("in_reply_to_screen_name")
    private String inReplyToScreenName;

    @SerializedName("possibly_sensitive_editable")
    private Boolean possiblySensitiveEditable;


    /** FullText と Text は同一とみなす */
    public String getFullText() {
        return fullText != null ? fullText : text;
    }

    /** FullText と Text は同一とみなす */
    public String getText() {
        return text != null ? text : fullText;
    }

    // region
    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getConversationId() {
        return conversationId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public Integer[] getDisplayTextRange() {
        return displayTextRange;
    }

    public String getSource() {
        return source;
    }

    public String getLang() {
        return lang;
    }

    public Entity getEntities() {
        return entities;
    }

    public ExtendedEntity getExtendedEntities() {
        return extendedEntities;
    }

    public Long getRetweetCount() {
        return retweetCount;
    }

    public Long getFavoriteCount() {
        return favoriteCount;
    }

    public Long getReplyCount() {
        return replyCount;
    }

    public Long getQuoteCount() {
        return quoteCount;
    }

    public Boolean getQuoteStatus() {
        return isQuoteStatus;
    }

    public String getQuotedStatusId() {
        return quotedStatusId;
    }

    public Link getQuotedStatusPermalink() {
        return quotedStatusPermalink;
    }

    public String getInReplyToStatusId() {
        return inReplyToStatusId;
    }

    public String getInReplyToUserId() {
        return inReplyToUserId;
    }

    public String getInReplyToScreenName() {
        return inReplyToScreenName;
    }

    public Boolean getPossiblySensitiveEditable() {
        return possiblySensitiveEditable;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", conversationId='" + conversationId + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", fullText='" + fullText + '\'' +
                ", text='" + text + '\'' +
                ", displayTextRange=" + Arrays.toString(displayTextRange) +
                ", source='" + source + '\'' +
                ", lang='" + lang + '\'' +
                ", entities=" + entities +
                ", extendedEntities=" + extendedEntities +
                ", retweetCount=" + retweetCount +
                ", favoriteCount=" + favoriteCount +
                ", replyCount=" + replyCount +
                ", quoteCount=" + quoteCount +
                ", isQuoteStatus=" + isQuoteStatus +
                ", quotedStatusId='" + quotedStatusId + '\'' +
                ", quotedStatusPermalink=" + quotedStatusPermalink +
                ", inReplyToStatusId='" + inReplyToStatusId + '\'' +
                ", inReplyToUserId='" + inReplyToUserId + '\'' +
                ", inReplyToScreenName='" + inReplyToScreenName + '\'' +
                ", possiblySensitiveEditable=" + possiblySensitiveEditable +
                '}';
        // endregion
    }
}
