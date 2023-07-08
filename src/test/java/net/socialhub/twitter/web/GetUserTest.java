package net.socialhub.twitter.web;

import net.socialhub.twitter.web.entity.response.Response;
import net.socialhub.twitter.web.entity.request.SpecifiedTweetRequest;
import net.socialhub.twitter.web.entity.request.ScreenNameRequest;
import net.socialhub.twitter.web.entity.request.UserIdRequest;
import net.socialhub.twitter.web.entity.response.TopLevel;
import net.socialhub.twitter.web.entity.response.graphql.GraphEntry;
import net.socialhub.twitter.web.entity.response.graphql.GraphRoot;
import net.socialhub.twitter.web.internal.UserResourceImpl;
import org.junit.Test;

public class GetUserTest extends AbstractTest {

    @Test
    public void testUsersLikedRetweetedBy() {
        TwitterWebClient client = new TwitterWebClient.Builder().build();
        {
            TopLevel top = client.user().getUsersLikedBy(
                    SpecifiedTweetRequest.builder()
                            .tweetId("1232157896453963776")
                            .build()).get();
            top.toUserTimeline().forEach(this::print);
        }
        {
            TopLevel top = client.user().getUsersRetweetedBy(
                    SpecifiedTweetRequest.builder()
                            .tweetId("1232157896453963776")
                            .build()).get();
            top.toUserTimeline().forEach(this::print);
        }
    }

    @Test
    public void testUserByScreenName() {
        TwitterWebClient client = new TwitterWebClient.Builder().build();
        ScreenNameRequest request = ScreenNameRequest.builder()
                .screenName("uakihir0")
                .build();

        Response<GraphRoot> root = client.user().getUserByScreenName(request);
        print(root.get().getData().getUser().getLegacy());
    }

    @Test
    public void testUserFollowers() {
        TwitterWebClient client = new TwitterWebClient.Builder().build();
        UserIdRequest request = UserIdRequest.builder()
                .userId("362220012")
                .build();

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
