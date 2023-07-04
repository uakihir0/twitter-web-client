package net.socialhub.twitter.web.internal;

import net.socialhub.twitter.web.api.FriendshipResource;
import net.socialhub.twitter.web.entity.request.friendship.GetFollowingRequest;
import net.socialhub.twitter.web.entity.response.Response;
import net.socialhub.twitter.web.entity.request.friendship.CreateFriendshipRequest;
import net.socialhub.twitter.web.entity.request.friendship.DestroyFriendshipRequest;
import net.socialhub.twitter.web.entity.response.User;
import net.socialhub.twitter.web.entity.response.graphql.GraphRoot;
import net.socialhub.twitter.web.utility.Endpoint;
import net.socialhub.twitter.web.utility.Session;

public class FriendshipResourceImpl extends AbstractResource implements FriendshipResource {
    public FriendshipResourceImpl(Session session) {
        super(session);
    }

    @Override
    public Response<GraphRoot> getFollowing(
            GetFollowingRequest request
    ) {
        String path = Endpoint.UsersFollowing.path();
        return graphGet(path, request, GraphRoot.class);
    }

    @Override
    public Response<User> createFriendship(
            CreateFriendshipRequest request
    ) {
        String path = Endpoint.CreateFriendships.path();
        return legacyPost(path, request, User.class);
    }

    @Override
    public Response<User> destroyFriendship(
            DestroyFriendshipRequest request
    ) {
        String path = Endpoint.DestroyFriendships.path();
        return legacyPost(path, request, User.class);
    }
}
