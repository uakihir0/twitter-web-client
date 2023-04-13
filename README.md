<img src="./resource/img/twitterwebclient.png" width="400">

---

[![](https://jitpack.io/v/uakihir0/twitter-web-client.svg)](https://jitpack.io/#uakihir0/twitter-web-client)

Twitter Web Client is client library to call twitter web api to written in java. 
This will be able to compile with [google/j2objc] to Objective-C library. (iOS, Mac OS)
This library created with the help of [Nitter](https://github.com/zedeus/nitter). Thanks.

## Features

* No Consumer Key/Secret required.
* Access to a variety of data.
* Various APIs available.
* Easy to use.

### APIs

#### V1

- [x] /1.1/guest/activate.json
- [x] /1.1/onboarding/task.json
- [ ] /1.1/friendships/create.json
- [ ] /1.1/friendships/destroy.json

#### V2

- [x] /2/timeline/profile/{userId}.json
- [x] /2/timeline/liked_by.json
- [x] /2/timeline/retweeted_by.json
- [x] /2/timeline/media/{userId}.json
- [x] /2/timeline/conversation/{tweetId}.json
- [x] /2/search/adaptive.json

#### GraphQL

- [ ] /graphql/{queryId}/UserByScreenName
- [ ] /graphql/{queryId}/Followers
- [x] /graphql/{queryId}/CreateTweet
- [x] /graphql/{queryId}/FavoriteTweet
- [x] /graphql/{queryId}/UnfavoriteTweet
- [x] /graphql/{queryId}/CreateRetweet
- [x] /graphql/{queryId}/DeleteRetweet
- [x] /graphql/{queryId}/HomeLatestTimeline

## Install

You can install via JitPack with gradle. Add the JitPack repository to your build file.

```
allprojects {
    repositories {
        ...
	    maven { url 'https://jitpack.io' }
    }
}
```

And add the dependency as bellow.

```
dependencies {
    implementation 'com.github.uakihir0:twitter-web-client:{{version}}'
}
```


## How To Use

**Twitter Web Client needs NO Twitter Consumer Key and Secret.**
You can access Twitter resources just only use this client library, as bellow.

### Access to PublicData

```java
// Get tweets from specified user.

TwitterWebClient client = new TwitterWebClient.Builder().build();
UserTimelineRequest request = new UserTimelineRequest();
request.setUserId("USER_ID");

client.timeline().getUserTimeline(request);
```

```java
// Get users who liked or retweeted specified tweet.

TwitterWebClient client = new TwitterWebClient.Builder().build();
SpecifiedTweetRequest request = new SpecifiedTweetRequest();
request.setTweetId("TWEET_ID");

client.timeline().getUsersLikedBy(request);
client.timeline().getUsersRetweetedBy(request);
```

## License
This software is released under the MIT License, see LICENSE.txt.

## Author
[@uakihir0](https://twitter.com/uakihir0)


  [google/j2objc]: https://github.com/google/j2objc