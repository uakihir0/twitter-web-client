package net.socialhub.twitter.web.api;

import net.socialhub.twitter.web.entity.Response;
import net.socialhub.twitter.web.entity.request.SpecifiedTweetRequest;
import net.socialhub.twitter.web.entity.request.UserTimelineRequest;
import net.socialhub.twitter.web.entity.response.TopLevel;

public interface TimelineResource {

    /**
     * Get User's Timeline
     * (Only for public users)
     * 特定ユーザーのツイートを取得
     */
    Response<TopLevel> getUserTimeline(UserTimelineRequest request);

    /**
     * Get Users who liked specified tweet.
     * 特定ツイートをいいねしているユーザー一覧を取得
     */
    Response<TopLevel> getUsersLikedBy(SpecifiedTweetRequest request);

    /**
     * Get Users who retweeted specified tweet.
     * 特定ツイートをリツイートしているユーザー一覧を取得
     */
    Response<TopLevel> getUsersRetweetedBy(SpecifiedTweetRequest request);

    /**
     * Get User's Media Timeline
     * (Only for public users)
     * 特定ユーザーのメディアを取得
     */
    Response<TopLevel> getUserMediaTimeline(UserTimelineRequest request);

    /**
     * Get Tweet's Conversation.
     * (Only for public tweets)
     * 特定ツイートの会話を取得
     */
    Response<TopLevel> getTweetConversation(SpecifiedTweetRequest request);
}
