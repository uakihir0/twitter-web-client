package net.socialhub.twitter.web;

import net.socialhub.twitter.web.utility.Config;
import net.socialhub.twitter.web.utility.GuestToken;
import net.socialhub.twitter.web.utility.Session;
import org.junit.Test;

public class GetGuestTokenTest extends AbstractTest {

    @Test
    public void testGetToken() {
        Config config = new Config();
        Session session = new Session(config);
        System.out.println((new GuestToken(session)).get());
    }
}
