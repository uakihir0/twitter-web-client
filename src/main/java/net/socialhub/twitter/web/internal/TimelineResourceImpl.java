package net.socialhub.twitter.web.internal;

import net.socialhub.twitter.web.api.TimelineResource;
import net.socialhub.twitter.web.entity.Response;
import net.socialhub.twitter.web.entity.request.SpecifiedTweetRequest;
import net.socialhub.twitter.web.entity.request.UserTimelineRequest;
import net.socialhub.twitter.web.entity.response.TopLevel;
import net.socialhub.twitter.web.utility.Token;

import static net.socialhub.twitter.web.utility.Endpoint.UserTimeline;
import static net.socialhub.twitter.web.utility.Endpoint.UserTweetLiked;
import static net.socialhub.twitter.web.utility.Endpoint.UserTweetRetweeted;

public class TimelineResourceImpl extends AbstractResource implements TimelineResource {

    public TimelineResourceImpl(String baseUrl, Token token) {
        super(baseUrl, token);
    }

    @Override
    public Response<TopLevel> getUserTimeline(
            UserTimelineRequest request) {

        String path = UserTimeline.path()
                .replaceAll("\\{userId}", request.getUserId());
        return get(path, request, TopLevel.class);
    }

    @Override
    public Response<TopLevel> getUsersLikedBy(
            SpecifiedTweetRequest request) {

        String path = UserTweetLiked.path();
        return get(path, request, TopLevel.class);
    }

    @Override
    public Response<TopLevel> getUsersRetweetedBy(
            SpecifiedTweetRequest request) {

        String path = UserTweetRetweeted.path();
        return get(path, request, TopLevel.class);
    }
}
