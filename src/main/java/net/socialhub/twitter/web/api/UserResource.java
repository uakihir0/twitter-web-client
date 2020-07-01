package net.socialhub.twitter.web.api;

import net.socialhub.twitter.web.entity.Response;
import net.socialhub.twitter.web.entity.request.SpecifiedTweetRequest;
import net.socialhub.twitter.web.entity.request.graphql.ScreenNameRequest;
import net.socialhub.twitter.web.entity.response.TopLevel;
import net.socialhub.twitter.web.entity.response.graphql.GraphRoot;

public interface UserResource {

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
     * Get single user from screen name.
     * 特定のユーザーをスクリーンネームから取得
     */
    Response<GraphRoot> getUserByScreenName(ScreenNameRequest request);

    /*
     * FIXME:
     * Get single user's followers.
     * 特定のユーザーのフォロワーを取得
     * Response<GraphRoot> getUserFollowers(UserIdRequest request);
     */
}
