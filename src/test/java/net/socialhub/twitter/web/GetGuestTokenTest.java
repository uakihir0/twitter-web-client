package net.socialhub.twitter.web;

import net.socialhub.twitter.web.utility.Const;
import net.socialhub.twitter.web.utility.GuestToken;
import org.junit.Test;

public class GetGuestTokenTest extends AbstractTest {

    @Test
    public void testGetToken() {
        System.out.println(GuestToken.with(Const.DefaultWebUrl).get());
    }
}
