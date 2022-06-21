package net.socialhub.twitter.web;

import net.socialhub.twitter.web.entity.request.SearchRequest;
import net.socialhub.twitter.web.entity.response.TopLevel;
import net.socialhub.twitter.web.entity.response.Tweet;
import net.socialhub.twitter.web.entity.response.User;
import org.junit.Test;

import java.util.List;

public class SearchTest extends AbstractTest {

    @Test
    public void testSearchTweets() {
        TwitterWebClient client = new TwitterWebClient.Builder().build();
        SearchRequest request = new SearchRequest();
        request.setQuery("イラスト");

        {
            TopLevel top = client.search().searchTweets(request).get();
            List<Tweet> tweets = top.toSearchTweetsTimeline();

            tweets.forEach(this::printTweet);
            System.out.println(tweets.size());
        }
    }

    @Test
    public void testSearchUsers() {
        TwitterWebClient client = new TwitterWebClient.Builder().build();
        SearchRequest request = new SearchRequest();
        request.setQuery("イラスト");

        {
            TopLevel top = client.search().searchUsers(request).get();
            List<User> users = top.toUserTimeline();

            users.forEach(this::printUser);
            System.out.println(users.size());
        }
    }
}
