package net.socialhub.twitter.web.entity.group;

import net.socialhub.twitter.web.entity.response.graphql.GraphTweetResult;
import net.socialhub.twitter.web.entity.response.graphql.GraphUserResult;

import java.util.List;
import java.util.Map;

public class TweetDetail {

    public GraphTweetResult tweet;

    public List<GraphTweetResult> conversation;

    public Map<String, GraphUserResult> user;

    // region
    public GraphTweetResult getTweet() {
        return tweet;
    }

    public void setTweet(GraphTweetResult tweet) {
        this.tweet = tweet;
    }

    public List<GraphTweetResult> getConversation() {
        return conversation;
    }

    public void setConversation(List<GraphTweetResult> conversation) {
        this.conversation = conversation;
    }

    public Map<String, GraphUserResult> getUser() {
        return user;
    }

    public void setUser(Map<String, GraphUserResult> user) {
        this.user = user;
    }
    // endregion
}
