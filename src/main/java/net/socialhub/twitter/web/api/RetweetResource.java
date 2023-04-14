package net.socialhub.twitter.web.api;

import net.socialhub.twitter.web.entity.response.Response;
import net.socialhub.twitter.web.entity.request.retweet.CreateRetweetRequest;
import net.socialhub.twitter.web.entity.request.retweet.DeleteRetweetRequest;
import net.socialhub.twitter.web.entity.response.graphql.GraphRoot;

public interface RetweetResource {

    /**
     * Create Retweet
     * リツイートを作成
     */
    Response<GraphRoot> createRetweet(CreateRetweetRequest request);

    /**
     * Delete Retweet
     * リツイートを解除
     */
    Response<GraphRoot> deleteRetweet(DeleteRetweetRequest request);
}
