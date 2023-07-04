package net.socialhub.twitter.web.internal;

import net.socialhub.twitter.web.api.TimelineResource;
import net.socialhub.twitter.web.entity.request.timeline.UserMediaTimelineRequest;
import net.socialhub.twitter.web.entity.response.Response;
import net.socialhub.twitter.web.entity.request.timeline.HomeTimelineRequest;
import net.socialhub.twitter.web.entity.request.timeline.RecommendTimelineRequest;
import net.socialhub.twitter.web.entity.request.timeline.UserTimelineRequest;
import net.socialhub.twitter.web.entity.response.TopLevel;
import net.socialhub.twitter.web.entity.response.graphql.GraphRoot;
import net.socialhub.twitter.web.utility.Session;

import static net.socialhub.twitter.web.utility.Endpoint.HomeLatestTimeline;
import static net.socialhub.twitter.web.utility.Endpoint.HomeTimeline;
import static net.socialhub.twitter.web.utility.Endpoint.UserMediaTimeline;
import static net.socialhub.twitter.web.utility.Endpoint.UserTimeline;

public class TimelineResourceImpl extends AbstractResource implements TimelineResource {

    public TimelineResourceImpl(Session session) {
        super(session);
    }

    @Override
    public Response<GraphRoot> getUserTimeline(
            UserTimelineRequest request
    ) {
        String path = UserTimeline.path();
        return graphGet(path, request, GraphRoot.class);
    }

    @Override
    public Response<GraphRoot> getUserMediaTimeline(
            UserMediaTimelineRequest request
    ) {
        String path = UserMediaTimeline.path();
        return graphGet(path, request, GraphRoot.class);
    }

    @Override
    public Response<GraphRoot> getHomeTimeline(
            HomeTimelineRequest request
    ) {
        String path = HomeLatestTimeline.path();
        return graphPost(path, request, GraphRoot.class);
    }

    @Override
    public Response<GraphRoot> getRecommendTimeline(
            RecommendTimelineRequest request
    ){
        String path = HomeTimeline.path();
        return graphPost(path, request, GraphRoot.class);
    }
}
