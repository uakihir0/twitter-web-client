package net.socialhub.twitter.web.api;

import net.socialhub.twitter.web.entity.Response;
import net.socialhub.twitter.web.entity.request.UserTimelineRequest;
import net.socialhub.twitter.web.entity.request.SpecifiedTweetRequest;
import net.socialhub.twitter.web.entity.response.TopLevel;

public interface TimelineResource {

    /**
     * Get User's Timeline
     * (Only for public users)
     */
    Response<TopLevel> getUserTimeline(UserTimelineRequest request);

    /**
     * Get Users who liked specified tweet.
     */
    Response<TopLevel> getUsersLikedBy(SpecifiedTweetRequest request);

    /**
     * Get Users who retweeted specified tweet.
     */
    Response<TopLevel> getUsersRetweetedBy(SpecifiedTweetRequest request);
}
