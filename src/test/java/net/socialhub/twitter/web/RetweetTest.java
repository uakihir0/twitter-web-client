package net.socialhub.twitter.web;

import net.socialhub.twitter.web.entity.request.favorite.FavoriteTweetRequest;
import net.socialhub.twitter.web.entity.request.retweet.CreateRetweetRequest;
import net.socialhub.twitter.web.entity.request.retweet.DeleteRetweetRequest;
import org.junit.Test;

public class RetweetTest extends AbstractTest {

    @Test
    public void testCreateRetweet() {

        client.retweet().createRetweet(
                CreateRetweetRequest.builder()
                        .tweetId("1645266104351178752")
                        .build());
    }

    @Test
    public void testDeleteRetweet() {

        client.retweet().deleteRetweet(
                DeleteRetweetRequest.builder()
                        .sourceTweetId("1645266104351178752")
                        .build());
    }
}
