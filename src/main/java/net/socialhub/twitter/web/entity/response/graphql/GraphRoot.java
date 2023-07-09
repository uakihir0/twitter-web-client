package net.socialhub.twitter.web.entity.response.graphql;

import com.google.gson.annotations.SerializedName;
import net.socialhub.twitter.web.entity.group.TweetTimeline;
import net.socialhub.twitter.web.entity.other.InstructionType;
import net.socialhub.twitter.web.entity.response.Tweet;
import net.socialhub.twitter.web.entity.response.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class GraphRoot {

    @SerializedName("data")
    private GraphData data;

    public TweetTimeline getTweetTimeline() {
        GraphInstruction[] instructions = null;

        // For HomeTimelines
        if (data.getHome() != null) {
            instructions = data.getHome()
                    .getHomeTimelineUrt()
                    .getInstructions();
        }

        // For BookmarkTimeline
        if (data.getBookmark() != null) {
            instructions = data.getBookmark()
                    .getTimeline()
                    .getInstructions();
        }

        // For SearchTimeline
        if (data.getSearch() != null) {
            instructions = data.getSearch()
                    .getSearchTimeline()
                    .getTimeline()
                    .getInstructions();
        }

        // For UserTimeline
        // For UserMediaTimeline
        if (data.getUser() != null) {
            instructions = data.getUser()
                    .getResult()
                    .getTimeline()
                    .getTimeline()
                    .getInstructions();
        }

        if (instructions == null) {
            return null;
        }

        List<GraphEntry> entities = Stream.of(instructions)
                .filter(it -> it.getType().equals(InstructionType.TimelineAddEntries))
                .map(GraphInstruction::getEntries)
                .flatMap(Stream::of)
                .collect(toList());

        // Get Tweets
        Map<String, GraphUserResult> users = new HashMap<>();
        List<GraphTweetResult> tweets = entities.stream()
                .map(it -> {
                    if (it.getEntryId().startsWith("tweet-")) {
                        GraphTweetResult tweet = it.getContent()
                                .getItemContent()
                                .getTweetResults()
                                .getResult();

                        if (tweet.getLegacy() != null) {
                            GraphUserResult user = tweet
                                    .getCore()
                                    .getUserResults()
                                    .getResult();

                            users.put(user.getRestId(), user);
                            return tweet;
                        }
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(toList());

        // Get Cursor Top
        String cursorTop = entities.stream()
                .filter(it -> it.getEntryId().startsWith("cursor-top-"))
                .map(GraphEntry::getContent)
                .map(GraphContent::getValue)
                .findFirst()
                .orElse(null);

        // Get Cursor Bottom
        String cursorBottom = entities.stream()
                .filter(it -> it.getEntryId().startsWith("cursor-bottom-"))
                .map(GraphEntry::getContent)
                .map(GraphContent::getValue)
                .findFirst()
                .orElse(null);

        // Make Timeline Object
        TweetTimeline timeline = new TweetTimeline();
        timeline.setTweet(tweets);
        timeline.setUser(users);

        timeline.setCursorTop(cursorTop);
        timeline.setCursorBottom(cursorBottom);

        return timeline;
    }

    // region
    public GraphData getData() {
        return data;
    }
    // endregion
}
