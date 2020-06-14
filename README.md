<img src="./resource/img/twitterwebclient.png" width="400">

---

[![](https://jitpack.io/v/uakihir0/twitter-web-client.svg)](https://jitpack.io/#uakihir0/twitter-web-client)

Twitter Web Client is client library to call twitter web api to written in java. 
This will be able to compile with [google/j2objc] to Objective-C library. (iOS, Mac OS)
This library created with the help of [Nitter](https://github.com/zedeus/nitter). Thanks.

## Features

* No need Consumer Key/Secret.
* Many fields are accessible.
* Can access various APIs.
* Easy to use.

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
(This library can access resources only no authentication required.)


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