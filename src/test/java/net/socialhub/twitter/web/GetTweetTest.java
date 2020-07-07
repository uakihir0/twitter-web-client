package net.socialhub.twitter.web;

import net.socialhub.twitter.web.entity.request.SpecifiedTweetRequest;
import net.socialhub.twitter.web.entity.request.UserTimelineRequest;
import net.socialhub.twitter.web.entity.response.TopLevel;
import org.junit.Test;

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
            request.setCursor(top.getTBottomCursor());
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

        client.timeline().getTweetConversation(request);
    }
}
