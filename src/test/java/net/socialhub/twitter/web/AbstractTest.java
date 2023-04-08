package net.socialhub.twitter.web;

import com.google.gson.Gson;
import net.socialhub.twitter.web.entity.response.Tweet;
import net.socialhub.twitter.web.entity.response.User;
import net.socialhub.twitter.web.model.Secrets;
import org.junit.Before;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AbstractTest {

    protected Secrets secrets;

    @Before
    public void before() {
        InputStream stream = getClass().getResourceAsStream("/secrets.json");

        if (stream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(stream);
            Stream<String> streamOfString = new BufferedReader(inputStreamReader).lines();
            String jsonString = streamOfString.collect(Collectors.joining());
            secrets = new Gson().fromJson(jsonString, Secrets.class);
        }
    }

    public void printTweet(Tweet tweet) {

        System.out.println("------------------------------------");
        System.out.println("ID   : " + tweet.getId());
        System.out.println("TEXT : " + tweet.getFullText());
    }

    public void printUser(User user) {

        System.out.println("------------------------------------");
        System.out.println("ID   : " + user.getId());
        System.out.println("NAME : " + user.getName());
    }
}
