package net.socialhub.twitter.web;

import net.socialhub.twitter.web.entity.Response;
import net.socialhub.twitter.web.entity.request.SpecifiedTweetRequest;
import net.socialhub.twitter.web.entity.request.graphql.ScreenNameRequest;
import net.socialhub.twitter.web.entity.request.graphql.UserIdRequest;
import net.socialhub.twitter.web.entity.response.graphql.GraphEntry;
import net.socialhub.twitter.web.entity.response.graphql.GraphRoot;
import net.socialhub.twitter.web.internal.UserResourceImpl;
import org.junit.Test;

public class GetUserTest extends AbstractTest {

    @Test
    public void testUsersLikedRetweetedBy() {
        TwitterWebClient client = new TwitterWebClient.Builder().build();
        SpecifiedTweetRequest request = new SpecifiedTweetRequest();
        request.setTweetId("1232157896453963776");

        client.user().getUsersLikedBy(request);
        client.user().getUsersRetweetedBy(request);
    }

    @Test
    public void testUserByScreenName() {
        TwitterWebClient client = new TwitterWebClient.Builder().build();
        ScreenNameRequest request = new ScreenNameRequest();
        request.setScreenName("uakihir0");

        Response<GraphRoot> root = client.user().getUserByScreenName(request);
        System.out.println(root.get().getData().getUser().getLegacy().getName());
    }

    @Test
    public void testUserFollowers() {
        TwitterWebClient client = new TwitterWebClient.Builder().build();
        UserIdRequest request = new UserIdRequest();
        request.setUserId("362220012");

        Response<GraphRoot> root = ((UserResourceImpl) client.user())
                .getUserFollowers(request);

        GraphEntry[] entries = root.get().getData().getUser().getFollowersTimeline()
                .getTimeline().getInstructions()[0].getEntries();

        for (GraphEntry entry : entries) {
            System.out.println(entry.getContent().getItemContent()
                    .getUser().getLegacy().getName());
        }
    }

}
