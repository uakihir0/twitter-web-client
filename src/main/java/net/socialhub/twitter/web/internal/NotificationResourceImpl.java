package net.socialhub.twitter.web.internal;

import net.socialhub.twitter.web.api.NotificationResource;
import net.socialhub.twitter.web.entity.request.notification.GetMentionRequest;
import net.socialhub.twitter.web.entity.response.Response;
import net.socialhub.twitter.web.entity.response.TopLevel;
import net.socialhub.twitter.web.utility.Session;

import static net.socialhub.twitter.web.utility.Endpoint.Mention;
import static net.socialhub.twitter.web.utility.Endpoint.UserTimeline;

public class NotificationResourceImpl extends AbstractResource implements NotificationResource {

    public NotificationResourceImpl(Session session) {
        super(session);
    }

    @Override
    public Response<TopLevel> getMention(
            GetMentionRequest request
    ) {
        String path = Mention.path();
        return get(path, request, TopLevel.class);
    }
}
