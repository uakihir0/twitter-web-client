package net.socialhub.twitter.web;

import net.socialhub.twitter.web.entity.response.Response;
import net.socialhub.twitter.web.entity.request.bookmark.GetBookmarkRequest;
import net.socialhub.twitter.web.entity.response.graphql.GraphRoot;
import org.junit.Test;

public class BookmarkTest extends AbstractTest {

    @Test
    public void testGetBookmarks() {

        Response<GraphRoot> response =
                client.bookmark().getBookmarks(
                        GetBookmarkRequest.builder()
                                .build()
                );
    }
}
