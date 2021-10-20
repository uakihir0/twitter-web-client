package net.socialhub.twitter.web.internal;

import net.socialhub.twitter.web.api.TimelineResource;
import net.socialhub.twitter.web.entity.Response;
import net.socialhub.twitter.web.entity.request.UserTimelineRequest;
import net.socialhub.twitter.web.entity.response.TopLevel;
import net.socialhub.twitter.web.utility.Token;

import static net.socialhub.twitter.web.utility.Endpoint.UserMediaTimeline;
import static net.socialhub.twitter.web.utility.Endpoint.UserTimeline;

public class TimelineResourceImpl extends AbstractResource implements TimelineResource {

    public TimelineResourceImpl(String baseUrl, Token token) {
        super(baseUrl, token);
    }

    @Override
    public Response<TopLevel> getUserTimeline(
            UserTimelineRequest request) {

        String path = UserTimeline.path()
                .replace("{userId}", request.getUserId());
        return get(path, request, TopLevel.class);
    }

    @Override
    public Response<TopLevel> getUserMediaTimeline(
            UserTimelineRequest request) {

        String path = UserMediaTimeline.path()
                .replace("{userId}", request.getUserId());
        return get(path, request, TopLevel.class);
    }
}
