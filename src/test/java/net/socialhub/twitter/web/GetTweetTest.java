package net.socialhub.twitter.web;

import net.socialhub.logger.Logger;
import net.socialhub.twitter.web.entity.response.Response;
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

        TopLevel top = client.timeline().getUserTimeline(
                UserTimelineRequest.builder()
                        .userId("362220012")
                        .build()).get();
        top.toTweetTimeline().forEach(this::printTweet);
    }

    @Test
    public void testGetUserMediaTimeline() {
        TwitterWebClient client = new TwitterWebClient.Builder().build();

        TopLevel top = client.timeline().getUserMediaTimeline(
                UserTimelineRequest.builder()
                        .userId("362220012")
                        .build()).get();
        top.toTweetTimeline().forEach(this::printTweet);
    }

    @Test
    public void testGetUserMediaTimelineCursorTest() {
        TwitterWebClient client = new TwitterWebClient.Builder().build();
        String cursor;
        {
            TopLevel top = client.timeline().getUserMediaTimeline(
                            UserTimelineRequest.builder()
                                    .userId("362220012")
                                    .count(1)
                                    .build())
                    .get();
            top.toTweetTimeline().forEach(this::printTweet);
            cursor = top.getBottomCursor();
        }
        {
            TopLevel top = client.timeline().getUserMediaTimeline(
                            UserTimelineRequest.builder()
                                    .userId("362220012")
                                    .cursor(cursor)
                                    .count(1)
                                    .build())
                    .get();
            top.toTweetTimeline().forEach(this::printTweet);
        }
    }

    @Test
    public void testTweetConversation() {
        TwitterWebClient client = new TwitterWebClient.Builder().build();
        SpecifiedTweetRequest request = SpecifiedTweetRequest.builder()
                .tweetId("1272741649270165504")
                .build();

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
