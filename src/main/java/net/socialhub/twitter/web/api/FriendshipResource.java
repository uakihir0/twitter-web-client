package net.socialhub.twitter.web.api;

import net.socialhub.twitter.web.entity.request.friendship.GetFollowingRequest;
import net.socialhub.twitter.web.entity.response.Response;
import net.socialhub.twitter.web.entity.request.friendship.CreateFriendshipRequest;
import net.socialhub.twitter.web.entity.request.friendship.DestroyFriendshipRequest;
import net.socialhub.twitter.web.entity.response.User;
import net.socialhub.twitter.web.entity.response.graphql.GraphRoot;

public interface FriendshipResource {


    /**
     *
     */
    Response<GraphRoot> getFollowing(GetFollowingRequest request);

    /**
     * ユーザーをフォローする
     * Follow a user
     */
    Response<User> createFriendship(CreateFriendshipRequest request);

    /**
     * ユーザーをフォロー解除する
     * Unfollow a user
     */
    Response<User> destroyFriendship(DestroyFriendshipRequest request);
}
