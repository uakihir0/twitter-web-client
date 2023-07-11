package net.socialhub.twitter.web.internal;

import net.socialhub.twitter.web.api.TweetResource;
import net.socialhub.twitter.web.entity.request.CreateTweetRequest;
import net.socialhub.twitter.web.entity.request.tweet.TweetDetailRequest;
import net.socialhub.twitter.web.entity.response.Response;
import net.socialhub.twitter.web.entity.response.graphql.GraphRoot;
import net.socialhub.twitter.web.utility.Endpoint;
import net.socialhub.twitter.web.utility.Session;

public class TweetResourceImpl extends AbstractResource implements TweetResource {

    public TweetResourceImpl(Session session) {
        super(session);
    }


    @Override
    public Response<GraphRoot> getTweetDetail(
            TweetDetailRequest request
    ) {
        String path = Endpoint.TweetDetail.path();
        return graphGet(path, request, GraphRoot.class);
    }

    @Override
    public Response<GraphRoot> createTweet(
            CreateTweetRequest request
    ) {
        String path = Endpoint.CreateTweet.path();
        return graphPost(path, request, GraphRoot.class);
    }
}
