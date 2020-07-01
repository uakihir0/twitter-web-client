package net.socialhub.twitter.web.entity.request.graphql;

import java.util.HashMap;
import java.util.Map;

public class UserIdRequest implements GraphRequest {

    private String userId;
    private Long count = 20L;

    private Boolean withHighlightedLabel = true;
    private Boolean withTweetQuoteCount = true;
    private Boolean includePromotedContent = true;
    private Boolean withTweetResult = true;
    private Boolean withUserResult = true;

    @Override
    public Map<String, Object> params() {
        Map<String, Object> params = new HashMap<>();
        put(params, "userId", userId);
        put(params, "count", count);

        put(params, "withHighlightedLabel", withHighlightedLabel);
        put(params, "withTweetQuoteCount", withTweetQuoteCount);
        put(params, "includePromotedContent", includePromotedContent);
        put(params, "withTweetResult", withTweetResult);
        put(params, "withUserResult", withUserResult);

        return params;
    }


    // region
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Boolean getWithHighlightedLabel() {
        return withHighlightedLabel;
    }

    public void setWithHighlightedLabel(Boolean withHighlightedLabel) {
        this.withHighlightedLabel = withHighlightedLabel;
    }

    public Boolean getWithTweetQuoteCount() {
        return withTweetQuoteCount;
    }

    public void setWithTweetQuoteCount(Boolean withTweetQuoteCount) {
        this.withTweetQuoteCount = withTweetQuoteCount;
    }

    public Boolean getIncludePromotedContent() {
        return includePromotedContent;
    }

    public void setIncludePromotedContent(Boolean includePromotedContent) {
        this.includePromotedContent = includePromotedContent;
    }

    public Boolean getWithTweetResult() {
        return withTweetResult;
    }

    public void setWithTweetResult(Boolean withTweetResult) {
        this.withTweetResult = withTweetResult;
    }

    public Boolean getWithUserResult() {
        return withUserResult;
    }

    public void setWithUserResult(Boolean withUserResult) {
        this.withUserResult = withUserResult;
    }

    // endregion
}
