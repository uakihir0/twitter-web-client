package net.socialhub.twitter.web;

import net.socialhub.twitter.web.entity.request.LoginRequest;
import org.junit.Test;

public class LoginTest extends AbstractTest {

    @Test
    public void testLogin() {
        TwitterWebClient client = new TwitterWebClient.Builder().build();
        LoginRequest request = LoginRequest.builder()
                .username(secrets.getUsername())
                .build();
        client.login().login(request);
    }
}
