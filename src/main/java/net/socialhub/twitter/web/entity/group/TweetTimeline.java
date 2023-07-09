package net.socialhub.twitter.web.entity.group;

import net.socialhub.twitter.web.entity.response.Tweet;
import net.socialhub.twitter.web.entity.response.User;
import net.socialhub.twitter.web.entity.response.graphql.GraphTweet;
import net.socialhub.twitter.web.entity.response.graphql.GraphTweetResult;
import net.socialhub.twitter.web.entity.response.graphql.GraphUser;
import net.socialhub.twitter.web.entity.response.graphql.GraphUserResult;

import java.util.List;
import java.util.Map;

public class TweetTimeline {

    public List<GraphTweetResult> tweet;

    public Map<String, GraphUserResult> user;

    public String cursorTop;
    public String cursorBottom;

    // region
    public List<GraphTweetResult> getTweet() {
        return tweet;
    }

    public void setTweet(List<GraphTweetResult> tweet) {
        this.tweet = tweet;
    }

    public Map<String, GraphUserResult> getUser() {
        return user;
    }

    public void setUser(Map<String, GraphUserResult> user) {
        this.user = user;
    }

    public String getCursorTop() {
        return cursorTop;
    }

    public void setCursorTop(String cursorTop) {
        this.cursorTop = cursorTop;
    }

    public String getCursorBottom() {
        return cursorBottom;
    }

    public void setCursorBottom(String cursorBottom) {
        this.cursorBottom = cursorBottom;
    }
    // endregion
}
