package net.socialhub.twitter.web.entity.request;

import java.util.HashMap;
import java.util.Map;

public class ScreenNameRequest implements GraphRequest {

    private String screenName;

    @Override
    public Map<String, Object> params() {
        Map<String, Object> variables = new HashMap<>();
        put(variables, "screen_name", getScreenName());
        put(variables, "withHighlightedLabel", true);

        Map<String, Object> params = new HashMap<>();
        put(params, "variables", getGson().toJson(variables));
        return params;
    }

    // region
    public static ScreenNameRequestBuilder builder() {
        return new ScreenNameRequestBuilder();
    }

    public String getScreenName() {
        return screenName;
    }

    public static final class ScreenNameRequestBuilder {
        private String screenName;

        private ScreenNameRequestBuilder() {
        }

        public ScreenNameRequestBuilder screenName(String screenName) {
            this.screenName = screenName;
            return this;
        }

        public ScreenNameRequest build() {
            ScreenNameRequest screenNameRequest = new ScreenNameRequest();
            screenNameRequest.screenName = this.screenName;
            return screenNameRequest;
        }
    }
    // endregion
}
