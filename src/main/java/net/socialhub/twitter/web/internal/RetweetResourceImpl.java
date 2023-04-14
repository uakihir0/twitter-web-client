package net.socialhub.twitter.web.internal;

import net.socialhub.twitter.web.api.RetweetResource;
import net.socialhub.twitter.web.entity.response.Response;
import net.socialhub.twitter.web.entity.request.retweet.CreateRetweetRequest;
import net.socialhub.twitter.web.entity.request.retweet.DeleteRetweetRequest;
import net.socialhub.twitter.web.entity.response.graphql.GraphRoot;
import net.socialhub.twitter.web.utility.Endpoint;
import net.socialhub.twitter.web.utility.Session;

public class RetweetResourceImpl extends AbstractResource implements RetweetResource {

    public RetweetResourceImpl(Session session) {
        super(session);
    }

    @Override
    public Response<GraphRoot> createRetweet(
            CreateRetweetRequest request
    ) {
        String path = Endpoint.CreateRetweet.path();
        return graphPost(path, request, GraphRoot.class);
    }

    @Override
    public Response<GraphRoot> deleteRetweet(
            DeleteRetweetRequest request
    ) {
        String path = Endpoint.DeleteRetweet.path();
        return graphPost(path, request, GraphRoot.class);
    }
}
