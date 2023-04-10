package net.socialhub.twitter.web.internal;

import net.socialhub.twitter.web.api.FavoriteResource;
import net.socialhub.twitter.web.entity.Response;
import net.socialhub.twitter.web.entity.request.favorite.FavoriteTweetRequest;
import net.socialhub.twitter.web.entity.request.favorite.UnfavoriteTweetRequest;
import net.socialhub.twitter.web.entity.response.graphql.GraphRoot;
import net.socialhub.twitter.web.utility.Endpoint;
import net.socialhub.twitter.web.utility.Session;

public class FavoriteResourceImpl extends AbstractResource implements FavoriteResource {

    public FavoriteResourceImpl(Session session) {
        super(session);
    }

    @Override
    public Response<GraphRoot> favoriteTweet(
            FavoriteTweetRequest request
    ) {
        String path = Endpoint.FavoriteTweet.path();
        return graphPost(path, request, GraphRoot.class);
    }

    @Override
    public Response<GraphRoot> unfavoriteTweet(
            UnfavoriteTweetRequest request
    ) {
        String path = Endpoint.UnfavoriteTweet.path();
        return graphPost(path, request, GraphRoot.class);
    }
}
