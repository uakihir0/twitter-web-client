package net.socialhub.twitter.web;

import net.socialhub.twitter.web.entity.request.SpecifiedTweetRequest;
import net.socialhub.twitter.web.entity.request.UserTimelineRequest;
import org.junit.Test;

public class GetTimelineTest extends AbstractTest {

    @Test
    public void testGetUserTimeline() {
        TwitterWebClient client = new TwitterWebClient.Builder().build();
        UserTimelineRequest request = new UserTimelineRequest();
        request.setUserId("362220012");

        client.timeline()
                .getUserTimeline(request).get()
                .getGlobalObjects()
                .getTweets()
                .forEach((k, v) -> {

                    System.out.println("// ------------------------------------ //");
                    System.out.println("ID  : " + v.getId());
                    System.out.println("TEXT: " + v.getFullText());
                });
    }

    @Test
    public void testGetUserMediaTimeline() {
        TwitterWebClient client = new TwitterWebClient.Builder().build();
        UserTimelineRequest request = new UserTimelineRequest();
        request.setUserId("362220012");

        client.timeline()
                .getUserMediaTimeline(request).get()
                .getGlobalObjects()
                .getTweets()
                .forEach((k, v) -> {

                    System.out.println("// ------------------------------------ //");
                    System.out.println("ID  : " + v.getId());
                    System.out.println("TEXT: " + v.getFullText());
                });
    }

    @Test
    public void testUsersLikedRetweetedBy() {
        TwitterWebClient client = new TwitterWebClient.Builder().build();
        SpecifiedTweetRequest request = new SpecifiedTweetRequest();
        request.setTweetId("1232157896453963776");

        client.timeline().getUsersLikedBy(request);
        client.timeline().getUsersRetweetedBy(request);
    }

    @Test
    public void testTweetConversation() {
        TwitterWebClient client = new TwitterWebClient.Builder().build();
        SpecifiedTweetRequest request = new SpecifiedTweetRequest();
        request.setTweetId("1272741649270165504");

        client.timeline().getTweetConversation(request);
    }
}
