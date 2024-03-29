package net.socialhub.twitter.web.api;

import net.socialhub.twitter.web.entity.request.timeline.UserMediaTimelineRequest;
import net.socialhub.twitter.web.entity.response.Response;
import net.socialhub.twitter.web.entity.request.timeline.HomeTimelineRequest;
import net.socialhub.twitter.web.entity.request.timeline.RecommendTimelineRequest;
import net.socialhub.twitter.web.entity.request.timeline.UserTimelineRequest;
import net.socialhub.twitter.web.entity.response.TopLevel;
import net.socialhub.twitter.web.entity.response.graphql.GraphRoot;

public interface TimelineResource {

    /**
     * Get User's Timeline
     * (Only for public users)
     * 特定ユーザーのツイートを取得
     */
    Response<GraphRoot> getUserTimeline(UserTimelineRequest request);

    /**
     * Get User's Media Timeline
     * (Only for public users)
     * 特定ユーザーのメディアを取得
     */
    Response<GraphRoot> getUserMediaTimeline(UserMediaTimelineRequest request);


    /**
     * Get User's HomeTimeline
     * ユーザーのタイムラインを取得
     */
    Response<GraphRoot> getHomeTimeline(HomeTimelineRequest request);

    /**
     * Get User's RecommendTimeline
     * ユーザーのおすすめタイムラインを取得
     */
    Response<GraphRoot> getRecommendTimeline(RecommendTimelineRequest request);
}
