package net.socialhub.twitter.web;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.socialhub.twitter.web.entity.request.LoginRequest;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class LoginTest extends AbstractTest {

    @Test
    public void testLogin() {
        TwitterWebClient client = new TwitterWebClient.Builder().build();
        LoginRequest request = LoginRequest.builder()
                .username(secrets.getUsername())
                .password(secrets.getPassword())
                .build();
        client.login().login(request);

        Map<String, String> cookie = client.getSession().getCookie().get();

        // cookie を json にしてファイルとして保存
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(cookie);

        try {
            FileWriter file = new FileWriter("cookie.json");
            PrintWriter pw = new PrintWriter(new BufferedWriter(file));
            pw.println(json);
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
