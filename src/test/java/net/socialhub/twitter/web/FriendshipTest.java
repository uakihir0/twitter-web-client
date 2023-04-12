package net.socialhub.twitter.web;

import net.socialhub.twitter.web.entity.request.friendship.CreateFriendshipRequest;
import net.socialhub.twitter.web.entity.request.friendship.DestroyFriendshipRequest;
import org.junit.Test;

public class FriendshipTest extends AbstractTest {

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
