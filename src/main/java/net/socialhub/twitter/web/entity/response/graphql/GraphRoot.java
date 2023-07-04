package net.socialhub.twitter.web.entity.response.graphql;

import com.google.gson.annotations.SerializedName;
import net.socialhub.twitter.web.entity.other.InstructionType;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GraphRoot {

    @SerializedName("data")
    private GraphData data;

    public List<GraphTweet> getTweets() {
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

        return Stream.of(instructions)
                .filter(it -> it.getType().equals(InstructionType.TimelineAddEntries))
                .map(GraphInstruction::getEntries)
                .flatMap(Stream::of)
                .map(it -> {
                    if (it.getEntryId().startsWith("tweet-")) {
                        return it.getContent()
                                .getItemContent()
                                .getTweetResults()
                                .getResult()
                                .getLegacy();
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    // region
    public GraphData getData() {
        return data;
    }
    // endregion
}
