package net.socialhub.twitter.web.utility;

public enum Endpoint {

    // region v1.1
    Activate("/1.1/guest/activate.json"),
    Onboarding("/1.1/onboarding/task.json"),
    CreateFriendships("/1.1/friendships/create.json"),
    DestroyFriendships("/1.1/friendships/destroy.json"),
    // endregion

    // region v2
    UserTweetLiked("/2/timeline/liked_by.json"),
    UserTweetRetweeted("/2/timeline/retweeted_by.json"),
    Mention("/2/notifications/mentions.json"),
    // endregion

    // region GraphQL
    UserByScreenName("/graphql/E4iSsd6gypGFWx2eUhSC1g/UserByScreenName"),
    UsersFollowing("/graphql/b22I8WSfQ8H4Ev8486xAlQ/Following"),
    UsersFollowers("/graphql/5HZiSi1hMNgxX8NZU_05xg/Followers"),
    CreateTweet("/graphql/XyvN0Wv13eeu_gVIHDi10g/CreateTweet"),
    FavoriteTweet("/graphql/lI07N6Otwv1PhnEgXILM7A/FavoriteTweet"),
    UnfavoriteTweet("/graphql/ZYKSe-w7KEslx3JhSIk5LA/UnfavoriteTweet"),
    CreateRetweet("/graphql/ojPdsZsimiJrUGLR1sjUtA/CreateRetweet"),
    DeleteRetweet("/graphql/iQtK4dl5hBmXewYZuEOKVw/DeleteRetweet"),
    HomeTimeline("/graphql/ILPEegjZTQ_3mOUc7pWCpA/HomeTimeline"),
    HomeLatestTimeline("/graphql/37RUvMgTiEVYYfrRTVDxpw/HomeLatestTimeline"),
    SearchTimeline("/graphql/nK1dw4oV3k4w5TdtcAdSww/SearchTimeline"),
    UserTimeline("/graphql/rIIwMe1ObkGh_ByBtTCtRQ/UserTweets"),
    UserMediaTimeline("/graphql/Az0-KW6F-FyYTc2OJmvUhg/UserMedia"),
    TweetDetail("/graphql/TuC3CinYecrqAyqccUyFhw/TweetDetail"),
    Bookmarks("/graphql/ThwoU-Q6_9oZHwxtWdpoPw/Bookmarks"),

    // Deleted Endpoints
    // UserTimeline("/2/timeline/profile/{userId}.json"),
    // UserMediaTimeline("/2/timeline/media/{userId}.json"),
    TweetConversation("/2/timeline/conversation/{tweetId}.json"),
    // Search("/2/search/adaptive.json"),

    // endregion

    ;

    private final String path;

    Endpoint(String path) {
        this.path = path;
    }

    public String path() {
        return path;
    }
}
