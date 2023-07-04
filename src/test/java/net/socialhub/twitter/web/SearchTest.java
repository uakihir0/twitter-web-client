package net.socialhub.twitter.web;

import net.socialhub.twitter.web.entity.request.GraphRequest;
import net.socialhub.twitter.web.entity.request.SearchRequest;
import net.socialhub.twitter.web.entity.request.timeline.SearchTimelineRequest;
import net.socialhub.twitter.web.entity.response.TopLevel;
import net.socialhub.twitter.web.entity.response.Tweet;
import net.socialhub.twitter.web.entity.response.User;
import net.socialhub.twitter.web.entity.response.graphql.GraphRoot;
import net.socialhub.twitter.web.entity.response.graphql.GraphTweet;
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
            List<GraphTweet> tweets = root.getTweets();

            tweets.forEach(this::printTweet);
            System.out.println(tweets.size());
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
