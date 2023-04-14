package net.socialhub.twitter.web.api;

import net.socialhub.twitter.web.entity.request.notification.GetMentionRequest;
import net.socialhub.twitter.web.entity.response.Response;
import net.socialhub.twitter.web.entity.response.TopLevel;

public interface NotificationResource {

    Response<TopLevel> getMention(GetMentionRequest request);
}
