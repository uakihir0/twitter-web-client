# Bookmark Tweets Sample

```json
{
  "data": {
    "bookmark_timeline_v2": {
      "timeline": {
        "instructions": [
          {
            "type": "TimelineAddEntries",
            "entries": [
              {
                "entryId": "tweet-1646550184946700294",
                "sortIndex": "1763127243521204927",
                "content": {
                  "entryType": "TimelineTimelineItem",
                  "__typename": "TimelineTimelineItem",
                  "itemContent": {
                    "itemType": "TimelineTweet",
                    "__typename": "TimelineTweet",
                    "tweet_results": {
                      "result": {
                        "__typename": "Tweet",
                        "rest_id": "1646550184946700294",
                        "core": {
                          "user_results": {
                            "result": {
                              "__typename": "User",
                              "id": "VXNlcjo0NDE5NjM5Nw==",
                              "rest_id": "44196397",
                              "affiliates_highlighted_label": {
                                "label": {
                                  "url": {
                                    "url": "https://twitter.com/Twitter",
                                    "urlType": "DeepLink"
                                  },
                                  "badge": {
                                    "url": "https://pbs.twimg.com/profile_images/1488548719062654976/u6qfBBkF_bigger.jpg"
                                  },
                                  "description": "Twitter",
                                  "userLabelType": "BusinessLabel",
                                  "userLabelDisplayType": "Badge"
                                }
                              },
                              "has_graduated_access": true,
                              "is_blue_verified": true,
                              "legacy": {
                                "can_dm": false,
                                "can_media_tag": false,
                                "created_at": "Tue Jun 02 20:12:29 +0000 2009",
                                "default_profile": false,
                                "default_profile_image": false,
                                "description": "nothing",
                                "entities": {
                                  "description": {
                                    "urls": []
                                  }
                                },
                                "fast_followers_count": 0,
                                "favourites_count": 20913,
                                "followers_count": 134834263,
                                "friends_count": 196,
                                "has_custom_timelines": true,
                                "is_translator": false,
                                "listed_count": 120196,
                                "location": "A Shortfall of Gravitas",
                                "media_count": 1495,
                                "name": "Elon Musk",
                                "normal_followers_count": 134834263,
                                "pinned_tweet_ids_str": [],
                                "possibly_sensitive": false,
                                "profile_banner_url": "https://pbs.twimg.com/profile_banners/44196397/1576183471",
                                "profile_image_url_https": "https://pbs.twimg.com/profile_images/1590968738358079488/IY9Gx6Ok_normal.jpg",
                                "profile_interstitial_type": "",
                                "screen_name": "elonmusk",
                                "statuses_count": 24588,
                                "translator_type": "none",
                                "verified": false,
                                "want_retweets": false,
                                "withheld_in_countries": []
                              },
                              "super_follow_eligible": true
                            }
                          }
                        },
                        "unmention_data": {},
                        "edit_control": {
                          "edit_tweet_ids": [
                            "1646550184946700294"
                          ],
                          "editable_until_msecs": "1681404930000",
                          "is_edit_eligible": true,
                          "edits_remaining": "5"
                        },
                        "edit_perspective": {
                          "favorited": false,
                          "retweeted": false
                        },
                        "is_translatable": true,
                        "views": {
                          "count": "11419231",
                          "state": "EnabledWithCount"
                        },
                        "source": "<a href=\"http://twitter.com/download/iphone\" rel=\"nofollow\">Twitter for iPhone</a>",
                        "legacy": {
                          "bookmark_count": 678,
                          "bookmarked": true,
                          "created_at": "Thu Apr 13 16:25:30 +0000 2023",
                          "conversation_id_str": "1646550184946700294",
                          "display_text_range": [
                            0,
                            61
                          ],
                          "entities": {
                            "user_mentions": [],
                            "urls": [],
                            "hashtags": [],
                            "symbols": []
                          },
                          "favorite_count": 84887,
                          "favorited": false,
                          "full_text": "Turning AI-designed fashion into real clothing would be great",
                          "is_quote_status": false,
                          "lang": "en",
                          "quote_count": 1005,
                          "reply_count": 8749,
                          "retweet_count": 7337,
                          "retweeted": false,
                          "user_id_str": "44196397",
                          "id_str": "1646550184946700294"
                        }
                      }
                    },
                    "tweetDisplayType": "Tweet"
                  }
                }
              },
              {
                "entryId": "cursor-top-1763127243521204928",
                "sortIndex": "1763127243521204928",
                "content": {
                  "entryType": "TimelineTimelineCursor",
                  "__typename": "TimelineTimelineCursor",
                  "value": "HCb+iqm+3rjx9zAAAA==",
                  "cursorType": "Top"
                }
              },
              {
                "entryId": "cursor-bottom-1763127243521204926",
                "sortIndex": "1763127243521204926",
                "content": {
                  "entryType": "TimelineTimelineCursor",
                  "__typename": "TimelineTimelineCursor",
                  "value": "HBb+iqm+3rjx9zAAAA==",
                  "cursorType": "Bottom",
                  "stopOnEmptyResponse": true
                }
              }
            ]
          }
        ],
        "responseObjects": {
          "feedbackActions": [],
          "immediateReactions": []
        }
      }
    }
  }
}
```