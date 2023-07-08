package net.socialhub.twitter.web;

import net.socialhub.logger.Logger;
import net.socialhub.twitter.web.entity.group.TweetTimeline;
import net.socialhub.twitter.web.entity.request.SpecifiedTweetRequest;
import net.socialhub.twitter.web.entity.request.timeline.HomeTimelineRequest;
import net.socialhub.twitter.web.entity.request.timeline.RecommendTimelineRequest;
import net.socialhub.twitter.web.entity.request.timeline.UserMediaTimelineRequest;
import net.socialhub.twitter.web.entity.request.timeline.UserTimelineRequest;
import net.socialhub.twitter.web.entity.response.Response;
import net.socialhub.twitter.web.entity.response.TopLevel;
import net.socialhub.twitter.web.entity.response.graphql.GraphRoot;
import org.junit.Test;

import java.util.List;

public class GetTweetTest extends AbstractTest {

    @Test
    public void testGetUserTimeline() {
        GraphRoot root = client.timeline().getUserTimeline(
                UserTimelineRequest.builder()
                        .userId("362220012")
                        .build()).get();

        print(root.getTweetTimeline());
    }

    @Test
    public void testGetUserMediaTimeline() {
        GraphRoot root = client.timeline().getUserMediaTimeline(
                UserMediaTimelineRequest.builder()
                        .userId("362220012")
                        .build()).get();

        print(root.getTweetTimeline());
    }

    @Test
    public void testGetUserMediaTimelineCursorTest() {
        String cursor;
        {
            GraphRoot root = client.timeline().getUserMediaTimeline(
                            UserMediaTimelineRequest.builder()
                                    .userId("362220012")
                                    .count(1)
                                    .build())
                    .get();

            TweetTimeline timeline = root.getTweetTimeline();
            print(timeline);

            cursor = timeline.getCursorBottom();
        }
        {
            GraphRoot root = client.timeline().getUserMediaTimeline(
                            UserMediaTimelineRequest.builder()
                                    .userId("362220012")
                                    .cursor(cursor)
                                    .count(1)
                                    .build())
                    .get();

            TweetTimeline timeline = root.getTweetTimeline();
            print(timeline);
        }
    }

    @Test
    public void testTweetConversation() {
        SpecifiedTweetRequest request = SpecifiedTweetRequest.builder()
                .tweetId("1272741649270165504")
                .build();

        TopLevel top = client.tweet().getTweetConversation(request).get();
        top.toTweetTimeline().forEach(this::print);
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

        print(root.get().getTweetTimeline());
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

        print(root.get().getTweetTimeline());
    }
}
