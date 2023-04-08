package net.socialhub.twitter.web.internal;

import net.socialhub.twitter.web.api.SearchResource;
import net.socialhub.twitter.web.entity.Response;
import net.socialhub.twitter.web.entity.request.SearchRequest;
import net.socialhub.twitter.web.entity.response.TopLevel;
import net.socialhub.twitter.web.utility.GuestToken;
import net.socialhub.twitter.web.utility.Session;

import static net.socialhub.twitter.web.utility.Endpoint.Search;

public class SearchResourceImpl extends AbstractResource implements SearchResource {

    public SearchResourceImpl(String baseUrl, Session session) {
        super(baseUrl, session);
    }

    @Override
    public Response<TopLevel> searchTweets(
            SearchRequest request) {

        String path = Search.path();
        request.setTweetSearchMode("live");
        return get(path, request, TopLevel.class);
    }

    @Override
    public Response<TopLevel> searchUsers(
            SearchRequest request) {

        String path = Search.path();
        request.setResultFilter("user");
        return get(path, request, TopLevel.class);
    }
}
