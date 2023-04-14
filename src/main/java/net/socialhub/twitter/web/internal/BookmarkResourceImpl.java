package net.socialhub.twitter.web.internal;

import net.socialhub.twitter.web.api.BookmarkResource;
import net.socialhub.twitter.web.entity.response.Response;
import net.socialhub.twitter.web.entity.request.bookmark.GetBookmarkRequest;
import net.socialhub.twitter.web.entity.response.graphql.GraphRoot;
import net.socialhub.twitter.web.utility.Session;

import static net.socialhub.twitter.web.utility.Endpoint.Bookmarks;

public class BookmarkResourceImpl extends AbstractResource implements BookmarkResource {

    public BookmarkResourceImpl(Session session) {
        super(session);
    }

    @Override
    public Response<GraphRoot> getBookmarks(
            GetBookmarkRequest request
    ) {
        String path = Bookmarks.path();
        return graphGet(path, request, GraphRoot.class);
    }
}
