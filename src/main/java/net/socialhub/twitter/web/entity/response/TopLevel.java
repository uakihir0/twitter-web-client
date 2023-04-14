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
        List<Entry> entries = getEntries("tweet");

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
        List<Entry> entries = getEntries("user");

        return entries.stream()
                .map(e -> e.getContent().getItem().getContent())
                .map(e -> map.get(e.getUser().getId()))
                .collect(Collectors.toList());
    }

    /**
     * Convert to SearchTweetsTimeline
     */
    public List<Tweet> toSearchTweetsTimeline() {
        Map<String, Tweet> map = globalObjects.getTweets();
        List<Entry> entries = getEntries("sq-I");

        return entries.stream()
                .map(e -> e.getContent().getItem().getContent())
                .map(e -> map.get(e.getTweet().getId()))
                .collect(Collectors.toList());
    }

    /**
     * Convert to MentionTweetsTimeline
     */
    public List<Tweet> toMentionTweetsTimeline() {
        Map<String, Tweet> map = globalObjects.getTweets();
        List<Entry> entries = getEntries("notification-");

        return entries.stream()
                .map(e -> e.getContent().getItem().getContent())
                .map(e -> map.get(e.getTweet().getId()))
                .collect(Collectors.toList());
    }

    /**
     * Get Top Cursor.
     * If not found, return null.
     */
    public String getTopCursor() {
        try {
            List<Entry> entries = getEntries("cursor-top");
            if (!entries.isEmpty()) {
                return entries.get(0).getContent().getOperation().getCursor().getValue();
            }

            // Replace されているかを確認
            List<Instruction.ReplaceEntry> replaced = getReplacedEntries("cursor-top");
            if (!replaced.isEmpty()) {
                return replaced.get(0).getEntry().getContent().getOperation().getCursor().getValue();
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    /**
     * Get Bottom Cursor.
     * If not found, return null.
     */
    public String getBottomCursor() {
        try {
            List<Entry> entries = getEntries("cursor-bottom");
            if (!entries.isEmpty()) {
                return entries.get(0).getContent().getOperation().getCursor().getValue();
            }

            // Replace されているかを確認
            List<Instruction.ReplaceEntry> replaced = getReplacedEntries("cursor-bottom");
            if (!replaced.isEmpty()) {
                return replaced.get(0).getEntry().getContent().getOperation().getCursor().getValue();
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    private List<Entry> getEntries(String entryId) {
        return Stream.of(timeline.getInstructions())
                .filter(Objects::nonNull)
                .map(Instruction::getAddEntries)
                .filter(Objects::nonNull)
                .flatMap(e -> Stream.of(e.getEntries()))
                .filter(e -> e.getEntryId().contains(entryId))
                .sorted(Comparator.comparing(Entry::getSortIndex).reversed())
                .collect(Collectors.toList());
    }

    private List<Instruction.ReplaceEntry> getReplacedEntries(String entryId) {
        return Stream.of(timeline.getInstructions())
                .filter(Objects::nonNull)
                .map(Instruction::getReplaceEntry)
                .filter(Objects::nonNull)
                .filter(e -> e.getEntryIdToReplace().contains(entryId))
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
