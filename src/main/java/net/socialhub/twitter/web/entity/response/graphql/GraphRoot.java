package net.socialhub.twitter.web.entity.response.graphql;

import com.google.gson.annotations.SerializedName;
import net.socialhub.twitter.web.entity.group.TweetDetail;
import net.socialhub.twitter.web.entity.group.TweetTimeline;
import net.socialhub.twitter.web.entity.other.InstructionType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class GraphRoot {

    @SerializedName("data")
    private GraphData data;

    /**
     * Get TweetTimeline
     */
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

        Map<String, GraphUserResult> users = new HashMap<>();
        List<GraphEntry> entities = extractEntities(instructions);

        // Get Tweets
        List<GraphTweetResult> tweets = extractTweets(
                entities, users, "tweet");

        // Get Cursor
        String cursorTop = extractCursor(
                entities, "cursor-top");
        String cursorBottom = extractCursor(
                entities, "cursor-bottom");

        // Make Timeline Object
        TweetTimeline timeline = new TweetTimeline();
        timeline.setTweet(tweets);
        timeline.setUser(users);
        timeline.setCursorTop(cursorTop);
        timeline.setCursorBottom(cursorBottom);

        return timeline;
    }

    /**
     * Get TweetDetail
     */
    public TweetDetail getTweetDetail() {
        GraphInstruction[] instructions = null;

        // For TweetDetail
        if (getData().getTweetDetail() != null) {
            instructions = getData().getTweetDetail()
                    .getInstructions();
        }

        if (instructions == null) {
            return null;
        }

        Map<String, GraphUserResult> users = new HashMap<>();
        List<GraphEntry> entities = extractEntities(instructions);

        // Get Tweets
        List<GraphTweetResult> tweets = extractTweets(
                entities, users, "tweet");
        List<GraphTweetResult> conversations = extractTweets(
                entities, users, "conversationthread");

        // Make Detail
        TweetDetail detail = new TweetDetail();
        detail.setTweet(tweets.get(0));
        detail.setConversation(conversations);
        detail.setUser(users);

        return detail;
    }

    /**
     * Extract Entities
     */
    private List<GraphEntry> extractEntities(
            GraphInstruction[] instructions
    ) {
        return Stream.of(instructions)
                .filter(it -> it.getType().equals(InstructionType.TimelineAddEntries))
                .map(GraphInstruction::getEntries)
                .flatMap(Stream::of)
                .collect(toList());
    }

    /**
     * Extract Tweets
     */
    private List<GraphTweetResult> extractTweets(
            List<GraphEntry> entities,
            Map<String, GraphUserResult> users,
            String prefix
    ) {
        return entities.stream().map(it -> {
                    if (it.getEntryId().startsWith(prefix + "-")) {
                        GraphContent content = it.getContent();
                        GraphTweetResult tweet = null;

                        if (content.getItemContent() != null) {
                            tweet = it.getContent()
                                    .getItemContent()
                                    .getTweetResults()
                                    .getResult();
                        }

                        if (tweet != null) {
                            if (content.getItems() != null) {
                                tweet = it.getContent()
                                        .getItems().get(0)
                                        .getItem()
                                        .getItemContent()
                                        .getTweetResults()
                                        .getResult();
                            }
                        }

                        if (tweet != null) {
                            if (tweet.getLegacy() != null) {
                                GraphUserResult user = tweet
                                        .getCore()
                                        .getUserResults()
                                        .getResult();

                                users.put(user.getRestId(), user);
                                return tweet;
                            }
                        }
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(toList());
    }

    /**
     * Extract Cursor
     */
    private String extractCursor(
            List<GraphEntry> entities,
            String prefix
    ) {
        return entities.stream()
                .filter(it -> it.getEntryId().startsWith(prefix + "-"))
                .map(GraphEntry::getContent)
                .map(GraphContent::getValue)
                .findFirst()
                .orElse(null);
    }

    // region
    public GraphData getData() {
        return data;
    }
    // endregion
}
