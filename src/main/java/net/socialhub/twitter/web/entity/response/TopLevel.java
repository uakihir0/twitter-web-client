package net.socialhub.twitter.web.entity.response;

import com.google.gson.annotations.SerializedName;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopLevel {

    @SerializedName("globalObjects")
    private Global globalObjects;

    @SerializedName("timeline")
    private Timeline timeline;

    /**
     * Convert to TweetTimeline
     */
    public List<Tweet> toTweetTimeline() {
        Map<String, Tweet> map = globalObjects.getTweets();
        List<Entry> entries = getEntities("tweet");

        return entries.stream()
                .map(e -> e.getContent().getItem().getContent())
                .map(e -> map.get(e.getTweet().getId()))
                .collect(Collectors.toList());
    }

    /**
     * Convert to UserTimeline
     */
    public List<User> toUserTimeline() {
        Map<String, User> map = globalObjects.getUsers();
        List<Entry> entries = getEntities("user");

        return entries.stream()
                .map(e -> e.getContent().getItem().getContent())
                .map(e -> map.get(e.getUser().getId()))
                .collect(Collectors.toList());
    }

    private List<Entry> getEntities(String prefix) {
        return Stream.of(timeline.getInstructions())
                .filter(Objects::nonNull)
                .map(Instruction::getAddEntries)
                .filter(Objects::nonNull)
                .flatMap(e -> Stream.of(e.getEntries()))
                .filter(e -> e.getEntryId().startsWith(prefix))
                .sorted(Comparator.comparing(Entry::getSortIndex).reversed())
                .collect(Collectors.toList());
    }

    // region
    public Global getGlobalObjects() {
        return globalObjects;
    }

    public Timeline getTimeline() {
        return timeline;
    }
    // endregion
}
