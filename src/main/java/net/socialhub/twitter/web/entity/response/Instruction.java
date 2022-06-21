package net.socialhub.twitter.web.entity.response;

import com.google.gson.annotations.SerializedName;

/**
 * Instruction
 * Only one field is non-null.
 */
public class Instruction {

    @SerializedName("addEntries")
    private EntriesRef addEntries;
    @SerializedName("pinEntry")
    private EntryRef pinEntry;
    @SerializedName("replaceEntry")
    private ReplaceEntry replaceEntry;

    // region
    public EntriesRef getAddEntries() {
        return addEntries;
    }

    public EntryRef getPinEntry() {
        return pinEntry;
    }

    public ReplaceEntry getReplaceEntry() {
        return replaceEntry;
    }
    // endregion

    public static class EntryRef {

        @SerializedName("entry")
        private Entry entry;

        // region
        public Entry getEntry() {
            return entry;
        }
        // endregion
    }

    public static class EntriesRef {
        
        @SerializedName("entries")
        private Entry[] entries;

        // region
        public Entry[] getEntries() {
            return entries;
        }
        // endregion
    }

    public static class ReplaceEntry {

        @SerializedName("entryIdToReplace")
        private String entryIdToReplace;
        @SerializedName("entry")
        private Entry entry;

        // region
        public String getEntryIdToReplace() {
            return entryIdToReplace;
        }

        public void setEntryIdToReplace(String entryIdToReplace) {
            this.entryIdToReplace = entryIdToReplace;
        }

        public Entry getEntry() {
            return entry;
        }

        public void setEntry(Entry entry) {
            this.entry = entry;
        }
        // endregion
    }
}
