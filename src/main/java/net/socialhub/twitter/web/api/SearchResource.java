package net.socialhub.twitter.web.api;

import net.socialhub.twitter.web.entity.Response;
import net.socialhub.twitter.web.entity.request.SearchRequest;
import net.socialhub.twitter.web.entity.response.TopLevel;

public interface SearchResource {

    /**
     * Search Tweets
     * ツイートを検索
     */
    Response<TopLevel> searchTweets(SearchRequest request);

    /**
     * Search Users
     * ユーザーを検索
     */
    Response<TopLevel> searchUsers(SearchRequest request);
}
