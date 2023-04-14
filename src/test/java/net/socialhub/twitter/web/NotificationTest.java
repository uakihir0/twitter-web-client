package net.socialhub.twitter.web;

import net.socialhub.twitter.web.entity.request.notification.GetMentionRequest;
import net.socialhub.twitter.web.entity.response.Response;
import net.socialhub.twitter.web.entity.response.TopLevel;
import org.junit.Test;

public class NotificationTest extends AbstractTest {

    @Test
    public void testGetMention() {

        Response<TopLevel> response = client.notification()
                .getMention(GetMentionRequest
                        .builder()
                        .build());

        response.get().toMentionTweetsTimeline()
                .forEach(this::printTweet);
    }
}
