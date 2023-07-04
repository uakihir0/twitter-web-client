package net.socialhub.twitter.web;

import net.socialhub.twitter.web.entity.request.friendship.CreateFriendshipRequest;
import net.socialhub.twitter.web.entity.request.friendship.DestroyFriendshipRequest;
import net.socialhub.twitter.web.entity.request.friendship.GetFollowingRequest;
import net.socialhub.twitter.web.entity.response.Response;
import net.socialhub.twitter.web.entity.response.graphql.GraphRoot;
import org.junit.Test;

public class FriendshipTest extends AbstractTest {


    @Test
    public void testFollowing() {
        Response<GraphRoot> response =
                client.friendship().getFollowing(
                        GetFollowingRequest.builder()
                                .userId("44196397")
                                .build());

    }

    @Test
    public void testCreateFriendship() {

        client.friendship().createFriendship(
                CreateFriendshipRequest.builder()
                        .userId("44196397")
                        .build());
    }

    @Test
    public void testDestroyFriendship() {

        client.friendship().destroyFriendship(
                DestroyFriendshipRequest.builder()
                        .userId("44196397")
                        .build());
    }
}
