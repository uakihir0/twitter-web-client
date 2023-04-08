package net.socialhub.twitter.web;

import net.socialhub.twitter.web.entity.request.LoginRequest;
import org.junit.Test;

public class LoginTest {

    @Test
    public void testLogin(){
        TwitterWebClient client = new TwitterWebClient.Builder().build();
        LoginRequest request = LoginRequest.builder()
                .username("").build();
        client.login().login(request);
    }
}
