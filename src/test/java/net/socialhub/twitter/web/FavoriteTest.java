package net.socialhub.twitter.web;

import net.socialhub.twitter.web.entity.request.favorite.FavoriteTweetRequest;
import net.socialhub.twitter.web.entity.request.favorite.UnfavoriteTweetRequest;
import org.junit.Test;

public class FavoriteTest extends AbstractTest {

    @Test
    public void testFavoriteTweet() {

        client.favorite().favoriteTweet(
                FavoriteTweetRequest.builder()
                        .tweetId("1645266104351178752")
                        .build());
    }

    @Test
    public void testUnfavoriteTweet() {

        client.favorite().unfavoriteTweet(
                UnfavoriteTweetRequest.builder()
                        .tweetId("1645266104351178752")
                        .build());
    }
}
