package net.socialhub.twitter.web;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.socialhub.twitter.web.entity.response.Tweet;
import net.socialhub.twitter.web.entity.response.User;
import net.socialhub.twitter.web.model.Secrets;
import org.junit.Before;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AbstractTest {

    protected Secrets secrets;

    protected Map<String, String> cookie;

    @Before
    public void before() {
        InputStream stream = getClass().getResourceAsStream("/secrets.json");

        if (stream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(stream);
            Stream<String> streamOfString = new BufferedReader(inputStreamReader).lines();
            String jsonString = streamOfString.collect(Collectors.joining());
            secrets = new Gson().fromJson(jsonString, Secrets.class);
        }

        try {
            String json = readFile("cookie.json");
            this.cookie = new Gson().fromJson(json,
                    new TypeToken<Map<String, String>>() {
                    }.getType());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String readFile(String fileName) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            StringBuilder b = new StringBuilder();

            String line;
            String ls = System.getProperty("line.separator");
            while ((line = br.readLine()) != null) {
                b.append(line);
                b.append(ls);
            }

            b.deleteCharAt(b.length() - 1);
            br.close();

            return b.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
