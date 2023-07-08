package net.socialhub.twitter.web;

import net.socialhub.twitter.web.entity.group.TweetTimeline;
import net.socialhub.twitter.web.entity.request.timeline.SearchTimelineRequest;
import net.socialhub.twitter.web.entity.response.graphql.GraphRoot;
import org.junit.Test;

import java.util.List;

public class SearchTest extends AbstractTest {

    @Test
    public void testSearchTweets() {
        SearchTimelineRequest request = SearchTimelineRequest
                .builder()
                .rawQuery("イラスト")
                .build();

        {
            GraphRoot root = client.search().searchTweets(request).get();
            print(root.getTweetTimeline());
        }
    }

    @Test
    public void testSearchUsers() {
        SearchTimelineRequest request = SearchTimelineRequest
                .builder()
                .rawQuery("イラスト")
                .build();

        {
            GraphRoot root = client.search().searchTweets(request).get();
            // List<User> users = root.getUsers();
            // users.forEach(this::printUser);
            // System.out.println(users.size());
        }
    }
}
