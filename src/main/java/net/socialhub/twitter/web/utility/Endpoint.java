package net.socialhub.twitter.web.utility;

public enum Endpoint {

    UserTimeline("/2/timeline/profile/{userId}.json"),

    UserTweetLiked("/2/timeline/liked_by.json"),

    UserTweetRetweeted("/2/timeline/retweeted_by.json"),

    UserMediaTimeline("/2/timeline/media/{userId}.json"),

    TweetConversation("/2/timeline/conversation/{tweetId}.json"),

    ;

    private String path;

    Endpoint(String path) {
        this.path = path;
    }

    public String path() {
        return path;
    }
}
