package net.socialhub.twitter.web;

import net.socialhub.twitter.web.entity.response.Tweet;
import net.socialhub.twitter.web.entity.response.User;
import org.junit.Before;

public class AbstractTest {

    @Before
    public void before() {
    }

    public void printTweet(Tweet tweet) {

        System.out.println("// ------------------------------------ //");
        System.out.println("ID   : " + tweet.getId());
        System.out.println("TEXT : " + tweet.getFullText());
    }

    public void printUser(User user) {

        System.out.println("// ------------------------------------ //");
        System.out.println("ID   : " + user.getId());
        System.out.println("NAME : " + user.getName());
    }
}
