package net.socialhub.twitter.web;

import net.socialhub.twitter.web.entity.request.graphql.CreateTweetRequest;
import org.junit.Test;

public class CreateTweetTest extends AbstractTest {

    @Test
    public void testCreateTweet() {

        client.tweet().createTweet(
                CreateTweetRequest.builder()
                        .text("Hello World!")
                        .build()
        );
    }
}
