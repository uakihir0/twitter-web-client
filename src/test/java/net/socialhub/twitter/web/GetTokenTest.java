package net.socialhub.twitter.web;

import net.socialhub.twitter.web.utility.Const;
import net.socialhub.twitter.web.utility.Token;
import org.junit.Test;

public class GetTokenTest extends AbstractTest {

    @Test
    public void testGetToken() {
        System.out.println(Token.with(Const.DefaultWebUrl).get());
    }
}
