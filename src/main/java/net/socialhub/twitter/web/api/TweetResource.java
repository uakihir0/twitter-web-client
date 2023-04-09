package net.socialhub.twitter.web.api;

import net.socialhub.twitter.web.entity.Response;
import net.socialhub.twitter.web.entity.request.SpecifiedTweetRequest;
import net.socialhub.twitter.web.entity.request.UserTimelineRequest;
import net.socialhub.twitter.web.entity.request.graphql.CreateTweetRequest;
import net.socialhub.twitter.web.entity.response.TopLevel;
import net.socialhub.twitter.web.entity.response.graphql.GraphRoot;

public interface TweetResource {

    /**
     * Get Tweet's Conversation.
     * 特定ツイートの会話を取得
     * (認証不要 / No Authentication Required)
     */
    Response<TopLevel> getTweetConversation(SpecifiedTweetRequest request);


    /**
     * Create Tweet.
     * ツイートを投稿
     */
    Response<GraphRoot> createTweet(CreateTweetRequest request);
}
