package net.socialhub.twitter.web.entity.request;

import net.socialhub.twitter.web.entity.GraphRequest;

import java.util.HashMap;
import java.util.Map;

public class ScreenNameRequest implements GraphRequest {

    private String screenName;
    private Boolean withHighlightedLabel = true;

    @Override
    public Map<String, Object> params() {
        Map<String, Object> params = new HashMap<>();
        put(params, "screen_name", screenName);
        put(params, "withHighlightedLabel", withHighlightedLabel);
        return params;
    }

    // region
    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public Boolean getWithHighlightedLabel() {
        return withHighlightedLabel;
    }

    public void setWithHighlightedLabel(Boolean withHighlightedLabel) {
        this.withHighlightedLabel = withHighlightedLabel;
    }
    // endregion
}
