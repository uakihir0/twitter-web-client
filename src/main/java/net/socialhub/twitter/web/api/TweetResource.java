package net.socialhub.twitter.web.api;

import net.socialhub.twitter.web.entity.request.tweet.TweetDetailRequest;
import net.socialhub.twitter.web.entity.response.Response;
import net.socialhub.twitter.web.entity.request.SpecifiedTweetRequest;
import net.socialhub.twitter.web.entity.request.CreateTweetRequest;
import net.socialhub.twitter.web.entity.response.TopLevel;
import net.socialhub.twitter.web.entity.response.graphql.GraphRoot;

public interface TweetResource {

    /**
     * Get Tweet's Detail.
     * ツイート詳細を取得
     * (認証不要 / No Authentication Required)
     */
    Response<GraphRoot> getTweetDetail(TweetDetailRequest request);

    /**
     * Create Tweet.
     * ツイートを投稿
     */
    Response<GraphRoot> createTweet(CreateTweetRequest request);
}
