package net.socialhub.twitter.web.entity.request;

import java.util.HashMap;
import java.util.Map;

public class UserIdRequest implements GraphRequest {

    private String userId;
    private Long count = 20L;

    @Override
    public Map<String, Object> params() {
        Map<String, Object> variables = new HashMap<>();
        put(variables, "userId", getUserId());
        put(variables, "count", getCount());

        put(variables, "withHighlightedLabel", true);
        put(variables, "withTweetQuoteCount", true);
        put(variables, "includePromotedContent", true);
        put(variables, "withTweetResult", true);
        put(variables, "withUserResult", true);

        Map<String, Object> params = new HashMap<>();
        put(params, "variables", getGson().toJson(variables));
        return params;
    }

    // region
    public static UserIdRequestBuilder builder() {
        return new UserIdRequestBuilder();
    }

    public String getUserId() {
        return userId;
    }

    public Long getCount() {
        return count;
    }

    public static final class UserIdRequestBuilder {
        private String userId;
        private Long count;

        private UserIdRequestBuilder() {
        }

        public UserIdRequestBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserIdRequestBuilder count(Long count) {
            this.count = count;
            return this;
        }

        public UserIdRequest build() {
            UserIdRequest userIdRequest = new UserIdRequest();
            userIdRequest.count = this.count;
            userIdRequest.userId = this.userId;
            return userIdRequest;
        }
    }
    // endregion
}
