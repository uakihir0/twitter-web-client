package net.socialhub.twitter.web.entity.request.notification;

import net.socialhub.twitter.web.entity.request.TimelineRequest;

public class GetMentionRequest extends TimelineRequest {


    public static GetMentionRequestBuilder builder() {
        return new GetMentionRequestBuilder();
    }

    public static final class GetMentionRequestBuilder {
        private Integer count;
        private String cursor;

        private GetMentionRequestBuilder() {
        }

        public GetMentionRequestBuilder count(Integer count) {
            this.count = count;
            return this;
        }

        public GetMentionRequestBuilder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        public GetMentionRequest build() {
            GetMentionRequest getMentionRequest = new GetMentionRequest();
            getMentionRequest.count = this.count;
            getMentionRequest.cursor = this.cursor;
            return getMentionRequest;
        }
    }
}