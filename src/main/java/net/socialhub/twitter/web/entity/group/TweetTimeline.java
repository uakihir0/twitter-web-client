package net.socialhub.twitter.web.entity.group;

import net.socialhub.twitter.web.entity.response.Tweet;
import net.socialhub.twitter.web.entity.response.User;
import net.socialhub.twitter.web.entity.response.graphql.GraphTweet;
import net.socialhub.twitter.web.entity.response.graphql.GraphUser;

import java.util.List;
import java.util.Map;

public class TweetTimeline {

    public List<Tweet> tweet;

    public Map<String, User> user;

    public String cursorTop;
    public String cursorBottom;

    // region
    public List<Tweet> getTweet() {
        return tweet;
    }

    public void setTweet(List<Tweet> tweet) {
        this.tweet = tweet;
    }

    public Map<String, User> getUser() {
        return user;
    }

    public void setUser(Map<String, User> user) {
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
