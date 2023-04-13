package net.socialhub.twitter.web;

import net.socialhub.logger.Logger;
import net.socialhub.twitter.web.entity.Response;
import net.socialhub.twitter.web.entity.request.SpecifiedTweetRequest;
import net.socialhub.twitter.web.entity.request.timeline.HomeTimelineRequest;
import net.socialhub.twitter.web.entity.request.timeline.RecommendTimelineRequest;
import net.socialhub.twitter.web.entity.request.timeline.UserTimelineRequest;
import net.socialhub.twitter.web.entity.response.TopLevel;
import net.socialhub.twitter.web.entity.response.graphql.GraphRoot;
import net.socialhub.twitter.web.entity.response.graphql.GraphTweet;
import org.junit.Test;

import java.util.List;

public class GetTweetTest extends AbstractTest {

    @Test
    public void testGetUserTimeline() {
        TwitterWebClient client = new TwitterWebClient.Builder().build();
        UserTimelineRequest request = new UserTimelineRequest();
        request.setUserId("362220012");

        TopLevel top = client.timeline().getUserTimeline(request).get();
        top.toTweetTimeline().forEach(this::printTweet);
    }

    @Test
    public void testGetUserMediaTimeline() {
        TwitterWebClient client = new TwitterWebClient.Builder().build();
        UserTimelineRequest request = new UserTimelineRequest();
        request.setUserId("362220012");

        TopLevel top = client.timeline().getUserMediaTimeline(request).get();
        top.toTweetTimeline().forEach(this::printTweet);
    }

    @Test
    public void testGetUserMediaTimelineCursorTest() {
        TwitterWebClient client = new TwitterWebClient.Builder().build();
        UserTimelineRequest request = new UserTimelineRequest();
        request.setUserId("362220012");
        request.setCount(1);
        {
            TopLevel top = client.timeline().getUserMediaTimeline(request).get();
            top.toTweetTimeline().forEach(this::printTweet);
            request.setCursor(top.getBottomCursor());
        }
        {
            TopLevel top = client.timeline().getUserMediaTimeline(request).get();
            top.toTweetTimeline().forEach(this::printTweet);
        }
    }

    @Test
    public void testTweetConversation() {
        TwitterWebClient client = new TwitterWebClient.Builder().build();
        SpecifiedTweetRequest request = new SpecifiedTweetRequest();
        request.setTweetId("1272741649270165504");

        TopLevel top = client.tweet().getTweetConversation(request).get();
        top.toTweetTimeline().forEach(this::printTweet);
    }

    @Test
    public void testHomeTimeline() {
        Logger.getLogger(null).setLogLevel(Logger.LogLevel.WARN);

        Response<GraphRoot> root =
                client.timeline().getHomeTimeline(
                        HomeTimelineRequest.builder()
                                .count(10)
                                .build()
                );

        List<GraphTweet> tweets = root.get().getTweets();
        tweets.forEach(this::printTweet);
    }

    @Test
    public void testRecommendTimeline() {
        Logger.getLogger(null).setLogLevel(Logger.LogLevel.WARN);

        Response<GraphRoot> root =
                client.timeline().getRecommendTimeline(
                        RecommendTimelineRequest.builder()
                                .count(10)
                                .build()
                );

        List<GraphTweet> tweets = root.get().getTweets();
        tweets.forEach(this::printTweet);
    }
}
