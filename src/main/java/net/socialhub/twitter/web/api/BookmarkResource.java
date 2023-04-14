package net.socialhub.twitter.web.api;

import net.socialhub.twitter.web.entity.response.Response;
import net.socialhub.twitter.web.entity.request.bookmark.GetBookmarkRequest;
import net.socialhub.twitter.web.entity.response.graphql.GraphRoot;

public interface BookmarkResource {

    /**
     * Get User's Bookmarks
     * ブックマークしたツイートを取得
     */
    Response<GraphRoot> getBookmarks(GetBookmarkRequest request);
}
