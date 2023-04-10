package net.socialhub.twitter.web.internal;

import net.socialhub.twitter.web.api.UserResource;
import net.socialhub.twitter.web.entity.Response;
import net.socialhub.twitter.web.entity.request.SpecifiedTweetRequest;
import net.socialhub.twitter.web.entity.request.graphql.ScreenNameRequest;
import net.socialhub.twitter.web.entity.request.graphql.UserIdRequest;
import net.socialhub.twitter.web.entity.response.TopLevel;
import net.socialhub.twitter.web.entity.response.graphql.GraphRoot;
import net.socialhub.twitter.web.utility.Session;

import static net.socialhub.twitter.web.utility.Endpoint.UserByScreenName;
import static net.socialhub.twitter.web.utility.Endpoint.UserTweetLiked;
import static net.socialhub.twitter.web.utility.Endpoint.UserTweetRetweeted;
import static net.socialhub.twitter.web.utility.Endpoint.UsersFollowers;

public class UserResourceImpl extends AbstractResource implements UserResource {

    public UserResourceImpl(Session session) {
        super(session);
    }

    @Override
    public Response<TopLevel> getUsersLikedBy(
            SpecifiedTweetRequest request
    ) {
        String path = UserTweetLiked.path();
        return get(path, request, TopLevel.class);
    }

    @Override
    public Response<TopLevel> getUsersRetweetedBy(
            SpecifiedTweetRequest request
    ) {
        String path = UserTweetRetweeted.path();
        return get(path, request, TopLevel.class);
    }

    @Override
    public Response<GraphRoot> getUserByScreenName(
            ScreenNameRequest request
    ) {
        String path = UserByScreenName.path();
        return graphGet(path, request, GraphRoot.class);
    }

    public Response<GraphRoot> getUserFollowers(
            UserIdRequest request
    ) {
        String path = UsersFollowers.path();
        return graphGet(path, request, GraphRoot.class);
    }
}
