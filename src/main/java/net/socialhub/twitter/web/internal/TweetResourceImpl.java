package net.socialhub.twitter.web.internal;

import net.socialhub.twitter.web.api.TweetResource;
import net.socialhub.twitter.web.entity.Response;
import net.socialhub.twitter.web.entity.request.SpecifiedTweetRequest;
import net.socialhub.twitter.web.entity.request.graphql.CreateTweetRequest;
import net.socialhub.twitter.web.entity.response.TopLevel;
import net.socialhub.twitter.web.entity.response.graphql.GraphRoot;
import net.socialhub.twitter.web.utility.Endpoint;
import net.socialhub.twitter.web.utility.Session;

import static net.socialhub.twitter.web.utility.Endpoint.TweetConversation;

public class TweetResourceImpl extends AbstractResource implements TweetResource {

    public TweetResourceImpl(Session session) {
        super(session);
    }

    @Override
    public Response<TopLevel> getTweetConversation(
            SpecifiedTweetRequest request
    ) {
        String path = TweetConversation.path()
                .replace("{tweetId}", request.getTweetId());
        return get(path, request, TopLevel.class);
    }

    @Override
    public Response<GraphRoot> createTweet(
            CreateTweetRequest request
    ) {
        String path = Endpoint.CreateTweet.path();
        return graphPost(path, request, GraphRoot.class);
    }
}
