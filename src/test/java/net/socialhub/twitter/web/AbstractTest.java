package net.socialhub.twitter.web;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.socialhub.twitter.web.entity.group.TweetTimeline;
import net.socialhub.twitter.web.entity.response.Tweet;
import net.socialhub.twitter.web.entity.response.User;
import net.socialhub.twitter.web.entity.response.graphql.GraphTweetResult;
import net.socialhub.twitter.web.entity.response.graphql.GraphUserResult;
import net.socialhub.twitter.web.model.Secrets;
import org.junit.Before;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;

public class AbstractTest {

    protected Secrets secrets;

    protected Map<String, String> cookie;

    protected TwitterWebClient client;

    @Before
    public void before() {
        client = new TwitterWebClient.Builder().build();

        // 認証情報等の読み込み実行
        String json = readFile("secrets.json");
        if (json != null && !json.isEmpty()) {
            secrets = new Gson().fromJson(json, Secrets.class);
        }

        readCookie();
    }

    /**
     * Save Cookie to File
     */
    protected void saveCookie() {
        try {
            Map<String, String> cookie = client.getSession().getCookie().get();
            String json = new Gson().toJson(cookie);
            FileWriter fw = new FileWriter("cookie.json");
            fw.write(json);
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Read Cookie from File
     */
    protected void readCookie() {
        try {
            String json = readFile("cookie.json");
            this.cookie = new Gson().fromJson(json,
                    new TypeToken<Map<String, String>>() {
                    }.getType());

            this.client.getSession().getCookie()
                    .get().putAll(this.cookie);

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
            return null;
        }
    }


    public void print(TweetTimeline timeline) {
        timeline.getTweet().forEach(this::print);

        System.out.println("[Cursor] -----------------------------------");
        System.out.println("Top    : " + timeline.getCursorTop());
        System.out.println("Bottom : " + timeline.getCursorBottom());
        System.out.println();
    }

    public void print(GraphTweetResult tweet) {
        System.out.println("[Tweet] -----------------------------------");
        System.out.println("ID   : " + tweet.getId());
        System.out.println("TEXT : " + tweet.getLegacy().getFullText());
        System.out.println();
    }

    public void print(GraphUserResult user) {
        System.out.println("[User] ------------------------------------");
        System.out.println("ID   : " + user.getId());
        System.out.println("NAME : " + user.getLegacy().getName());
        System.out.println();
    }
}
