package net.socialhub.twitter.web.api;

import net.socialhub.twitter.web.entity.Response;
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
     * Get User's Media Timeline
     * (Only for public users)
     * 特定ユーザーのメディアを取得
     */
    Response<TopLevel> getUserMediaTimeline(UserTimelineRequest request);
}
