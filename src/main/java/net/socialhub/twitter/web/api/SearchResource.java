package net.socialhub.twitter.web.api;

import net.socialhub.twitter.web.entity.request.timeline.SearchTimelineRequest;
import net.socialhub.twitter.web.entity.response.Response;
import net.socialhub.twitter.web.entity.request.SearchRequest;
import net.socialhub.twitter.web.entity.response.TopLevel;
import net.socialhub.twitter.web.entity.response.graphql.GraphRoot;

public interface SearchResource {

    /**
     * Search Tweets
     * ツイートを検索
     */
    Response<GraphRoot> searchTweets(SearchTimelineRequest request);

    /**
     * Search Users
     * ユーザーを検索
     */
    Response<GraphRoot> searchUsers(SearchTimelineRequest request);
}
