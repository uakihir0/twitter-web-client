package net.socialhub.twitter.web.internal;

import net.socialhub.twitter.web.api.SearchResource;
import net.socialhub.twitter.web.entity.request.timeline.SearchTimelineRequest;
import net.socialhub.twitter.web.entity.response.Response;
import net.socialhub.twitter.web.entity.response.graphql.GraphRoot;
import net.socialhub.twitter.web.utility.Session;

import static net.socialhub.twitter.web.utility.Endpoint.SearchTimeline;

public class SearchResourceImpl extends AbstractResource implements SearchResource {

    public SearchResourceImpl(Session session) {
        super(session);
    }

    @Override
    public Response<GraphRoot> searchTweets(
            SearchTimelineRequest request
    ) {
        String path = SearchTimeline.path();
        request.setProduct("Top");
        return graphGet(path, request, GraphRoot.class);
    }

    @Override
    public Response<GraphRoot> searchUsers(
            SearchTimelineRequest request
    ) {
        String path = SearchTimeline.path();
        request.setProduct("People");
        return graphGet(path, request, GraphRoot.class);
    }
}
