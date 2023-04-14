package net.socialhub.twitter.web.api;

import net.socialhub.twitter.web.entity.response.Response;
import net.socialhub.twitter.web.entity.request.favorite.FavoriteTweetRequest;
import net.socialhub.twitter.web.entity.request.favorite.UnfavoriteTweetRequest;
import net.socialhub.twitter.web.entity.response.graphql.GraphRoot;

public interface FavoriteResource {

    /**
     * Favorite Tweet
     * ツイートをお気に入りに追加
     */
    Response<GraphRoot> favoriteTweet(FavoriteTweetRequest request);

    /**
     * Delete Favorite
     * お気に入りを解除
     */
    Response<GraphRoot> unfavoriteTweet(UnfavoriteTweetRequest request);
}
